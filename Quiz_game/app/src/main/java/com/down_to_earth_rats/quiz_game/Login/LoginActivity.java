package com.down_to_earth_rats.quiz_game.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.down_to_earth_rats.quiz_game.R;
import com.down_to_earth_rats.quiz_game.databinding.ActivityLoginBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Created by Erik Blomberg
 *
 *
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());

        TextInputLayout usernameInputLayout = binding.usernameInputLayout;
        TextInputEditText usernameInputEdit = binding.usernameInputEdit;

        TextInputLayout passwordInputLayout = binding.passwordInputLayout;
        TextInputEditText passwordInputEdit = binding.passwordInputEdit;

        MaterialButton loginButton = binding.loginButton;

        setContentView(binding.getRoot());
    }

}