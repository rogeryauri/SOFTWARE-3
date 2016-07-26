package com.example.yack.holamundo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    EditText txtuser,txtpass;
    Button txtboton;
    String url = "";
    String parametros ="";
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtuser = (EditText)findViewById(R.id.txtuser);
        txtpass = (EditText)findViewById(R.id.txtpass);
        final TextView registerLink  = (TextView) findViewById(R.id.textregistro);
        final Button paginaprincipal  = (Button) findViewById(R.id.txtboton);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent =new Intent(MainActivity.this, registro.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });

        paginaprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    String user = txtuser.getText().toString();
                    String pass = txtpass.getText().toString();
                    if (user.isEmpty()|| pass.isEmpty()){
                        Toast.makeText(getApplication(),"Leller campo vacio",Toast.LENGTH_LONG).show();
                    }else{
                        new ConsultarDatos().execute("http://10.0.2.2:8080/login/consulta.php?txtuser="+user+"&txtpass="+pass);

                    }

                } else {
                    Toast.makeText(getApplication(),"conexion no detectada",Toast.LENGTH_LONG).show();
                }

                //new ConsultarDatos().execute("http://10.0.2.2:8080/login/consulta.php?usuario="+ txtuser.getText().toString()+"&contrasenia="+ txtpass.getText().toString());

            }
        });


    }
    private class ConsultarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String resultado) {

        if (resultado.contains("Bienvenido")){
            Intent principal= new Intent(MainActivity.this,lugar_1.class);
            startActivity(principal);
        }else{
            Toast.makeText(getApplication(),"usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
        }
        }
    }
    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
        InputStream is = null;
        // Only display the first 500 characters of the retrieved
        // web page content.
        int len = 500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            int response = conn.getResponseCode();
            Log.d("respuesta", "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            String contentAsString = readIt(is, len);
            return contentAsString;

            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
    public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }


}
