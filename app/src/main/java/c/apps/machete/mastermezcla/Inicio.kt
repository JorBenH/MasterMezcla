package c.apps.machete.mastermezcla

import android.content.Intent
import android.opengl.Visibility
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.ActionBarContainer
import android.view.View
import android.widget.Toast
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.activity_inicio.*

class Inicio : AppCompatActivity() {

    var ToolBar : Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        ToolBar = toolbar_inicio
        setSupportActionBar(ToolBar)
        supportActionBar!!.title = ""

        val basic = Intent(this, Basico::class.java)
        val datosAvanzado = Intent(this, DatosAvanzado::class.java)
        val creditosss = Intent(this, Creditos::class.java)

        calculoBasico.setOnClickListener {
            startActivity(basic)
            this.finish()
        }

        calculoAvanzado.setOnClickListener {
            startActivity(datosAvanzado)
            this.finish()
        }

        botonCreditos.setOnClickListener {
            startActivity(creditosss)
            this.finish()
        }

        back_button.setOnClickListener {
            this.finish()
        }

    }

    override fun onBackPressed() {
        this.finish()
    }
}
