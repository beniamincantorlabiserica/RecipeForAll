package com.example.recipesforall.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipesforall.data.dao.RecipeDAO;
import com.example.recipesforall.data.model.Recipe;
import com.example.recipesforall.databinding.FragmentDashboardBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    RecyclerView recipesList;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private RecipesAdapter recipesAdapter;
    ArrayList<Recipe> recipeLiveData;
    DashboardViewModel dashboardViewModel;
    private RecipeDAO dao;



    public DashboardFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dao = new RecipeDAO();
        database = FirebaseDatabase.getInstance("https://recipesforall-1e004-default-rtdb.europe-west1.firebasedatabase.app/");
        myRef = database.getReference("recipes");

        recipeLiveData = dao.getStartingData();

        recipesList = binding.rv;
        recipesList.hasFixedSize();
        recipesList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recipesAdapter = new RecipesAdapter(dao, this);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                recipesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recipesList.setAdapter(recipesAdapter);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    private ArrayList<Recipe> getAllData() {
        return dao.getAllData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}