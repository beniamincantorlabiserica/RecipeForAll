package com.example.recipesforall.data.model;

public class Recipe {
    private String id;
    private String title;
    private String recipe;
    private String duration;
    private String username;

    public Recipe(String title, String recipe, String duration, String username) {
        this.title = title;
        this.recipe = recipe;
        this.duration = duration;
        this.username = username;
    }

    public Recipe() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
