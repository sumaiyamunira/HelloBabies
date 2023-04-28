package com.sumaiyamunira.hellobabies

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity :  AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        val resID = resources.getIdentifier("baby_music", "raw", packageName)
        var img :  ImageView
        img = findViewById(R.id.SplashScreenImage)
        val clk_rotate = AnimationUtils.loadAnimation(
            this,
            R.anim.rotate_anim
        )

        val secondAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anticlock)

        val animationListener = object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
            }

            override fun onAnimationEnd(animation: Animation) {
                img.startAnimation(secondAnimation)
            }

            override fun onAnimationRepeat(animation: Animation) {
            }
        }

        clk_rotate.setAnimationListener(animationListener)
        img.startAnimation(clk_rotate)

        mediaPlayer = MediaPlayer.create(this, resID)
        mediaPlayer.start()

        Handler(Looper.getMainLooper()).postDelayed({
            mediaPlayer.stop()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // 3000 is the delayed time in milliseconds.
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the media player's resources
        mediaPlayer.release()
    }
}