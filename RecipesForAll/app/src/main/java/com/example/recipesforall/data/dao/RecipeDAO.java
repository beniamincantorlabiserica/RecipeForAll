package com.example.recipesforall.data.dao;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.recipesforall.data.model.Recipe;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecipeDAO {
    private final FirebaseDatabase database;

    public RecipeDAO() {
        database = FirebaseDatabase.getInstance("https://recipesforall-1e004-default-rtdb.europe-west1.firebasedatabase.app");
    }

    public void insertRecipe(Recipe recipe) {
        DatabaseReference myRef = database.getReference();
        if (recipe != null)
        {
            myRef.child("Recipe").setValue(recipe);
        }
        else
        {
            Log.d("ERROR", "OBJECT NULL");
        }
    }

    public MutableLiveData<Recipe> getAllData() {
        return null;
    }
}

