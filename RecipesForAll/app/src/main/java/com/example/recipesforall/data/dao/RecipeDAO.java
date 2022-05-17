package com.example.recipesforall.data.dao;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.recipesforall.data.model.Recipe;
import com.example.recipesforall.ui.dashboard.RecipesAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RecipeDAO {
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ArrayList<Recipe> recipes;
    private RecipesAdapter adapter;


    public RecipeDAO() {
        startDAO();
        //this.adapter = recipesAdapter;


    }

    public ArrayList<Recipe> getStartingData(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Recipe> newRecipes = new ArrayList<>();
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Recipe r = dataSnapshot.getValue(Recipe.class);
                    newRecipes.add(r);
                }
                recipes = newRecipes;
                //adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return recipes;
    }

    public void startDAO() {
        database = FirebaseDatabase.getInstance("https://recipesforall-1e004-default-rtdb.europe-west1.firebasedatabase.app/");
        myRef = database.getReference("recipes");
        recipes = new ArrayList<>();

    }



    public void insertRecipe(Recipe recipe) {

        if (recipe != null)
        {
            String key = myRef.push().getKey();
            recipe.setId(key);
            myRef.child(key).setValue(recipe);
        }
        else
        {
            Log.d("ERROR", "OBJECT NULL");
        }
    }

    public ArrayList<Recipe> getAllData() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Recipe> newRecipes = new ArrayList<>();
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Recipe r = dataSnapshot.getValue(Recipe.class);
                    newRecipes.add(r);
                }
                recipes = newRecipes;
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("                       error ");
            }
        });
        return recipes;
    }
}

