package com.example.yusi.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by yusi on 15/04/16.
 */
public class LoginWithFacebookActivity extends Activity {

    private TextView info;
    private ArrayList<String>User;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private AccessToken accessToken;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     *
     */
    private GoogleApiClient client;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.login_facebook_layout);
        callbackManager = CallbackManager.Factory.create();

        info = (TextView)findViewById(R.id.info);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    GraphRequest request = GraphRequest.newMeRequest(
                            loginResult.getAccessToken(),
                            new GraphRequest.GraphJSONObjectCallback() {

                                @Override
                                public void onCompleted(JSONObject object, GraphResponse response) {
                                    Log.v("Main", response.toString());
                                    LoginWithFacebookActivity.this.finish();
                                    Intent intent = new Intent(LoginWithFacebookActivity.this, MainMenuActivity.class);
                                    startActivity(intent);
                                }
                            });
                    Bundle parameters = new Bundle();
                    parameters.putString("fields", "id,name,email,gender, birthday");
                    request.setParameters(parameters);
                    request.executeAsync();
                }


                @Override
            public void onCancel() {
             //   info.setText("Login attempt canceled.");

            }

            @Override
            public void onError(FacebookException e) {
              //  info.setText("Login attempt failed.");

            }



        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}


