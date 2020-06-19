package com.example.tarea1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView TxtSaludo = (TextView)findViewById(R.id.TxtSaludo);
        Bundle bundle = this.getIntent().getExtras();
        TxtSaludo.setText("Hola! " + bundle.getString("NOMBRE")+" verifica si tus datos son correcto, tu genero es:" +bundle.getString("FEMAS")
                +" tu numero telefonico es: "+ bundle.getString("TELEFONO")+" y naciste el: "+bundle.getString("FNACIMIENTO"));
    }
}