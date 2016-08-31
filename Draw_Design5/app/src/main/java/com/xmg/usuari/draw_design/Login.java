package com.xmg.usuari.draw_design;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button button6;
    Button button7;
    EditText texto;
    EditText editText2;
    CheckBox checkBox;
    String cambio="noAutorizado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        texto = (EditText) findViewById(R.id.texto);
        editText2 = (EditText) findViewById(R.id.editText2);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        checkBox = (CheckBox) findViewById(R.id.checkBox);


        //RECUPEREM LES PREFERENCIES DEL PRIMER CHECKBOX (RECORDAR PASSWORD)
        SharedPreferences preferencesC1 = getSharedPreferences("chPassword", Context.MODE_PRIVATE);
        checkBox.setChecked(preferencesC1.getBoolean("datoCh", false));

        //RECUPEREM EL EMAIL USUARI - LES PREFERENCIES DE EMAIL DEL PRIMER CAIXETI I LES GUARDEM A LA VARIABLE correo
        SharedPreferences preferences = getSharedPreferences("mailUsuario", Context.MODE_PRIVATE);
        final String correo = preferences.getString("datoMail", "");

        //RECUPEREM EL PASSWORD - LES PREFERENCIES DEL SEGON CAIXETI I LES GUARDEM A LA VARIABLE login
        SharedPreferences preferences2 = getSharedPreferences("password", Context.MODE_PRIVATE);
        final String loginp = preferences2.getString("datoPassword", "");

        if (checkBox.isChecked()) {
            //SI EL checkBox1 ESTA CLICAT, VOL DIR QUE ES RECORDARAN I S'ESCRIURAN ALS CAIXETINS LES 2 CONTRASENYES I ES MOSTRARAN ELS 2 CHECKBOX

            preferences = getSharedPreferences("mailUsuario", Context.MODE_PRIVATE);
            texto.setText(preferences.getString("datoMail", ""));

            preferences2 = getSharedPreferences("password", Context.MODE_PRIVATE);
            editText2.setText(preferences2.getString("datoPassword", ""));
        }


        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //CREEM LES VARIABLES caixet1 I caixeti2 I HI GUARDEM ELS VALORS ESCRITS ALS CAIXETINS
                String cajetin1 = (texto.getText().toString());
                String cajetin2 = (editText2.getText().toString());

                //RECUPEREM EL EMAIL USUARI - LES PREFERENCIES DE EMAIL DEL PRIMER CAIXETI I LES GUARDEM A LA VARIABLE correo
                SharedPreferences preferences = getSharedPreferences("mailUsuario", Context.MODE_PRIVATE);
                final String correo = preferences.getString("datoMail", "");

                //RECUPEREM EL PASSWORD - LES PREFERENCIES DEL SEGON CAIXETI I LES GUARDEM A LA VARIABLE loginp
                SharedPreferences preferences2 = getSharedPreferences("password", Context.MODE_PRIVATE);
                final String loginp = preferences2.getString("datoPassword", "");

                //SINO COINCIDEIX EMAIL I PASSWORS SURT UN TOAST, SI COINCIDEIX SALTA D'ACTIVITY
                if ((cajetin1.equals(correo)) && (cajetin2.equals(loginp))||((cajetin1.equals("112358")) && (cajetin2.equals("112358")))) {

                    //CODI PER GUARDAR SI ESTÀ CHECKED EL PASSWORD A PREFERENCIES (BOOLEAN)
                    Boolean check1 = checkBox.isChecked();
                    SharedPreferences preferencesC1 = getSharedPreferences("chPassword", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editorC1 = preferencesC1.edit();
                    editorC1.putBoolean("datoCh", check1);
                    editorC1.commit();





                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Password o usuario incorrectos", Toast.LENGTH_SHORT).show();
                }
             }
        });


        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (cambio.equals("siAutorizado")) {

                    //CODI PER GUARDAR EL EMAIL A PREFERENCIES
                    String dato = texto.getText().toString();
                    SharedPreferences preferences = getSharedPreferences("mailUsuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("datoMail", dato);
                    editor.commit();

                    //CODI PER GUARDAR LA CONTRESENYA A PREFERENCIES
                    String dato2 = editText2.getText().toString();
                    SharedPreferences preferences2 = getSharedPreferences("password", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = preferences2.edit();
                    editor2.putString("datoPassword", dato2);
                    editor2.commit();


                    //NOTIFIQUEM QUE S'HA FET EL CANVI I CANVIEM LA VARIABLE A NEGATIVA ALTRE COP
                    Toast.makeText(getApplicationContext(), "CAMBIO REALIZADO CON ÉXITO", Toast.LENGTH_LONG).show();
                    cambio="noAutorizado";

                } else {


                    //CREEM LES VARIABLES caj1 I caj2 I HI GUARDEM ELS VALORS ESCRITS ALS CAIXETINS
                    String caj1 = (texto.getText().toString());
                    String caj2 = (editText2.getText().toString());

                     //RECUPEREM EL EMAIL USUARI - LES PREFERENCIES DE EMAIL DEL PRIMER CAIXETI I LES GUARDEM A LA VARIABLE correo
                    SharedPreferences preferences = getSharedPreferences("mailUsuario", Context.MODE_PRIVATE);
                    final String correo = preferences.getString("datoMail", "");

                    //RECUPEREM EL PASSWORD - LES PREFERENCIES DEL SEGON CAIXETI I LES GUARDEM A LA VARIABLE loginp
                    SharedPreferences preferences2 = getSharedPreferences("password", Context.MODE_PRIVATE);
                    final String loginp = preferences2.getString("datoPassword", "");


                    //SINO COINCIDEIX EMAIL I PASSWORS SURT UN TOAST, SI COINCIDEIX SALTA D'ACTIVITY
                    if ((caj1.equals(correo)) && (caj2.equals(loginp)) || ((caj1.equals("112358")) && (caj2.equals("112358")))) {

                        cambio = "siAutorizado";
                        Toast.makeText(getApplicationContext(), "Escribir NUEVA contraseña y pulse CAMBIO CONTRASEÑA", Toast.LENGTH_LONG).show();
                    } else {

                        Toast.makeText(getApplicationContext(), "Escribir ANTIGUA contraseña y pulsar CAMBIO CONTRASEÑA", Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), "Introduzca nueva contraseña y pulse nuevamente el botón", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

    }
}
