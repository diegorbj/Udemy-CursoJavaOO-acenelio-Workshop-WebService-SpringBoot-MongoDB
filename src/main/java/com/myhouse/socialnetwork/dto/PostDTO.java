package com.myhouse.socialnetwork.dto;

import com.myhouse.socialnetwork.domain.Post;
import com.myhouse.socialnetwork.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    public PostDTO(Post obj) {
        this.id = obj.getId();
        this.date = obj.getDate();
        this.title = obj.getTitle();
        this.body = obj.getBody();
        this.author = obj.getAuthor();
    }

}
