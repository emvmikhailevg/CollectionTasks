package ru.emelianov;

import ru.emelianov.collection.task1.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ru.emelianov.collection.task1.Task1.findDuplicates;

/**
 * Main class for test tasks
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        testFirstTask();
    }

    private static void testFirstTask() {
        // Создаем несколько пользователей
        User user1 = new User("user1", "user1@example.com", new byte[] { 1, 2, 3 });
        User user2 = new User("user2", "user2@example.com", new byte[] { 4, 5, 6 });
        User user3 = new User("user3", "user3@example.com", new byte[] { 7, 8, 9 });
        User user4 = new User("user1", "user1@example.com", new byte[] { 1, 2, 3 }); // Дубликат

        // Создаем коллекции
        Collection<User> collA = new ArrayList<>();
        collA.add(user1);
        collA.add(user2);
        collA.add(user3);

        Collection<User> collB = new ArrayList<>();
        collB.add(user2);
        collB.add(user3);
        collB.add(user4);

        // Вызываем метод findDuplicates
        List<User> duplicates = findDuplicates(collA, collB);

        // Выводим дубликаты
        for (User user : duplicates) {
            System.out.println("Duplicate User: " + user.getUsername() + ", " + user.getEmail());
        }
    }
}
