package com.example.yourtrainingday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.navigation.fragment.NavHostFragment;

import com.example.yourtrainingday.databinding.FragmentUserPageBinding;

public class UserPageFragment extends Fragment {
    private FragmentUserPageBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentUserPageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonPlanai.setOnClickListener(view12 -> {
            NavHostFragment.findNavController(UserPageFragment.this)
                            .navigate(R.id.action_userPageFragment_to_planaiFragment);
        });

        binding.buttonTreneriai.setOnClickListener(view14 -> {
            NavHostFragment.findNavController(UserPageFragment.this)
                .navigate(R.id.action_userPageFragment_to_planaiFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}