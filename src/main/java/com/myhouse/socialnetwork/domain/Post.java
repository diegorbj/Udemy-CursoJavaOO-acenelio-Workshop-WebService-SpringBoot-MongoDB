package com.myhouse.socialnetwork.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Post implements Serializable {

    private final static long serialVersionUID = 1L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
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
    private User author = new User();

    @Getter
    private Set<Comment> comments = new HashSet<>();

    public Post(String id, Date date, String title, String body, User author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

}
