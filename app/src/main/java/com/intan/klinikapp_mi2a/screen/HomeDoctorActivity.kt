package com.intan.klinikapp_mi2a.screen


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.intan.klinikapp_mi2a.R
import com.intan.klinikapp_mi2a.adapter.AdapterListDoktor
import com.intan.klinikapp_mi2a.adapter.AdapterMenuIcon
import com.intan.klinikapp_mi2a.model.ModelListDoctor
import com.intan.klinikapp_mi2a.model.ModelMenuIcon


class HomeDoctorActivity : AppCompatActivity() {
    private var rv_list_doctor : RecyclerView? = null
    private var rv_icon_menu : RecyclerView? = null
    private var homeDoctorAdapter : AdapterListDoktor? = null
    private var homeMenuIcon : AdapterMenuIcon? = null

    private var doctorlist = mutableListOf<ModelListDoctor>()
    private var menuIcon = mutableListOf<ModelMenuIcon>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_doctor)
        rv_list_doctor = findViewById(R.id.rv_doctor)
        rv_icon_menu=findViewById(R.id.rv_menu_icon)

        doctorlist = ArrayList()
        homeDoctorAdapter = AdapterListDoktor(doctorlist)

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 1)
        rv_list_doctor!!.layoutManager = layoutManager
        rv_list_doctor!!.adapter = homeDoctorAdapter

        menuIcon = ArrayList()
        homeMenuIcon = AdapterMenuIcon(menuIcon)

        val layoutManager2: RecyclerView.LayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_icon_menu!!.layoutManager = layoutManager2
        rv_icon_menu!!.adapter = homeMenuIcon

        prepareDataDoctor()
        prepareMenuIcon()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareMenuIcon() {
        var itemMenuIcon = ModelMenuIcon(
            R.drawable.icon_tooth,
            "Ikon Gigi"
        )
        menuIcon.add(itemMenuIcon)
        itemMenuIcon = ModelMenuIcon(
            R.drawable.icon_eye,
            "Ikon Mata"
        )
        menuIcon.add(itemMenuIcon)
        itemMenuIcon = ModelMenuIcon(
            R.drawable.icon_heart,
            "Ikon Mata "
        )
        menuIcon.add(itemMenuIcon)
        itemMenuIcon = ModelMenuIcon(
            R.drawable.icon_heart,
            "Ikon Mata "
        )

        menuIcon.add(itemMenuIcon)
    }

    private fun prepareDataDoctor() {
        var itemDoctors = ModelListDoctor(
            R.drawable.dokter1,
            "Rizki Syaputra",
            "Dentist",
            "123",
            "5.0"
        )
        doctorlist.add(itemDoctors)
        itemDoctors = ModelListDoctor(
            R.drawable.dokter3,
            "Rizki Bambang",
            "Dokter Umum",
            "100",
            "5.0",
        )
        doctorlist.add(itemDoctors)
        itemDoctors = ModelListDoctor(
            R.drawable.dokter1,
            "Junaidi",
            "Dokter Gigi",
            "88",
            "5.0",
        )
        doctorlist.add(itemDoctors)

    }
}