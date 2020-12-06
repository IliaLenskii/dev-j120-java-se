package ru.avalon.java.j20.labs;

import ru.avalon.java.j20.labs.userExeptions.ConverterException;

/**
 *
 * TODO Напишите реализацию класса DataConverter, который наследует интерфейс: IFileConverter
 *
 */

public class DataConverter implements IFileConverter {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {

        System.out.println("__ok");
    }

    @Override
    public String toBinary(String inputFileName, String outputFileName, String charSet) {
        return null;
    }

    @Override
    public String toText(String inputFileName, String outputFileName, String charSet) {
        return null;
    }

    @Override
    public double getSum(String fileName) throws ConverterException {
        return 0;
    }
}
