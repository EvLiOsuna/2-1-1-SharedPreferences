package mx.edu.ittepic.sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email;
    RadioButton h,m;
    CheckBox prog,esc,camin;
    Spinner spn;
    Button grd, obt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        h=findViewById(R.id.hombre);
        m=findViewById(R.id.mujer);
        prog=findViewById(R.id.program);
        esc=findViewById(R.id.escrit);
        camin=findViewById(R.id.camin);
        spn=findViewById(R.id.spinner);
        grd=findViewById(R.id.guardar);
        obt=findViewById(R.id.obtener);


    }
    public void guardarPreferencia (View v){

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("email", email.getText().toString());
        editor.putBoolean("hombre",h.isChecked());
        editor.putBoolean("mujer",m.isChecked());
        editor.putBoolean("programacion",prog.isChecked());
        editor.putBoolean("escritura",esc.isChecked());
        editor.putBoolean("caminata",camin.isChecked());

        //int seleccion = spn.getSelectedItemPosition();
        editor.putInt("signo",spn.getSelectedItemPosition());


        editor.commit();


        Toast.makeText(this,"Se han Guardado tus Datos", Toast.LENGTH_LONG).show();
    }


    public void obtenerPreferencia (View v){

        String eM;
        Boolean g1,g2,h1,h2,h3;
        int zod;

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        eM = sharedPreferences.getString("email",null);
        g1= sharedPreferences.getBoolean("hombre", false);
        g2= sharedPreferences.getBoolean("mujer", false);
        h1= sharedPreferences.getBoolean("programacion", false);
        h2= sharedPreferences.getBoolean("escritura", false);
        h3= sharedPreferences.getBoolean("caminata", false);
        zod = sharedPreferences.getInt("signo",0);

        email.setText(eM);
        h.setChecked(g1);
        m.setChecked(g2);
        prog.setChecked(h1);
        esc.setChecked(h2);
        camin.setChecked(h3);
        spn.setSelection(zod);

        Toast.makeText(this,"Configuracion Cargada", Toast.LENGTH_LONG).show();
    }
}
