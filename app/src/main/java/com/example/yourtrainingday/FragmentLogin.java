package com.example.yourtrainingday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.yourtrainingday.databinding.FragmentLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        binding.button.setOnClickListener(view1 -> {
            NavHostFragment.findNavController(FragmentLogin.this)
                    .navigate(R.id.action_userPageFragment_to_planaiFragment);
            //getAccessToken(FragmentLogin.this)
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        binding = null;

        etUsername = null;
        etPassword = null;
    }

    public void getAccessToken(FragmentLogin fragmentLogin) {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        Call<AccessToken> call1 = service.getAccessToken(
                Constants.CLIENT_ID,
                Constants.GRANT_TYPE,
                Constants.CLIENT_SECRET,
                Constants.SCOPE,
                username,
                password
        );
        call1.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(@NonNull Call<AccessToken> call, @NonNull Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Constants.REFRESH_TOKEN = response.body().getRefreshToken();

                    NavHostFragment.findNavController(fragmentLogin)
                            .navigate(R.id.action_userPageFragment_to_planaiFragment);

                    /*
                    Fragment newFragment = new UserPageFragment();

                    FragmentTransaction transaction = requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction();
                    transaction.replace(R.id.main_container, newFragment);
                    transaction.setPrimaryNavigationFragment(newFragment);
                    transaction.commit();

                    binding.button.setVisibility(View.GONE);
                    binding.editTextTextPersonName.setVisibility(View.GONE);
                    binding.editTextTextPassword.setVisibility(View.GONE);

                     */

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
    }
}