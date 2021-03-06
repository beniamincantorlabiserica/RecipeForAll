package com.example.recipesforall.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recipesforall.data.dao.RecipeDAO;
import com.example.recipesforall.data.model.Recipe;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private RecipeDAO dao;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to Recipe for All, here you can add your recipe");
        dao = new RecipeDAO();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void insertInDb(Recipe recipe) {
        if (recipe != null)
        {
            dao.insertRecipe(recipe);
        }

    }
}