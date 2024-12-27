import java.util.Arrays;

public class FileOperations {
    private final VirtualDisk virtualDisk;

    public FileOperations(VirtualDisk virtualDisk) {
        this.virtualDisk = virtualDisk;
    }

    public void writeToFile(FileSystemNode file, String content) {
        byte[] data = content.getBytes();
        int blockSize = virtualDisk.getBlockSize();
        int blocksNeeded = (int) Math.ceil((double) data.length / blockSize);

        for (int i = 0; i < blocksNeeded; i++) {
            int blockIndex = virtualDisk.allocateBlock();
            int start = i * blockSize;
            int end = Math.min(start + blockSize, data.length);
            virtualDisk.writeBlock(blockIndex, Arrays.copyOfRange(data, start, end));
            file.metadata.allocatedBlocks.add(blockIndex);
        }
        file.metadata.size = data.length;
    }

    public String readFromFile(FileSystemNode file) {
        StringBuilder content = new StringBuilder();
        for (int blockIndex : file.metadata.allocatedBlocks) {
            byte[] data = virtualDisk.readBlock(blockIndex);
            content.append(new String(data).trim());
        }
        return content.toString();
    }

    public void deleteFile(FileSystemNode file) {
        for (int blockIndex : file.metadata.allocatedBlocks) {
            virtualDisk.freeBlock(blockIndex);
        }
        file.metadata.allocatedBlocks.clear();
        file.metadata.size = 0;
    }
}