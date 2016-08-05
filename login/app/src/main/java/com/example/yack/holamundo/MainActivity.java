package com.example.yack.holamundo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import cz.msebera.android.httpclient.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends AppCompatActivity {
    EditText txtuser,txtpass;
    Button txtboton;
    String url = "";
    String parametros ="";
    String us,pass;

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

    paginaprincipal.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
        EditText txtuser=(EditText)findViewById(R.id.txtuser);
        EditText txtpass=(EditText)findViewById(R.id.txtpass);
        us=txtuser.getText().toString();
        pass=txtpass.getText().toString();

        if(us.equals("")||pass.equals("")){
            Toast.makeText(MainActivity.this, "Llenar campo vacio",
                    Toast.LENGTH_LONG).show();
        }else if(us.equals(txtuser) && pass.equals(txtpass)){
            AsyncHttpClient cliente  =  new  AsyncHttpClient ();
            RequestParams params = new RequestParams();

            params.add("txtuser",us);
            params.add("txtpass",pass);
            cliente.post("http://192.168.25.223:8080/login/consulta.php?",params,new AsyncHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    if(statusCode==200){
                        String rs=new String(responseBody);
                            if(rs.equals("Bienvenido")){
                            Intent intent=new Intent(MainActivity.this,lugar_1.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "Bienvenido ",Toast.LENGTH_LONG).show();

                        }
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                }
            });
        }else{
            Toast.makeText(MainActivity.this, "Usuario incorrecto",Toast.LENGTH_LONG).show();
        }
 }
});
}
}

