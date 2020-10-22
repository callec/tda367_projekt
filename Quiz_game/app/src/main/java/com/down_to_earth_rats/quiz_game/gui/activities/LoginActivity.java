package com.down_to_earth_rats.quiz_game.gui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.down_to_earth_rats.quiz_game.user.ILoginService;
import com.down_to_earth_rats.quiz_game.user.LoginServiceFactory;
import com.down_to_earth_rats.quiz_game.databinding.ActivityLoginBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Created by Erik Blomberg
 *
 * This is the Activity used to log in.
 * It consists of Username and passwords fields and a "Log in" button
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Binding stuff

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

                //The Username-field cannot be empty
                if(TextUtils.isEmpty(usernameInputEdit.getText())){
                    usernameInputLayout.setError("Fyll i användarnamn");
                    return;
                } else{
                    usernameInputLayout.setError(null);
                    username = usernameInputEdit.getText().toString();
                }

                //The Password-field cannot be empty
                if(TextUtils.isEmpty(passwordInputEdit.getText())){
                    passwordInputLayout.setError("Fyll i lösenord");
                    return;
                } else{
                    passwordInputLayout.setError(null);
                    password = passwordInputEdit.getText().toString();
                }

                //Try registering. If the registering is unsuccessful, the user already exists.
                loginService.registerUser(username, password);

                //Followed by an login. If that fails, the password must be wrong
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