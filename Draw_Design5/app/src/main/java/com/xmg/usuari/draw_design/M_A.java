package com.xmg.usuari.draw_design;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


//FUNCIONA PERFECTE!!!!!!

public class M_A extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String                      dato;
    Button button;


    AutoCompleteTextView autoCompleteTextView;
    String[]nombres={"Juan", "Juanito", "Pepe", "Pepito", "Juan Manuel"};
    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner6;
    Spinner spinner7;
    Spinner spinner8;
    Spinner spinner9;
    Spinner spinner10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_);

        autoCompleteTextView= (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,nombres);
        autoCompleteTextView.setThreshold(3);
        autoCompleteTextView.setAdapter(adapter);

        // SPINNER

        spinner=(Spinner)findViewById(R.id.spinner);
        List list=new ArrayList();
        list.add(">>   NOMBRE PETICIONARIO");
        list.add("Item2");
        list.add("Item3");
        list.add("Item4");
        list.add("Item5");
        list.add("Item6");
        list.add("Item7");
        list.add("Item8");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                  Toast.makeText(M_A.this, "Position " + String.valueOf(spinner.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> parent) {

                                              }
                                          }

        );

        // SPINNER2
        spinner2=(Spinner)findViewById(R.id.spinner2);

        List list2=new ArrayList();
        list2.add(">>   FORMATO DEPÓSITO");
        list2.add("Vertical Ext. Cerrado Fondo Plano");
        list2.add("Vertical Enterr. Cerrado Fondo Plano");
        list2.add("Vertical Ext. Abierto Fondo Plano");
        list2.add("Vertical Ext. Cerrado con Patas");
        list2.add("Horizontal Ext. Cunas");
        list2.add("Horizontal Enterr.");
        list2.add("Cisterna Aguas Pluviales");

        ArrayAdapter arrayAdapter2=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list2);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   Toast.makeText(M_A.this, "Position " + String.valueOf(spinner2.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }

        );

        //SPINNER3
        spinner3=(Spinner)findViewById(R.id.spinner3);
        List list3=new ArrayList();
        list3.add(">>   VOLUMEN Y DIMENSIONES");
        list3.add("Otros volúmenes y/o dimensiones");
        list3.add("5 m3 ø2000 x 2090 mm");
        list3.add("8 m3 ø2000 x 2850 mm");
        list3.add("10 m3 ø2350 x 2190 mm");
        list3.add("12 m3 ø2350 x 2510 mm");
        list3.add("15 m3 ø2500 x 3850 mm");
        list3.add("20 m3 ø2500 x 4200 mm");

        ArrayAdapter arrayAdapter3=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list3);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   Toast.makeText(M_A.this, "Position " + String.valueOf(spinner3.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }

        );

        // SPINNER4
        spinner4=(Spinner)findViewById(R.id.spinner4);

        List list4=new ArrayList();
        list4.add(">>   TRANSPORTE NO INCLUIDO");
        list4.add("Propia Provincia sin Grúa");
        list4.add("Propia Provincia con Grúa");
        list4.add("En otra provincia sin Grúa");
        list4.add("En otra provincia con Grúa");

        ArrayAdapter arrayAdapter4=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list4);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(arrayAdapter4);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   Toast.makeText(M_A.this, "Position " + String.valueOf(spinner4.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }

        );

        // SPINNER5
        spinner5=(Spinner)findViewById(R.id.spinner5);

        List list5=new ArrayList();
        list5.add(">>   LUGAR DE DESTINO");
        list5.add("Vertical Ext. Cerrado Fondo Plano");
        list5.add("Vertical Enterr. Cerrado Fondo Plano");
        list5.add("Vertical Ext. Abierto Fondo Plano");
        list5.add("Vertical Ext. Cerrado con Patas");
        list5.add("Horizontal Ext. Cunas");
        list5.add("Horizontal Enterr.");
        list5.add("Cisterna Aguas Pluviales");

        ArrayAdapter arrayAdapter5=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list5);
        arrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(arrayAdapter5);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   Toast.makeText(M_A.this, "Position " + String.valueOf(spinner5.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }

        );

// SPINNER6
        spinner6=(Spinner)findViewById(R.id.spinner6);

        List list6=new ArrayList();
        list6.add(">>  ELEMENTO A AÑADIR");
        list6.add("Anclajes de Fijación al Suelo (RECOMENDADO)");
        list6.add("Soportes Laterales de Tuberia");
        list6.add("1 Tubuladura PRFV PN 10 atm Superior");
        list6.add("1 Tubuladura PRFV PN 10 atm Lateral Inf.");
        list6.add("1 Tubuladura PRFV PN 10 atm Lateral Sup.");
        list6.add("1 Tubo PVC PN 10 atm Cubierta Superior");
        list6.add("1 Tubo PVC PN 10 atm Lateral Superior");
        list6.add("1 Boca de Hombre Later. DN 500 Presión");
        list6.add("1 Boca de Hombre Later. DN 600 Presión");
        list6.add("1 Boca de Hombre Sup. ø550 PEHD + aireac.");
        list6.add("Orejas de Elevación Adicionales");

        ArrayAdapter arrayAdapter6=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list6);
        arrayAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(arrayAdapter6);

        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   Toast.makeText(M_A.this, "Position " + String.valueOf(spinner6.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }

        );

