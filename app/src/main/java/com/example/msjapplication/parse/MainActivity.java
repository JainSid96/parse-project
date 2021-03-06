package com.example.msjapplication.parse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("5a967a381894abccdb56c1c6ecc4b385409b1c3f")
                .clientKey("630027cb21a16f374934feedd9195e90a86f6711")
                .server("http://ec2-13-126-125-192.ap-south-1.compute.amazonaws.com:80/parse/")
                .build()
        );
        ParseObject object = new ParseObject("ExampleObject");
        object.put("myNumber", "2713");
        object.put("myString", "Siddhant");
        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException ex) {
                if (ex == null) {
                    Log.i("Parse Result", "Successful!");
                } else {
                    Log.i("Parse Result", "Failed" + ex.toString());
                }
            }
        });

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
