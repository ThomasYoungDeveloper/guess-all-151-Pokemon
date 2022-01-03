package com.thomasyoung.guess151pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pokemonCaughtList = mutableSetOf<String>()
        val pokemonList = listOf(
            "bulbasaur",
            "ivysaur",
            "venusaur",
            "charmander",
            "charmeleon",
            "charizard",
            "squirtle",
            "wartortle",
            "blastoise",
            "caterpie",
            "metapod",
            "butterfree",
            "weedle",
            "kakuna",
            "beedrill",
            "pidgey",
            "pidgeotto",
            "pidgeot",
            "rattata",
            "raticate",
            "spearow",
            "fearow",
            "ekans",
            "arbok",
            "pikachu",
            "raichu",
            "sandshrew",
            "sandslash",
            "nidoran",
            "nidorina",
            "nidoqueen",
            "nidorino",
            "nidoking",
            "clefairy",
            "clefable",
            "vulpix",
            "ninetales",
            "jigglypuff",
            "wigglytuff",
            "zubat",
            "golbat",
            "oddish",
            "gloom",
            "vileplume",
            "paras",
            "parasect",
            "venonat",
            "venomoth",
            "diglett",
            "dugtrio",
            "meowth",
            "persian",
            "psyduck",
            "golduck",
            "mankey",
            "primeape",
            "growlithe",
            "arcanine",
            "poliwag",
            "poliwhirl",
            "poliwrath",
            "abra",
            "kadabra",
            "alakazam",
            "machop",
            "machoke",
            "machamp",
            "bellsprout",
            "weepinbell",
            "victreebel",
            "tentacool",
            "tentacruel",
            "geodude",
            "graveler",
            "golem",
            "ponyta",
            "rapidash",
            "slowpoke",
            "slowbro",
            "magnemite",
            "magneton",
            "farfetch’d",
            "doduo",
            "dodrio",
            "seel",
            "dewgong",
            "grimer",
            "muk",
            "shellder",
            "cloyster",
            "gastly",
            "haunter",
            "gengar",
            "onix",
            "drowzee",
            "hypno",
            "krabby",
            "kingler",
            "voltorb",
            "electrode",
            "exeggcute",
            "exeggutor",
            "cubone",
            "marowak",
            "hitmonlee",
            "hitmonchan",
            "lickitung",
            "koffing",
            "weezing",
            "rhyhorn",
            "rhydon",
            "chansey",
            "tangela",
            "kangaskhan",
            "horsea",
            "seadra",
            "goldeen",
            "seaking",
            "staryu",
            "starmie",
            "mr. mime",
            "scyther",
            "jynx",
            "electabuzz",
            "magmar",
            "pinsir",
            "tauros",
            "magikarp",
            "gyarados",
            "lapras",
            "ditto",
            "eevee",
            "vaporeon",
            "jolteon",
            "flareon",
            "porygon",
            "omanyte",
            "omastar",
            "kabuto",
            "kabutops",
            "aerodactyl",
            "snorlax",
            "articuno",
            "zapdos",
            "moltres",
            "dratini",
            "dragonair",
            "dragonite",
            "mewtwo",
            "mew"
        )
        var count: Int = 0
        var pokemonInputName: EditText = findViewById(R.id.pokemonInputName)
        var catchPokemon: Button = findViewById(R.id.catchPokemon)
        var pokemonCaught: TextView = findViewById(R.id.pokemonCaught)
        var pokemonCaughtListTV: TextView = findViewById(R.id.pokemonCaughtList)
        var pokemonCount: TextView = findViewById(R.id.pokemonCount)
        var response: String
        var countDownTimer: TextView = findViewById(R.id.countdownTimer)
        var pokemonCaughtTitle: TextView = findViewById(R.id.pokemonCaughtTitle)
        var totalPokemonCaught = pokemonCaughtList.size


        object : CountDownTimer(900000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                countDownTimer.setText("${millisUntilFinished / 60000} Minutes Remaining")
            }

            override fun onFinish() {
                countDownTimer.setText("done!")
                pokemonCaughtTitle.text = totalPokemonCaught.toString()
            }
        }.start()


        fun checkIfPokemonExist() {
            response = pokemonInputName.text.toString()

            when {
                pokemonCaughtList.contains(response.lowercase()) -> {
                    pokemonCaught.text = "You've already caught $response"
                }
                pokemonList.contains(response.lowercase()) -> {
                    count++
                    pokemonCaughtList.add(response.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    })
                    pokemonCaught.text = "You've caught $response"
                    pokemonCount.text = "$count/150 Pokemon Caught "
                    pokemonCaughtListTV.text = pokemonCaughtList.toString()

                }
                else -> {
                    pokemonCaught.text = "$response does not exist"
                }
            }
        }


        catchPokemon.setOnClickListener {
            checkIfPokemonExist()
        }

    }
}