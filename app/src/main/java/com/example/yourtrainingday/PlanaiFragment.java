package com.example.yourtrainingday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.yourtrainingday.databinding.FragmentCoachBinding;
import com.example.yourtrainingday.databinding.FragmentPlanaiBinding;

public class PlanaiFragment extends Fragment {

    private FragmentPlanaiBinding binding;




    public PlanaiFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = FragmentPlanaiBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonTreneriai.setOnClickListener(view12 -> {
            NavHostFragment.findNavController(PlanaiFragment.this)
                    .navigate(R.id.action_planaiFragment_to_coachFragment);
        });

        binding.imageView4.setOnClickListener(view12 -> {
            NavHostFragment.findNavController(PlanaiFragment.this)
                    .navigate(R.id.action_planaiFragment_to_gymPlanFragment);
        });

        binding.imageView5.setOnClickListener(view12 -> {
            NavHostFragment.findNavController(PlanaiFragment.this)
                    .navigate(R.id.action_planaiFragment_to_homePlanFragment2);
        });

    }
}
