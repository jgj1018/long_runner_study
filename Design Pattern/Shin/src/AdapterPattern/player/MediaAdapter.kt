package AdapterPattern.player

import AdapterPattern.player.playerInterface.AdvancedMediaPlayer
import AdapterPattern.player.playerInterface.MediaPlayer

/**
 * Created by Shin on 2017/10/17.
 */
class MediaAdapter(audioType: String):MediaPlayer {

    private val advancedMediaPlayer:AdvancedMediaPlayer = when (audioType) {
        "vlc" -> VlcPlayer();
        "mp4" -> Mp4Player();
        else -> throw IllegalArgumentException("audioType $audioType is not supported")
    }

    override fun play(audioType: String, fileName: String) {
        when (audioType) {
            "vlc" -> advancedMediaPlayer.playVlc(fileName)
            "mp4" -> advancedMediaPlayer.playMp4(fileName)
            else -> throw IllegalArgumentException("audioType $audioType is not supported")
        }
    }
}