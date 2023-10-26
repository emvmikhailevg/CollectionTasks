package ru.emelianov.collection.task2;

import java.util.List;

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
    public static void main(String[] args) {
        TicketManager ticketManager = new TicketManager();

        Product drink1 = new Product("Coca-Cola", 2.5);
        Product drink2 = new Product("Pepsi", 2.0);
        Product food1 = new Product("Burger", 5.0);
        Product food2 = new Product("Pizza", 8.0);

        ticketManager.addProductToTicket(12345, drink1);
        ticketManager.addProductToTicket(12345, food1);
        ticketManager.addProductToTicket(67890, drink2);
        ticketManager.addProductToTicket(54321, food2);

        // Пример поиска товаров по номеру билета
        int ticketIdToFind = 12345;
        List<Product> products = ticketManager.getProductsForTicket(ticketIdToFind);

        if (products.isEmpty()) {
            System.out.println("Нет товаров");
        } else {
            System.out.println("Дополнительные товары для билета " + ticketIdToFind + ":");
            for (Product product : products) {
                System.out.println(product.getName() + " - $" + product.getPrice());
            }
        }
    }
}
