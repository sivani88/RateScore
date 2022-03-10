package com.example.ratescore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;

public class TwitterActivity extends MainActivity {
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();

        OAuthProvider.Builder provider = OAuthProvider.newBuilder("twitter.com");

        // Target specific email with login hint.
        provider.addCustomParameter("lang", "fr");


        Task<AuthResult> pendingResultTask = firebaseAuth.getPendingAuthResult();
        if (pendingResultTask != null) {
            // There's something already here! Finish the sign-in for your user.
            pendingResultTask
                    .addOnSuccessListener(
                            new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    startActivity(new Intent(TwitterActivity.this, FragmentActivity.class));

                                    Toast.makeText(TwitterActivity.this, "great login successful ", Toast.LENGTH_SHORT).show();
                                    // User is signed in.
                                    // IdP data available in
                                    // authResult.getAdditionalUserInfo().getProfile().
                                    // The OAuth access token can also be retrieved:
                                    // authResult.getCredential().getAccessToken().
                                    // The OAuth secret can be retrieved by calling:
                                    // authResult.getCredential().getSecret().
                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(TwitterActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.e("Twitter failed", e.getMessage());
                                }
                            });
        } else {
            firebaseAuth
                    .startActivityForSignInWithProvider(/* activity= */ this, provider.build())
                    .addOnSuccessListener(
                            new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    startActivity(new Intent(TwitterActivity.this, FragmentActivity.class));
                                    Toast.makeText(TwitterActivity.this, "great login successful ", Toast.LENGTH_SHORT).show();
                                    // User is signed in.
                                    // IdP data available in
                                    // authResult.getAdditionalUserInfo().getProfile().
                                    // The OAuth access token can also be retrieved:
                                    // authResult.getCredential().getAccessToken().
                                    // The OAuth secret can be retrieved by calling:
                                    // authResult.getCredential().getSecret().
                                }
                            })
                    .addOnFailureListener(
                            new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(TwitterActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                                    // Handle failure.
                                    Log.e("Twitter failed", e.getMessage());
                                }
                            });
        }
    }
}