package ru.avalon.java.j20.labs.models;

/**
 * Модель представления о точке.
 */
public class Point<Tx extends Number, Ty extends Number> {
    /**
     * Абсцисса точки.
     */
    private final Tx x;
    /**
     * Ордината точки.
     */
    private final Ty y;

    /**
     * Основной конструктор класса.
     *
     * @param x абсцисса точки
     * @param y ордината точки
     */
    public Point(Tx x, Ty y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращает абсциссу точки.
     *
     * @return x-координата точки.
     */
    public Tx getX() {
        return x;
    }

    /**
     * Возвращает ординату точки.
     *
     * @return y-координата точки.
     */
    public Ty getY() {
        return y;
    }

    /**
     * Возвращает дистанцию от точки до точки.
     *
     * @param point точка, до которой следует вычислить
     *              дистанцию.
     * @return дистанция между точками
     */

    public double distanceTo(Point<?, ?> point) {

        float dx = this.x.floatValue() - point.x.floatValue();
        float dy = this.y.floatValue() - point.y.floatValue();

        return Math.sqrt(dx * dx + dy * dy);
    }
}
