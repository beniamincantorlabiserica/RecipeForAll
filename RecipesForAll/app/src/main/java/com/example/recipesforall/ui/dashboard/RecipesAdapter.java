package com.example.recipesforall.ui.dashboard;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipesforall.R;
import com.example.recipesforall.data.dao.RecipeDAO;
import com.example.recipesforall.data.model.Recipe;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {

    List<Recipe> recipeList;
    private RecipeDAO dao;

    public RecipesAdapter(RecipeDAO dao, DashboardFragment dashboardFragment) {
        this.dao = dao;
        this.recipeList = dao.getStartingData();
    }

    public RecipesAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        recipeList = dao.getStartingData();
        holder.title.setText(recipeList.get(position).getTitle());
        holder.duration.setText(recipeList.get(position).getDuration());
        holder.recipe.setText(recipeList.get(position).getRecipe());
        holder.username.setText(recipeList.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView duration;
        TextView recipe;
        TextView username;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recipeTitle);
            duration = itemView.findViewById(R.id.recipeDuration);
            recipe = itemView.findViewById(R.id.recipeText);
            username = itemView.findViewById(R.id.recipeUsername);
        }
    }

}
