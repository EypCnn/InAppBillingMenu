/*
 * Copyright (c) 2018. EypCnn
 */

package com.eypcnn.satinalma;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void github(View view) {
        String url = getString(R.string.githublink);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void googleplus(View view) {
        String url = getString(R.string.googlepluslink);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void translate(View view) {
        String url = getString(R.string.translatelink);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void rate(View view) {
        Uri uri = Uri.parse(getString(R.string.appratelink));
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.android.vending");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(getString(R.string.appratelink))));
        }
    }

    public void paylas(View view) {
        Intent shareintent = new Intent(  );
        shareintent.setAction( Intent.ACTION_SEND );
        shareintent.putExtra( Intent.EXTRA_TEXT, getString(R.string.app_name) );
        shareintent.setType( "text/plain" );
        startActivity( shareintent );
    }

    public void instagram(View view) {
        Uri uri = Uri.parse(getString(R.string.instagramlink));
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.instagram.android");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(getString(R.string.instagramlink))));
        }
    }

    public void twitter(View view) {
        Uri uri = Uri.parse(getString(R.string.twitterlink));
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.twitter.android");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(getString(R.string.twitterlink))));
        }
    }


    public void donate(View view) {
        Intent cnn = new Intent(MainActivity.this, Donation.class);
        startActivity(cnn);
    }
}
