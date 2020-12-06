package ru.avalon.java.j20.labs.core;

/**
 * Абстрактное представление об эталоне проектирования
 * "Фабрика".
 *
 * @param <Result> тип, описывающий значения, создаваемые фабрикой.
 * @param <Param> тип, описывающий принимаемый фабрикой параметр
 */
public interface Factory<Result, Param> {

    /**
     * Возвращает экземпляр, создаваемый фабрикой.
     *
     * @return новый экземпляр типа {@code T}
     */
    Result getInstance(Param param);
}
