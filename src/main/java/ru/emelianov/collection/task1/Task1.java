package ru.emelianov.collection.task1;

import java.lang.management.GarbageCollectorMXBean;
import java.util.*;

/**
 * Дано:
 * <pre>
 * public class User {
 *     private String username;
 *     private String email;
 *     private byte[] passwordHash;
 *     …
 * }
 * </pre>
 * Нужно написать утилитный метод
 * <pre>
 * public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB);
 * </pre>
 * <p>который возвращает дубликаты пользователей, которые есть в обеих коллекциях.</p>
 * <p>Одинаковыми считаем пользователей, у которых совпадают все 3 поля: username,
 * email, passwordHash. Дубликаты внутри коллекций collA, collB можно не учитывать.</p>
 * <p>Метод должен быть оптимален по производительности.</p>
 * <p>Пользоваться можно только стандартными классами Java SE.
 * Коллекции collA, collB изменять запрещено.</p>
 *
 * См. {@link User}
 *
 * @author mikhailemv
 * @since 25.10.2023
 */
public class Task1 {

    public static List<User> findDuplicates(Collection<User> collA, Collection<User> collB) {
        Set<User> setA = new HashSet<>(collA);
        Set<User> setB = new HashSet<>(collB);

        List<User> duplicates = new ArrayList<>();

        for (User userA : setA) {
            if (setB.contains(userA)) {
                duplicates.add(userA);
            }
        }

        return duplicates;
    }
}
