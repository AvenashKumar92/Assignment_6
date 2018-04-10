package com.example.avenash_2.walmartextendedapp;

public class Food {
    private final String name;
    private final String description;
    private final int resourseId;


    public Food(int resourseId, String name, String description) {
        this.resourseId=resourseId;
        this.name = name;
        this.description = description;
    }

    public int getResourseId() {
        return resourseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
