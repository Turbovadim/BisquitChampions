package net.turbovadim.bisquitchampions.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import net.turbovadim.bisquitchampions.screens.apiTrash.ApiTrash
import net.turbovadim.bisquitchampions.screens.recorder.RecorderUI
import net.turbovadim.bisquitchampions.screens.sorting.SortingScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreensList.Sorting.route,
    ) {
        composable(ScreensList.Sorting.route) {
            SortingScreen()
        }
        composable(ScreensList.Recorder.route) {
            RecorderUI()
        }
        composable(ScreensList.ApiTrash.route) {
            ApiTrash()
        }
    }
}