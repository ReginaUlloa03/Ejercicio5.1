package com.example.ejercicio5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var txtTitulo: TextView //Se utilizan en codigo no es necesario que se llame igual a la vista
    lateinit var spLenguaje: Spinner
    lateinit var txtDescripcion: TextView
    val lenguajes = arrayOf("PHP", "JAVA", "KOTLIN","JAVASCRIPT","RUBY","C","SWIFT")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //INICIALIZAR
        txtTitulo = findViewById(R.id.txtTitulo)
        spLenguaje = findViewById(R.id.spLenguaje)
        txtDescripcion = findViewById(R.id.txtDescripcion)
        //Crear el adaptador del spinner
        //cuando se vea contexto es this
        //Esto es para traernos los recursos de android, no de R porque no tenemos layout
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,lenguajes)

        spLenguaje.adapter = adaptador
        spLenguaje.onItemSelectedListener = this
//Decirle al spinner que en evento onItemSelected el que va a controlar es esta clase

    }
//Sucede cuando seleccionemos item
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    //Log es para mandar letrerito el logcat, como print
    Log.v("App Spinner", "Seleccionaste uno $position")
    val lenguaje = lenguajes[position]
    //modificar titulo
    txtTitulo.text = lenguaje
    val descripcion = when (lenguaje){
    "PHP" -> "Es un lenguaje para el backend de las páginas"
    "JAVA" -> "Es un lenguaje para el backend de las páginas"
                "KOTLIN" ->"Lenguaje de programación de código abierto y tipo estático, es el lenguaje oficial de android"
        "JAVASCRIPT" -> "funcion o logica en el lado del cliente en las páginas web"
        "RUBY"->"Lenguaje de desarrollo de páginas web y análisis de datos"
        "C"->"Lenguaje de nivel medio bajo, tiene la capacidad de manipular direcciones arbitrarias"
        "SWIFT"->"Lenguaje de programación creado por Apple para desarollar en iOS"
    else ->"No se ha definido"
     }
    txtDescripcion.text= descripcion
    }
//Cuando spinner esté vacio y no tenga nada seleccionado
    //TODO= exepcion, hay que quitarlos
    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

}