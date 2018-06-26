/*
 * Copyright (c) 2018. EypCnn
 */

package com.eypcnn.uygulamaicieypcnn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.github.javiersantos.piracychecker.PiracyChecker;
import com.github.javiersantos.piracychecker.enums.PirateApp;

public class Donation extends AppCompatActivity implements  AppData{

    CardView cookie,dietcola,coffee,buttermilk,fastfoot,popcorn,gift;

    BillingProcessor bp;
    private boolean readyToPurchase = false;
    private static final String LOG_TAG = "iabv3";
    SharedPreferences prefs;

    float userPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        PirateApp app = new PirateApp("Lucky Patcher", "com.android.vending.billing.InAppBillingService.COIN");
        new PiracyChecker(this)
                .addAppToCheck(app)
                .start();

        cookie = (CardView) findViewById(R.id.cookie);
        dietcola = (CardView) findViewById(R.id.dietcola);
        coffee = (CardView) findViewById(R.id.coffee);
        buttermilk = (CardView) findViewById(R.id.buttermilk);
        fastfoot = (CardView) findViewById(R.id.fastfoot);
        popcorn = (CardView) findViewById(R.id.popcorn);
        gift = (CardView) findViewById(R.id.gift);


        prefs = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        ////// billing processor

        if(!BillingProcessor.isIabServiceAvailable(this)) {

        }

        bp = new BillingProcessor(this, GOOGLE_BILLING_KEY, new BillingProcessor.IBillingHandler() {
            @Override
            public void onProductPurchased(String productId, TransactionDetails details) {


                if (productId.equals(BUY_COOKIE)){
                }
                if (productId.equals(BUY_DIETCOLA)){
                }
                if (productId.equals(BUY_COFFEE)){
                }
                if (productId.equals(BUY_BUTTERMILK)){
                }
                if (productId.equals(BUY_FASTFOOD)){
                }
                if (productId.equals(BUY_POPCORN)){
                }
                if (productId.equals(BUY_GIFT)){
                }


            }
            @Override
            public void onBillingError(int errorCode, Throwable error) {


            }
            @Override
            public void onBillingInitialized() {
                readyToPurchase = true;

            }
            @Override
            public void onPurchaseHistoryRestored() {
                for(String sku : bp.listOwnedProducts())
                    System.out.println("Owned Managed Product: " + sku);
                for(String sku : bp.listOwnedSubscriptions())
                    System.out.println("Owned Subscription: " + sku);
                // updateTextViews();
            }
        });
    }

    public void setCookie(View view){
        bp.purchase(Donation.this,BUY_COOKIE);
    }

    public void setDietcola(View view){
        bp.purchase(Donation.this,BUY_DIETCOLA);
    }

    public void setCoffee(View view){
        bp.purchase(Donation.this,BUY_COFFEE);
    }

    public void setButtermilk(View view){
        bp.purchase(Donation.this,BUY_BUTTERMILK);
    }

    public void setFastfoot(View view){
        bp.purchase(Donation.this,BUY_FASTFOOD);
    }

    public void setPopcorn(View view){
        bp.purchase(Donation.this,BUY_POPCORN);
    }

    public void setGift(View view){
        bp.purchase(Donation.this,BUY_GIFT);
    }

    public void consumeInapp (String productId){
        Boolean consumed = bp.consumePurchase(productId);
    }

    @Override
    public void onDestroy() {
        if (bp != null)
            bp.release();
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data))
            super.onActivityResult(requestCode, resultCode, data);
    }


}
