package c.apps.machete.mastermezcla

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tabla_revenimiento.*

class TablaRevenimiento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabla_revenimiento)

        val regresarr = Intent(this, DatosAvanzado::class.java)

        setSupportActionBar(toolbar_tablaRevenimiento)
        supportActionBar!!.title = ""

        regresarADatos.setOnClickListener {
            startActivity(regresarr)
            this.finish()
        }

        back_button.setOnClickListener{
            startActivity(regresarr)
            this.finish()
        }
    }

    override fun onBackPressed() {
        val regresarrr = Intent(this, DatosAvanzado::class.java)
        startActivity(regresarrr)
        this.finish()
    }
}
