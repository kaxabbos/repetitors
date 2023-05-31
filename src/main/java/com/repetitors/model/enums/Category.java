package com.repetitors.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    RUSSIAN("Русский язык"),
    MATH("Математика"),
    ENGLISH("Английский язык"),
    PHYSICS("Физика"),
    BIOLOGY("Биология");
    private final String name;
}

