import java.util.ArrayList;
import java.util.List;

public class Metadata {
    String name;
    long size;
    boolean isDirectory;
    List<Integer> allocatedBlocks;

    public Metadata(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.size = 0;
        this.allocatedBlocks = new ArrayList<>();
    }
}