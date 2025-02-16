package util;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    private FileOutputStream fos;
    private String filename;

    public MyFileWriter(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename, true);
        this.filename = filename;
    }

    public void clearFile() throws IOException {
        this.fos = new FileOutputStream(filename);
    }

    public void writeLine(String line) throws IOException {
        fos.write(line.getBytes());
    }
}
