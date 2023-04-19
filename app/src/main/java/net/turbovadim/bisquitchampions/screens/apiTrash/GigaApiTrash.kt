package net.turbovadim.bisquitchampions.screens.apiTrash

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.OutputStreamWriter
import java.net.URL

@Composable
fun ApiTrash() {

    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { getListoboba() }) {
                Text(text = "Get From Remote")
            }
            Button(onClick = { postToRemote() }) {
                Text(text = "Post To Remote")
            }
        }

    }
}

fun getFromRemote() {
    CoroutineScope(Dispatchers.IO).launch {
        val url = URL("https://jsonplaceholder.typicode.com/posts")
        val connection = url.openConnection()

        connection.connect()

        val inputStream = connection.getInputStream()
        val content = String(inputStream.readBytes())

        Log.d("mylogger", content)
    }
}

fun getEntries() {
    CoroutineScope(Dispatchers.IO).launch {
        val url = URL("https://api.publicapis.org/")
        val connection = url.openConnection()

        connection.setRequestProperty("Content-Type", "application/json")
        connection.connect()

        val inputStream = connection.getInputStream()
        val content = String(inputStream.readBytes())
    }
}

fun postToRemote() {
    CoroutineScope(Dispatchers.Default).launch {
        withContext(Dispatchers.IO) {
            val url = URL("https://jsonplaceholder.typicode.com/posts")
            val connection = url.openConnection()
            connection.doOutput = true
            connection.setRequestProperty("Content-Type", "application/json")

            val postData = """
                {
                    "title":"I'm Aboba",
                    "body": "FattyMan",
                    "userId": 1
                }
            """.trimIndent()
            val wr = OutputStreamWriter(connection.getOutputStream())
            wr.write(postData)
            wr.flush()

            val inputStream = connection.getInputStream()
            val content = String(inputStream.readBytes())

            Log.d("mylogger", content)
        }
    }
}









































fun getListoboba() {
    CoroutineScope(Dispatchers.Default).launch {
        val url = URL("https://api.publicapis.org/")
        val connection = url.openConnection()

        connection.setRequestProperty("Content-Type", "application/json")
        connection.setRequestProperty("Accept", "application/json")
        connection.connect()

        val inputStream = connection.getInputStream()
        val content = String(inputStream.readBytes())

        Log.d("mylogger", content)
    }
}

