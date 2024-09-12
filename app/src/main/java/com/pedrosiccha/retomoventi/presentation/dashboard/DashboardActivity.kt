package com.pedrosiccha.retomoventi.presentation.dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.pedrosiccha.retomoventi.R
import com.pedrosiccha.retomoventi.presentation.pokemonlist.PokemonListActivity
import com.pedrosiccha.retomoventi.presentation.searchpokemon.SearchPokemonActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        findViewById<Button>(R.id.btnPokemonList).setOnClickListener {
            startActivity(Intent(this, PokemonListActivity::class.java))
        }

        findViewById<Button>(R.id.btnSearchPokemon).setOnClickListener {
            startActivity(Intent(this, SearchPokemonActivity::class.java))
        }
    }

    private fun enableEdgeToEdge() {
        window.decorView.systemUiVisibility =
            window.decorView.systemUiVisibility or
                    android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}