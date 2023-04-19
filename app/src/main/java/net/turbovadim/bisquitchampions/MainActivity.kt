package net.turbovadim.bisquitchampions

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Abc
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.SettingsEthernet
import androidx.compose.material.icons.rounded.Abc
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material.icons.rounded.SettingsEthernet
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.turbovadim.bisquitchampions.navigation.Navigation
import net.turbovadim.bisquitchampions.navigation.ScreensList
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            0
        )
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomBar(navController) }
            ) {
                Box(
                    Modifier.padding(it)
                ) {
                    Navigation(navController)
                }
            }
        }
    }
}

data class BottomNavItem(
    val icon: ImageVector,
    val selectedIcon: ImageVector,
    val route: String,
)

val BottomNavItems = listOf(
    BottomNavItem(
        icon = Icons.Outlined.Abc,
        selectedIcon = Icons.Rounded.Abc,
        route = ScreensList.Sorting.route
    ),
    BottomNavItem(
        icon = Icons.Outlined.Mic,
        selectedIcon = Icons.Rounded.Mic,
        route = ScreensList.Recorder.route
    ),
    BottomNavItem(
        icon = Icons.Outlined.SettingsEthernet,
        selectedIcon = Icons.Rounded.SettingsEthernet,
        route = ScreensList.ApiTrash.route
    ),
)

@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(
        modifier = Modifier.height(55.dp),
    ) {
        BottomNavItems.forEach { navItem ->
            val isSelected = currentRoute == navItem.route
            val icon = if (isSelected) {navItem.selectedIcon} else {navItem.icon}
            NavigationBarItem(
                modifier = Modifier
                    .height(55.dp),
                selected = isSelected,
                onClick = {
                    if (currentRoute != navItem.route) {
                        navController.navigate(navItem.route)
                    }
                },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = "",
                    )
                },
            )
        }

    }
}

fun sfsdfs() {
    val url = URL("sdfdfs")
    val connection = url.openConnection()

    connection.setRequestProperty("", "")
    connection.setRequestProperty("", "")
    connection.connect()

    val inputStream = connection.getInputStream()
    val result = String(inputStream.readBytes())
}