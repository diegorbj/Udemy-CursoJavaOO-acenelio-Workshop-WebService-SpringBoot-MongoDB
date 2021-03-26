package com.myhouse.socialnetwork.config;

import com.myhouse.socialnetwork.domain.User;
import com.myhouse.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository _userRepository;

    @Override
    public void run(String... args) throws Exception {

        _userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        _userRepository.saveAll(Arrays.asList(maria, alex, bob));

    }
}