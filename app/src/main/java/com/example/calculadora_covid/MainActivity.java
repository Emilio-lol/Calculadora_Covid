package com.example.calculadora_covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout main;
    private RadioButton gMujer, gHombre, pBajo, pNormal, pSobre, pObe;
    private Switch paHiper, paDiab, paEpoc, paRen, paInmu;
    private TextView Riesgo, msg, etEdad, etDiabetes, etHiper, etEPOC, etERC, etInmuno, etSobrepeso, etObesidad, etGenero;
    private Spinner Edad;
    private RadioGroup grSexo, grPeso;
    private int cont = 0;


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
        etEdad = (TextView) findViewById(R.id.paEdad);
        etSobrepeso = (TextView) findViewById(R.id.txvSobrepeso);
        etObesidad = (TextView) findViewById(R.id.paObesidad);
        etDiabetes = (TextView) findViewById(R.id.txvDiabetes2);
        etHiper = (TextView) findViewById(R.id.txvHiper2);
        etEPOC = (TextView) findViewById(R.id.txvEPOC);
        etERC = (TextView) findViewById(R.id.txvERC);
        etInmuno = (TextView) findViewById(R.id.txvInmuno);
        etGenero = (TextView) findViewById(R.id.paGenero2);
        Riesgo = (TextView) findViewById(R.id.txvRiesgo);
        msg = (TextView) findViewById(R.id.txtMsg);
        grSexo = (RadioGroup) findViewById(R.id.rdgSexo);
        grPeso = (RadioGroup) findViewById(R.id.rdgPeso);
        Edad = (Spinner) findViewById(R.id.spnEdad);

        Edad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Riesgo.setText("0");
                cont=0;
                check();
                checkPadecimientos();
                if(cont > 2){
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                }else{
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        grSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Riesgo.setText("0");
                cont=0;
                check();
                checkPadecimientos();
                if(cont > 2){
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                }else{
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }
            }
        });
        grPeso.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Riesgo.setText("0");
                cont=0;
                check();
                checkPadecimientos();
                if(cont > 2){
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                }else{
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }
            }
        });

        paDiab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(paDiab.isChecked()){
                    aumentar();
                    cont++;
                    etDiabetes.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                }else{
                    if(!paDiab.isChecked()){
                        disminuir();
                        cont--;
                        etDiabetes.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                    }
                }
                if(cont > 2){
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                }else{
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }
            }
        });

        paHiper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(paHiper.isChecked()){
                    aumentar();
                    cont++;
                    etHiper.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                }else{
                    if(!paHiper.isChecked()){
                        disminuir();
                        cont--;
                        etHiper.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                    }
                }
                if(cont > 2){
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                }else{
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }
            }
        });
        paEpoc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(paEpoc.isChecked()){
                    aumentar();
                    cont++;
                    etEPOC.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                }else{
                    if(!paEpoc.isChecked()){
                        disminuir();
                        cont--;
                        etEPOC.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                    }
                }
                if(cont > 2){
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                }else{
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }
            }
        });
        paRen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(paRen.isChecked()){
                    aumentar();
                    cont++;
                    etERC.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                }else{
                    if(!paRen.isChecked()){
                        disminuir();
                        cont--;
                        etERC.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                    }
                }
                if(cont > 2){
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                }else{
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }
            }
        });

        paInmu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(paInmu.isChecked()){
                    aumentar();
                    cont++;
                    etInmuno.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                }else{
                    if(!paInmu.isChecked()){
                        disminuir();
                        cont--;
                        etInmuno.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                    }
                }
                if(cont > 2){
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                }else{
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }
            }
        });
    }

    public void check(){
        int saveEdad = Integer.parseInt((String) Edad.getSelectedItem());
        if(gHombre.isChecked()){
            aumentar();
            etGenero.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
            msg.setText("Riesgo medio para cuadro grave COVID-19");
            if(saveEdad <= 45){
                etEdad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                msg.setText("Riesgo medio para cuadro grave COVID-19");
                if(pBajo.isChecked() || pNormal.isChecked()){
                    etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                    etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                }else{
                    if(pSobre.isChecked() || pObe.isChecked()){
                        aumentar();
                        msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                        msg.setText("Riesgo medio para cuadro grave COVID-19");
                        if(pSobre.isChecked()){
                            etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                            etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                        }else{
                            if(pObe.isChecked()){
                                etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                                etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                            }
                        }
                    }
                }
            }else{
                if(saveEdad >= 46){
                    aumentar();
                    etEdad.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                    msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                    msg.setText("Riesgo alto para cuadro grave COVID-19");
                    if(pBajo.isChecked() || pNormal.isChecked()){
                        etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                        etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                        msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                        msg.setText("Riesgo alto para cuadro grave COVID-19");
                    }else{
                        if(pSobre.isChecked() || pObe.isChecked()){
                            aumentar();
                            msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                            msg.setText("Riesgo alto para cuadro grave COVID-19");
                            if(pSobre.isChecked()){
                                etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                                etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                            }else{
                                if(pObe.isChecked()){
                                    etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                                    etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                                }
                            }
                        }
                    }
                }
            }
        }

        if(gMujer.isChecked()){
            etGenero.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
            msg.setText("Riesgo medio para cuadro grave COVID-19");
            if(Integer.parseInt((String) Riesgo.getText()) != 0){
                disminuir();
            }else{
                if(saveEdad <= 53){
                    etEdad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                    msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                    msg.setText("Riesgo medio para cuadro grave COVID-19");
                    if(pBajo.isChecked() || pNormal.isChecked()){
                        etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                        etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                        msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                        msg.setText("Riesgo medio para cuadro grave COVID-19");
                    }else{
                        if(pSobre.isChecked() || pObe.isChecked()){
                            aumentar();
                            msg.setBackground(getResources().getDrawable(R.drawable.message_baja));
                            msg.setText("Riesgo medio para cuadro grave COVID-19");
                            if(pSobre.isChecked()){
                                etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                                etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                            }else{
                                if(pObe.isChecked()){
                                    etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                                    etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                                }
                            }
                        }
                    }
                }else{
                    if(saveEdad >= 54){
                        aumentar();
                        etEdad.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                        msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                        msg.setText("Riesgo alto para cuadro grave COVID-19");
                        if(pBajo.isChecked() || pNormal.isChecked()){
                            etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                            etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                            msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                            msg.setText("Riesgo alto para cuadro grave COVID-19");
                        }else{
                            if(pSobre.isChecked() || pObe.isChecked()){
                                aumentar();
                                msg.setBackground(getResources().getDrawable(R.drawable.message_alta));
                                msg.setText("Riesgo alto para cuadro grave COVID-19");
                                if(pSobre.isChecked()){
                                    etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                                    etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                                }else{
                                    if(pObe.isChecked()){
                                        etObesidad.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
                                        etSobrepeso.setBackground(getResources().getDrawable(R.drawable.etiqueta_pade));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void checkPadecimientos(){
        if(paDiab.isChecked()){
            aumentar();
            cont++;
            etDiabetes.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
        }
        if(paHiper.isChecked()){
            aumentar();
            cont++;
            etHiper.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
        }
        if(paEpoc.isChecked()){
            aumentar();
            cont++;
            etEPOC.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
        }
        if(paRen.isChecked()){
            aumentar();
            cont++;
            etERC.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
        }
        if(paInmu.isChecked()){
            aumentar();
            cont++;
            etInmuno.setBackground(getResources().getDrawable(R.drawable.etiqueta_activa));
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
}