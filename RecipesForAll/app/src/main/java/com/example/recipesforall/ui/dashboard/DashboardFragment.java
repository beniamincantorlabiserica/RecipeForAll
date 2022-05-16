package com.example.recipesforall.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipesforall.data.model.Recipe;
import com.example.recipesforall.databinding.FragmentDashboardBinding;

import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    RecyclerView recipesList;
    RecipesAdapter recipesAdapter;
    LiveData<Recipe> recipeLiveData;
    DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
    dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        recipeLiveData = getAllData();
        recipesList = binding.rv;
        recipesList.hasFixedSize();
        recipesList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recipesAdapter = new RecipesAdapter((List)recipeLiveData);
        recipesList.setAdapter(recipesAdapter);
        return root;
    }

    private LiveData<Recipe> getAllData() {
        return dashboardViewModel.getAllData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}