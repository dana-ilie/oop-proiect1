package writer;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private final FileWriter file;

    public Writer(final String path) throws IOException {
        this.file = new FileWriter(path);
    }


}
