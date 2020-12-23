package com.alphabank.demo.entity;

import lombok.Data;

@Data
public class TypeOfLink {
    private String input;

    public TypeOfLink(String input) {
        this.input = input;
    }
}
