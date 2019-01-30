/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Switch;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

//      ParseObject score = new ParseObject("Score");
//      score.put("UserName", "Sur");
//      score.put("Score", 100);
//      score.saveInBackground(new SaveCallback() {
//          @Override
//          public void done(ParseException e) {
//              if(e==null) {
//                  Log.i("SaveInBackground",  "Successful");
//              }
//              else {
//                  Log.i("SaveInBackground", "Failed! Exception: " + e.toString());
//              }
//          }
//      });

//      ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
//      query.getInBackground("LGdOiPaKXv", new GetCallback<ParseObject>() {
//          @Override
//          public void done(ParseObject parseObject, ParseException e) {
//              if(e == null && parseObject != null) {
//                  parseObject.put("Score", 50);
//                  parseObject.saveInBackground();
//
//                  Log.i("ObjectValue", parseObject.getString("UserName"));
//                  Log.i("ObjectValue", Integer.toString(parseObject.getInt("Score")));
//              }
//          }
//      });

      ParseObject tweet = new ParseObject("Tweet");
      tweet.put("username", "Andy");
      tweet.put("tweet", "I like Android Studio!");
      tweet.saveInBackground(new SaveCallback() {
          @Override
          public void done(ParseException e) {
              if(e == null) {
                  Log.i("Tweet", "Success");
              }
              else {
                  Log.i("Tweet", "Failure");
              }
          }
      });

      ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");
      query.getInBackground("w5BtgxQACU", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject parseObject, ParseException e) {
              if(e == null && parseObject!=null) {
                  parseObject.put("tweet", "Android Studio is alright");
                  parseObject.saveInBackground();
              }
          }
      });

    
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}