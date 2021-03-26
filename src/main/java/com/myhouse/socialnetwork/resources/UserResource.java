package com.myhouse.socialnetwork.resources;

import com.myhouse.socialnetwork.domain.User;
import com.myhouse.socialnetwork.dto.UserDTO;
import com.myhouse.socialnetwork.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserServices _service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> listAll() {
        List<User> list = _service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findByID(@PathVariable("id") String id) {
        User obj = _service.findById(id);
        UserDTO objDTO = new UserDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO obj) {
        User newObj = _service.fromDTO(obj);
        newObj = _service.insert(newObj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
