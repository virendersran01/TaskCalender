package com.virtualstudios.taskcalender.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.virtualstudios.taskcalender.databinding.ActivityLoginBinding;
import com.virtualstudios.taskcalender.utilities.PreferenceManager;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private GoogleSignInClient mGoogleSignInClient;
    private final int RC_SIGN_IN = 0;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManager = new PreferenceManager(getApplicationContext());
        if (preferenceManager.getLoginStatus()){
            startActivity(new Intent(this, MainActivity.class));
        }
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        binding.buttonGoogle.setOnClickListener(v -> {
//            signIn();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
//        if (account != null) {
//            String personName = account.getDisplayName();
//            String personGivenName = account.getGivenName();
//            String personFamilyName = account.getFamilyName();
//            String personEmail = account.getEmail();
//            String personId = account.getId();
//            Uri personPhoto = account.getPhotoUrl();
//        }

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
           // Log.d("TAG", "handleSignInResult: "+account.toString());
            if (account != null) {
                String personName = account.getDisplayName();
                String personGivenName = account.getGivenName();
                String personFamilyName = account.getFamilyName();
                String personEmail = account.getEmail();
                String personId = account.getId();
                Uri personPhoto = account.getPhotoUrl();

                preferenceManager.setLoginStatus(true);
                preferenceManager.setUserId(personId);
                preferenceManager.setUserFullName(personName);
                preferenceManager.setUserEmail(personEmail);
                preferenceManager.setProfilePicUrl(personPhoto.toString());

                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("TAG", "signInResult:failed code=" + e.getStatusCode());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            //updateUI(null);
        }
    }
}