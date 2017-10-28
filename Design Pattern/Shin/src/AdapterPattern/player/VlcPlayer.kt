package AdapterPattern.player

import AdapterPattern.player.playerInterface.AdvancedMediaPlayer

/**
 * Created by Shin on 2017/10/17.
 */
class VlcPlayer:AdvancedMediaPlayer {
    override fun playVlc(fileName: String) {
        println("Play vlc File: $fileName")
    }

    override fun playMp4(fileName: String) {

    }
}