package com.sumaiyamunira.hellobabies

import android.os.Bundle


import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class VideoPlayerActivity : AppCompatActivity() {

    // on the below line we are creating a variable
    // for our youtube player view.
    lateinit var youtubePlayerView1: YouTubePlayerView
    lateinit var youtubePlayerView2: YouTubePlayerView
    lateinit var youtubePlayerView3: YouTubePlayerView
    lateinit var youtubePlayerView4: YouTubePlayerView

    // on below line we are creating a
    // string variable for our video id.
    var videoID1 = "7D4K9oi7oBM"
    var videoID2 = "aPM3h9UV2S0"
    var videoID3 = "Ew8db0pBVCc"
    var videoID4 = "_1LqnXzp0GY"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // on below line we are setting
        // screen orientation to landscape
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // on below line we are setting flags to
        // change our activity to full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_video_player)

        // on below line we are hiding our action bar
        actionBar?.hide()

        // on below line we are initializing
        // our youtube player view with its id.
        youtubePlayerView1 = findViewById(R.id.youTubePlayerView1)
        doPlayerViewWork(youtubePlayerView1, videoID1)

        youtubePlayerView2 = findViewById(R.id.youTubePlayerView2)
        doPlayerViewWork(youtubePlayerView2, videoID2)

        youtubePlayerView3 = findViewById(R.id.youTubePlayerView3)
        doPlayerViewWork(youtubePlayerView3, videoID3)

        youtubePlayerView4 = findViewById(R.id.youTubePlayerView4)
        doPlayerViewWork(youtubePlayerView4, videoID4)

    }

    private fun doPlayerViewWork(youtubePlayerView: YouTubePlayerView?, videoID: String) {

        // on below line we are setting full
        // screen for our youtube player view.
        if (youtubePlayerView != null) {
            youtubePlayerView.enterFullScreen()

            youtubePlayerView.toggleFullScreen()

            // on below line we are getting observer
            // for our youtube player view.
            lifecycle.addObserver(youtubePlayerView)

            // on below line we are getting
            // youtube player controller ui.
            youtubePlayerView.getPlayerUiController()

            // on below line we are
            // entering it to full screen.
            youtubePlayerView.enterFullScreen()
            youtubePlayerView.toggleFullScreen()

            // on below line we are adding listener
            // for our youtube player view.
            youtubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    // loading the selected video
                    // into the YouTube Player
                    youTubePlayer.loadVideo(videoID, 0f)
                }

                override fun onStateChange(
                    youTubePlayer: YouTubePlayer,
                    state: PlayerConstants.PlayerState
                ) {
                    // this method is called if video has ended,
                    super.onStateChange(youTubePlayer, state)
                }
            })
        }

    }
}
