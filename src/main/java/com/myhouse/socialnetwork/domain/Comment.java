package com.myhouse.socialnetwork.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comment implements Serializable {

    private final static long serialVersionUID = 1L;

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    private String id;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private User author = new User();

    @Getter
    @Setter
    private Post post = new Post();

}
