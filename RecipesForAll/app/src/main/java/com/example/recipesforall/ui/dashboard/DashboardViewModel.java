package com.example.recipesforall.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recipesforall.data.dao.RecipeDAO;
import com.example.recipesforall.data.model.Recipe;

import java.util.ArrayList;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private ArrayList<Recipe> recipeMutableLiveData;
    private RecipeDAO dao;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Find the perfect recipe for you");
    }

    public LiveData<String> getText() {
        return mText;
    }
}