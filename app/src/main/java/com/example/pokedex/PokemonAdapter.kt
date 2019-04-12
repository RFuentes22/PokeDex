package com.example.pokedex

import android.content.Context
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.pokedex.R.id.tv_pokemon_name
import kotlinx.android.synthetic.main.list_item_pokemon.view.*
import com.example.pokedex.models.Pokemon
import com.example.pokedex.utilities.NetworkUtils
import java.io.IOException
import java.util.ArrayList
import org.json.JSONObject




class PokemonAdapter(val items: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    // TODO: Para contar elementos creados
    private var countViews: Int = 0
    private var dataset: String? = null

    internal lateinit var mResultText: TextView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_pokemon, parent, false)

        /*
         * TODO: Muestra el valor de contador de view creadas solo se hace aqui, para asegurar
         * que solo se asigne el valor aqui
         */


        view.findViewById<TextView>(R.id.count_element).text = countViews.toString()
        countViews++


        FetchPokemonTask().execute()
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Pokemon) = with(itemView) {

            tv_pokemon_name.text = item.name
            tv_pokemon_id.text = item.id.toString()

        }



    }
    private inner class FetchPokemonTask : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg params: String?): String? {


            val pokeAPI = NetworkUtils.buildUrl()

            try {


                return NetworkUtils.getResponseFromHttpUrl(pokeAPI!!)
            } catch (e: IOException) {
                e.printStackTrace()
                return ""
            }

        }


        override fun onPostExecute(pokemonInfo: String?) {


            if (pokemonInfo != null || pokemonInfo != "") {
                if (pokemonInfo != null) {
                    var arrayPoke = pokemonInfo.toCharArray()
                }


            }

        }

        }

    }



