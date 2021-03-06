package com.myhouse.socialnetwork.resources;

import com.myhouse.socialnetwork.domain.Post;
import com.myhouse.socialnetwork.dto.PostDTO;
import com.myhouse.socialnetwork.resources.util.URL;
import com.myhouse.socialnetwork.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService _service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> listAll() {
        List<Post> list = _service.findAll();
        List<PostDTO> listDTO = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PostDTO> findByID(@PathVariable("id") String id) {
        Post obj = _service.findById(id);
        PostDTO objDTO = new PostDTO(obj);
        return ResponseEntity.ok().body(objDTO);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = _service.findByTitle(text);
        List<PostDTO> listDTO = list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = _service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> insert(@RequestBody PostDTO obj) {
//        Post newObj = _service.fromDTO(obj);
//        newObj = _service.insert(newObj);
//
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
//        _service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Void> update(@PathVariable("id") String id, @RequestBody PostDTO obj) {
//        Post newObj = _service.fromDTO(obj);
//        newObj = _service.update(id, newObj);
//        return ResponseEntity.noContent().build();
//    }

}
