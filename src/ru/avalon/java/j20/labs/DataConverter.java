package ru.avalon.java.j20.labs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ru.avalon.java.j20.labs.userExeptions.ConverterException;

/**
 *
 * TODO Напишите реализацию класса DataConverter, который наследует интерфейс: IFileConverter
 *
 */

public class DataConverter implements IFileConverter {

    private final String fileIntoText = "text.tmp";
    private final String fileIntoDigits = "digits.tmp";

    @Override
    public String toBinary(String inputFileName, String outputFileName, String charSet) throws ConverterException {

        //private boolean makeFile(String name) throws IOException {

        return null;
    }

    @Override
    public String toText(String inputFileName, String outputFileName, String charSet) throws ConverterException {

        return null;
    }

    @Override
    public double getSum(String fileName) throws ConverterException {
        return 0;
    }

    @Override
    public void run() {

        try {

            this.makeTmplFiles();
        } catch (IOException ex){

            ex.printStackTrace();
        }

        System.out.println("__ok");
    }

    private boolean isFileExists(String name) {

        File f = new File(name.trim());

        if(f.exists() && f.isFile())
            return true;

        return false;
    }

    private void makeTmplFiles() throws IOException {

        String tmpText[] = new String[2];
        tmpText[0] = "Съешь ещё этих мягких французских булок, да выпей же чаю.";
        tmpText[1] = "The quick brown fox jumps over the lazy dog.";

        String tmpDigitsLines[] = new String[1];
        tmpDigitsLines[0] = "150 144 185 187 103 147 160 167 51 95";
        //tmpDigitsLines[1] = "183, 168, 98, 82, 194, 71, 84, 69, 82, 151";
        //tmpDigitsLines[3] = "145, 90, 82, 164, 119, 186, 174, 71, 94, 131";
        //tmpDigitsLines[4] = "114, 123, 141, 173, 93, 143, 182, 178, 111, 83";

        if(!isFileExists(this.fileIntoText)) {

            this.makeFile(this.fileIntoText);
            this.writeUnicodeJava8(this.fileIntoText, tmpText);
        }

        if(!isFileExists(this.fileIntoDigits)) {

            this.makeFile(this.fileIntoDigits);
            this.writeUnicodeJava8(this.fileIntoDigits, tmpDigitsLines);
        }
    }

    private boolean makeFile(String name) throws IOException {

        File f = new File(name.trim());

        try {

            return f.createNewFile();

        } catch (IOException ex) {

            throw new IOException("File not made: "+ f.getName());
        }
    }

    private static void writeUnicodeJava8(String fileName, String[] lines) {

        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
