package c.apps.machete.mastermezcla

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.AdapterView
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_datos_avanzado.*
import kotlinx.android.synthetic.main.activity_datos_avanzado.view.*

class DatosAvanzado : AppCompatActivity(), AdapterView.OnItemSelectedListener, TextWatcher, View.OnFocusChangeListener, View.OnClickListener {

    var resistenciaSelected = 0
    var gravaSelected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_avanzado)

        //Activities necesarios
        val regresar = Intent(this,Inicio::class.java)
        val resultados = Intent(this,ResultadoAvanzado::class.java)
        val tabladeRevenimiento = Intent(this, TablaRevenimiento::class.java)

        //Configuracion de la ActionBar
        setSupportActionBar(toolbar_datosAvanzado)
        supportActionBar!!.title = ""

        //Configuracion spinner de Resistencia
        spinner_ResistenciaAvanzado.onItemSelectedListener = this
        val aaRes = ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.spinner_ResistenciaAvanzado))
        aaRes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_ResistenciaAvanzado.adapter = aaRes


        //Configuracion spinner de Grava
        spinner_GravaAvanzado.onItemSelectedListener = this
        val aaG = ArrayAdapter(this,android.R.layout.simple_spinner_item,resources.getStringArray(R.array.spinner_GravaAvanzado))
        aaG.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_GravaAvanzado.adapter = aaG

        //Configuracion del EditText Revenimmiento
        revenimiento.addTextChangedListener(this)
        revenimiento.onFocusChangeListener = this

        //Configuracion del EditText DesviacionEstandar
        desviacionEstandar.addTextChangedListener(this)
        desviacionEstandar.onFocusChangeListener = this

        //Configuracion del EditText Densidad
        densidad.addTextChangedListener(this)
        densidad.onFocusChangeListener = this

        //Configuracion del EditText DensidadGrava
        densidadGrava.addTextChangedListener(this)
        densidadGrava.onFocusChangeListener = this

        //Configuracion del EditText Absorcion grava
        absorcionGrava.addTextChangedListener(this)
        absorcionGrava.onFocusChangeListener =  this

        //Configuracion del EditText PVSS grava
        PVSSGrava.addTextChangedListener(this)
        PVSSGrava.onFocusChangeListener = this

        //Configuracion del EditText PVSC grava
        PVSCGrava.addTextChangedListener(this)
        PVSCGrava.onFocusChangeListener = this

        //Configuracion del EditText Humedad Obra grava
        humedadObraGrava.addTextChangedListener(this)
        humedadObraGrava.onFocusChangeListener = this

        //Configuracion del EditText DensidadArena
        densidadArena.addTextChangedListener(this)
        densidadArena.onFocusChangeListener = this

        //Configuracion del EditText Absorcion arena
        absorcionArena.addTextChangedListener(this)
        absorcionArena.onFocusChangeListener =  this

        //Configuracion del EditText PVSS arena
        PVSSArena.addTextChangedListener(this)
        PVSSArena.onFocusChangeListener = this

        //Configuracion del EditText PVSC arena
        PVSCArena.addTextChangedListener(this)
        PVSCArena.onFocusChangeListener = this

        //Configuracion del EditText modulo de finura
        moduloFinura.addTextChangedListener(this)
        moduloFinura.onFocusChangeListener = this

        //Configuracion del EditText Humedad Obra arena
        humedadObraArena.addTextChangedListener(this)
        humedadObraArena.onFocusChangeListener = this

        linear_layout.setOnClickListener(null)

        //ToolBar boton atras
        back_button.setOnClickListener {
            startActivity(regresar)
            this.finish()
        }

        //Ver tabla de revenimiento
        tabla_Revenimiento.setOnClickListener {
            startActivity(tabladeRevenimiento)
            this.finish()
        }

        //Verificar datos e ir a resultados
        calcular_avanzado.setOnClickListener {

            var dataCorrect = 0
            try {
                if (revenimiento.text.toString() == "" || desviacionEstandar.text.toString() == "" || densidad.text.toString() == "" || densidadGrava.text.toString() == "" || absorcionGrava.text.toString() == "" || PVSSGrava.text.toString() == "" || PVSCGrava.text.toString() == "" || humedadObraGrava.text.toString() == "" || densidadArena.text.toString() == "" || absorcionArena.text.toString() == "" || PVSSArena.text.toString() == "" || PVSCArena.text.toString() == "" || moduloFinura.text.toString() == "" || humedadObraArena.text.toString() == "")
                {
                    Snackbar.make(linearLayout1,"Debes proporcionar todos los campos",Snackbar.LENGTH_LONG).setAction("OK",this).show()
                    dataCorrect+=1
                }
                if (revenimiento.text.toString().toFloat() < 2.5f)
                {
                    Snackbar.make(linearLayout1, "El Revenimiento no debe ser menor que 2.5", Snackbar.LENGTH_LONG).setAction("OK",this).show()
                    dataCorrect+=1
                }
                if (revenimiento.text.toString().toFloat() > 17.5f)
                {
                    Snackbar.make(linearLayout1, "El Revenimiento no debe ser mayor que 17.5 ", Snackbar.LENGTH_LONG).setAction("OK",this).show()
                    dataCorrect+=1
                }
                if (moduloFinura.text.toString().toFloat() < 2.4 || 3 < moduloFinura.text.toString().toFloat())
                {
                    Snackbar.make(linearLayout1, "El módulo de finura debe estar entre 2.4 y 3", Snackbar.LENGTH_LONG).setAction("OK",this).show()
                    dataCorrect+=1
                }
                if (dataCorrect == 0) {
                    Datos.resistenciaProyecto = resistenciaSelected
                    Datos.grava = gravaSelected
                    Datos.revenimiento = revenimiento.text.toString().toFloat()
                    Datos.desviacionEstandar = desviacionEstandar.text.toString().toFloat()

                    if (r5.isChecked && r1.isChecked)
                        Datos.calidad = 1
                    else if (r6.isChecked && r1.isChecked)
                        Datos.calidad = 2
                    else
                        Datos.calidad = 0

                    Datos.densidad = densidad.text.toString().toFloat()
                    Datos.densidadGrava = densidadGrava.text.toString().toFloat()
                    Datos.absorcionGrava = absorcionGrava.text.toString().toFloat()
                    Datos.pvssGrava = PVSSGrava.text.toString().toFloat()
                    Datos.pvscGrava = PVSCGrava.text.toString().toFloat()
                    Datos.humedadObraGrava = humedadObraGrava.text.toString().toFloat()
                    Datos.densidadArena = densidadArena.text.toString().toFloat()
                    Datos.absorcionArena = absorcionArena.text.toString().toFloat()
                    Datos.pvssArena = PVSSArena.text.toString().toFloat()
                    Datos.pvscArena = PVSCArena.text.toString().toFloat()
                    Datos.moduloFinuraArena = moduloFinura.text.toString().toFloat()
                    Datos.humedadObraArena = humedadObraArena.text.toString().toFloat()
                    Datos.aireIncluido = r7.isChecked

                    if (r1.isChecked)
                        Datos.norma = "RCDF"
                    else if (r2.isChecked)
                        Datos.norma = "2004"
                    else if (r3.isChecked)
                        Datos.norma = "1999"
                    else if (r4.isChecked)
                        Datos.norma = "ACI"

                    startActivity(resultados)
                    this.finish()
                }
            } catch (e : Exception){
                Snackbar.make(linearLayout1,"Los datos proporcionados son inconsistentes",Snackbar.LENGTH_LONG).setAction("OK",this).show()
            }
        }

        //Regresar al inicio
        inicio.setOnClickListener {
            startActivity(regresar)
            this.finish()
        }

        //Aire incluido?
        r7.setOnCheckedChangeListener { compoundButton, b ->
            if(r7.isChecked)
                r7.text = "Si"
            else
                r7.text = "No"
        }

        //Normatividad y calidad para RCDF
        r1.setOnCheckedChangeListener { compoundButton, b ->
            if(r1.isChecked)
            {
                r5.isEnabled = true
                r6.isEnabled = true
            }
            else
            {
                r5.isEnabled = false
                r6.isEnabled = false
            }
        }
    }

    override fun onClick(arg0: View) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        //TextChange Revenimiento
        if(revenimiento.isFocused && revenimiento.text.toString().isEmpty()){
            revenimiento_TextInputLayout.isErrorEnabled = true
            revenimiento_TextInputLayout.error = "Éste campo es necesario"
        }
        else if(revenimiento.isFocused && (revenimiento.text.toString().toFloat() < 2.5f || revenimiento.text.toString().toFloat() > 17.5f) ){
            revenimiento_TextInputLayout.isErrorEnabled = true
            revenimiento_TextInputLayout.error = "El revenimiento debe estar entre 2.5 y 17.5 [cm]"
        }
        else
            revenimiento_TextInputLayout.isErrorEnabled = false

        //TextChange Desviacion Estandar
        if (desviacionEstandar.isFocused && desviacionEstandar.text.toString().isEmpty()) {
            desviacionEstandar_TextInputLayout.isErrorEnabled = true
            desviacionEstandar_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            desviacionEstandar_TextInputLayout.isErrorEnabled = false

        //TextChange Densidad
        if(densidad.isFocused && densidad.text.toString().isEmpty())
        {
            densidad_TextInputLayout.isErrorEnabled = true
            densidad_TextInputLayout.error = "Éste campo es necesrio"
        }
        else
            densidad_TextInputLayout.isErrorEnabled = false

        //TextChange densidad grava
        if(densidadGrava.isFocused && densidadGrava.text.toString().isEmpty())
        {
            densidadGrava_TextInputLayout.isErrorEnabled = true
            densidadGrava_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            densidadGrava_TextInputLayout.isErrorEnabled = false

        //TextChange absorcion grava
        if(absorcionGrava.isFocused && absorcionGrava.text.toString().isEmpty())
        {
            absorcionGrava_TextInputLayout.isErrorEnabled = true
            absorcionGrava_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            absorcionGrava_TextInputLayout.isErrorEnabled = false

        //TextChange PVSS grava
        if(PVSSGrava.isFocused && PVSSGrava.text.toString().isEmpty())
        {
            PVSSGrava_TextInputLayout.isErrorEnabled = true
            PVSSGrava_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            PVSSGrava_TextInputLayout.isErrorEnabled = false

        //TextChange PSVC grava
        if(PVSCGrava.isFocused && PVSCGrava.text.toString().isEmpty())
        {
            PVSCGrava_TextInputLayout.isErrorEnabled = true
            PVSCGrava_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            PVSCGrava_TextInputLayout.isErrorEnabled = false

        //TextChange humedad en obra grava
        if (humedadObraGrava.isFocused && humedadObraGrava.text.toString().isEmpty())
        {
            humedadObraGrava_TextInputLayout.isErrorEnabled = true
            humedadObraGrava_TextInputLayout.error  = "Éste campo es necesario"
        }
        else
            humedadObraGrava_TextInputLayout.isErrorEnabled = false

        //TextChange densidad arena
        if(densidadArena.isFocused && densidadArena.text.toString().isEmpty())
        {
            densidadArena_TextInputLayout.isErrorEnabled = true
            densidadArena_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            densidadArena_TextInputLayout.isErrorEnabled = false

        //TextChange absorcion arena
        if(absorcionArena.isFocused && absorcionArena.text.toString().isEmpty())
        {
            absorcionArena_TextInputLayout.isErrorEnabled = true
            absorcionArena_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            absorcionArena_TextInputLayout.isErrorEnabled = false

        //TextChange PVSS arena
        if(PVSSArena.isFocused && PVSSArena.text.toString().isEmpty())
        {
            PVSSArena_TextInputLayout.isErrorEnabled = true
            PVSSArena_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            PVSSArena_TextInputLayout.isErrorEnabled = false

        //TextChange PSVC arena
        if(PVSCArena.isFocused && PVSCArena.text.toString().isEmpty())
        {
            PVSCArena_TextInputLayout.isErrorEnabled = true
            PVSCArena_TextInputLayout.error = "Éste campo es necesario"
        }
        else
            PVSCArena_TextInputLayout.isErrorEnabled = false

        //TextChange Modulo de finura
        if (moduloFinura.isFocused && moduloFinura.text.toString().isEmpty())
        {
            moduloFinura_TextInputLayout.isErrorEnabled = true
            moduloFinura_TextInputLayout.error = "Éste campo es necesario"
        }
        else if(moduloFinura.isFocused && (moduloFinura.text.toString().toFloat() < 2.4 || moduloFinura.text.toString().toFloat() > 3))
        {
            moduloFinura_TextInputLayout.isErrorEnabled = true
            moduloFinura_TextInputLayout.error = "El módulo de finura debe estar entre 2.4 y 3"
        }
        else
            moduloFinura_TextInputLayout.isErrorEnabled = false

        //TextChange humedad en obra arena
        if (humedadObraArena.isFocused && humedadObraArena.text.toString().isEmpty())
        {
            humedadObraArena_TextInputLayout.isErrorEnabled = true
            humedadObraArena_TextInputLayout.error  = "Éste campo es necesario"
        }
        else
            humedadObraArena_TextInputLayout.isErrorEnabled = false
    }

    override fun afterTextChanged(p0: Editable?) {

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onFocusChange(p0: View, p1: Boolean) {
        if (p0 == revenimiento)
        {
            //TextChange Revenimiento
            if(revenimiento.text.toString().isEmpty()){
                revenimiento_TextInputLayout.isErrorEnabled = true
                revenimiento_TextInputLayout.error = "Éste campo es necesario"
            }
            else if(revenimiento.text.toString().toFloat() < 2.5f || revenimiento.text.toString().toFloat() > 17.5f){
                revenimiento_TextInputLayout.isErrorEnabled = true
                revenimiento_TextInputLayout.error = "El revenimiento debe estar entre 2.5 y 17.5 [cm]"
            }
            else
                revenimiento_TextInputLayout.isErrorEnabled = false
        }

        if(p0 == desviacionEstandar)
        {
            //TextChange Desviacion Estandar
            if (desviacionEstandar.text.toString().isEmpty()) {
                desviacionEstandar_TextInputLayout.isErrorEnabled = true
                desviacionEstandar_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                desviacionEstandar_TextInputLayout.isErrorEnabled = false
        }

        if(p0 == densidad)
        {
            //TextChange Densidad
            if(densidad.text.toString().isEmpty())
            {
                densidad_TextInputLayout.isErrorEnabled = true
                densidad_TextInputLayout.error = "Éste campo es necesrio"
            }
            else
                densidad_TextInputLayout.isErrorEnabled = false
        }

        if(p0 == densidadGrava)
        {
            //TextChange densidad grava
            if(densidadGrava.text.toString().isEmpty())
            {
                densidadGrava_TextInputLayout.isErrorEnabled = true
                densidadGrava_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                densidadGrava_TextInputLayout.isErrorEnabled = false
        }

        if(p0 == absorcionGrava)
        {
            //TextChange absorcion grava
            if(absorcionGrava.text.toString().isEmpty())
            {
                absorcionGrava_TextInputLayout.isErrorEnabled = true
                absorcionGrava_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                absorcionGrava_TextInputLayout.isErrorEnabled = false
        }

        if (p0 == PVSSGrava)
        {
            //TextChange PVSS grava
            if(PVSSGrava.text.toString().isEmpty())
            {
                PVSSGrava_TextInputLayout.isErrorEnabled = true
                PVSSGrava_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                PVSSGrava_TextInputLayout.isErrorEnabled = false
        }

        if (p0 == PVSCGrava)
        {
            //TextChange PSVC grava
            if(PVSCGrava.text.toString().isEmpty())
            {
                PVSCGrava_TextInputLayout.isErrorEnabled = true
                PVSCGrava_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                PVSCGrava_TextInputLayout.isErrorEnabled = false
        }

        if ( p0 == humedadObraGrava)
        {
            //TextChange humedad en obra grava
            if (humedadObraGrava.text.toString().isEmpty())
            {
                humedadObraGrava_TextInputLayout.isErrorEnabled = true
                humedadObraGrava_TextInputLayout.error  = "Éste campo es necesario"
            }
            else
                humedadObraGrava_TextInputLayout.isErrorEnabled = false
        }

        if ( p0 == densidadArena)
        {
            //TextChange densidad arena
            if(densidadArena.text.toString().isEmpty())
            {
                densidadArena_TextInputLayout.isErrorEnabled = true
                densidadArena_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                densidadArena_TextInputLayout.isErrorEnabled = false
        }

        if(p0 == absorcionArena)
        {
            //TextChange absorcion arena
            if(absorcionArena.text.toString().isEmpty())
            {
                absorcionArena_TextInputLayout.isErrorEnabled = true
                absorcionArena_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                absorcionArena_TextInputLayout.isErrorEnabled = false
        }

        if ( p0 == PVSSArena)
        {
            //TextChange PVSS arena
            if(PVSSArena.text.toString().isEmpty())
            {
                PVSSArena_TextInputLayout.isErrorEnabled = true
                PVSSArena_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                PVSSArena_TextInputLayout.isErrorEnabled = false
        }

        if ( p0 == PVSCArena)
        {
            //TextChange PSVC arena
            if(PVSCArena.text.toString().isEmpty())
            {
                PVSCArena_TextInputLayout.isErrorEnabled = true
                PVSCArena_TextInputLayout.error = "Éste campo es necesario"
            }
            else
                PVSCArena_TextInputLayout.isErrorEnabled = false
        }

        if ( p0 == moduloFinura)
        {
            //TextChange Modulo de finura
            if (moduloFinura.text.toString().isEmpty())
            {
                moduloFinura_TextInputLayout.isErrorEnabled = true
                moduloFinura_TextInputLayout.error = "Éste campo es necesario"
            }
            else if(moduloFinura.isFocused && (moduloFinura.text.toString().toFloat() < 2.4 || moduloFinura.text.toString().toFloat() > 3))
            {
                moduloFinura_TextInputLayout.isErrorEnabled = true
                moduloFinura_TextInputLayout.error = "El módulo de finura debe estar entre 2.4 y 3"
            }
            else
                moduloFinura_TextInputLayout.isErrorEnabled = false
        }

        if ( p0 == humedadObraArena)
        {
            //TextChange humedad en obra arena
            if (humedadObraArena.text.toString().isEmpty())
            {
                humedadObraArena_TextInputLayout.isErrorEnabled = true
                humedadObraArena_TextInputLayout.error  = "Éste campo es necesario"
            }
            else
                humedadObraArena_TextInputLayout.isErrorEnabled = false
        }
    }

    override fun onBackPressed() {
        val regresarr = Intent(this,Inicio::class.java)
        startActivity(regresarr)
        this.finish()
    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View?, position: Int, id: Long) {

        if(arg0 == spinner_ResistenciaAvanzado)
        {
            when (position){
                0 -> resistenciaSelected = 100
                1 -> resistenciaSelected = 150
                2 -> resistenciaSelected = 200
                3 -> resistenciaSelected = 250
                4 -> resistenciaSelected = 300
                5 -> resistenciaSelected = 350
                6 -> resistenciaSelected = 400
            }
        }
        if (arg0 == spinner_GravaAvanzado)
        {
            gravaSelected = position
        }
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }
}

class Datos{
    companion object {

        //Parametros del proyecto
        var resistenciaProyecto : Int = 0
        var revenimiento : Float = 0f
        var desviacionEstandar : Float = 0f
        var calidad : Int = 0
        var densidad : Float = 0f
        var densidadGrava : Float = 0f
        var absorcionGrava : Float = 0f
        var pvssGrava : Float = 0f
        var pvscGrava : Float = 0f
        var humedadObraGrava : Float = 0f
        var densidadArena : Float = 0f
        var absorcionArena : Float = 0f
        var pvssArena : Float = 0f
        var pvscArena : Float = 0f
        var moduloFinuraArena : Float = 0f
        var humedadObraArena : Float = 0f
        var aireIncluido : Boolean = false
        var norma : String = ""

        //Tablas de datos para los cálculos
        val rAproxUno = arrayOf( 207, 199, 190, 179, 166, 154, 130, 113 )
        val rAproxDos = arrayOf( 215, 206, 196, 185, 172, 160, 136, 117 )
        val rAproxTres = arrayOf( 228, 216, 205, 193, 181, 169, 145, 124 )
        val rAproxCuatro = arrayOf( 236, 222, 211, 198, 186, 174, 153 )
        val rAproxCinco = arrayOf( 243, 228, 216, 202, 190, 178, 160, 0 )
        val rAproxSeis = arrayOf( 3f, 2.5f, 2f, 1.5f, 1f, 0.5f, 0.3f, 0.2f )
        val rAproxSiete = arrayOf( 181, 175, 168, 160, 150, 142, 122, 107 )
        val rAproxOcho = arrayOf( 189, 182, 174, 166, 156, 148, 126, 112 )
        val rAproxNueve = arrayOf( 202, 193, 184, 175, 165, 157, 133, 119 )
        val rAproxDiez = arrayOf( 209, 199, 191, 175, 170, 162, 144, 0 )
        val rAproxOnce = arrayOf( 216, 205, 197, 174, 174, 166, 154, 0 )
        val rAproxDoce = arrayOf( 4.5f, 4f, 3.5f, 3f, 2.5f, 2f, 1.5f, 1f )
        var grava : Int = 0
        val resistenciaCompresion28Dias = arrayOf( 140, 210, 280, 350, 420 )
        val reralcionAguaCementoSA = arrayOf( 0.82f, 0.68f, 0.57f, 0.48f, 0.41f )
        val reralcionAguaCementoAI = arrayOf( 0.74f, 0.59f, 0.48f, 0.40f, 0f )
        val gravaSobreConcreto24 = arrayOf( 0.5f, 0.59f, 0.66f, 0.71f, 0.75f, 0.78f, 0.82f, 0.87f )
        val gravaSobreConcreto26 = arrayOf( 0.48f, 0.57f, 0.64f, 0.69f, 0.73f, 0.76f, 0.80f, 0.85f )
        val gravaSobreConcreto28 = arrayOf( 0.46f, 0.55f, 0.62f, 0.67f, 0.71f, 0.74f, 0.78f, 0.83f )
        val gravaSobreConcreto30 = arrayOf( 0.44f, 0.53f, 0.60f, 0.65f, 0.69f, 0.72f, 0.76f, 0.81f )
    }
}
