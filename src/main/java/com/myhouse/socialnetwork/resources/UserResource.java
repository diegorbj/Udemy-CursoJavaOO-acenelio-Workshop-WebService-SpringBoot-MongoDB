package com.myhouse.socialnetwork.resources;

import com.myhouse.socialnetwork.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAll() {
        User maria = new User("1", "Maria Brwon", "maria@gamil.com");
        User alex = new User("2", "Alex Green", "alex@gamil.com");
        List<User> list = Arrays.asList(maria, alex);
        return ResponseEntity.ok().body(list);
    }

}
