package com.firebasedbManage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*getReference we can also set Root  */
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        User user = new User("Swati", "vswati.vishnoi@gmail.com");

        /* users main root >> swati_1 is sub root >> user model set entities*/
        mDatabase.child("users").child("Swati_1").setValue(user);


       writeNode();
    }


    private void writeNode() {
        List<String> subNodeList=new ArrayList<>();
        subNodeList.add("SubPain1");
        subNodeList.add("SubPain2");
        subNodeList.add("SubPain3");
        List<String>NodeList=new ArrayList<>();
        NodeList.add("Pain");
        NodeList.add("Pain2");
        NodeList.add("Pain3");
        for(int i=0;i<NodeList.size();i++){
            saveData(NodeList.get(i),subNodeList);
        }

    }

    private void saveData(String table_node, List<String>subNodeList){
        for(int i=0;i<subNodeList.size();i++) {
            mDatabase.child("Sicknes").child(table_node).child(subNodeList.get(i)).setValue(subNodeList.get(i));
        }
    }
}
