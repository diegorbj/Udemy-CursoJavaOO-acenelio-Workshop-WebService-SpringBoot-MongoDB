package com.myhouse.socialnetwork.dto;

import com.myhouse.socialnetwork.domain.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO implements Serializable {

    private final static long servialVersionUID = 1L;

    private String id;
    private Date date;
    private AuthorDTO author;

    public CommentDTO(String id, Date date, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.author = author;
    }
    
}
