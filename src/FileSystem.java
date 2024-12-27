public class FileSystem {
    private final FileSystemNode root;

    public FileSystem() {
        this.root = new FileSystemNode(new Metadata("/", true));
    }

    public FileSystemNode getRoot() {
        return root;
    }

    public FileSystemNode createDirectory(String name, FileSystemNode parent) {
        Metadata metadata = new Metadata(name, true);
        FileSystemNode directory = new FileSystemNode(metadata);
        parent.children.add(directory);
        return directory;
    }

    public FileSystemNode createFile(String name, FileSystemNode parent) {
        Metadata metadata = new Metadata(name, false);
        FileSystemNode file = new FileSystemNode(metadata);
        parent.children.add(file);
        return file;
    }
}