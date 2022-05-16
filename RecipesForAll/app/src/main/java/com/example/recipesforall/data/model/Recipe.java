package com.example.recipesforall.data.model;

public class Recipe {
    private String recipe;
    private String duration;
    private String username;

    public Recipe(String recipe, String duration, String username) {
        this.recipe = recipe;
        this.duration = duration;
        this.username = username;
    }

    public String getRecipe() {
        return recipe;
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
