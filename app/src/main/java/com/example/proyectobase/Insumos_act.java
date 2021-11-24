package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView result;
    private RatingBar estrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spninsumos);
        result = findViewById(R.id.result);
        estrellas = findViewById(R.id.rb);

        // RECIBO LOS EXTRAS
        Bundle bun = getIntent().getExtras(); // OBTENGO MI BUNDLE
        String[] listado = bun.getStringArray("insumos"); // GUARDA LA LISTA DESDE

        //RELLENO DE SPINNER

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);

    }


    public void Resultado(View view)
    {


        Insumos insumo = new Insumos();

        String ins = insumos.getSelectedItem().toString();
        int[] precio = insumo.getPrecios();
        int[] adicional = insumo.getAdicional();
        int[] rbar = {0,1,2,3,4,5};

        if(ins.equals("Mancuernas")) {
            result.setVisibility(View.VISIBLE);
            result.setText("La opción es: 1" + insumo.resultadoMan(precio[0], adicional[0]));
            estrellas.setRating(rbar[1]);
        }
        if(ins.equals("Barras") ){
            result.setVisibility(View.VISIBLE);
            result.setText("La opción es: 2" + insumo.resultadoBarra(precio[1],adicional[1]));
            estrellas.setRating((rbar[3]));
        }
        if(ins.equals("Press Banca")){
            result.setVisibility(View.VISIBLE);
            result.setText("La opción es: 3" + insumo.resultadoBarra(precio[2],adicional[2]));
            estrellas.setRating(rbar[2]);

        }
        if(ins.equals("Puching Bag")){
            result.setVisibility(View.VISIBLE);
            result.setText("La opción es: 4" + insumo.resultadoBarra(precio[3],adicional[3]));
            estrellas.setRating(rbar[5]);

        }

        }

}

