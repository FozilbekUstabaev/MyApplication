package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var pubg: Game
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClick();
        initTosts();
        initIntent();
    }

    private fun initTosts() {
        binding.btnFrownIc.setOnClickListener {
            if (pubg == Game.FROWN) {
                Toast.makeText(applicationContext, "Правильно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Не верно", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnWornIc.setOnClickListener {
            if (pubg == Game.WORN) {
                Toast.makeText(applicationContext, "Правильно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Не верно", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnPoseidonIc.setOnClickListener {
            if (pubg == Game.POSEIDON) {
                Toast.makeText(applicationContext, "Правильно!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Не верно", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initClick() {
        binding.btnFrown.setOnClickListener {
            binding.imgGame.setImageResource(R.drawable.frown)
            pubg = Game.FROWN

        }

        binding.btnWorn.setOnClickListener {
            binding.imgGame.setImageResource(R.drawable.worn)
            pubg = Game.WORN
        }

        binding.btnPoseidon.setOnClickListener {
            binding.imgGame.setImageResource(R.drawable.poseidon)
            pubg = Game.POSEIDON
        }
    }

    private fun initIntent() {
        binding.btnSave.setOnClickListener {
            val intent = Intent(this@MainActivity, GameActivity::class.java)
            when(pubg){
                Game.FROWN -> name = "Frown"
                Game.WORN -> name = "Worn"
                Game.POSEIDON -> name = "Poseidon"
            }
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }
}