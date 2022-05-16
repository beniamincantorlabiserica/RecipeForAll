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
        this.dao = new RecipeDAO();
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to Receipt for All, here you can add your recei");
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