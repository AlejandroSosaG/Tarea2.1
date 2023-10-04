package com.example.tarea2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.tarea2_1.databinding.ActivityMainBinding
import com.example.tarea2_1.databinding.BienvenidaBinding
import com.example.tarea2_1.databinding.PausaBinding

class MainActivity : AppCompatActivity() {
    var usuario: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
        val bienvenida = BienvenidaBinding.inflate(layoutInflater)
        main.acceder.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                usuario = main.completaUsuario.text.toString()
                setContentView(bienvenida.root)
                val tostada = Toast.makeText(applicationContext, "Estoy en bienvenida", Toast.LENGTH_SHORT).show()
                bienvenida.bienvenido.text = "${bienvenida.bienvenido.text} ${usuario}"
            }
        })
        bienvenida.boton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                setContentView(main.root)
                val main = Toast.makeText(applicationContext, "Estoy en main", Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onPause() {
        super.onPause()
        val pausa = PausaBinding.inflate(layoutInflater)
        setContentView(pausa.root)
    }
    override fun onResume() {
        super.onResume()
        val main = ActivityMainBinding.inflate(layoutInflater)
        val bienvenida = BienvenidaBinding.inflate(layoutInflater)
        setContentView(main.root)
        val tostá = Toast.makeText(applicationContext, "Bienvenido de nuevo, ${usuario}", Toast.LENGTH_LONG).show()
        main.acceder.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                usuario = main.completaUsuario.text.toString()
                setContentView(bienvenida.root)
                val tostada = Toast.makeText(applicationContext, "Estoy en bienvenida", Toast.LENGTH_SHORT).show()
                bienvenida.bienvenido.text = "${bienvenida.bienvenido.text} ${usuario}"
            }
        })
        bienvenida.boton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                setContentView(main.root)
                val main = Toast.makeText(applicationContext, "Estoy en main", Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onDestroy() {
        super.onDestroy()
        var builder = NotificationCompat.Builder(this, "Notificación")
            .setSmallIcon(R.drawable.login)
            .setContentTitle("Aplicación cerrada")
            .setContentText("Se ha cerrado la sesión de ${usuario}")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
    }
}