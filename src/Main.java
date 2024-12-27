public class Main {
    public static void main(String[] args) {
        VirtualDisk virtualDisk = new VirtualDisk(100, 512); 
        FileSystem fileSystem = new FileSystem();
        FileOperations fileOps = new FileOperations(virtualDisk);

        // Create directories and files
        FileSystemNode root = fileSystem.getRoot();
        FileSystemNode docs = fileSystem.createDirectory("docs", root);
        FileSystemNode file = fileSystem.createFile("example.txt", docs);

        fileOps.writeToFile(file, "This is a file system implemented using Java");

        String content = fileOps.readFromFile(file);
        System.out.println("File Content: " + content);

        fileOps.deleteFile(file);
        System.out.println("File deleted successfully!");
    }
}