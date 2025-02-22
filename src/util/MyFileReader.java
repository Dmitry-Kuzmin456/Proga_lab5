package util;

import java.io.*;

/**
 * Класс, считывающий объекты из исходного csv файла
 */
public class MyFileReader {
    private final BufferedReader reader;

    public MyFileReader(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis);
        this.reader = new BufferedReader(isr);

    }

    /**
     *
     * @return Строка, содержащая информацию об объекте
     */
    public String[] readLine() throws IOException {
        String line = reader.readLine();
        return line == null ? null : line.split(",");
    }
}
