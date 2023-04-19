package net.turbovadim.bisquitchampions.screens.recorder

import java.io.File

interface AudioPlayer {
    fun playFile(file: File) {

    }
    fun stop() {

    }
}