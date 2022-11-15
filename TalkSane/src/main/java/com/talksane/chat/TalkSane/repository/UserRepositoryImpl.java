package com.talksane.chat.TalkSane.repository;

import com.talksane.chat.TalkSane.models.User;
import com.talksane.chat.TalkSane.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
abstract public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        try {
            User user = userRepository.getUserByUsername(username);
            System.out.println(user);
            return user;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}