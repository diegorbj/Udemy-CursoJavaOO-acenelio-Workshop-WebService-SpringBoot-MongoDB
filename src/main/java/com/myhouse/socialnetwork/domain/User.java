package com.myhouse.socialnetwork.domain;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {

    private final static long serialVersionUID = 1L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @Getter
    private Set<Post> posts = new HashSet<>();

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
