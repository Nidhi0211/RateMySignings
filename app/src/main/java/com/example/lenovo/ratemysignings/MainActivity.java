package com.example.lenovo.ratemysignings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    Button btn,ref;
    EditText eduser,edname,edage;

    private List<ListItem> listItems;
    private List<ListItem> listItems1;
    private List<ListItem> listItems2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref=(Button)findViewById(R.id.ref);
        btn=(Button)findViewById(R.id.btn);
        eduser=(EditText)findViewById(R.id.eduser);
        edname=(EditText)findViewById(R.id.edname);
        edage=(EditText)findViewById(R.id.edage);


        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems=new ArrayList<>();
        listItems1=new ArrayList<>();
        listItems2=new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("id/");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    String gid=ds.child("user").getValue().toString();
                    String name=ds.child("name").getValue().toString();
                    String age=ds.child("age").getValue().toString();
                    ListItem li=new ListItem(gid,name,age);
                    listItems.add(li);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        final DatabaseReference mRef = database.getReference("id");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListItem l=new ListItem(eduser.getText().toString(),edname.getText().toString(),edage.getText().toString());
                listItems.add(l);
                mRef.child(eduser.getText().toString()).setValue(l);
            }
        });
        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adapter=new MyAdapter(listItems,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }
        });


    }
}
