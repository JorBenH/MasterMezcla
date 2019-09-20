package c.apps.machete.mastermezcla

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_creditos.*

class Creditos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creditos)

        val regresarInicio = Intent(this, Inicio::class.java)

        setSupportActionBar(toolbar_creditos)
        supportActionBar!!.title = ""

        back_button.setOnClickListener{
            startActivity(regresarInicio)
            this.finish()
        }

        regresarInicioxD.setOnClickListener {
            startActivity(regresarInicio)
            this.finish()
        }
    }

    override fun onBackPressed() {
        val inicioo = Intent(this, Inicio::class.java)
        startActivity(inicioo)
        this.finish()
    }
}
