package demo.service.impl;

import demo.domain.User;
import demo.domain.UserMapper;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by new on 17-2-15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public User query(String name) {
        return mapper.findByName(name);
    }

    @Override
    public String upload(String name, Integer age) {
        mapper.insert(name,age);
        return "success";
    }

    @Override
    public void update(String name, Integer age) {
        mapper.update(new User(name,age));
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }
}