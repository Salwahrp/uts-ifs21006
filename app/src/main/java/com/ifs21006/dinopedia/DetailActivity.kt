package com.ifs21006.dinopedia

import android.R
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ifs21006.dinopedia.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var dino: Dino? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dino = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DINO,
                Dino::class.java)
        }
        else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DINO)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (dino != null) {
            supportActionBar?.title = "Makanan ${dino!!.name}"
            loadData(dino!!)
        }
        else {
            finish()
        }
    }
    private fun loadData(dino: Dino)
    {
        binding .iPhotoDino.setImageResource(dino.photo)
        binding .tNamaDino.setText(dino.name)
        binding .tFamilyDino.setText(dino.family)
        binding .tDeskripsi.setText(dino.deskripsi)
        binding .tPeriodeDino.setText(dino.periode)
        binding .tKarakteristikDino.setText(dino.karakteristik)
        binding .tHabitatDino.setText(dino.habitat)
        binding .tPerilakuDino.setText(dino.perilaku)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
    companion object {
        const val EXTRA_DINO = "extra_dino"
    }
}