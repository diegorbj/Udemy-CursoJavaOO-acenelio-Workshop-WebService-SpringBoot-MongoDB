package com.myhouse.socialnetwork.services;

import com.myhouse.socialnetwork.domain.Post;
import com.myhouse.socialnetwork.dto.PostDTO;
import com.myhouse.socialnetwork.repository.PostRepository;
import com.myhouse.socialnetwork.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository _repository;

    public List<Post> findAll() {
        return _repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = _repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return _repository.findByTitle(text);
    }

    public Post insert(Post obj) {
        return _repository.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        _repository.deleteById(id);
    }

    public Post update(String id, Post obj) {
        Post newObj = findById(id);
        updateDate(obj, newObj);
        return _repository.save(newObj);
    }

    public Post fromDTO(PostDTO from) {
        return new Post(from.getId(), from.getDate(), from.getTitle(), from.getBody(), from.getAuthor());
    }

    public void updateDate(Post from, Post to) {
        to.setDate(from.getDate());
        to.setTitle(from.getTitle());
        to.setBody(from.getBody());
        to.setAuthor(from.getAuthor());
    }

}
