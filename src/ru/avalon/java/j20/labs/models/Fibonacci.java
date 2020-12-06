package ru.avalon.java.j20.labs.models;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Модель получения последовательности чисел Фибоначчи.
 *
 * <p>Числа Фибонааччи (иногда пишут Фибона́чи[1]) — элементы
 * числовой последовательности 0, 1, 1, 2, 3, 5, 8, 13, 21,
 * 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181,
 * 6765, 10946, 17711, … (последовательность A000045 в OEIS),
 * в которой первые два числа равны либо 1 и 1, либо 0 и 1,
 * а каждое последующее число равно сумме двух предыдущих
 * чисел. Названы в честь средневекового математика Леонардо
 * Пизанского (известного как Фибоначчи).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8">Числа Фибоначчи</a>
 */
public class Fibonacci implements Iterable<Integer> {

    private int length = 0;
    private final int MAXLENGTH = 20;
    private int arrFib[] = new int[MAXLENGTH];

    public Fibonacci(int length) {

        this.length = length;

        this.initialize();
    }

    /**
     * Выполняет инициализацию массива значениями
     * последовательности Фибоначчи.
     *
     */
    private void initialize() {

        if(this.length < 1)
            return;

        int n0 = 1;
        int n1 = 1;
        int n2 = 0;

        this.arrFib[0] = n0;
        this.arrFib[1] = n1;

        for(int i = 2; i < this.length; ++i) {
            n2 = n0 + n1;

            this.arrFib[i] = n2;

            n0 = n1;
            n1 = n2;
        }
    }

    public int[] getArrFib() {

        return this.arrFib;
    }

    public int getSum() {
        int sum = 0;

        for (int i = 0; i < this.arrFib.length; ++i)
            sum += this.arrFib[i];

        return sum;
    }

    /**
     * Итератор, выполняющий обход последовательности
     * чисел Фибоначчи.
     */
    private class FibonacciIterator implements Iterator<Integer> {

        private Integer curr;

        public FibonacciIterator() {
            this.curr = 0;
        }

        /**
         * Определяет, есть ли следующее значение
         * последовательности чисел Фибоначчи.
         *
         * @return {@code true}, если следующее число
         * последовательности существует. В обратном случае
         * {@code false}.
         */
        @Override
        public boolean hasNext() {
            int[] mArr = Fibonacci.this.getArrFib();

            return this.curr < mArr.length;
        }

        /**
         * Возвращает следующее число последовательности
         * чисел Фибоначчи.
         *
         * @return следующее число последовательности.
         */
        @Override
        public Integer next() {

            if (!this.hasNext())
                throw new NoSuchElementException();

            int[] mArr = Fibonacci.this.getArrFib();

            Integer curEl = mArr[this.curr];

            ++this.curr;

            return curEl;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Возвращает итератор, позволяющий выполнить обход
     * последовательности чисел Фибоначчи.
     *
     * @return итератор последовательности чисел Фибоначчи
     */
    @Override
    public Iterator<Integer> iterator() {

        return new FibonacciIterator();
    }
}
