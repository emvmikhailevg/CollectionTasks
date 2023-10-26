package ru.emelianov.collection.task2;

import java.util.*;

class TicketManager {
    private final Map<Long, List<Product>> ticketToProductsMap;

    public TicketManager() {
        ticketToProductsMap = new HashMap<>();
    }

    public void addProductToTicket(long ticketId, Product product) {
        ticketToProductsMap.computeIfAbsent(ticketId, k -> new ArrayList<>()).add(product);
    }

    public List<Product> getProductsForTicket(long ticketId) {
        return ticketToProductsMap.getOrDefault(ticketId, Collections.emptyList());
    }
}
