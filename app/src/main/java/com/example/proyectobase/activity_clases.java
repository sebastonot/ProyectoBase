package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectobase.db.DbHelper;

public class activity_clases extends AppCompatActivity {

    Button Crear,Borrar,Mostrar,Actualizar;
    EditText code,Class,Intensi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        Crear = findViewById(R.id.btnCrear);
        Mostrar = findViewById(R.id.btnMostrar);
        Actualizar = findViewById(R.id.btnUpdate);
        Borrar = findViewById(R.id.btnDelete);
        code = findViewById(R.id.tvCodigo);
        Class = findViewById(R.id.tvClase);
        Intensi = findViewById(R.id.tvIntensi);

    }


    public void Añadir(View v) {
        DbHelper admin = new DbHelper(this, "biofit",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clases = Class.getText().toString();
        String intensidad = Intensi.getText().toString();

        if (!codigo.isEmpty() && !clases.isEmpty() && !intensidad.isEmpty()) {

            ContentValues values = new ContentValues();
            values.put("codigo",codigo);
            values.put("clases",clases);
            values.put("intensidad",intensidad);

            db.insert("Clase",null,values);
            db.close();
            Clean();
            Toast.makeText(this, "Has guardado una clase",Toast.LENGTH_LONG).show();
        } else
        {
            Toast.makeText(this, "Los campos están vacios",Toast.LENGTH_LONG).show();

        }
    }
    public void Clean()
    {
        code.setText("");
        Class.setText("");
        Intensi.setText("");
    }
    public void MostrarClases(View v)
    {
        DbHelper admin = new DbHelper(this, "biofit",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String cod = code.getText().toString();

        if(!cod.isEmpty())
        {
            Cursor file = db.rawQuery
                    ("SELECT clases,intensidad FROM Clase WHERE codigo="+cod,null);
            if(file.moveToFirst())
            {
                Class.setText(file.getString(0));
                Intensi.setText(file.getString(1));

            }
            else
                {
                    Toast.makeText(this,"No hay elementos",Toast.LENGTH_LONG).show();
                }
        }
        else
        {
            Toast.makeText(this,"No hay clase asociada",Toast.LENGTH_LONG).show();
        }
    }
    public void Eliminar (View v)
    {
        DbHelper admin = new DbHelper(this, "biofit",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo =code.getText().toString();

        if(!codigo.isEmpty())
        {
            int cant = db.delete("Clase", "codigo="+codigo,null);
            db.close();
            Clean();

            if(cant==1)
            {
                Toast.makeText(getBaseContext(),"Eliminaste una clase asociada a: " +codigo, Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(getBaseContext(),"No existe la clase en la database", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(getBaseContext(),"No hay clase asociada", Toast.LENGTH_SHORT).show();
        }


    }

    public void Actualizar(View v)
    {
        DbHelper admin = new DbHelper(this, "biofit",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clases = Class.getText().toString();
        String intensidad = Intensi.getText().toString();


        if (!clases.isEmpty() && !intensidad.isEmpty()) {

            ContentValues values = new ContentValues();
            values.put("clases",clases);
            values.put("intensidad",intensidad);

            db.update("Clase", values,"codigo="+codigo,null);
            db.close();
            Clean();
            Toast.makeText(this, "Has actualizado",Toast.LENGTH_LONG).show();
        } else
        {
            Toast.makeText(this, "Los campos están vacios",Toast.LENGTH_LONG).show();

        }

    }
}