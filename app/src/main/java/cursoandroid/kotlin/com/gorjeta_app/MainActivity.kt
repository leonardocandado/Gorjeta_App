package cursoandroid.kotlin.com.gorjeta_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    var porcentagem = 0
    private lateinit var seekBarGorjeta: SeekBar
    private lateinit var editValor: EditText
    private lateinit var textGorjeta: TextView
    private lateinit var textTotal: TextView
    private lateinit var textPorcent:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editValor = findViewById(R.id.id_editValor)
        textGorjeta = findViewById(R.id.id_valorGorjeta)
        textPorcent = findViewById(R.id.id_percent)
        textTotal = findViewById(R.id.id_valorTotal)
        seekBarGorjeta = findViewById(R.id.id_seekBar)

        //Adição Listener
        seekBarGorjeta.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                porcentagem = p1
                textPorcent.text = "$porcentagem%"
                calcular()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

    }
    fun calcular (){
        var valorRecuperado = editValor.text.toString()
        if (valorRecuperado.equals("")){
            Toast.makeText(
                applicationContext, "Digite um valor primeiro!", Toast.LENGTH_SHORT
            ).show()
        } else {
            val valorGorjeta = ((porcentagem / 100.00) * valorRecuperado.toDouble())

            textGorjeta.text = "R$ $valorGorjeta"
            textTotal.text = "R$ ${(valorGorjeta + valorRecuperado.toDouble())}"
        }
        
    }


}