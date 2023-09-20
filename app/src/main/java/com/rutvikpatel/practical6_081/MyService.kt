import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.rutvikpatel.practical6_081.R

class MyService : Service() {
    lateinit var mediaPlayer: MediaPlayer

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!this::mediaPlayer.isInitialized)
            mediaPlayer = MediaPlayer.create(this, R.raw.natunatu)

        if (intent != null) {
            val str1: String? = intent.getStringExtra("Service1")
            if (str1 == "PlayButton") {
                if (!mediaPlayer.isPlaying) {
                    mediaPlayer.start()
                    Log.d("MyService", "Audio started")
                } else {
                    mediaPlayer.pause()
                    Log.d("MyService", "Audio paused")
                }
            }
        } else {
            mediaPlayer.stop()
            Log.d("MyService", "Audio stopped")
        }

        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
        Log.d("MyService", "Service destroyed")
        super.onDestroy()
    }
}