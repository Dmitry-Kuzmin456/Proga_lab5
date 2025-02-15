package util;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    private FileWriter fw;
    private String filename;

    public MyFileWriter(String filename) throws IOException {
        this.fw = new FileWriter(filename, true);
        this.filename = filename;
    }

    public void clearFile() throws IOException {
        this.fw = new FileWriter(filename);
    }

    public void writeLine(String line) throws IOException {
        fw.write(line);
    }
}
