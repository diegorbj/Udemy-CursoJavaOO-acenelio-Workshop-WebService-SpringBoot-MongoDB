package com.myhouse.socialnetwork.services;

import com.myhouse.socialnetwork.domain.User;
import com.myhouse.socialnetwork.dto.UserDTO;
import com.myhouse.socialnetwork.repository.UserRepository;
import com.myhouse.socialnetwork.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository _repository;

    public List<User> findAll() {
        return _repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = _repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj) {
        return _repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        _repository.deleteById(id);
    }

    public User update(String id, User obj) {
        User newObj = findById(id);
        updateDate(obj, newObj);
        return _repository.save(newObj);
    }

    public User fromDTO(UserDTO from) {
        return new User(from.getId(), from.getName(), from.getEmail());
    }

    public void updateDate(User from, User to) {
        to.setName(from.getName());
        to.setEmail(from.getName());
    }
}
