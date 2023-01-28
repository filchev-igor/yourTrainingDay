package com.example.yourtrainingday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.yourtrainingday.databinding.FragmentLoginBinding;

public class FragmentLogin extends Fragment {
    private EditText etUsername;
    private EditText etPassword;
    private FragmentLoginBinding binding;

    public FragmentLogin() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);

        etUsername = binding.editTextTextPersonName;
        etPassword = binding.editTextTextPassword;

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(view1 -> getAccessToken());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        etUsername = null;
        etPassword = null;
    }

    public void getAccessToken() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();


        NavHostFragment
                .findNavController(FragmentLogin.this)
                .navigate(R.id.secondFragment);
                //.setPopUpTo(findNavController().graph.startDestination, true).build());


        /*
        Fragment newFragment = new FirstFragment();

        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.nav_host_fragment_content_main, newFragment)
                .setPrimaryNavigationFragment(newFragment)
                .commit();

         */

                /*
        NavHostFragment
                .findNavController(FragmentLogin.this)
                .navigate(R.id.action_fragmentLogin_to_secondFragment);

                 */


        /*
        Call<AccessToken> call1 = service.getAccessToken(
                "Login",
                "password",
                "kOETUEGYPx7a3wDOuf2emGlF4MqFwv4Q",
                "openid",
                username,
                password
        );
        call1.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(@NonNull Call<AccessToken> call, @NonNull Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(getActivity(), SecondFragment.class);
                    Intent intent2 = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent2);
                }
                else {
                    Toast.makeText(getActivity(), "onResponse error:", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AccessToken> call, @NonNull Throwable throwable) {
                Toast.makeText(getActivity(), "onFailure error:", Toast.LENGTH_LONG).show();

                call.cancel();
            }
        });

         */
    }
}