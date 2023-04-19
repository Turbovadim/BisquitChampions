package net.turbovadim.bisquitchampions.screens.recorder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import java.io.File

@Composable
fun RecorderUI() {

    val context = LocalContext.current

    val recorder by lazy {
        AndroidAudioRecorder(context)
    }

    var audioFile: File? = null

    val player by lazy {
        AndroidAudioPlayer(context)
    }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    File(context.cacheDir, "audio.mp3").also {
                        recorder.start(it)
                        audioFile = it
                    }
                }
            ) {
                Text(text = "Start")
            }
            Button(
                onClick = {
                    recorder.stop()
                }
            ) {
                Text(text = "Stop")
            }
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    player.playFile(audioFile ?: return@Button)
                    val sex = audioFile!!.readBytes()
                }
            ) {
                Text(text = "Play")
            }
            Button(
                onClick = {
                    player.stop()
                }
            ) {
                Text(text = "Stop")
            }
        }
    }
}