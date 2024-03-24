package com.ifs21006.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21006.dinopedia.databinding.ActivitySatuanBinding

class SatuanActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySatuanBinding
    private val dataDino = ArrayList<Satuan>()

    companion object{
        const val EXTRA_SATUAN = "extra_satuan"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySatuanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.satuanDino.setHasFixedSize(true)
        dataDino.addAll(getListSatuan())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListSatuan(): ArrayList<Satuan> {
        val data = intent.getParcelableArrayListExtra<Satuan>(EXTRA_SATUAN)

        val listDino = ArrayList<Satuan>()
        if (data != null) {
            listDino.addAll(data)
        }
        return listDino
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.satuanDino.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.satuanDino.layoutManager =
                LinearLayoutManager(this)
        }

        val listSatuanAdapter = ListSatuanAdapter(dataDino)
        binding.satuanDino.adapter = listSatuanAdapter
        listSatuanAdapter.setOnItemClickCallback(object :
            ListSatuanAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Satuan) {
                showSelectedDino(data)
            }
        })
    }

    private fun showSelectedDino(dino: Satuan) {
        val intentWithData = Intent(this@SatuanActivity,
            DetailActivity::class.java)
        intentWithData.putExtra(DetailActivity.EXTRA_DINO, dino)
        startActivity(intentWithData)
    }
}
