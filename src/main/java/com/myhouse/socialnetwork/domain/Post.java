package com.myhouse.socialnetwork.domain;

import com.myhouse.socialnetwork.dto.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Post implements Serializable {

    private final static long serialVersionUID = 1L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    @Id
    private String id;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String body;

    @Getter
    @Setter
    private AuthorDTO author;

    @Getter
    private Set<Comment> comments = new HashSet<>();

    public Post(String id, Date date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}
