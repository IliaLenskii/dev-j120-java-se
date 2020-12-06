package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.userExeptions.*;
import  java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Задание №2 из файла "Задачи 1 и 2 (Н)Файл"
 *
 * TODO(Студент): Выполните задание №2
 *
 * Напишите реализацию методов класса StringService
 *
 * Класс предоставляет набор сервисных функций для работы со строками.
 *
 * @author (C)Y.D.Zakovryashin, 17.11.2020
 *
 */
public class StringService implements Task {

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {

        /*
        String arr1[] = new String[]{"g","d","c","h","r","a","z","u","o"};

        String arrAsc[] = null;
        String arrDesc[] = null;

        try {
            arrAsc = StringService.sort(arr1, true);
            arrDesc = StringService.sort(arr1, false);
        } catch (StringArrayException e) {

            System.out.println("err >> "+ e.toString() );
        }
        */

        //char uniqChar[] = getCharStat("aaaaqqww");
    }

    /**
     * Метод сортирует массив строк, заданных параметром as.
     *
     * @param as  исходный массив строк.
     * @param dir определяет порядок сортировки строк: если
     *            данный параметр равен true, то строки сортируются в
     *            алфавитном порядке, а если данный параметр равен
     *            false, то строки сортируются в обратном порядке.
     * @return возвращается отсортированный массив строк.
     * @throws StringArrayException данное исключение
     *                              выбрасывается в случае, если ссылка на исходный массив as
     *                              равна null или в случае когда массив as пуст.
     */
    public static String[] sort(String[] as, boolean dir)
            throws StringArrayException {

        if(as == null || as.length < 0)
            throw new StringArrayException("Array is invalid");

        Arrays.sort(as, (dir ? null : Collections.reverseOrder()) );

        return as;
    }

    /**
     * Метод возвращает набор символов, каждый из которых хотя
     * бы один раз встречается в исходной строке str.
     *
     * @param str исходная строка.
     * @return массив уникальный символов, каждый из которых
     * хотя бы один раз встречается в исходной строке str. Если
     * ссылка на исходный массив равна null, то метод также
     * возвращает null. Если исходная строка пуста, то
     * возвращается пустой массив.
     */
    public static char[] getCharStat(String str) {

        if(str == null)
            return null;

        if(str.equals(""))
            return new char[]{};

        Set<Character> uniqChar = new HashSet<>();

        for (int i = 0; i < str.length(); ++i)
            uniqChar.add( str.charAt(i) );

        char res[] = new char[ uniqChar.size() ];
        int iarr[] = new int[]{0};

        uniqChar.forEach(itm -> {

            res[ iarr[0]++ ] = itm;
        });

        return res;
    }
}
