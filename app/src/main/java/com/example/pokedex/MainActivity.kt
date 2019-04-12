package com.example.pokedex

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import com.example.pokedex.models.Pokemon
import com.example.pokedex.utilities.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var viewAdapter: PokemonAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    internal lateinit var mNamePoke: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()


    }


    fun initRecycler() {

        var pokemon: MutableList<Pokemon> = MutableList(100) { i ->
            Pokemon(i,"Name" + i, "Tyep " + i)
        }

        viewManager = LinearLayoutManager(this)

        viewAdapter = PokemonAdapter(pokemon)

        rv_pokemon_list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }

     override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }




}
