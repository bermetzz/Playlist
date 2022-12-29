package com.example.playlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.playlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = arrayListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        val adapter = SongAdapter(list, this::onClick)
        binding.recyclerView.adapter = adapter

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.fragment_first, FirstFragment()).commit()
            supportFragmentManager.beginTransaction().add(R.id.fragment_second, SecondFragment()).commit()
        }

    }

    private fun onClick(position: Int){
        val intent = Intent(this, SecondActivity::class.java)
        val name = list[position].name
        intent.putExtra("name", name)
        startActivity(intent)
    }

    private fun loadData() {
        list.add(Song(1, "Blank Space", "Taylor Swift", "3:22"))
        list.add(Song(2, "Promiscuous", "Nelly Furtado", "4:01"))
        list.add(Song(3, "Happy Xmas", "John Lennon", "3:33"))
        list.add(Song(4, "Off To The Races", "Lana Del Rey", "4:58"))
        list.add(Song(5, "Love On The Brain", "Rihanna", "3:42"))
        list.add(Song(6, "Maneater", "Nelly Furtado", "4:17"))
        list.add(Song(7, "Bound 2", "Kanye West", "3:47"))
        list.add(Song(8, "Wildest Dreams", "Taylor Swift", "3:40"))
        list.add(Song(9, "Ein Traum wird wahr", "Arne Stephan", "2:54"))
        list.add(Song(10, "Maestro", "Hans Zimmer", "3:52"))
    }
}