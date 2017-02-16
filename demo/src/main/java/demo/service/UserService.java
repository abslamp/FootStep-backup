package demo.service;

import demo.domain.User;

/**
 * Created by new on 17-2-15.
 */
public interface UserService {
    User query(String name);
    String upload(User user);
    void update(String name , Integer age);
    void delete(Long id);
}
