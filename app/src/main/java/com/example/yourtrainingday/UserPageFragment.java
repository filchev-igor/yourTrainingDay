package com.example.yourtrainingday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.navigation.fragment.NavHostFragment;

import com.example.yourtrainingday.databinding.FragmentSecondBinding;

public class UserPage extends Fragment {

    private FragmentUserPage binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = UserPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonPlanai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UserPage.this)
                        .navigate(R.id.action_userPageFragment_to_planaiFragment);
            }
            binding.buttonTreniruotes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(UserPage.this)
                            .navigate(R.id.action_userPageFragment_to_planaiFragment);
                }
                binding.buttonPratimai.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NavHostFragment.findNavController(UserPage.this)
                                .navigate(R.id.action_userPageFragment_to_planaiFragment);
                    }
            binding.buttonTreneriai.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            NavHostFragment.findNavController(UserPage.this)
                                    .navigate(R.id.action_userPageFragment_to_planaiFragment);
                        }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
        }