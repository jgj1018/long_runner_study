package AdapterPattern

import AdapterPattern.player.playerInterface.AudioPlayer

/**
 * Created by Shin on 2017/10/17.
 */
fun main(args: Array<String>) {
    val audioPlayer = AudioPlayer()

    audioPlayer.play("mp3", "beyond the horizon.mp3")
    audioPlayer.play("mp4", "alone.mp4")
    audioPlayer.play("vlc", "far far away.vlc")
    audioPlayer.play("avi", "mind me.avi")
}