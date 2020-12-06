package ru.avalon.java.j20.labs;

/**
 * Лабораторная работа №3
 *
 * Базовый ввод/вывод
 * Напишите реализацию класса DataConverter, который наследует
 * интерфейс: IFileConverter
 *
 */

public class Application {

    /**
     * Задачи, которые следует выполнить в рамках
     * лабораторной работы.
     */
    private static final Task[] tasks = {
        new DataConverter()
    };

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        /*
         * Задачи выполняются последовательно. В порядке,
         * определённом массивом tasks.
         *
         * Для удобства выполнения заданий, можно менять их
         * порядок и/или закомментировать любой из элементов
         * массива.
         */
	    for (Task task : tasks) task.run();
    }
}
