package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;
import ru.avalon.java.j20.labs.userExeptions.*;

import java.lang.CloneNotSupportedException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Random;

/**
 * Задание №1 из файла "Задачи 1 и 2 (Н)Файл"
 *
 * TODO(Студент): Выполните задание №1
 *
 * 1. Для заданного класса User переопределите
 * конструкторы и методы clone(), equls() и hashCode()
 * в соответствии с указаниями, заданными в комментариях к этим методам
 *
 * 2. С использованием отладчика проверьте корректность
 *    выполнения задания.
 *
 */
public class User implements Task {

    /**
     * Уникальный идентификатор пользователя.
     */
    private int id;
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Определяет является ли данный пользователь
     * администратором системы.
     */
    private boolean isAdmin;

    public static Set<Integer> setId = new HashSet<>();

    /**
     * Конструктор по умолчанию.
     */
    public User() {}

    /**
     * Конструктор, определяющий все поля класса.
     *
     * @param id      уникальный идентификатор пользователя.
     * @param name    имя пользователя.
     * @param isAdmin задаёт значение true, если
     *                пользователь
     *                является администратором системы.
     * @throws UserException выбрасывается в случаях, когда:
     *                       - идентификатор пользователя не уникален;
     *                       - имя пользователя равно null или является пустым.
     *                       (Класс данного исключения определите самостоятельно).
     */
    public User(int id, String name, boolean isAdmin)
            throws UserException, CloneNotSupportedException {

        if(!User.setId.add(id))
            throw new UserException("This user id is not unique");

        if(name == null || name == "")
            throw new UserException("This user name is not valid");

        this.id = id;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {

        /*
        try {
            User u1 = new User(1, "user1", false);
            //User u2 = new User(1, "user2", true);
            User u3 = new User(2, "user3", false);

            User u4 = (User) u1.clone();

        } catch (UserException | CloneNotSupportedException e) {

            System.out.println("err >> "+ e.toString() );
        }
         */
    }

    /**
     * Метод клонирует объект данного класса по следующим
     * правилам:
     * - имя пользователя name и поле isAdmin дублируются;
     * - для идентификатора id выбирается новое уникальное
     * значение (в данной задаче можно генерировать случайное
     * значение, например, с помощью метода Math.random()).
     *
     * @return ссылка на клон данного объекта.
     * @throws CloneNotSupportedException выбрасывается в
     *                                    случае, когда имя пользователя равно null или является
     *                                    пустой строкой.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {

        Random rndObj = new Random();
        int rnd = rndObj.nextInt(500);

        User u = null;

        try {
            u = new User(rnd, this.name, this.isAdmin);
        } catch (CloneNotSupportedException e) {

            System.out.println("err >> "+ e.toString() );
        } catch (UserException e) {

            System.out.println("err >> "+ e.toString() );
        }

        return u;
    }

    /**
     * Метод сравнивает по содержанию текущий объект с объектом
     * obj.
     *
     * @param o ссылка на объект, с которым сравнивается
     *            текущий объект.
     * @return возвращает значение true, если имя пользователя
     * name и значение поля isAdmin у обоих объектов совпадают.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || this.getClass() != o.getClass())
            return false;

        User u = (User) o;

        return this.name.equals(u.getName()) && this.isAdmin == u.isAdmin();
    }

    /**
     * Метод возвращает хэш-код данного объекта. Алгоритм
     * вычисления кода должен учитывать имя пользователя и
     * значение поля isAdmin.
     *
     * @return хэш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.isAdmin);
    }

    public String getName() {
        return this.name;
    }

    public boolean isAdmin() {
        return this.isAdmin;
    }
}
