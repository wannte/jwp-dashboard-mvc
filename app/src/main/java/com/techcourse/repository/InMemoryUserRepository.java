package com.techcourse.repository;

import com.techcourse.domain.User;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserRepository {

    private static final Map<String, User> database = new ConcurrentHashMap<>();
    private static Long autoIncrement = 0L;

    static {
        final User user = new User(++autoIncrement, "gugu", "password", "hkkang@woowahan.com");
        database.put(user.getAccount(), user);
    }

    private InMemoryUserRepository() {
    }

    public static void save(User user) {
        database.put(user.getAccount(),
                new User(++autoIncrement, user.getAccount(), user.getPassword(), user.getEmail()));
    }

    public static Optional<User> findByAccount(String account) {
        return Optional.ofNullable(database.get(account));
    }
}
