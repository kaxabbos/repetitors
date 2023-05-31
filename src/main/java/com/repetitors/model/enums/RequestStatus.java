package com.repetitors.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestStatus {
    FRESH("Новое"),
    IN_CONSIDERATION("В рассмотрении"),
    ANSWERED("Отвечено"),
    ;
    private final String name;
}

