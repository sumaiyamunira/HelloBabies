package com.sumaiyamunira.hellobabies

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.sumaiyamunira.hellobabies.adapter.AlphabetListAdapter

class AlphabetLearningActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private val handler = Handler()
    private var canClick: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_learning)

        val items = listOf(
            AlphabetDTO("A", R.drawable.letter_a, 0),
            AlphabetDTO("B", R.drawable.letter_b, 1000),
            AlphabetDTO("C", R.drawable.letter_c, 2500),
            AlphabetDTO("D", R.drawable.letter_d, 3000),
            AlphabetDTO("E", R.drawable.letter_e, 4500),
            AlphabetDTO("F", R.drawable.letter_f, 7000),
            AlphabetDTO("G", R.drawable.letter_g, 8000),
            AlphabetDTO("H", R.drawable.letter_h, 9500),
            AlphabetDTO("I", R.drawable.letter_i, 11000),
            AlphabetDTO("J", R.drawable.letter_j, 12000),
            AlphabetDTO("K", R.drawable.letter_k, 13000),
            AlphabetDTO("L", R.drawable.letter_l, 14000),
            AlphabetDTO("M", R.drawable.letter_m, 15000),
            AlphabetDTO("N", R.drawable.letter_n, 17000),
            AlphabetDTO("O", R.drawable.letter_o, 18000),
            AlphabetDTO("P", R.drawable.letter_p, 19000),
            AlphabetDTO("Q", R.drawable.letter_q, 20500),
            AlphabetDTO("R", R.drawable.letter_r, 22000),
            AlphabetDTO("S", R.drawable.letter_s, 23000),
            AlphabetDTO("T", R.drawable.letter_t, 24000),
            AlphabetDTO("U", R.drawable.letter_u, 25500),
            AlphabetDTO("V", R.drawable.letter_v, 26500),
            AlphabetDTO("W", R.drawable.letter_w, 28000),
            AlphabetDTO("X", R.drawable.letter_x, 29000),
            AlphabetDTO("Y", R.drawable.letter_y, 30500),
            AlphabetDTO("Z", R.drawable.letter_z, 32000),
        )

        val gridView = findViewById<GridView>(R.id.gridView)
        gridView.adapter = AlphabetListAdapter(this, items)

// Set the data source and prepare the MediaPlayer
        val resId = R.raw.abc_alphabet
        val uri = Uri.parse("android.resource://$packageName/$resId")
        mediaPlayer = MediaPlayer()
        mediaPlayer.setDataSource(this, uri)
        mediaPlayer.prepare()



        gridView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            } else {
                val item = items[position]
                val seekposition = item.audioResource
                //    Toast.makeText(this, "seek position on " + seekposition, Toast.LENGTH_SHORT).show()
                mediaPlayer.seekTo(seekposition)
                mediaPlayer.start()
                gridView.postDelayed({ mediaPlayer.pause() }, 1000)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the media player's resources
        mediaPlayer.release()
    }
}