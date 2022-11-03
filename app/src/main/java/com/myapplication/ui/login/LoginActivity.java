package com.myapplication.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.myapplication.Instance.ApiInterface;
import com.myapplication.Instance.ApiUtils;
import com.myapplication.Model.Post;
import com.myapplication.Model.UrlData;
import com.myapplication.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    ApiInterface mAPIService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.userName);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.btnSubmit);

       /* mAPIService = ApiUtils.getAPIService();*/

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.159:4000/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                 mAPIService = retrofit.create(ApiInterface.class);

                 sendPost(userName,password);

            }
        });

    }

    private void sendPost(String userName, String password) {
        Post post = new Post();
        post.setUserName(userName);
        post.setPassword(password);
        Call<Post> call = mAPIService.sendPosts(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (response.isSuccessful()) {
                    String res = response.body().toString();
                }else {
                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /*public void sendPost(String username, String password) {
        mAPIService.savePost(username, password).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(@NotNull Call<Post> call, @NotNull Response<Post> response) {

                if(response.isSuccessful()) {
                    String res = response.body().toString();
                }else{
                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<Post> call, @NotNull Throwable t) {
                Toast.makeText(LoginActivity.this, "Unable to submit post to API." + t, Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    /*public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }*/
}