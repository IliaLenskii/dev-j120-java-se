package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.models.Fibonacci;

import java.util.Iterator;

/**
 * Задание №3
 *
 * <p>Тема: "Изучение интерфейсов {@link Iterable} и {@link Iterator}".
 */
public class Task3 implements Task {

    @Override
    public void run() {

        Fibonacci fib = new Fibonacci(20);
        Iterator<Integer> fibIterator = fib.iterator();

        //int[] mArr = fib.getArrFib();
        //for(int i = 0; i < mArr.length; ++i)
        //    System.out.print( mArr[i] +" "+ (i % 6 == 0 ? '\n' : ""));

        //System.out.println("sum: "+ fib.getSum());

        Integer s = 0;

        for (Iterator<Integer> it = fibIterator; it.hasNext(); ) {
            s += it.next();
        }

        //System.out.println("sum2: "+ s );

        /*
         * TODO(Студент): Выполнить задание №3
         *
         * 1. Завершить описание класса Fibonacci так, чтобы класс
         *    возвращал заданное количество чисел последовательности
         *    Фибоначчи.
         *
         *    Количество чисел последовательности можно указывать
         *    при создании экземпляра класса.
         *
         *    Найти сумму 20 первых чисел последовательности Фибоначчи:
         *
         * 2. Создать экземпляр класса Fibonacci так, чтобы он
         *    возвращал последовательность чисел Фибоначчи длиной
         *    в 20 элементов.
         *
         * 3. Найти сумму полученных значений.
         *
         * 4. С использованием отладчика проверьте корректность
         *    выполнения задания.
         */
    }
}
