package com.adit_saputra.maps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adit_saputra.maps.Adapter.adapterWisata
import com.adit_saputra.maps.Model.modelWisata


class ListWisata : AppCompatActivity() {

    private var recyleView : RecyclerView? = null

    private var wisatalist =  mutableListOf<modelWisata>()

    private var wisataAdapter : adapterWisata? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        wisatalist = ArrayList()

        recyleView = findViewById(R.id.rv_wisata)
        wisataAdapter = adapterWisata(this,wisatalist);

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(
            this,1
        )
        recyleView!!.layoutManager = layoutManager
        recyleView!!.adapter =wisataAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        preparedDataWisata()
    }

    private fun preparedDataWisata() {
        var wisata = modelWisata(
            R.drawable.bukittinggi,
            "Jam Gadang",
            "Bukitingi",
            -0.3055235249336176, 100.3696274337037

        )
        wisatalist.add(wisata)
        wisata = modelWisata(
            R.drawable.bali,
            "Bali",
            "Bali",
            -8.403321479206745,
            115.17040294312433

        )
        wisatalist.add(wisata)
        wisata = modelWisata(
            R.drawable.stadion,
            "Stadion GBK",
            "Jakarta",
            -6.218624591590104,
            106.80192207684631
        )
        wisatalist.add(wisata)
        wisata = modelWisata(
            R.drawable.monas,
            "Monas",
            "Jakarta",
            -6.175301659461097,
            106.82669657375969
        )
        wisatalist.add(wisata)
        wisata = modelWisata(
            R.drawable.borobudur,
            "Candi Boroubudur",
            "Jakarta",
            -7.608061715880993, 110.20359605016597
        )
        wisatalist.add(wisata)
        wisataAdapter!!.notifyDataSetChanged()
    }
}