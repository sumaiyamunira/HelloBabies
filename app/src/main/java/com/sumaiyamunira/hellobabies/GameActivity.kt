package com.sumaiyamunira.hellobabies

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.properties.Delegates

class GameActivity : AppCompatActivity() {
    private lateinit var mediaPlayerSuccess: MediaPlayer
    var resID_success by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        resID_success = resources.getIdentifier("success_sound", "raw", packageName)
        mediaPlayerSuccess = MediaPlayer.create(this, resID_success)
    }

    fun refresh(view: View) {
        startActivity(Intent(this, GameActivity::class.java))

        finish()
    }

    fun btnTicTac(view: View) {
        val btnSelected = view as ImageButton
        var cellID = 0
        when (btnSelected.id) {
            R.id.btnTicTac1 -> cellID = 1
            R.id.btnTicTac2 -> cellID = 2
            R.id.btnTicTac3 -> cellID = 3
            R.id.btnTicTac4 -> cellID = 4
            R.id.btnTicTac5 -> cellID = 5
            R.id.btnTicTac6 -> cellID = 6
            R.id.btnTicTac7 -> cellID = 7
            R.id.btnTicTac8 -> cellID = 8
            R.id.btnTicTac9 -> cellID = 9
        }
        //   Toast.makeText(this, "ID: "+cellID, Toast.LENGTH_SHORT).show()
        GameLogic(cellID, btnSelected)
    }

    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()
    var ActivePlayer = 1
    fun GameLogic(cellId: Int, btnSelected: ImageButton) {
        if (ActivePlayer == 1) {
            btnSelected.setImageResource(R.drawable.ic_cross)
            //  btnSelected.setBackgroundColor(Color.GRAY)
            Player1.add(cellId)
            ActivePlayer = 2

        } else {
            btnSelected.setImageResource(R.drawable.ic_nougth)
            //  btnSelected.setBackgroundColor(Color.blue)
            Player2.add(cellId)
            ActivePlayer = 1
        }
        btnSelected.isEnabled = false
        FindWinner()
    }

    fun FindWinner() {
        var winner = -1
        // row 1
        if (Player1.contains(1) && Player1.contains(2) && Player1.contains(3)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(2) && Player2.contains(3)) {
            winner = 2
        }
        // row 2
        if (Player1.contains(4) && Player1.contains(5) && Player1.contains(6)) {
            winner = 1
        }
        if (Player2.contains(4) && Player2.contains(5) && Player2.contains(6)) {
            winner = 2
        }
        // row 3
        if (Player1.contains(7) && Player1.contains(8) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(7) && Player2.contains(8) && Player2.contains(9)) {
            winner = 2
        }

        // col 1
        if (Player1.contains(1) && Player1.contains(4) && Player1.contains(7)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(4) && Player2.contains(7)) {
            winner = 2
        }
        // col 2
        if (Player1.contains(2) && Player1.contains(5) && Player1.contains(8)) {
            winner = 1
        }
        if (Player2.contains(2) && Player2.contains(5) && Player2.contains(8)) {
            winner = 2
        }
        // col 3
        if (Player1.contains(3) && Player1.contains(6) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(6) && Player2.contains(9)) {
            winner = 2
        }
        // Diagonal 1
        if (Player1.contains(1) && Player1.contains(5) && Player1.contains(9)) {
            winner = 1
        }
        if (Player2.contains(1) && Player2.contains(5) && Player2.contains(9)) {
            winner = 2
        }
        // Diagonal 2
        if (Player1.contains(3) && Player1.contains(5) && Player1.contains(7)) {
            winner = 1
        }
        if (Player2.contains(3) && Player2.contains(5) && Player2.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                mediaPlayerSuccess.start()
                //  Toast.makeText(this,"Player 1 is Winner\n\nWould You like to play again",Toast.LENGTH_LONG).show()
                AlertDialog.Builder(this).setTitle("X is Winner")
                    .setMessage("\nWould You like to play again dear?\n")
                    .setPositiveButton("Yes") { dialog, which ->
                        startActivity(Intent(this, GameActivity::class.java))
                        finish()
                    }.setNegativeButton("No") { dialog, which ->
                    startActivity(Intent(this, MainActivity::class.java))
                }.create().show()
            } else {
                mediaPlayerSuccess.start()
                //  Toast.makeText(this,"Player 2 is Winner",Toast.LENGTH_LONG).show()
                AlertDialog.Builder(this).setTitle("O is Winner")
                    .setMessage("\nWould You like to play again dear?\n")
                    .setPositiveButton("Yes") { dialog, which ->
                        startActivity(Intent(this, GameActivity::class.java))
                        finish()
                    }.setNegativeButton("No") { dialog, which ->
                    startActivity(Intent(this, MainActivity::class.java))
                }.create().show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the media player's resources
        mediaPlayerSuccess.release()
    }

}