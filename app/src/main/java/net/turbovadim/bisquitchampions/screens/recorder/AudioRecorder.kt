package net.turbovadim.bisquitchampions.screens.recorder

import java.io.File

interface AudioRecorder {
    fun start(outputFile: File) {

    }

    fun stop() {

    }
}