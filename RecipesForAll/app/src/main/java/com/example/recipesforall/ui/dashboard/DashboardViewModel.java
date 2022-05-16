package com.example.recipesforall.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recipesforall.data.dao.RecipeDAO;
import com.example.recipesforall.data.model.Recipe;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private MutableLiveData<Recipe> recipeMutableLiveData;
    private RecipeDAO dao;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
        this.dao = new RecipeDAO();
        recipeMutableLiveData = dao.getAllData();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Recipe> getAllData() {
        return dao.getAllData();
    }
}