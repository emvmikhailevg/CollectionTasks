package ru.emelianov.collection.task1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Пользователь
 *
 * @author mikhailemv
 * @since 25.10.2023
 */
public class User {
    private String username;
    private String email;
    private byte[] passwordHash;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username)
                && Objects.equals(email, user.email)
                && Arrays.equals(passwordHash, user.passwordHash);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username, email);
        result = 31 * result + Arrays.hashCode(passwordHash);
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(byte[] passwordHash) {
        this.passwordHash = passwordHash;
    }

    public User(String username, String email, byte[] passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }
}
