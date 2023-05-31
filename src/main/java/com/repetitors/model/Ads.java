package com.repetitors.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ads {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private int price;
    private String[] photos;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AdDescription description;
    @ManyToOne
    private Users owner;
    private String tel;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL)
    private List<Comments> comments;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ad", cascade = CascadeType.ALL)
    private List<Requests> requests;

    public Ads(String name, int price, String tel, String[] result_photos) {
        this.name = name;
        this.price = price;
        this.tel = tel;
        this.photos = result_photos;
        comments = new ArrayList<>();
    }

    public void addComment(Comments comment) {
        comments.add(comment);
        comment.setCar(this);
    }

    public void removeComment(Comments comment) {
        comments.remove(comment);
        comment.setCar(null);
    }

    public String[] getPartPhotos() {
        return Arrays.copyOfRange(photos, 1, photos.length);
    }
}
