package com.example.randomtoboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton  rand = (ImageButton) findViewById(R.id.randomizeButton);
        rand.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent myIntent = new Intent(v.getContext(), ResultActivity.class);
                                        EditText myText = (EditText) findViewById(R.id.studentsInClassroom);
                                        String inClassroom = myText.getText().toString();

                                        myIntent.putExtra("inClassroom", inClassroom);
                                        startActivityForResult(myIntent, 0);

//                                        if (inClassroom != ""){
//                                            myIntent.putExtra("inClassroom", inClassroom);
//                                            startActivityForResult(myIntent, 0);
//                                        }else{
//
//                                        }

                                    }
                                }

        );
    }
    public void randomize(){

    }
}