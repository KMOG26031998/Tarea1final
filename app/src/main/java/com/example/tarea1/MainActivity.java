package com.example.tarea1;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView txtNacimiento;
    private DatePickerDialog.OnDateSetListener Fecha;
    private  EditText txtNombre,txtTelefono;
   RadioGroup rg;
   RadioButton rb;
    int radiobuttons;
    //NOTA: AL AGREGAR LA FECHA DE NACIMIENTO DAR DOBLE CLIC
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg=(RadioGroup)findViewById(R.id.RG);

           txtNacimiento = (TextView) findViewById(R.id.TxtNacimiento);
            txtNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNacimiento.setInputType(InputType.TYPE_NULL);
                 Calendar cl = Calendar.getInstance();
                int anio = cl.get(Calendar.YEAR);
                int mes = cl.get(Calendar.MONTH);
                int dia = cl.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        Fecha,
                        anio,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        Fecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                mes = mes + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + mes + "/" + dia + "/" + anio);
                String date = mes + "/" + dia + "/" + anio;
                txtNacimiento.setText(date);
            }
        };
    }
     public void btnEnviar(View view) {
       Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        txtNombre = (EditText) findViewById(R.id.TxtNombre);
        txtTelefono = (EditText) findViewById(R.id.TxtTelefono);
        try {
            if (Validarcamposvacios()) {
                Toast.makeText(this, "Perfecto!", Toast.LENGTH_SHORT).show();
                Bundle a = new Bundle();
                Bundle b = new Bundle();
                Bundle c = new Bundle();
                Bundle d = new Bundle();
                a.putString("NOMBRE", txtNombre.getText().toString());
                b.putString("TELEFONO", txtTelefono.getText().toString());
                c.putString("FNACIMIENTO", txtNacimiento.getText().toString());
                d.putString("FEMAS", rb.getText().toString());
                intent.putExtras(a);
                intent.putExtras(b);
                intent.putExtras(c);
                intent.putExtras(d);
                startActivity(intent);
            }
        }catch(Exception e){
            Toast.makeText(this, "Selecciona su Genero", Toast.LENGTH_SHORT).show();
        }
    }
     public boolean Validarcamposvacios(){
        boolean retorno=true;
        String c1= txtNombre.getText().toString();
        String c2=txtTelefono.getText().toString();
        String c3=txtNacimiento.getText().toString();
        if(c1.isEmpty()){
            Toast.makeText(this, "Debes de ingresar sus nombres", Toast.LENGTH_SHORT).show();
            retorno=false;
        }if(c2.isEmpty()){
            Toast.makeText(this, "Debes de ingresar el numero telefonico", Toast.LENGTH_SHORT).show();
            retorno=false;
        }if(c3.isEmpty()){
             Toast.makeText(this, "Debes de ingresar tu fecha de nacimiento", Toast.LENGTH_SHORT).show();
             retorno=false;
         }
        return retorno;
     }
     public void rbclick(View view){
         radiobuttons= rg.getCheckedRadioButtonId();
         rb=(RadioButton)findViewById(radiobuttons);

    }
}