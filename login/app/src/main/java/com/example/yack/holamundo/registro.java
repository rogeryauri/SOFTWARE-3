package com.example.yack.holamundo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final EditText textnom1 = (EditText) findViewById(R.id.textnom1);
        final EditText textapell = (EditText) findViewById(R.id.textapell);
        final EditText textpass1 = (EditText) findViewById(R.id.textpass1);
        final EditText textpass2 = (EditText) findViewById(R.id.textpass2);
        final EditText textdni = (EditText) findViewById(R.id.textdni);
        final Button btnregistro = (Button) findViewById(R.id.btnregistro);


    }

}
