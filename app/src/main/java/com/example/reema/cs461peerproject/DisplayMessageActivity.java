package com.example.reema.cs461peerproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Map;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayMessageActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private DatabaseReference messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void addToDatabase(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();


        //database stuff

        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //System.out.println(mDatabase);
        messages = mDatabase.child("messages");

        messages.setValue(message);


        startActivity(intent);
    }


//    private void submitPost() {
//
//        // Disable button so there are no multi-posts
//        Toast.makeText(this, "Posting...", Toast.LENGTH_SHORT).show();
//        System.out.println(message);
//        writeNewPost(message);
//        // [START single_value_read]
////        final String userId = getUid();
////        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(
////                new ValueEventListener() {
////                    @Override
////                    public void onDataChange(DataSnapshot dataSnapshot) {
//////                        // Get user value
//////                        User user = dataSnapshot.getValue(User.class);
//////
//////                        // [START_EXCLUDE]
//////                        if (user == null) {
//////                            // User is null, error out
//////                            Log.e(TAG, "User " + userId + " is unexpectedly null");
//////                            Toast.makeText(NewPostActivity.this,
//////                                    "Error: could not fetch user.",
//////                                    Toast.LENGTH_SHORT).show();
//////                        } else {
////                            // Write new post
////                            writeNewPost(message);
//////                        }
////
////                        // Finish this Activity, back to the stream
////                        //setEditingEnabled(true);
////                        finish();
////                        // [END_EXCLUDE]
////                    }
////
////                    @Override
////                    public void onCancelled(DatabaseError databaseError) {
////                        //Log.w(TAG, "getUser:onCancelled", databaseError.toException());
////                        // [START_EXCLUDE]
////                        //setEditingEnabled(true);
////                        // [END_EXCLUDE]
////                        return;
////                    }
////                });
//        // [END single_value_read]
//
//    }
//
//    // [START write_fan_out]
//    private void writeNewPost(String message) {
//        // Create new post at /user-posts/$userid/$postid and at
//        // /posts/$postid simultaneously
//        String key = mDatabase.child("posts").push().getKey();
//        //Post post = new Post(userId, message);
//        Map<String, Object> newMap = new HashMap<>();
//        newMap.put("message", message);
//
//        Map<String, Object> childUpdates = new HashMap<>();
//        childUpdates.put("/posts/" + key, newMap);
//
//        mDatabase.updateChildren(childUpdates);
//    }
//    // [END write_fan_out]
//
//
//
//}

}