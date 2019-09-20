package c.apps.machete.mastermezcla

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.math.BigDecimal
import android.content.Intent
import android.support.design.widget.Snackbar
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_resultado_avanzado.*

class ResultadoAvanzado : AppCompatActivity(), View.OnClickListener, TextWatcher, View.OnFocusChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_avanzado)

        val inicioo = Intent(this, Inicio::class.java)
        val regresarr = Intent(this, DatosAvanzado::class.java)

        setSupportActionBar(toolbar_resultadoAvanzado)
        supportActionBar!!.title = ""

        try {
            conversionesFinales()
            masConversiones()
        }catch (e : Exception){
            Snackbar.make(linearLayout2,"Los datos proporcionados son inconsistentes",Snackbar.LENGTH_LONG).setAction("OK",this).show()
        }

        fun createTables(){
            val arrayTabla1 = arrayOf("Insumo", "En peso para 1 [m³]","Agua","${aguaPeso} [kg]", "Cemento", "${cementoPeso} [kg]", "Grava", "${gravaPeso} [kg]", "Arena","${arenaPeso} [kg]", "Agua de Absorción","${aguaTotal} [kg]")
            val arrayTabla2 = arrayOf("Insumo", "En volumen para 1 [m³]","Agua","${aguaVolumen1} [L]", "Cemento", "${cementoVolumen1} [kg]", "Grava", "${gravaVolumen1} [L]", "Arena","${arenaVolumen1} [L]", "Agua de Absorción","${aguaTotal} [L]")
            val arrayTabla3 = arrayOf("Insumo", "En volumen (1 saco)","Agua","${aguaVolumen2} [L]", "Cemento", "${cementoVolumen2} [kg]", "Grava", "${gravaVolumen2} [L]", "Arena","${arenaVolumen2} [L]", "Agua de Absorción","${aguaTottalV} [L]")
            val arrayTabla4 = arrayOf("Insumo", "En peso para 1 [m³]","Agua","${aguaPeso} [kg]", "Cemento", "${cementoPeso} [kg]", "Grava", "${gravaPeso} [kg]", "Arena","${arenaPeso} [kg]", "Agua de Absorción","${aguaTotal} [kg]")
            val arrayTabla5 = arrayOf("Insumo", "En volumen para 1 [m³]","Agua","${aguaVolumen1} [L]", "Cemento", "${cementoVolumen1} [kg]", "Grava", "${gravaVolumen1} [L]", "Arena","${arenaVolumen1} [L]", "Agua de Absorción","${aguaTotal} [L]")
            val arrayTabla6 = arrayOf("Insumo", "En volumen (1 saco)","Agua","${aguaVolumen2} [L]", "Cemento", "${cementoVolumen2} [kg]", "Grava", "${gravaVolumen2} [L]", "Arena","${arenaVolumen2} [L]", "Agua de Absorción","${aguaTottalV} [L]")

            val aaTabla1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla1)
            tablaResultadosAvanzado1.adapter = aaTabla1

            val aaTabla2 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla2)
            tablaResultadosAvanzado2.adapter = aaTabla2

            val aaTabla3 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla3)
            tablaResultadosAvanzado3.adapter = aaTabla3

            val aaTabla4 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla4)
            tablaResultadosAvanzado4.adapter = aaTabla4

            val aaTabla5 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla5)
            tablaResultadosAvanzado5.adapter = aaTabla5

            val aaTabla6 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla6)
            tablaResultadosAvanzado6.adapter = aaTabla6

        }

        createTables()

        calcularnm3.setOnClickListener {
            if(nm3.text.toString().isEmpty() || nS.text.toString().isEmpty())
            {
                Snackbar.make(linearLayout2,"No dejes campos vacíos",Snackbar.LENGTH_LONG).setAction("OK",this).show()
            }
            else {
                try {
                    conversionesTabla2(nm3.text.toString().toFloat(), nS.text.toString().toFloat())
                    masMasConversiones()
                }catch (e : Exception){
                    Snackbar.make(linearLayout2,"Los datos proporcionados son inconsistentes",Snackbar.LENGTH_LONG).setAction("OK",this).show()
                }

                val arrayTabla4 = arrayOf("Insumo", "En peso para ${nm3.text.toString().toFloat()} [m³]","Agua","${aaguaPeso} [kg]", "Cemento", "${acementoPeso} [kg]", "Grava", "${agravaPeso} [kg]", "Arena","${aarenaPeso} [kg]", "Agua de Absorción","${aaguaTotal} [kg]")
                val arrayTabla5 = arrayOf("Insumo", "En volumen para ${nm3.text.toString().toFloat()} [m³]","Agua","${aaguaVolumen1} [L]", "Cemento", "${acementoVolumen1} [kg]", "Grava", "${agravaVolumen1} [L]", "Arena","${aarenaVolumen1} [L]", "Agua de Absorción","${aaguaTotal} [L]")
                val arrayTabla6 = arrayOf("Insumo", "En volumen (${nS.text.toString().toFloat()} saco)","Agua","${aaguaVolumen2} [L]", "Cemento", "${acementoVolumen2} [kg]", "Grava", "${agravaVolumen2} [L]", "Arena","${aarenaVolumen2} [L]", "Agua de Absorción","${aaguaTottalV} [L]")

                val aaTabla4 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla4)
                tablaResultadosAvanzado4.adapter = aaTabla4

                val aaTabla5 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla5)
                tablaResultadosAvanzado5.adapter = aaTabla5

                val aaTabla6 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla6)
                tablaResultadosAvanzado6.adapter = aaTabla6
            }

        }

        calcularS.setOnClickListener {
            if(nm3.text.toString().isEmpty() || nS.text.toString().isEmpty())
            {
                Snackbar.make(linearLayout2,"No dejes campos vacíos",Snackbar.LENGTH_LONG).setAction("OK",this).show()
            }
            else {
                try {
                    conversionesTabla2(nm3.text.toString().toFloat(), nS.text.toString().toFloat())
                    masMasConversiones()
                }catch (e : Exception){
                    Snackbar.make(linearLayout2,"Los datos proporcionados son inconsistentes",Snackbar.LENGTH_LONG).setAction("OK",this).show()
                }

                val arrayTabla4 = arrayOf("Insumo", "En peso para ${nm3.text.toString().toFloat()} [m³]","Agua","${aaguaPeso} [kg]", "Cemento", "${acementoPeso} [kg]", "Grava", "${agravaPeso} [kg]", "Arena","${aarenaPeso} [kg]", "Agua de Absorción","${aaguaTotal} [kg]")
                val arrayTabla5 = arrayOf("Insumo", "En volumen para ${nm3.text.toString().toFloat()} [m³]","Agua","${aaguaVolumen1} [L]", "Cemento", "${acementoVolumen1} [kg]", "Grava", "${agravaVolumen1} [L]", "Arena","${aarenaVolumen1} [L]", "Agua de Absorción","${aaguaTotal} [L]")
                val arrayTabla6 = arrayOf("Insumo", "En volumen (${nS.text.toString().toFloat()} saco)","Agua","${aaguaVolumen2} [L]", "Cemento", "${acementoVolumen2} [kg]", "Grava", "${agravaVolumen2} [L]", "Arena","${aarenaVolumen2} [L]", "Agua de Absorción","${aaguaTottalV} [L]")

                val aaTabla4 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla4)
                tablaResultadosAvanzado4.adapter = aaTabla4

                val aaTabla5 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla5)
                tablaResultadosAvanzado5.adapter = aaTabla5

                val aaTabla6 = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTabla6)
                tablaResultadosAvanzado6.adapter = aaTabla6
            }
        }

        back_button.setOnClickListener {
            startActivity(regresarr)
            this.finish()
        }

        regresarDatos.setOnClickListener {
            startActivity(regresarr)
            this.finish()
        }

        irInicio.setOnClickListener {
            startActivity(inicioo)
            this.finish()
        }

        linearLayout2.setOnClickListener {

        }

        //Configuracion EditText nm3
        nm3.addTextChangedListener(this)
        nm3.onFocusChangeListener = this

        //Configuracion EditText nS
        nS.addTextChangedListener(this)
        nS.onFocusChangeListener = this
    }

    override fun onBackPressed() {
        val regresarrrr = Intent(this, DatosAvanzado::class.java)
        startActivity(regresarrrr)
        this.finish()
    }

    override fun onClick(p0: View?) {

    }

    override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

        if(nm3.isFocused && nm3.text.toString().isEmpty())
        {
            nm3_TextInputLayout.isErrorEnabled = true
            nm3_TextInputLayout.error = "Debes llenar este campo"
        }
        else
            nm3_TextInputLayout.isErrorEnabled = false

        if(nS.isFocused && nS.text.toString().isEmpty())
        {
            nS_TextInputLayout.isErrorEnabled = true
            nS_TextInputLayout.error = "Debes llenar este campo"
        }
        else
            nS_TextInputLayout.isErrorEnabled = false
    }

    override fun afterTextChanged(p0: Editable?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onFocusChange(p0: View, p1: Boolean) {

        if(p0 == nm3)
        {
            if(nm3.isFocused && nm3.text.toString().isEmpty())
            {
                nm3_TextInputLayout.isErrorEnabled = true
                nm3_TextInputLayout.error = "Debes llenar este campo"
            }
            else
                nm3_TextInputLayout.isErrorEnabled = false
        }

        if(p0 == nS)
        {

            if(nS.isFocused && nS.text.toString().isEmpty())
            {
                nS_TextInputLayout.isErrorEnabled = true
                nS_TextInputLayout.error = "Debes llenar este campo"
            }
            else
                nS_TextInputLayout.isErrorEnabled = false
        }
    }

    //Variables para los calculos
    var aguaPesoa: Double= 0.0
    var cementoPesoa: Double = 0.0
    var gravaPesoa: Double = 0.0
    var arenaPesoa: Double = 0.0
    var aguaVolumen1a: Double = 0.0
    var cementoVolumen1a: Double = 0.0
    var gravaVolumen1a: Double = 0.0
    var arenaVolumen1a: Double = 0.0
    var aguaVolumen2a: Double = 0.0
    var cementoVolumen2a: Double = 0.0
    var gravaVolumen2a: Double = 0.0
    var arenaVolumen2a: Double = 0.0
    var aguaTotala: Double = 0.0
    var aguaTottalVa: Double = 0.0

    var aguaPeso: Int = 0
    var cementoPeso: Int = 0
    var gravaPeso: Int = 0
    var arenaPeso: Int = 0
    var aguaVolumen1: Int = 0
    var cementoVolumen1: Int = 0
    var gravaVolumen1: Int = 0
    var arenaVolumen1: Int = 0
    var aguaVolumen2: Int = 0
    var cementoVolumen2: Int = 0
    var gravaVolumen2: Int = 0
    var arenaVolumen2: Int = 0
    var aguaTotal: Int = 0
    var aguaTottalV: Int = 0

    var aaguaPesoa: Double = 0.0
    var acementoPesoa: Double = 0.0
    var agravaPesoa: Double = 0.0
    var aarenaPesoa: Double = 0.0
    var aaguaVolumen1a: Double = 0.0
    var acementoVolumen1a: Double = 0.0
    var agravaVolumen1a: Double = 0.0
    var aarenaVolumen1a: Double = 0.0
    var aaguaVolumen2a: Double = 0.0
    var acementoVolumen2a: Double = 0.0
    var agravaVolumen2a: Double = 0.0
    var aarenaVolumen2a: Double = 0.0
    var aaguaTotala: Double = 0.0
    var aaguaTottalVa: Double = 0.0

    var aaguaPeso: Int = 0
    var acementoPeso: Int = 0
    var agravaPeso: Int = 0
    var aarenaPeso: Int = 0
    var aaguaVolumen1: Int = 0
    var acementoVolumen1: Int = 0
    var agravaVolumen1: Int = 0
    var aarenaVolumen1: Int = 0
    var aaguaVolumen2: Int = 0
    var acementoVolumen2: Int = 0
    var agravaVolumen2: Int = 0
    var aarenaVolumen2: Int = 0
    var aaguaTotal: Int = 0
    var aaguaTottalV: Int = 0

    //Resisitencia de diseño

    fun resistenciaDeDiseño() : Float
    {
        var resistencaideDiseñodelaMezcla : Float = 0f
        var fcr1 : Float
        var fcr2 : Float
        if (Datos.norma == "RCDF")
        {
            if (Datos.calidad == 1)
            {
                fcr1 = Datos.resistenciaProyecto - 35 + Datos.desviacionEstandar * 3.35f
                fcr2 = Datos.resistenciaProyecto + (Datos.desviacionEstandar * 3.35f) / (1.73205f)
                if (fcr1 > fcr2)
                    resistencaideDiseñodelaMezcla = fcr1
                else
                    resistencaideDiseñodelaMezcla = fcr2
            }
            else if (Datos.calidad == 2)
            {
                fcr1 = Datos.resistenciaProyecto - 50 + Datos.desviacionEstandar * 3.35f
                fcr2 = Datos.resistenciaProyecto - 17 + (Datos.desviacionEstandar * 3.35f) / (1.73205f)
                if (fcr1 > fcr2)
                    resistencaideDiseñodelaMezcla = fcr1
                else
                    resistencaideDiseñodelaMezcla = fcr2
            }
        }
        else if (Datos.norma == "2004")
        {
            var fcr3 : Float
            var fcr4 : Float
            fcr1 = Datos.resistenciaProyecto + Datos.desviacionEstandar * 1.28f
            fcr2 = Datos.resistenciaProyecto + (Datos.desviacionEstandar * 2.33f) / (1.73207f)
            fcr3 = Datos.resistenciaProyecto - 35 + Datos.desviacionEstandar * 2.33f
            fcr4 = Datos.resistenciaProyecto - 13 + (Datos.desviacionEstandar * 2.33f) / (1.41421f)
            if (fcr1 > fcr2 && fcr1 > fcr3 && fcr1 > fcr4)
                resistencaideDiseñodelaMezcla = fcr1
            else if (fcr2 > fcr1 && fcr2 > fcr3 && fcr2 > fcr4)
                resistencaideDiseñodelaMezcla = fcr2
            else if (fcr3 > fcr1 && fcr3 > fcr2 && fcr3 > fcr4)
                resistencaideDiseñodelaMezcla = fcr3
            else
                resistencaideDiseñodelaMezcla = fcr4
        }
        else if (Datos.norma == "1999")
        {
            fcr1 = Datos.resistenciaProyecto - 35 + Datos.desviacionEstandar * 3.35f
            fcr2 = Datos.resistenciaProyecto + (Datos.desviacionEstandar * 3.35f) / (1.73205f)
            if (fcr1 > fcr2)
                resistencaideDiseñodelaMezcla = fcr1
            else
                resistencaideDiseñodelaMezcla = fcr2
        }
        else
        {
            fcr1 = Datos.resistenciaProyecto - 35 + Datos.desviacionEstandar * 3.35f
            fcr2 = Datos.resistenciaProyecto + (Datos.desviacionEstandar * 3.35f) / (1.73205f)
            if (fcr1 > fcr2)
                resistencaideDiseñodelaMezcla = fcr1
            else
                resistencaideDiseñodelaMezcla = fcr2
        }
        return resistencaideDiseñodelaMezcla
    }

    //Contenido de Agua
    fun contenidoDeAgua() : Float
    {
        var agua : Float = 0f
        if (!Datos.aireIncluido)
        {
            if (Datos.revenimiento in 2.5f..5.0f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxUno[i].toFloat()
                        break
                    }
                }
            }
            else if (Datos.revenimiento in 5f..7.5f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxDos[i].toFloat()
                        break
                    }
                }
            }
            else if (Datos.revenimiento in 7.5f..10f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxTres[i].toFloat()
                        break
                    }
                }
            }
            else if (Datos.revenimiento in 10f..15f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxCuatro[i].toFloat()
                        break
                    }
                }
            }
            else if (Datos.revenimiento in 15f..17.5f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxCinco[i].toFloat()
                        break
                    }
                }
            }
        }
        else
        {
            if (Datos.revenimiento in 2.5f..5f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxSiete[i].toFloat()
                        break
                    }
                }
            }
            else if (Datos.revenimiento in 5f..7.5f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxOcho[i].toFloat()
                        break
                    }
                }
            }
            else if (Datos.revenimiento in 7.5f..10f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxNueve[i].toFloat()
                        break
                    }
                }
            }
            else if (Datos.revenimiento in 10f..15f)
            {
                for (i in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxDiez[i].toFloat()
                        break
                    }
                }
            }
            else if (Datos.revenimiento in 15f..17.5f)
            {
                for (i  in 0..8)
                {
                    if (Datos.grava == i)
                    {
                        agua = Datos.rAproxOnce[i].toFloat()
                        break
                    }
                }
            }
        }
        return agua
    }

    //Contenido de Cemento
    fun contenidoDeCemento() : Float
    {
        var relacionAguaCemento : Float = 0f
        var cemento : Float = 0f
        if (Datos.aireIncluido)
        {
            if(resistenciaDeDiseño()<140)
            {
                cemento = contenidoDeAgua() / 0.74f
            }
            else if(resistenciaDeDiseño()>420)
            {
                cemento = contenidoDeAgua() / 0.01f
            }
            else if (Datos.resistenciaCompresion28Dias[0] <= resistenciaDeDiseño() && resistenciaDeDiseño() <= Datos.resistenciaCompresion28Dias[1])
            {
                relacionAguaCemento = (resistenciaDeDiseño() - Datos.resistenciaCompresion28Dias[0]) / (Datos.resistenciaCompresion28Dias[1] - Datos.resistenciaCompresion28Dias[0])
                relacionAguaCemento *= (Datos.reralcionAguaCementoAI[1] - Datos.reralcionAguaCementoAI[0])
                relacionAguaCemento += Datos.reralcionAguaCementoAI[0]
                cemento = contenidoDeAgua() / relacionAguaCemento
            }
            else if (Datos.resistenciaCompresion28Dias[1] <= resistenciaDeDiseño() && resistenciaDeDiseño() <= Datos.resistenciaCompresion28Dias[2])
            {
                relacionAguaCemento = (resistenciaDeDiseño() - Datos.resistenciaCompresion28Dias[1]) / (Datos.resistenciaCompresion28Dias[2] - Datos.resistenciaCompresion28Dias[1])
                relacionAguaCemento *= (Datos.reralcionAguaCementoAI[2] - Datos.reralcionAguaCementoAI[1])
                relacionAguaCemento += Datos.reralcionAguaCementoAI[1]
                cemento = contenidoDeAgua() / relacionAguaCemento
            }
            else if (Datos.resistenciaCompresion28Dias[2] <= resistenciaDeDiseño() && resistenciaDeDiseño() <= Datos.resistenciaCompresion28Dias[3])
            {
                relacionAguaCemento = (resistenciaDeDiseño() - Datos.resistenciaCompresion28Dias[2]) / (Datos.resistenciaCompresion28Dias[3] - Datos.resistenciaCompresion28Dias[2])
                relacionAguaCemento *= (Datos.reralcionAguaCementoAI[3] - Datos.reralcionAguaCementoAI[2])
                relacionAguaCemento += Datos.reralcionAguaCementoAI[2]
                cemento = contenidoDeAgua() / relacionAguaCemento
            }
            else if (Datos.resistenciaCompresion28Dias[3] <= resistenciaDeDiseño() && resistenciaDeDiseño() <= Datos.resistenciaCompresion28Dias[4])
            {
                relacionAguaCemento = (resistenciaDeDiseño() - Datos.resistenciaCompresion28Dias[3]) / (Datos.resistenciaCompresion28Dias[4] - Datos.resistenciaCompresion28Dias[3])
                relacionAguaCemento *= (Datos.reralcionAguaCementoAI[4] - Datos.reralcionAguaCementoAI[3])
                relacionAguaCemento += Datos.reralcionAguaCementoAI[3]
                cemento = contenidoDeAgua() / relacionAguaCemento
            }
        }
        else if (!Datos.aireIncluido)
        {
            if (resistenciaDeDiseño() < 140)
            {
                cemento = contenidoDeAgua() / 0.82f
            }
            else if (resistenciaDeDiseño() > 420)
            {
                cemento = contenidoDeAgua() / 0.41f
            }
            else if (Datos.resistenciaCompresion28Dias[0] <= resistenciaDeDiseño() && resistenciaDeDiseño() <= Datos.resistenciaCompresion28Dias[1])
            {
                relacionAguaCemento = (resistenciaDeDiseño() - Datos.resistenciaCompresion28Dias[0]) / (Datos.resistenciaCompresion28Dias[1] - Datos.resistenciaCompresion28Dias[0])
                relacionAguaCemento *= (Datos.reralcionAguaCementoSA[1] - Datos.reralcionAguaCementoSA[0])
                relacionAguaCemento += Datos.reralcionAguaCementoSA[0]
                cemento = contenidoDeAgua() / relacionAguaCemento
            }
            else if (Datos.resistenciaCompresion28Dias[1] <= resistenciaDeDiseño() && resistenciaDeDiseño() <= Datos.resistenciaCompresion28Dias[2])
            {
                relacionAguaCemento = (resistenciaDeDiseño() - Datos.resistenciaCompresion28Dias[1]) / (Datos.resistenciaCompresion28Dias[2] - Datos.resistenciaCompresion28Dias[1])
                relacionAguaCemento *= (Datos.reralcionAguaCementoSA[2] - Datos.reralcionAguaCementoSA[1])
                relacionAguaCemento += Datos.reralcionAguaCementoSA[1]
                cemento = contenidoDeAgua() / relacionAguaCemento
            }
            else if (Datos.resistenciaCompresion28Dias[2] <= resistenciaDeDiseño() && resistenciaDeDiseño() <= Datos.resistenciaCompresion28Dias[3])
            {
                relacionAguaCemento = (resistenciaDeDiseño() - Datos.resistenciaCompresion28Dias[2]) / (Datos.resistenciaCompresion28Dias[3] - Datos.resistenciaCompresion28Dias[2])
                relacionAguaCemento *= (Datos.reralcionAguaCementoSA[3] - Datos.reralcionAguaCementoSA[2])
                relacionAguaCemento += Datos.reralcionAguaCementoSA[2]
                cemento = contenidoDeAgua() / relacionAguaCemento
            }
            else if (Datos.resistenciaCompresion28Dias[3] <= resistenciaDeDiseño() && resistenciaDeDiseño() <= Datos.resistenciaCompresion28Dias[4])
            {
                relacionAguaCemento = (resistenciaDeDiseño() - Datos.resistenciaCompresion28Dias[3]) / (Datos.resistenciaCompresion28Dias[4] - Datos.resistenciaCompresion28Dias[3])
                relacionAguaCemento *= (Datos.reralcionAguaCementoSA[4] - Datos.reralcionAguaCementoSA[3])
                relacionAguaCemento += Datos.reralcionAguaCementoSA[3]
                cemento = contenidoDeAgua() / relacionAguaCemento
            }
        }
        return cemento
    }

    //Contenido de Grava
    fun contenidoDeGrava() : Float
    {
        var grava : Float = 0f
        var gravaT : Float = 0f
        if (Datos.moduloFinuraArena in 2.40f..2.60f)
        {
            for (i in 0..8)
            {
                if (Datos.grava == i)
                {
                    gravaT = (Datos.moduloFinuraArena - 2.40f) / (2.60f - 2.40f)
                    gravaT *= (Datos.gravaSobreConcreto26[i] - Datos.gravaSobreConcreto24[i])
                    gravaT += Datos.gravaSobreConcreto24[i]
                    grava = Datos.pvscGrava * gravaT
                    break
                }
            }
        }
        else if (Datos.moduloFinuraArena in 2.60f..2.80f)
        {
            for (i in 0..8)
            {
                if (Datos.grava == i)
                {
                    gravaT = (Datos.moduloFinuraArena - 2.60f) / (2.80f - 2.60f)
                    gravaT *= (Datos.gravaSobreConcreto28[i] - Datos.gravaSobreConcreto26[i])
                    gravaT += Datos.gravaSobreConcreto26[i]
                    grava = Datos.pvscGrava * gravaT
                    break
                }
            }
        }
        else if (Datos.moduloFinuraArena in 2.80f..3.0f)
        {
            for (i in 0..8)
            {
                if (Datos.grava == i)
                {
                    gravaT = (Datos.moduloFinuraArena - 2.80f) / (3.0f - 2.80f)
                    gravaT *= (Datos.gravaSobreConcreto30[i] - Datos.gravaSobreConcreto28[i])
                    gravaT += Datos.gravaSobreConcreto28[i]
                    grava = Datos.pvscGrava * gravaT
                    break
                }
            }
        }
        return grava
    }

    //Porcentaje de Aire
    fun porcentajeDeAire() : Float
    {
        var aire : Float = 0f
        if (Datos.aireIncluido)
        {
            for (i in 0..8)
            {
                if (Datos.grava == i)
                    aire = Datos.rAproxDoce[i]
            }
        }
        else if (!Datos.aireIncluido)
        {
            for (i in 0..8)
            {
                if (Datos.grava == i)
                    aire = Datos.rAproxSeis[i]
            }
        }
        return aire
    }

    //Contenido de Arena en Litros
    fun contenidoDeArenaLts() : Float
    {
        val cemento : Float = contenidoDeCemento() / Datos.densidad
        val  grava : Float = contenidoDeGrava() / Datos.densidadGrava
        val  aire : Float = porcentajeDeAire() * 10
        val agua : Float = contenidoDeAgua()
        val x : Float = cemento + grava + aire + agua
        val arena : Float = 1000 - x
        return arena
    }

    //Agua de absorcion Grava
    fun aguaDeAbsorcionGrava() : Float
    {
        var aAbsorcionGrava : Float = 0f
        aAbsorcionGrava = contenidoDeGrava() * (Datos.absorcionGrava - Datos.humedadObraGrava)
        aAbsorcionGrava /= 100
        return aAbsorcionGrava
    }

    //Agua de absorcion Arena
    fun aguaDeAbsorcionArena() : Float
    {
        var aAbsorcionArena :Float = 0f
        aAbsorcionArena = contenidoDeArenaLts() * Datos.densidadArena
        aAbsorcionArena *= (Datos.absorcionArena - Datos.humedadObraArena)
        aAbsorcionArena /= 100
        return aAbsorcionArena
    }

    //Agua de absorcion total
    fun aguaDeAbsorcionTotal() : Float
    {
        val aAbsorcionTotal : Float = aguaDeAbsorcionArena() + aguaDeAbsorcionGrava()
        return aAbsorcionTotal
    }

    //Funcion para redondear Double a Entero
    fun Double.doubleToInt() = BigDecimal(this).setScale(0,BigDecimal.ROUND_HALF_UP).toInt()


    //Conversiones Finales
    fun conversionesFinales()
    {

        aguaPesoa = (contenidoDeAgua()).toDouble()
        cementoPesoa = (contenidoDeCemento()).toDouble()
        arenaPesoa = (contenidoDeArenaLts() * Datos.densidadArena).toDouble()
        gravaPesoa = (contenidoDeGrava()).toDouble()
        aguaVolumen1a = (contenidoDeAgua()).toDouble()
        cementoVolumen1a = (contenidoDeCemento()).toDouble()
        arenaVolumen1a = ((arenaPesoa / Datos.pvssArena) * 1000)
        gravaVolumen1a = ((contenidoDeGrava() / Datos.pvssGrava) * 1000).toDouble()
        aguaVolumen2a = (contenidoDeAgua()) / (contenidoDeCemento() / 50).toDouble()
        cementoVolumen2a = 50.toDouble()
        gravaVolumen2a = (((contenidoDeGrava() / Datos.pvssGrava) * 1000) / (contenidoDeCemento() / 50)).toDouble()
        arenaVolumen2a = ((arenaVolumen1a) / (contenidoDeCemento() / 50))
        aguaTotala = (aguaDeAbsorcionTotal()).toDouble()
        aguaTottalVa = ((aguaDeAbsorcionTotal()) / (contenidoDeCemento() / 50)).toDouble()
    }

    //Conversiones para numero de bultos
    fun conversionesTabla2(a : Float, b : Float)
    {

        aaguaPesoa = (aguaPesoa * a)
        acementoPesoa = (cementoPesoa * a)
        aarenaPesoa = (arenaPesoa * a)
        agravaPesoa = (gravaPesoa * a)
        aaguaVolumen1a = (aguaVolumen1a * a)
        acementoVolumen1a = (cementoVolumen1a * a)
        aarenaVolumen1a = (arenaVolumen1a * a)
        agravaVolumen1a = (gravaVolumen1a * a)
        aaguaVolumen2a = (aguaVolumen2a * b)
        acementoVolumen2a = (cementoVolumen2a*b)
        agravaVolumen2a = (gravaVolumen2a * b)
        aarenaVolumen2a = (arenaVolumen2a * b)
        aaguaTotala = (aguaTotala * a)
        aaguaTottalVa = (aguaTottalVa * b)
    }

    //Conversiones
    fun  masConversiones()
    {
        aguaPeso = aguaPesoa.doubleToInt()
        cementoPeso = cementoPesoa.doubleToInt()
        arenaPeso = arenaPesoa.doubleToInt()
        gravaPeso = gravaPesoa.doubleToInt()
        aguaVolumen1 = aguaVolumen1a.doubleToInt()
        cementoVolumen1 = cementoVolumen1a.doubleToInt()
        arenaVolumen1 = arenaVolumen1a.doubleToInt()
        gravaVolumen1 = gravaVolumen1a.doubleToInt()
        aguaVolumen2 = aguaVolumen2a.doubleToInt()
        cementoVolumen2 = 50
        gravaVolumen2 = gravaVolumen2a.doubleToInt()
        arenaVolumen2 = arenaVolumen2a.doubleToInt()
        aguaTotal = aguaTotala.doubleToInt()
        aguaTottalV = aguaTottalVa.doubleToInt()
    }

    //Conversiones
    fun masMasConversiones() {
        aaguaPeso = aaguaPesoa.doubleToInt()
        acementoPeso = acementoPesoa.doubleToInt()
        aarenaPeso = aarenaPesoa.doubleToInt()
        agravaPeso = agravaPesoa.doubleToInt()
        aaguaVolumen1 = aaguaVolumen1a.doubleToInt()
        acementoVolumen1 = acementoVolumen1a.doubleToInt()
        aarenaVolumen1 = aarenaVolumen1a.doubleToInt()
        agravaVolumen1 = agravaVolumen1a.doubleToInt()
        aaguaVolumen2 = aaguaVolumen2a.doubleToInt()
        acementoVolumen2 = acementoVolumen2a.doubleToInt()
        agravaVolumen2 = agravaVolumen2a.doubleToInt()
        aarenaVolumen2 = aarenaVolumen2a.doubleToInt()
        aaguaTotal = aaguaTotala.doubleToInt()
        aaguaTottalV = aaguaTottalVa.doubleToInt()
    }
}
