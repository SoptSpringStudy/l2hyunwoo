package kr.co.marubook.javaspringboot.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// 비즈니스 로직은 Service에서 작업
// 인 메모리 데이터들을 다룸
public class UserService {
    public static List<User> userList = new ArrayList<>();

    private static int userCount = 3;

    static {
        userList.add(new User(1, "HyunWoo", new Date()));
        userList.add(new User(2, "HyunMi", new Date()));
        userList.add(new User(3, "KiWoo", new Date()));
    }

    public List<User> fetchAll() {
        return userList;
    }

    public User fetchUser(Integer id) {
        if (isUserExistOf(id))
            return userList.stream()
                    .filter(user -> user.getId().equals(id))
                    .findAny().get();

        return null;
    }

    public User save(User user) {
        if(user.getId() == null) {
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }

    private boolean isUserExistOf(Integer id) {
        for (User user : userList) {
            if (user.getId().equals(id))
                return true;
        }

        return false;
    }
}