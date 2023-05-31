package com.repetitors.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {
    ONLINE("Онлайн"),
    OFFLINE("Офлайн");
    private final String name;
}

