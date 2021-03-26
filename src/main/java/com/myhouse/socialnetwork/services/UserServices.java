package com.myhouse.socialnetwork.services;

import com.myhouse.socialnetwork.domain.User;
import com.myhouse.socialnetwork.repository.UserRepository;
import com.myhouse.socialnetwork.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository _repository;

    public List<User> findAll() {
        return _repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = _repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    
}
