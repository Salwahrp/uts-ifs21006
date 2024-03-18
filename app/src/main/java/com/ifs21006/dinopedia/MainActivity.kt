package com.ifs21006.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21006.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dataDino = ArrayList<Dino>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDino.setHasFixedSize(false)
        dataDino.addAll(getListDino())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListDino(): ArrayList<Dino> {
        val dataName =
            resources.getStringArray(R.array.dino_name)
        val dataIcon =
            resources.obtainTypedArray(R.array.family_dino_photo)
        val dataFamily =
            resources.getStringArray(R.array.dino_family)
        val dataPeriode =
            resources.getStringArray(R.array.dino_periode)
        val dataKarakter =
            resources.getStringArray(R.array.dino_karakteristik)
        val dataDeskripsi =
            resources.getStringArray(R.array.dino_deskripsi)
        val dataHabitat =
            resources.getStringArray(R.array.dino_habitat)
        val dataPerilaku =
            resources.getStringArray(R.array.dino_perilaku)
        val listDino = ArrayList<Dino>()
        for (i in dataName.indices) {
            val dino = Dino(
                dataName[i],
                dataIcon.getResourceId(i, -1), dataFamily[i],
                dataPerilaku[i], dataPeriode[i], dataKarakter[i], dataDeskripsi[i], dataHabitat[i])
            listDino.add(dino)
        }
        return listDino
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvDino.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvDino.layoutManager = LinearLayoutManager(this)
        }
        val listDinoAdapter = ListDinoAdapter(dataDino)
        binding.rvDino.adapter = listDinoAdapter
        listDinoAdapter.setOnItemClickCallback(object :
            ListDinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {
                showSelectedDino(data)
            }
        })
    }
    private fun showSelectedDino(dino: Dino) {
        val intentWithData = Intent(this@MainActivity,
            DetailActivity::class.java)
        intentWithData.putExtra(DetailActivity.EXTRA_DINO, dino)
        startActivity(intentWithData)
    }


}