package com.myhouse.socialnetwork.resources;

import com.myhouse.socialnetwork.domain.User;
import com.myhouse.socialnetwork.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserServices _service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAll() {
        List<User> list = _service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
