package com.example.recyclerview

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.adapter.AdapterPresiden
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Presiden

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  listPemain = ArrayList<Presiden>()
        listPemain.add(Presiden("Ir. Soekarno",R.drawable.soekarno, " Periode 1"))
        listPemain.add(Presiden("H.M. Soeharto ",R.drawable.soeharto, "Periode 2"))
        listPemain.add(Presiden("K.H. Abdurrahman Wahid",R.drawable.gusdur, "Periode 3"))
        listPemain.add(Presiden("Ir.H. B J Habibie",R.drawable.habiebie, "Periode 4"))
        listPemain.add(Presiden("Megawati Soekarnoputri",R.drawable.megawati, "Periode 5"))

        binding.list.adapter = AdapterPresiden(this, listPemain,object : AdapterPresiden.OnClikListener{
            override fun detailData(item: Presiden?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_presiden)

                    val image = this.findViewById<ImageView>(R.id.image_presiden)
                    val nama = this.findViewById<TextView>(R.id.txtnama)


                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"


                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode (selectedMode : Int){
        when (selectedMode){
            R.id.myprofile -> {
                val  intent = Intent ( this,Profile::class.java)
                startActivity(intent)
            }
        }
    }

}