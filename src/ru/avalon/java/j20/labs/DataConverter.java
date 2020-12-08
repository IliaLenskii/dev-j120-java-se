package ru.avalon.java.j20.labs;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


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
    public String toBinary(String inputFileName, String outputFileName, String charSet)  {

        try {
            this.makeFile(outputFileName);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Path path = Paths.get(inputFileName);

        try (
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(outputFileName))
        ) {

            String line;
            while ((line = reader.readLine()) != null) {

                line += System.lineSeparator();

                byte[] byteArr = line.getBytes(StandardCharsets.UTF_8);

                writer.write(byteArr);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFileName;
    }

    @Override
    public String toText(String inputFileName, String outputFileName, String charSet) {

        try {
            this.makeFile(outputFileName);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        var tmpByte = new ArrayList<Byte>();

        try (
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(inputFileName));
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFileName));
        ) {
            while(reader.available() > 0)
                tmpByte.add( reader.readByte() );

            byte bb2[] = new byte[ tmpByte.size() ];

            int cc = 0;
            for(byte itm : tmpByte)
                bb2[ cc++ ] = itm;

            String s2 = new String(bb2);

            writer.write(s2);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputFileName;
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

        String binFile = "binary.bin";
        String binToText = "convertFromBinary.txt";

        this.toBinary(this.fileIntoText, binFile, "utf-8");

        this.toText(binFile, binToText,"utf-8");

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
        tmpText[0] = "Съешь 34 ещё этих 2466 мягких 56.5 французских булок, 34.675 да выпей же чаю.";
        tmpText[1] = "The 1.0 quick 6543.2 brown fox 134.87 jumps over the lazy dog. 0.0";

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
