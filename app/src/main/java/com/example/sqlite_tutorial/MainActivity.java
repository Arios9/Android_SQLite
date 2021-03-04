package com.example.sqlite_tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button_viewall, button_add;
    EditText et_name,et_age;
    Switch sw_active;
    ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_views();
        add_listeners();
    }



    private void create_views() {

        button_viewall=findViewById(R.id.button_viewall);
        button_add=findViewById(R.id.button_add);
        et_name=findViewById(R.id.et_name);
        et_age=findViewById(R.id.et_age);
        sw_active=findViewById(R.id.sw_active);
        list_view=findViewById(R.id.list_view);

    }

    private void add_listeners() {

        button_viewall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                List<Person> everyone = databaseHelper.getList();

                ArrayAdapter arrayAdapter=new ArrayAdapter<Person>
                        (MainActivity.this, android.R.layout.simple_list_item_1,everyone);
                list_view.setAdapter(arrayAdapter);


            }
        });

        button_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String name=et_name.getText().toString();
                int age=Integer.parseInt(et_age.getText().toString());
                boolean is_active=sw_active.isChecked();

                Person person=new Person(name,age,is_active);

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success=databaseHelper.add_new_row(person);

                Toast.makeText(MainActivity.this, "Success: "+success, Toast.LENGTH_SHORT).show();
            }

        });

    }
}