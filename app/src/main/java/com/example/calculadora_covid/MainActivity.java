package com.example.calculadora_covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton gMujer, gHombre, pBajo, pNormal, pSobre, pObe;
    private Switch paHiper, paDiab, paEpoc, paRen, paInmu;
    private TextView Riesgo, msg;
    private Spinner Edad;
    String sEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gHombre = (RadioButton) findViewById(R.id.rdbHombre);
        gMujer = (RadioButton) findViewById(R.id.rdbMujer);
        pBajo = (RadioButton) findViewById(R.id.rbdBajo);
        pNormal = (RadioButton) findViewById(R.id.rdbNormal);
        pSobre = (RadioButton) findViewById(R.id.rdbSobrepeso);
        pObe = (RadioButton) findViewById(R.id.rdbObesidad);
        paDiab = (Switch) findViewById(R.id.swtDiabetes);
        paHiper = (Switch) findViewById(R.id.swtHipertencion);
        paEpoc = (Switch) findViewById(R.id.swtEpoc);
        paRen = (Switch) findViewById(R.id.swtRenal);
        paInmu = (Switch) findViewById(R.id.swtInmuno);
        Riesgo = (TextView) findViewById(R.id.txvRiesgo);
        msg = (TextView) findViewById(R.id.txtMsg);
        Edad = (Spinner) findViewById(R.id.spnEdad);
        Edad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sEdad = (String) Edad.getSelectedItem();
                if(gMujer.isChecked() && Integer.parseInt(sEdad) <= 53) {
                    Riesgo.setText("0");
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }else{
                    if(gMujer.isChecked() && Integer.parseInt(sEdad) >= 54){
                        Riesgo.setText("1");
                        msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                        msg.setText("Riesgo alto para cuadro grave COVID-19");
                    }
                }

                if(gHombre.isChecked() && Integer.parseInt(sEdad) <= 45) {
                    Riesgo.setText("1");
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }else{
                    if(gHombre.isChecked() && Integer.parseInt(sEdad) >= 46){
                        Riesgo.setText("2");
                        msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                        msg.setText("Riesgo alto para cuadro grave COVID-19");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void checkGenero(View view){
        if(gHombre.isChecked()){
            Riesgo.setText("1");
            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
            msg.setText("Riesgo medio para cuadro grave COVID-19");

        }else{
            if(gMujer.isChecked()){
                Riesgo.setText("0");
                msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                msg.setText("Riesgo medio para cuadro grave COVID-19");
            }
        }
    }

    public void checkPeso(View view){
        if(Integer.parseInt(sEdad) >= 54 && gMujer.isChecked() && pSobre.isChecked() || Integer.parseInt(sEdad) >= 54 && gMujer.isChecked() && pObe.isChecked()){
            Riesgo.setText("2");
            msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
            msg.setText("Riesgo alto para cuadro grave COVID-19");
        }

        if(Integer.parseInt(sEdad) >= 54 && gMujer.isChecked() && pBajo.isChecked() || Integer.parseInt(sEdad) >= 54 && gMujer.isChecked() && pNormal.isChecked()){
            Riesgo.setText("1");
            msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
            msg.setText("Riesgo alto para cuadro grave COVID-19");
        }

        if(Integer.parseInt(sEdad) <= 53 && gMujer.isChecked() && pSobre.isChecked() || Integer.parseInt(sEdad) <= 53 && gMujer.isChecked() && pObe.isChecked()){
            Riesgo.setText("1");
            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
            msg.setText("Riesgo medio para cuadro grave COVID-19");
        }

        if(Integer.parseInt(sEdad) <= 53 && gMujer.isChecked() && pBajo.isChecked() || Integer.parseInt(sEdad) <= 53 && gMujer.isChecked() && pNormal.isChecked()){
            Riesgo.setText("0");
            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
            msg.setText("Riesgo medio para cuadro grave COVID-19");
        }

        if(Integer.parseInt(sEdad) >= 46 && gHombre.isChecked() && pSobre.isChecked() || Integer.parseInt(sEdad) >= 46 && gHombre.isChecked() && pObe.isChecked()){
            Riesgo.setText("3");
            msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
            msg.setText("Riesgo alto para cuadro grave COVID-19");
        }

        if(Integer.parseInt(sEdad) >= 46 && gHombre.isChecked() && pBajo.isChecked() || Integer.parseInt(sEdad) >= 46 && gHombre.isChecked() && pNormal.isChecked()){
            Riesgo.setText("2");
            msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
            msg.setText("Riesgo alto para cuadro grave COVID-19");
        }

        if(Integer.parseInt(sEdad) <= 45 && gHombre.isChecked() && pSobre.isChecked() || Integer.parseInt(sEdad) <= 45 && gHombre.isChecked() && pObe.isChecked()){
            Riesgo.setText("2");
            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
            msg.setText("Riesgo medio para cuadro grave COVID-19");
        }

        if(Integer.parseInt(sEdad) <= 45 && gHombre.isChecked() && pBajo.isChecked() || Integer.parseInt(sEdad) <= 45 && gHombre.isChecked() && pNormal.isChecked()){
            Riesgo.setText("1");
            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
            msg.setText("Riesgo medio para cuadro grave COVID-19");
        }
    }

    public void checkHipertencion(View view){
        if(paHiper.isChecked()){
            aumentar();
            checkRiesgo();
        }else{
            disminuir();
            checkRiesgo();
        }
    }
    public void checkDiabetes(View view){
        if(paDiab.isChecked()){
            aumentar();
            checkRiesgo();
        }else{
            disminuir();
            checkRiesgo();
        }
    }
    public void checkEpoc(View view){
        if(paEpoc.isChecked()){
            aumentar();
            checkRiesgo();
        }else{
            disminuir();
            checkRiesgo();
        }
    }
    public void checkRenal(View view){
        if(paRen.isChecked()){
            aumentar();
            checkRiesgo();
        }else{
            disminuir();
            checkRiesgo();
        }
    }
    public void checkInmuno(View view){
        if(paInmu.isChecked()){
            aumentar();
            checkRiesgo();
        }else{
            disminuir();
            checkRiesgo();
        }
    }

    public void aumentar(){
        String data = (String) Riesgo.getText();
        int vRiesgo = Integer.parseInt(data)+1;
        Riesgo.setText(String.valueOf(vRiesgo));
    }

    public void disminuir(){
        String data = (String) Riesgo.getText();
        int vRiesgo = Integer.parseInt(data)-1;
        Riesgo.setText(String.valueOf(vRiesgo));
    }

    public void checkRiesgo(){
        String data = (String) Riesgo.getText();
        int vRiesgo = Integer.parseInt(data);
        if(vRiesgo > 3){
            msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
            msg.setText("Riesgo alto para cuadro grave COVID-19");
        }else{
            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
            msg.setText("Riesgo medio para cuadro grave COVID-19");
        }
    }
}