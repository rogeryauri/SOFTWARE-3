package com.example.yack.holamundo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtemail = (EditText) findViewById(R.id.txtemail);
        final EditText txtpass = (EditText) findViewById(R.id.txtpass);
        final Button txtboton = (Button) findViewById(R.id.txtboton);
        final TextView registerLink  = (TextView) findViewById(R.id.textregistro);
        
        registerLink.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent registerIntent =new Intent(MainActivity.this, registro.class);
            MainActivity.this.startActivity(registerIntent);
        }
    });
    }

}
