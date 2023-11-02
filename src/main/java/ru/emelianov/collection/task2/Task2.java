package ru.emelianov.collection.task2;

import java.util.HashMap;
import java.util.Map;

/**
 * Дано:
 * <pre>
 * public class Ticket {
 *     private long id;
 *     private String client;
 *     …
 * }</pre>
 * <p>Разработать программу для бармена в холле огромного концертного зала.
 * Зрители в кассе покупают билет (класс Ticket), на котором указан идентификатор билета (id) и имя зрителя.
 * При этом, есть возможность докупить наборы разных товаров (комбо-обед): нет товаров, напитки, еда и напитки.
 * Доп. услуги оформляются через интернет и привязываются к билету, но хранятся отдельно от билета
 * (нельзя добавить товары в класс Ticket).</p>
 * <p>Бармен сканирует билет и получает объект Ticket. По этому объекту нужно уметь
 * находить необходимые товары по номеру билета. И делать это нужно очень быстро,
 * ведь нужно как можно быстрее всех накормить.</p>
 * <p>
 * См. {@link Ticket}
 *
 * @author mikhailemv
 * @since 25.10.2023
 */
public class Task2 {
    private static final Map<Ticket, Goods> goodsByTicket = new HashMap<>();

    // Итоговая сложность нахождения необходимых товаров по билету O(1)
    public static void main(String[] args) {
        Ticket ticket = new Ticket(456, "Sasha");
        goodsByTicket.put(ticket, Goods.DRINKS);
        getGoods(ticket);
    }

    private static void getGoods(Ticket ticket) {
        System.out.println(goodsByTicket.get(ticket));
    }
}
