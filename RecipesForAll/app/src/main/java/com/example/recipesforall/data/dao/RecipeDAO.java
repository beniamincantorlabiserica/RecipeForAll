package com.example.recipesforall.data.dao;

import android.util.Log;

import com.example.recipesforall.data.model.Recipe;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RecipeDAO {

    public RecipeDAO() {
    }

    public void insertRecipe(Recipe recipe) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
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
}

