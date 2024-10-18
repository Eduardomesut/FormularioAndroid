package com.mgh.pmdm.ejemplosui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.mgh.pmdm.ejemplosui.databinding.ActivityMainBinding
import java.util.jar.Attributes.Name

class MainActivity : AppCompatActivity() {

    // Definimos la clase de vinculación
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Instanciamos el binding con el método estático inflate de la
        // clase de vinculación
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        populateSpinner()

        // Añadimos por código la imagen
        val miImg:ImageView=findViewById(R.id.Image)
        miImg.setImageResource(R.drawable.appimg)

        binding.btSave.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage("¿Desea guardar los cambios? \n \n Nombre: ${binding.Name.text}\n Descripción: ${binding.Description.text} \n Telefono: ${binding.Phone.text}"
                +"\n Web: ${binding.webSite.text} \n Apertura: ${binding.SpinnerOpeningTime.selectedItem} \n Cierre: ${binding.SpinnerClosingTime.selectedItem}")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, { dialog, which ->
                    Snackbar.make(binding.root, "Cambios guardados", Snackbar.LENGTH_SHORT).show()
                })
                .setNegativeButton(android.R.string.cancel, { dialog, which ->
                    Toast.makeText(applicationContext, "Cambios no guardados", Toast.LENGTH_SHORT).show()
                })
                .show()





//            Log.d("Caso Práctico 2", "Nombre: " + binding.Name.text);
//            Log.d("Caso Práctico 2", "Descripción:" +
//                    binding.Description.text);
//            Log.d("Caso Práctico 2", "telefono: " + binding.Phone.text);
//            Log.d("Caso Práctico 2", "Web: " + binding.webSite.text);
//            Log.d("Caso Práctic 2", "Hora de apertura: " +
//                    binding.SpinnerOpeningTime.selectedItem);
//            Log.d("Caso Práctico 2", "Hora de cierre: " +
//                    binding.SpinnerClosingTime.selectedItem);
//            if (binding.cbSport.isChecked)
//                Log.d("Caso Práctico 2", "Con instalaciones Deportivas");
//            if (binding.cbChildren.isChecked)
//                Log.d("Caso Práctico 2", "Con instalaciones para niños");
//            if (binding.cbBar.isChecked)
//                Log.d("Caso Práctico 2", "Con zona de restauración");
        }

    }

    // Método específico para poblar el spinner para la hora de cierre
    // (la hora de apertura se ha hecho mediante el XML)
    private fun populateSpinner() {
        // Creamos un ArrayAdapter a partir de un recurso de tipo array
        // Requiere tres parámetros: El contexto, el recurso, y el
        // diseño de la entrada (utilizaremos el proporcionado por la
        // propia plataforma.
        ArrayAdapter.createFromResource(
            this,
            R.array.horas,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            // Si tenemos el adaptador preparado, seleccionamos el diseño
            // para la lista de opciones (lo proporciona por la plataforma)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            // Y finalmente, añadimos el adaptador al spinner
            binding.SpinnerClosingTime.adapter = adapter
        }
    }

}