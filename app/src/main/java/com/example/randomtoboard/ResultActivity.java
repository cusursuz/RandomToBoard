package com.example.randomtoboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.net.ssl.SSLEngineResult;


public class ResultActivity extends AppCompatActivity {
    public HashMap<Integer, Integer> ClassHashMap = new HashMap<Integer, Integer>();
    protected Integer auRaspunsInt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        CLASS_ROOM class_room;
        ArrayList<CLASS_ROOM> list_class_room = new ArrayList<CLASS_ROOM>();
        TextView suntInClasa = (TextView) findViewById(R.id.textView4);
        TextView auRaspuns = (TextView) findViewById(R.id.textView);

        String inClassroom = getIntent().getStringExtra("inClassroom");

        suntInClasa.setText("In clasa sunt "+ inClassroom +" elevi");
        int inClass = Integer.parseInt(inClassroom);
        for(int i=0; i<=inClass; i++){
            class_room = new CLASS_ROOM();
            class_room.setStudent_id(i);
            class_room.setIs_board(0);

            list_class_room.add(class_room);
        }

        Integer z = 0;
        TextView resultText = (TextView) findViewById(R.id.randomResult);
        do {
            resultText.setText("");
            z = randomGenerate(list_class_room.size());
            if(list_class_room.get(z).getIs_board() == 0){
                list_class_room.get(z).setIs_board(1);

                resultText.setText("" + ++z);
                auRaspunsInt++;
                auRaspuns.setText("Deja a fost ales "+ auRaspunsInt +" elevi");

                break;
            }
            z++;
        }while (list_class_room.get(z).getIs_board() == 1);

        Button newRand = (Button) findViewById(R.id.testButton);
        newRand.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Integer z = 0;
                                        TextView resultText = (TextView) findViewById(R.id.randomResult);
                                        do {
                                            resultText.setText("");
                                            z = randomGenerate(list_class_room.size());
                                            if(list_class_room.get(z).getIs_board() == 0){
                                                list_class_room.get(z).setIs_board(1);

                                                resultText.setText("" + ++z);
                                                auRaspunsInt++;
                                                auRaspuns.setText("Deja au fost alesi "+ auRaspunsInt +" elevi");
                                                if(auRaspunsInt == inClass){
                                                    TextView textView2 = (TextView) findViewById(R.id.textView2);
                                                    Button nextButton = (Button) findViewById(R.id.testButton);
//                                                  textView2.setVisibility(View.INVISIBLE);
                                                    nextButton.setVisibility(View.INVISIBLE);

                                                    Button exitButton = (Button) findViewById(R.id.testButton2);
                                                    exitButton.setVisibility(View.VISIBLE);
                                                }
                                                break;
                                            }
                                            z++;
                                        }while (list_class_room.get(z).getIs_board() == 1);

                                    }
                                }
        );
        Button exitButton = (Button) findViewById(R.id.testButton2);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();

                System.exit(0);
            }
        });
    }
    private int randomGenerate(Integer size){
        Random rand = new Random();
        int randomInteger = rand.nextInt(--size);
        return randomInteger;
    }
}