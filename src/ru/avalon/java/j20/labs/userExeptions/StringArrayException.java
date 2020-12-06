package ru.avalon.java.j20.labs.userExeptions;

/**
 * Класс исключения для работы с массивами строк.
 *
 * @author (C)Y.D.Zakovryashin, 17.11.2020
 */
public class StringArrayException extends Exception {
    private static final String DEFAUTL_DESCRIPTION
            = "Common error";

    /**
     * Конструктор по умолчанию.
     */
    public StringArrayException() {
        super(DEFAUTL_DESCRIPTION);
    }

    /**
     * Конструктор с описание причины возникновения исключения.
     *
     * @param string описание причины возникновения исключения.
     */
    public StringArrayException(String string) {
        super(string);
    }
}