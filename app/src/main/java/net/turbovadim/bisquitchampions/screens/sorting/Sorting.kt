package net.turbovadim.bisquitchampions.screens.sorting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class Tags(val string: String) {
    KOTLIN("Kotlin"),
    SWIFT("Swift"),
    EASY("Easy"),
    MEDIUM("Medium"),
    HARD("Hard"),
}

data class Item(
    val name: String,
    val desc: String,
    val tags: List<Tags>
)

val tagsList = listOf(
    Tags.SWIFT,
    Tags.HARD,
    Tags.MEDIUM,
    Tags.EASY,
    Tags.KOTLIN
)

val items = listOf(
    Item(
        name = "Easy kotlin",
        desc = "Easy kotlin",
        tags = listOf(Tags.KOTLIN, Tags.EASY)
    ),
    Item(
        name = "Medium kotlin",
        desc = "Medium kotlin",
        tags = listOf(Tags.KOTLIN, Tags.MEDIUM)
    ),
    Item(
        name = "Hard kotlin",
        desc = "Hard kotlin",
        tags = listOf(Tags.KOTLIN, Tags.HARD)
    ),
    Item(
        name = "Easy Swift",
        desc = "Easy Swift",
        tags = listOf(Tags.SWIFT, Tags.EASY)
    ),
    Item(
        name = "Medium Swift",
        desc = "Medium Swift",
        tags = listOf(Tags.SWIFT, Tags.MEDIUM)
    ),
    Item(
        name = "Hard Swift",
        desc = "Hard Swift",
        tags = listOf(Tags.SWIFT, Tags.HARD)
    ),
)

@Composable
fun SortingScreen() {

    val selectedTags = remember { mutableStateListOf<Tags>() }

    Column {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxWidth().background(Color.Gray).padding(vertical = 5.dp),
            contentPadding = PaddingValues(horizontal = 5.dp)
        ) {
            items(tagsList) { tag ->
                Button(
                    onClick = {
                        if (selectedTags.contains(tag)) {
                            selectedTags.remove(tag)
                        } else {
                            selectedTags.add(tag)
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!selectedTags.contains(tag)) {Color(0xFFF5B514) } else {Color(0xFF966F0E) }
                    )

                ) {
                    Text(text = tag.string, color = Color.Black)
                }
            }
        }

        val filteredItems = remember { derivedStateOf { if (selectedTags.isNotEmpty()) {
                    items.filter { it.tags.containsAll(selectedTags)}
                } else {
                    items
                }
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(vertical = 5.dp)
        ) {
            items(filteredItems.value ) { item ->
                Card(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = item.name,
                            modifier = Modifier.padding(top = 5.dp)
                        )
                        Text(
                            text = item.desc,
                            modifier = Modifier.padding(vertical = 5.dp))
                        Column(
                            verticalArrangement = Arrangement.spacedBy(3.dp)
                        ) {
                            item.tags.forEach { tag ->
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color.Cyan)
                                        .width(120.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        modifier = Modifier.padding(4.dp),
                                        text = tag.string,
                                        fontWeight = FontWeight.W500,
                                        fontSize = 15.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}