package c.apps.machete.mastermezcla

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.support.v7.widget.AppCompatSpinner
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_basico.*

class Basico : AppCompatActivity(),AdapterView.OnItemSelectedListener{

    companion object {

        var agua = ""
        var cemento = ""
        var arena = ""
        var grava = ""
        var aguaS = ""
        var cementoS = ""
        var arenaS = ""
        var gravaS = ""
        var resistenciaSelected = 0
        var gravaSelected = 0
    }

        var spinnerResistencia: AppCompatSpinner? = null
        var spinnerGrava: AppCompatSpinner? = null

        var gridViewResultadosm3: GridView? = null
        var gridViewResultadosS: GridView? = null

        var toolBar : Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basico)

        toolBar = this.toolbar_basico
        setSupportActionBar(toolBar)
        supportActionBar!!.title = ""

        //Para regresar al inicio
        val regresar_inicio = Intent(this, Inicio::class.java)

        //Configuracion spinner de Resistencia
        spinnerResistencia = this.spinner_Resistencia
        spinnerResistencia!!.onItemSelectedListener = this
        val aaRes = ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.spinner_Resistencia))
        aaRes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerResistencia!!.adapter = aaRes

        //Configuracion spinner de Grava
        spinnerGrava = this.spinner_Grava
        spinnerGrava!!.onItemSelectedListener = this
        val aaGrava = ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.spinner_Grava))
        aaGrava.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGrava!!.adapter = aaGrava

        fun calculosBasicos(resistencia : Int, tGrava : Int){
            if ( resistencia == 100 && tGrava == 20 )
            {
                cemento = DatosBasicos.PSDL20m3100[0].toString() + " [kg]"
                grava = DatosBasicos.PSDL20m3100[1].toString() + " [kg]"
                arena = DatosBasicos.PSDL20m3100[2].toString() + " [kg]"
                agua = DatosBasicos.PSDL20m3100[3].toString() + " [L]"

                cementoS = "50 [kg]"
                gravaS = DatosBasicos.PSDL20b100[0].toString() + " [kg]"
                arenaS = DatosBasicos.PSDL20b100[1].toString() + " [kg]"
                aguaS = DatosBasicos.PSDL20b100[2].toString() + " [L]"
            }
            else if ( resistencia == 150 && tGrava == 20 )
            {
                cemento = DatosBasicos.PSDL20m3150[0].toString() + " [kg]"
                grava = DatosBasicos.PSDL20m3150[1].toString() + " [kg]"
                arena = DatosBasicos.PSDL20m3150[2].toString() + " [kg]"
                agua = DatosBasicos.PSDL20m3150[3].toString() + " [L]"

                cementoS = "50 [kg]"
                gravaS = DatosBasicos.PSDL20b150[0].toString() + " [kg]"
                arenaS = DatosBasicos.PSDL20b150[1].toString() + " [kg]"
                aguaS = DatosBasicos.PSDL20b150[2].toString() + " [L]"
            }
            else if ( resistencia == 200 && tGrava == 20)
            {
                cemento = DatosBasicos.PSDL20m3200[0].toString() + " [kg]"
                grava = DatosBasicos.PSDL20m3200[1].toString() + " [kg]"
                arena = DatosBasicos.PSDL20m3200[2].toString() + " [kg]"
                agua = DatosBasicos.PSDL20m3200[3].toString() + " [L]"

                cementoS = "50 [kg]"
                gravaS = DatosBasicos.PSDL20b200[0].toString() + " [kg]"
                arenaS = DatosBasicos.PSDL20b200[1].toString() + " [kg]"
                aguaS = DatosBasicos.PSDL20b200[2].toString() + " [L]"
            }
            else if ( resistencia == 250 && tGrava == 20 )
            {
                cemento = DatosBasicos.PSDL20m3250[0].toString() + " [kg]"
                grava = DatosBasicos.PSDL20m3250[1].toString() + " [kg]"
                arena = DatosBasicos.PSDL20m3250[2].toString() + " [kg]"
                agua = DatosBasicos.PSDL20m3250[3].toString() + " [L]"

                cementoS = "50 [kg]"
                gravaS = DatosBasicos.PSDL20b250[0].toString() + " [kg]"
                arenaS = DatosBasicos.PSDL20b250[1].toString() + " [kg]"
                aguaS = DatosBasicos.PSDL20b250[2].toString() + " [L]"
            }

            else if ( resistencia == 100 && tGrava == 40 )
            {
                cemento = DatosBasicos.PSDL40m3100[0].toString() + " [kg]"
                grava = DatosBasicos.PSDL40m3100[1].toString() + " [kg]"
                arena = DatosBasicos.PSDL40m3100[2].toString() + " [kg]"
                agua = DatosBasicos.PSDL40m3100[3].toString() + " [L]"

                cementoS = "50 [kg]"
                gravaS = DatosBasicos.PSDL40b100[0].toString() + " [kg]"
                arenaS = DatosBasicos.PSDL40b100[1].toString() + " [kg]"
                aguaS = DatosBasicos.PSDL40b100[2].toString() + " [L]"
            }
            else if ( resistencia == 150 && tGrava == 40 )
            {
                cemento = DatosBasicos.PSDL40m3150[0].toString() + " [kg]"
                grava = DatosBasicos.PSDL40m3150[1].toString() + " [kg]"
                arena = DatosBasicos.PSDL40m3150[2].toString() + " [kg]"
                agua = DatosBasicos.PSDL40m3150[3].toString() + " [L]"

                cementoS = "50 [kg]"
                gravaS = DatosBasicos.PSDL40b150[0].toString() + " [kg]"
                arenaS = DatosBasicos.PSDL40b150[1].toString() + " [kg]"
                aguaS = DatosBasicos.PSDL40b150[2].toString() + " [L]"
            }
            else if ( resistencia == 200 && tGrava == 40 )
            {
                cemento = DatosBasicos.PSDL40m3200[0].toString() + " [kg]"
                grava = DatosBasicos.PSDL40m3200[1].toString() + " [kg]"
                arena = DatosBasicos.PSDL40m3200[2].toString() + " [kg]"
                agua = DatosBasicos.PSDL40m3200[3].toString() + " [L]"

                cementoS = "50 [kg]"
                gravaS = DatosBasicos.PSDL40b200[0].toString() + " [kg]"
                arenaS = DatosBasicos.PSDL40b200[1].toString() + " [kg]"
                aguaS = DatosBasicos.PSDL40b200[2].toString() + " [L]"
            }
            else if ( resistencia == 250 && tGrava == 40 )
            {
                cemento = DatosBasicos.PSDL40m3250[0].toString() + " [kg]"
                grava = DatosBasicos.PSDL40m3250[1].toString() + " [kg]"
                arena = DatosBasicos.PSDL40m3250[2].toString() + " [kg]"
                agua = DatosBasicos.PSDL40m3250[3].toString() + " [L]"

                cementoS = "50 [kg]"
                gravaS = DatosBasicos.PSDL40b250[0].toString() + " [kg]"
                arenaS = DatosBasicos.PSDL40b250[1].toString() + " [kg]"
                aguaS = DatosBasicos.PSDL40b250[2].toString() + " [L]"
            }
        }

        calcular.setOnClickListener {

            calculosBasicos(resistenciaSelected, gravaSelected)

            var tablam3 = arrayOf("Insumo", "Por [m³]", "Cemento", cemento, "Grava", grava, "Arena", arena, "Agua", agua)
            var tablaS = arrayOf("Insumo", "Por Bulto", "Cemento", cementoS, "Grava", gravaS, "Arena", arenaS, "Agua", aguaS)

            //Configuracion de la tabla1
            gridViewResultadosm3 = this.tablaResultadosBasicos1
            val aaTabla1 = ArrayAdapter(this, android.R.layout.simple_list_item_1,tablam3)
            gridViewResultadosm3!!.adapter = aaTabla1

            //Configuracion de la tabla2
            gridViewResultadosS = this.tablaResultadosBasicos2
            val aaTabla2 = ArrayAdapter(this, android.R.layout.simple_list_item_1,tablaS)
            gridViewResultadosS!!.adapter = aaTabla2
        }

        regresar.setOnClickListener {
            startActivity(regresar_inicio)
            this.finish()
        }

        back_button.setOnClickListener {
            startActivity(regresar_inicio)
            this.finish()
        }
    }

    override fun onBackPressed(){
        val regresar_al_inicio = Intent(this, Inicio::class.java)
        startActivity(regresar_al_inicio)
        this.finish()
    }

    override fun onItemSelected(arg0 : AdapterView<*>,arg1 : View, position : Int, id : Long){
        if(arg0 == spinnerResistencia)
        {
            when (position){
                0 -> resistenciaSelected = 250
                1 -> resistenciaSelected = 250
                2 -> resistenciaSelected = 200
                3 -> resistenciaSelected = 250
                4 -> resistenciaSelected = 150
                5 -> resistenciaSelected = 100
                6 -> resistenciaSelected = 100
                7 -> resistenciaSelected = 200
                8 -> resistenciaSelected = 250
            }
        }

        if(arg0 == spinnerGrava)
        {
            when (position){
                0 -> gravaSelected = 20
                1 -> gravaSelected = 40
            }
        }
    }

    override fun onNothingSelected(arg0 : AdapterView<*>){

    }

}

class DatosBasicos{
    companion object {
        val PSDL20m3100 = arrayOf( 265, 1000, 900, 205 )
        val PSDL20m3150 = arrayOf( 310, 1000, 860, 205 )
        val PSDL20m3200 = arrayOf( 350, 1000, 825, 205 )
        val PSDL20m3250 = arrayOf( 390, 1000, 790, 205 )
        val PSDL40m3100 = arrayOf( 230, 1000, 960, 190 )
        val PSDL40m3150 = arrayOf( 270, 1000, 930, 190 )
        val PSDL40m3200 = arrayOf( 205, 1000, 900, 190 )
        val PSDL40m3250 = arrayOf( 340, 1000, 870, 190 )
        val PSDL20b100 = arrayOf( 122, 106, 39 )
        val PSDL20b150 = arrayOf( 104, 86, 33 )
        val PSDL20b200 = arrayOf( 92, 73, 29 )
        val PSDL20b250 = arrayOf( 83, 63, 26 )
        val PSDL40b100 = arrayOf( 145, 129, 41 )
        val PSDL40b150 = arrayOf( 123, 107, 35 )
        val PSDL40b200 = arrayOf( 109, 92, 31 )
        val PSDL40b250 = arrayOf( 98, 79, 28 )
    }
}
