package com.example.recipesforall.data.dao;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.recipesforall.data.model.Recipe;
import com.example.recipesforall.ui.dashboard.DashboardFragment;
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



    public RecipeDAO() {
        startDAO();

        database = FirebaseDatabase.getInstance("https://recipesforall-1e004-default-rtdb.europe-west1.firebasedatabase.app/");
        myRef = database.getReference("recipes");
        recipes = new ArrayList<>();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println("........................          .......................");
                ArrayList<Recipe> newRecipes = new ArrayList<>();
                for (DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    Recipe r = dataSnapshot.getValue(Recipe.class);
                    newRecipes.add(r);
                }
                for (Recipe index: newRecipes){
                    recipes.add(index);
                }
                System.out.println(newRecipes.size());
                //adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public ArrayList<Recipe> getStartingData(){
        System.out.println("Recipes in DAO: " + recipes.size());
        return recipes;
    }

    public void startDAO() {

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
        return recipes;
    }
}

