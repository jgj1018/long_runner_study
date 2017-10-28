package AdapterByDelegation

/**
 * Created by Shin on 2017/10/23.
 */
interface MediaPlayer {
    fun play():String
}

class AudioPlayerImpl(val fileType:String):MediaPlayer {
    override fun play() = fileType
}

class VideoPlayerImpl(val fileType:String):MediaPlayer {
    override fun play() = fileType
}

class AudioOrVideo(val mediaType:String ,impl:MediaPlayer): MediaPlayer by impl {
    fun howToPlay() {
        println("${mediaType}: ${play()}")
    }
}

fun main(args: Array<String>) {
    val playAudio = AudioOrVideo("Audio", AudioPlayerImpl("mp3"))
    val playVideo = AudioOrVideo("Video", VideoPlayerImpl("mp4"))
    playAudio.howToPlay()
    playVideo.howToPlay()
}

