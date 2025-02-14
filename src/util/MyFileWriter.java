package util;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    private FileWriter fw;

    public MyFileWriter(String filename) throws IOException {
        this.fw = new FileWriter(filename, true);
    }
}
