package AdapterPattern.player.playerInterface

import AdapterPattern.player.MediaAdapter

/**
 * Created by Shin on 2017/10/17.
 */
class AudioPlayer:MediaPlayer {
    override fun play(audioType: String, fileName: String) {
        when (audioType) {
            "mp3" -> println("Playing mp3 file: $fileName")
            "vlc" , "mp4" -> MediaAdapter(audioType).play(audioType, fileName)
            else -> println("audioType $audioType is not supported")
        }
    }
}