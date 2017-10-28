package AdapterPattern.player

import AdapterPattern.player.playerInterface.AdvancedMediaPlayer

/**
 * Created by Shin on 2017/10/17.
 */
class Mp4Player:AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {

    }

    override fun playMp4(fileName: String) {
        println("Play mp4 File: $fileName")
    }
}