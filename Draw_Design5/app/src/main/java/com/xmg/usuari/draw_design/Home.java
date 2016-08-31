package com.xmg.usuari.draw_design;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity implements View.OnClickListener {

    Button button,button2,button3,button4,button5;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button  = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

                                      @Override
                                      public void onClick(View v) {

                                          switch (v.getId()) {
                                              case R.id.button:
                                                  Intent intent = new Intent(Home.this, M_A.class);
                                                  dato = "agua";
                                                  intent.putExtra("DATO_ENVIADO", dato);
                                                  startActivity(intent);

                                                  break;

                                              case R.id.button2:
                                                  Intent intent2 = new Intent(Home.this, M_A.class);
                                                  dato = "prod_quim";
                                                  intent2.putExtra("DATO_ENVIADO", dato);
                                                  startActivity(intent2);

                                                  break;

                                              case R.id.button3:
                                                  Intent intent3 = new Intent(Home.this, M_A.class);
                                                  startActivity(intent3);

                                                  break;

                                              case R.id.button4:
                                                  Intent intent4 = new Intent(Home.this, M_A.class);
                                                  startActivity(intent4);

                                                  break;

                                              case R.id.button5:
                                                  Intent intent5 = new Intent(Home.this, M_A.class);
                                                  startActivity(intent5);

                                                  break;


                                              default:

                                                  break;

                                          }

                                      }
                                  }
