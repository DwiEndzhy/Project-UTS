package id.pusponingsih.dwi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun tambah(view: View){

        //find id
        val input_pinjam = findViewById<EditText>(R.id.input_data)
        val input_tenor = findViewById<EditText>(R.id.input_tenor)
        val pencairan = findViewById<TextView>(R.id.tv_total_pencairan)
        val total_pinjam = findViewById<TextView>(R.id.tv_total_pinjam)

        //format Rp.
        val formater = NumberFormat.getCurrencyInstance(Locale("in", "id"))

        // perhitungan
        val suku_bunga = 3.75/100
        val bunga_tenor = suku_bunga * input_tenor.text.toString().toDouble()
        val pencairan_bersih = input_pinjam.text.toString().toDouble() * 5/100
        val total_pinjaman = input_pinjam.text.toString().toDouble() + bunga_tenor.toString().toDouble()

        //data tampil
        val total_pencairan = formater.format(pencairan_bersih.toString().toDouble())
        pencairan.text = total_pencairan

        val total_bayar = formater.format(total_pinjaman.toString().toDouble())
        total_pinjam.text = total_bayar


    }
}