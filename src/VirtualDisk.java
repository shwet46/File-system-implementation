import java.util.Arrays;

public class VirtualDisk {
    private final byte[][] disk;
    private final boolean[] blockStatus;

    public VirtualDisk(int totalBlocks, int blockSize) {
        disk = new byte[totalBlocks][blockSize];
        blockStatus = new boolean[totalBlocks];
        Arrays.fill(blockStatus, false);
    }

    public int allocateBlock() {
        for (int i = 0; i < blockStatus.length; i++) {
            if (!blockStatus[i]) {
                blockStatus[i] = true;
                return i;
            }
        }
        throw new RuntimeException("Disk is full :(");
    }

    public void freeBlock(int blockIndex) {
        blockStatus[blockIndex] = false;
    }

    public byte[] readBlock(int blockIndex) {
        return disk[blockIndex];
    }

    public void writeBlock(int blockIndex, byte[] data) {
        disk[blockIndex] = Arrays.copyOf(data, data.length);
    }

    public int getBlockSize() {
        return disk[0].length;
    }
}