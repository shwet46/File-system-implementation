import java.util.ArrayList;
import java.util.List;

public class FileSystemNode {
    Metadata metadata;
    List<FileSystemNode> children;

    public FileSystemNode(Metadata metadata) {
        this.metadata = metadata;
        this.children = metadata.isDirectory ? new ArrayList<>() : null;
    }
}