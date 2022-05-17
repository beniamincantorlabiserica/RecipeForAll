package com.example.recipesforall.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.recipesforall.data.model.Recipe;
import com.example.recipesforall.databinding.FragmentHomeBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        binding.addRecipe.setOnClickListener(v->{
            insertRecipe();
        });
        return root;
    }

    public void insertRecipe() {
        Recipe recipe = new Recipe(binding.title.getText().toString(), binding.recipe.getText().toString(), binding.duration.getText().toString(), binding.username.getText().toString());
        Log.d("Recipe: ", recipe.getRecipe());
        Log.d("Duration: ", recipe.getDuration());
        Log.d("Username: ", recipe.getUsername());
        if(recipe != null)
        {
            homeViewModel.insertInDb(recipe);
        }

    }

    public void daoTest() {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://recipesforall-1e004-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}