package ru.emelianov.collection.task2;

/**
 * Билет
 *
 * @author mikhailemv
 * @since 25.10.2023
 */
public class Ticket {
    private final long id;
    private final String client;

    public Ticket(long id, String client) {
        this.id = id;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }
}
