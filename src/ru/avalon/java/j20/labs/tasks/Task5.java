package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.core.RandomArrayFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Задание №5.
 *
 * <p>Тема: "Изучение отличия между списками и наборами".
 */
public class Task5 implements Task {

    /**
     * Фабрика, генерирующая массивы чисел случайного характера.
     */
    private final RandomArrayFactory arrayFactory = new RandomArrayFactory();

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
        final Number[] array = arrayFactory.getInstance(20);

        List<Integer> tmp = new ArrayList<Integer>();

        for(int i = 0; i < array.length; ++i)
            tmp.add( array[i].intValue() );

        List<Integer> list = new ArrayList<Integer>();

        list.addAll(tmp);

        /*
        интерфейсе Set определяется множество.
        Он расширяет интерфейс Collection и определяет
        поведение коллекций, не допускающих дублирования элементов.
         */
        Set<Integer> set = new HashSet<>();
        set.addAll(tmp);


        /**
         * TODO(Студент): Выполните задание №5
         *
         * 1. Проинициализируйте переменные list и set объектами
         *    подходящих классов.
         *
         * 2. В обе коллекции поместите элементы массива array.
         *
         * 3. С использованием отладчика проверьте корректность
         *    выполнения задания.
         */
    }
}
