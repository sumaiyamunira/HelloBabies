package com.sumaiyamunira.hellobabies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val abc_card: CardView
        abc_card = findViewById(R.id.abc_card)
        abc_card.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AlphabetLearningActivity::class.java)
            startActivity(intent)
        })

        val math_card: CardView
        math_card = findViewById(R.id.math_card)
        math_card.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, EasyMathActivity::class.java)
            startActivity(intent)
        })

        val game_card: CardView
        game_card = findViewById(R.id.game_card)
        game_card.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        })

        val music_card: CardView
        music_card = findViewById(R.id.music_card)
        music_card.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            startActivity(intent)
        })


    }
}