// SPINNER7
        // DEPENENTDEL QUE S'HAGI SELECCIONAT ABANS A "ELEMENTO A AÑADIR" S'OBRIRA L'SPINNER AMB UNA LLISTA O UNA ALTRE
        // SI SÓN TUBULADURES DIREM EL DN I EL PN
        //SI SÓN ANCORATGES O ORELLETES DIREM LES UNITATS

        spinner7=(Spinner)findViewById(R.id.spinner7);

        List list7=new ArrayList();
        list7.add(">>   UNIDADES / TIPOLOGÍA");
        list7.add("1 Tubulad. DN 25 mm PN 10 atm");
        list7.add("1 Tubulad. DN 40 mm PN 10 atm");
        list7.add("1 Tubulad. DN 50 mm PN 10 atm");
        list7.add("1 Tubulad. DN 65 mm PN 10 atm");
        list7.add("1 Tubulad. DN 80 mm PN 10 atm");
        list7.add("1 Tubulad. DN 100 mm PN 10 atm");
        list7.add("1 Tubulad. DN 125 mm PN 10 atm");
        list7.add("1 Tubulad. DN 150 mm PN 10 atm");
        list7.add("1 Tubulad. DN 200 mm PN 10 atm");
        list7.add("1 Tubulad. DN 250 mm PN 10 atm");

        ArrayAdapter arrayAdapter7=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list7);
        arrayAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(arrayAdapter7);

        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   Toast.makeText(M_A.this, "Position " + String.valueOf(spinner7.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }

        );

// SPINNER8
        //AL MATEIX SELLECCIONAR PERQUÈ SERVEIX, SELECCIONEM A ON VA POSAT
        spinner8=(Spinner)findViewById(R.id.spinner8);

        List list8=new ArrayList();
        list8.add(">>  USO Y SITUACIÓN");
        list8.add("Acceso a personas desde lateral cilindro");
        list8.add("Rebose en parte alta cilíndrica");
        list8.add("Vaciado total en el punto más bajo");
        list8.add("Nivel Ultrasonidos o Radar en cubierta");
        list8.add("Nivel visual polea y contrapeso DN125 mm");
        list8.add("Elemento de Reserva en cubierta superior ");

        ArrayAdapter arrayAdapter8=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list8);
        arrayAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(arrayAdapter8);

        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   Toast.makeText(M_A.this, "Position " + String.valueOf(spinner8.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }

        );

        //SPINNER9
        //ES POSARÀ L'ORIENTACIÓ EN GRAUS
        //LES COTES SORTIRAN PER DEFECTE, SI ES VOLEN CANVIAR ES FARÀ AL CAIXETÍ
        spinner9=(Spinner)findViewById(R.id.spinner9);

        List list9=new ArrayList();
        list9.add(">>   ACOTACIÓN");
        list9.add("Vertical Ext. Cerrado Fondo Plano");
        list9.add("Vertical Enterr. Cerrado Fondo Plano");
        list9.add("Vertical Ext. Abierto Fondo Plano");
        list9.add("Vertical Ext. Cerrado con Patas");
        list9.add("Horizontal Ext. Cunas");
        list9.add("Horizontal Enterr.");
        list9.add("Cisterna Aguas Pluviales");

        ArrayAdapter arrayAdapter9=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,list9);
        arrayAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner9.setAdapter(arrayAdapter9);

        spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                   Toast.makeText(M_A.this, "Position " + String.valueOf(spinner9.getSelectedItem()), Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }

        );




        button=(Button)findViewById(R.id.button);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                String cadena = (String) bundle.get("DATO_ENVIADO");



            }
        });



        Resources res = getResources();

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("", res.getDrawable(android.R.drawable.ic_menu_edit));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("", res.getDrawable(android.R.drawable.ic_menu_compass));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("", res.getDrawable(android.R.drawable.ic_menu_today));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("", res.getDrawable(android.R.drawable.ic_menu_gallery));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);


            //CAL POSAR-HO A CADA IF DE CADA PESTANYA CLICADA
        //tabs.getTabWidget().getChildAt(tabs.getCurrentTab()).setBackgroundColor(Color.parseColor("#40C4FF"));











        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.login) {

            SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(this);
            Boolean datosActivo=pref.getBoolean("opcion1", false);
            String nombreUsuario=pref.getString("opcion2", "");
            String nombreEmpresa=pref.getString("opcion3", "");
            String nombreDireccion=pref.getString("opcion4", "");
            String localidad=pref.getString("opcion5", "");
            String telefono=pref.getString("opcion6", "");
            String nombrePais=pref.getString("opcion8","");

            //String datos=;


        } else if (id == R.id.preferencias_remitente) {

            startActivity(new Intent(this,Preferencias.class));


        } else if (id == R.id.condiciones) {

        } else if (id == R.id.oferta) {

        } else if (id == R.id.anejos) {

        } else if (id == R.id.enviar) {

        } else if (id == R.id.guardar) {

        } else if (id == R.id.salir) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
