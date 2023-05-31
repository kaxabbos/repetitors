package com.repetitors.model;

import com.repetitors.model.enums.Category;
import com.repetitors.model.enums.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AdDescription {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(length = 5000)
    private String description;

    public AdDescription(Category category, Type type,String description) {
        this.category = category;
        this.type = type;
        this.description = description;
    }
}
