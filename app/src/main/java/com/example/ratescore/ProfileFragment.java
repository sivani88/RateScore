package com.example.ratescore;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {

        Button buttonMettreAjour, buttonDeconnexion, buttonSupprimerCompte;
        private UserManager userManager = UserManager.getInstance();
        ImageView mImageProfile;
        TextView mViewName, mViewEmail;
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        buttonDeconnexion = view.findViewById(R.id.buttonDeconnexion);
        buttonMettreAjour = view.findViewById(R.id.buttonMettreAJour);
        buttonSupprimerCompte = view.findViewById(R.id.buttonSupprimerMonCompte);
        mImageProfile = view.findViewById(R.id.imageViewProfile);
        mViewEmail = view.findViewById(R.id.textView3);
        mViewName = view.findViewById(R.id.textView4);
        setUpListener();
        return view;


    }
    private void updateUIWithUserData() {
        if(userManager.isCurrentUserLogged()) {
            FirebaseUser user = userManager.getCurrentUser();

            if(user.getPhotoUrl() != null) {
                setProfilePicture(user.getPhotoUrl());
            }
            setTextUserData(user);
        }
    }
    private void setProfilePicture(Uri profilePictureUrl) {
        Glide.with(this)
                .load(profilePictureUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(mImageProfile);
    }
    private void setTextUserData(FirebaseUser user) {
        String email = TextUtils.isEmpty(user.getEmail()) ?
                getString(R.string.info_no_email_found) : user.getEmail();
                String userName = TextUtils.isEmpty(user.getDisplayName()) ? getString(R.string.info_no_username_found): user.getDisplayName();
               mViewName.setText(userName);
               mViewEmail.setText(email);

    }
    private void setUpListener() {
        buttonSupprimerCompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        buttonDeconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        buttonMettreAjour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}