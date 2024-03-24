package com.ifs21006.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
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
        val dataName = resources.getStringArray(R.array.dino_name)
        val dataIcon = resources.obtainTypedArray(R.array.family_dino_photo)
        val dataDeskripsi = resources.getStringArray(R.array.dino_deskripsi)

        val listDino = ArrayList<Dino>()

        for (i in dataName.indices) {
            val dino = Dino(dataIcon.getResourceId(i, -1), dataName[i], dataDeskripsi[i])
            listDino.add(dino)
        }
        return listDino
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvDino.layoutManager = GridLayoutManager(this, 2)
        }
        else {
            binding.rvDino.layoutManager = LinearLayoutManager(this)
        }

        val listDinoAdapter = ListDinoAdapter(dataDino)
        binding.rvDino.adapter = listDinoAdapter
        listDinoAdapter.setOnItemClickCallback(object :
            ListDinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {

                showDeskripActivity(data)
                showSelectedDino(data)
            }
        })
    }

    private fun showSelectedDino(dino: Dino) {
        val listDino = ArrayList<Satuan>()
        val intentWithData = Intent(this@MainActivity,
            SatuanActivity::class.java)

        when (dino.name) {
            "Theropoda" -> {
                val jenisName =
                    resources.getStringArray(R.array.jenis1_dino_name)
                val jenisImg =
                    resources.obtainTypedArray(R.array.jenis1_dino_photo)
                val jenisFamily =
                    resources.getStringArray(R.array.jenis1_dino_family)
                val jenisKarakteristik =
                    resources.getStringArray(R.array.jenis1_dino_karakteristik)
                val jenisPeriode =
                    resources.getStringArray(R.array.jenis1_dino_periode)
                val jenisDeskripsi =
                    resources.getStringArray(R.array.jenis1_dino_deskripsi)
                val jenisHabitat =
                    resources.getStringArray(R.array.jenis1_dino_habitat)
                val jenisPerilaku =
                    resources.getStringArray(R.array.jenis1_dino_perilaku)

                for (i in jenisName.indices) {
                    val list = Satuan(
                        jenisName[i], jenisImg.getResourceId(i, -1),
                        jenisFamily[i], jenisKarakteristik[i], jenisPeriode[i], jenisDeskripsi[i],  jenisHabitat[i], jenisPerilaku[i])
                    listDino.add(list)
                }
            }

            "Sauropoda" -> {
                val jenisName =
                    resources.getStringArray(R.array.jenis2_dino_name)
                val jenisImg =
                    resources.obtainTypedArray(R.array.jenis2_dino_photo)
                val jenisFamily =
                    resources.getStringArray(R.array.jenis2_dino_family)
                val jenisKarakteristik =
                    resources.getStringArray(R.array.jenis2_dino_karakteristik)
                val jenisPeriode =
                    resources.getStringArray(R.array.jenis2_dino_periode)
                val jenisDeskripsi =
                    resources.getStringArray(R.array.jenis2_dino_deskripsi)
                val jenisHabitat =
                    resources.getStringArray(R.array.jenis2_dino_habitat)
                val jenisPerilaku =
                    resources.getStringArray(R.array.jenis2_dino_perilaku)

                for (i in jenisName.indices) {
                    val list = Satuan(
                        jenisName[i], jenisImg.getResourceId(i, -1),
                        jenisFamily[i], jenisKarakteristik[i], jenisPeriode[i], jenisDeskripsi[i],  jenisHabitat[i], jenisPerilaku[i])
                    listDino.add(list)
                }
            }

            "Ornithopoda" -> {
                val jenisName =
                    resources.getStringArray(R.array.jenis3_dino_name)
                val jenisImg =
                    resources.obtainTypedArray(R.array.jenis3_dino_photo)
                val jenisFamily =
                    resources.getStringArray(R.array.jenis3_dino_family)
                val jenisKarakteristik =
                    resources.getStringArray(R.array.jenis3_dino_karakteristik)
                val jenisPeriode =
                    resources.getStringArray(R.array.jenis3_dino_periode)
                val jenisDeskripsi =
                    resources.getStringArray(R.array.jenis3_dino_deskripsi)
                val jenisHabitat =
                    resources.getStringArray(R.array.jenis3_dino_habitat)
                val jenisPerilaku =
                    resources.getStringArray(R.array.jenis3_dino_perilaku)

                for (i in jenisName.indices) {
                    val list = Satuan(
                        jenisName[i], jenisImg.getResourceId(i, -1),
                        jenisFamily[i], jenisKarakteristik[i], jenisPeriode[i], jenisDeskripsi[i],  jenisHabitat[i], jenisPerilaku[i])
                    listDino.add(list)
                }
            }

            "Stegosauria" -> {
                val jenisName =
                    resources.getStringArray(R.array.jenis4_dino_name)
                val jenisImg =
                    resources.obtainTypedArray(R.array.jenis4_dino_photo)
                val jenisFamily =
                    resources.getStringArray(R.array.jenis4_dino_family)
                val jenisKarakteristik =
                    resources.getStringArray(R.array.jenis4_dino_karakteristik)
                val jenisPeriode =
                    resources.getStringArray(R.array.jenis4_dino_periode)
                val jenisDeskripsi =
                    resources.getStringArray(R.array.jenis4_dino_deskripsi)
                val jenisHabitat =
                    resources.getStringArray(R.array.jenis4_dino_habitat)
                val jenisPerilaku =
                    resources.getStringArray(R.array.jenis4_dino_perilaku)

                for (i in jenisName.indices) {
                    val list = Satuan(
                        jenisName[i], jenisImg.getResourceId(i, -1),
                        jenisFamily[i], jenisKarakteristik[i], jenisPeriode[i], jenisDeskripsi[i],  jenisHabitat[i], jenisPerilaku[i])
                    listDino.add(list)
                }
            }

            "Ankylosauria" -> {
                val jenisName =
                    resources.getStringArray(R.array.jenis5_dino_name)
                val jenisImg =
                    resources.obtainTypedArray(R.array.jenis5_dino_photo)
                val jenisFamily =
                    resources.getStringArray(R.array.jenis5_dino_family)
                val jenisKarakteristik =
                    resources.getStringArray(R.array.jenis5_dino_karakteristik)
                val jenisPeriode =
                    resources.getStringArray(R.array.jenis5_dino_periode)
                val jenisDeskripsi =
                    resources.getStringArray(R.array.jenis5_dino_deskripsi)
                val jenisHabitat =
                    resources.getStringArray(R.array.jenis5_dino_habitat)
                val jenisPerilaku =
                    resources.getStringArray(R.array.jenis5_dino_perilaku)

                for (i in jenisName.indices) {
                    val list = Satuan(
                        jenisName[i], jenisImg.getResourceId(i, -1),
                        jenisFamily[i], jenisKarakteristik[i], jenisPeriode[i], jenisDeskripsi[i],  jenisHabitat[i], jenisPerilaku[i])
                    listDino.add(list)
                }
            }

            "Ceratopsia" -> {
                val jenisName =
                    resources.getStringArray(R.array.jenis6_dino_name)
                val jenisImg =
                    resources.obtainTypedArray(R.array.jenis6_dino_photo)
                val jenisFamily =
                    resources.getStringArray(R.array.jenis6_dino_family)
                val jenisKarakteristik =
                    resources.getStringArray(R.array.jenis6_dino_karakteristik)
                val jenisPeriode =
                    resources.getStringArray(R.array.jenis6_dino_periode)
                val jenisDeskripsi =
                    resources.getStringArray(R.array.jenis6_dino_deskripsi)
                val jenisHabitat =
                    resources.getStringArray(R.array.jenis6_dino_habitat)
                val jenisPerilaku =
                    resources.getStringArray(R.array.jenis6_dino_perilaku)

                for (i in jenisName.indices) {
                    val list = Satuan(
                        jenisName[i], jenisImg.getResourceId(i, -1),
                        jenisFamily[i], jenisKarakteristik[i], jenisPeriode[i], jenisDeskripsi[i],  jenisHabitat[i], jenisPerilaku[i])
                    listDino.add(list)
                }
            }

            "Hadrosauridae" -> {
                val jenisName =
                    resources.getStringArray(R.array.jenis7_dino_name)
                val jenisImg =
                    resources.obtainTypedArray(R.array.jenis7_dino_photo)
                val jenisFamily =
                    resources.getStringArray(R.array.jenis7_dino_family)
                val jenisKarakteristik =
                    resources.getStringArray(R.array.jenis7_dino_karakteristik)
                val jenisPeriode =
                    resources.getStringArray(R.array.jenis7_dino_periode)
                val jenisDeskripsi =
                    resources.getStringArray(R.array.jenis7_dino_deskripsi)
                val jenisHabitat =
                    resources.getStringArray(R.array.jenis7_dino_habitat)
                val jenisPerilaku =
                    resources.getStringArray(R.array.jenis7_dino_perilaku)

                for (i in jenisName.indices) {
                    val list = Satuan(
                        jenisName[i], jenisImg.getResourceId(i, -1),
                        jenisFamily[i], jenisKarakteristik[i], jenisPeriode[i], jenisDeskripsi[i],  jenisHabitat[i], jenisPerilaku[i])
                    listDino.add(list)
                }
            }

            "Therizinosauria" -> {
                val jenisName =
                    resources.getStringArray(R.array.jenis8_dino_name)
                val jenisImg =
                    resources.obtainTypedArray(R.array.jenis8_dino_photo)
                val jenisFamily =
                    resources.getStringArray(R.array.jenis8_dino_family)
                val jenisKarakteristik =
                    resources.getStringArray(R.array.jenis8_dino_karakteristik)
                val jenisPeriode =
                    resources.getStringArray(R.array.jenis8_dino_periode)
                val jenisDeskripsi =
                    resources.getStringArray(R.array.jenis8_dino_deskripsi)
                val jenisHabitat =
                    resources.getStringArray(R.array.jenis8_dino_habitat)
                val jenisPerilaku =
                    resources.getStringArray(R.array.jenis8_dino_perilaku)

                for (i in jenisName.indices) {
                    val list = Satuan(
                        jenisName[i], jenisImg.getResourceId(i, -1),
                        jenisFamily[i], jenisKarakteristik[i], jenisPeriode[i], jenisDeskripsi[i],  jenisHabitat[i], jenisPerilaku[i])
                    listDino.add(list)
                }
            }
        }
        intentWithData.putExtra(SatuanActivity.EXTRA_SATUAN, listDino)
        startActivity(intentWithData)
    }

    private fun showDeskripActivity(dino: Dino) {
        val intent = Intent(this, DeskripActivity::class.java)
        // Anda mungkin ingin mem-pass data tertentu ke DeskripActivity menggunakan Intent.putExtra() jika diperlukan
        startActivity(intent)
    }
}