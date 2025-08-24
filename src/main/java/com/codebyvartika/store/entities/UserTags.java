package com.codebyvartika.store.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_tags")
public class UserTags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "tag_id", nullable = false)
    private Integer tagID;
}
