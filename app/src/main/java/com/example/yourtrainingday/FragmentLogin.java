package com.example.yourtrainingday;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.yourtrainingday.databinding.FragmentLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLogin extends Fragment {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
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
        btnLogin = binding.button;

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAccessToken();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

        etUsername = null;
        etPassword = null;
        btnLogin = null;
    }

    public void getAccessToken() {
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        Call<AccessToken> call = service.getAccessToken(
                "Login",
                "password",
                "Wyf8BSiIxWdlcsrs2i6eeLsF95AS0l0x",
                "openid",
                username,
                password
        );
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(@NonNull Call<AccessToken> call, @NonNull Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    //AccessToken accessToken = response.body();
                    Intent intent = new Intent(getActivity(), SecondFragment.class);
                    FragmentLogin.this.startActivity(intent);
                }
                else {
                    Toast.makeText(getActivity(), "Error:", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<AccessToken> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), "Error:", Toast.LENGTH_LONG).show();
            }
        });
    }
}