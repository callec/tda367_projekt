package com.down_to_earth_rats.quiz_game.Login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.down_to_earth_rats.quiz_game.MainActivity;
import com.down_to_earth_rats.quiz_game.UserPackage.ILoginService;
import com.down_to_earth_rats.quiz_game.UserPackage.LoginServiceFactory;
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

        final TextInputLayout usernameInputLayout = binding.usernameInputLayout;
        final TextInputEditText usernameInputEdit = binding.usernameInputEdit;

        final TextInputLayout passwordInputLayout = binding.passwordInputLayout;
        final TextInputEditText passwordInputEdit = binding.passwordInputEdit;

        final MaterialButton loginButton = binding.loginButton;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ILoginService loginService = LoginServiceFactory.getStandardService();

                String username;
                String password;

                if(TextUtils.isEmpty(usernameInputEdit.getText())){
                    usernameInputLayout.setError("Fyll i användarnamn");
                    return;
                } else{
                    usernameInputLayout.setError(null);
                    username = usernameInputEdit.getText().toString();
                }

                if(TextUtils.isEmpty(passwordInputEdit.getText())){
                    passwordInputLayout.setError("Fyll i lösenord");
                    return;
                } else{
                    passwordInputLayout.setError(null);
                    password = passwordInputEdit.getText().toString();
                }

                loginService.registerUser(username, password);

                if(loginService.loginUser(username,password)){
                    nextActivity();
                }else{
                    passwordInputLayout.setError("Fel lösenord");
                }


            }
        });

        setContentView(binding.getRoot());
    }

    private void nextActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}