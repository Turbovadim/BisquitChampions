package net.turbovadim.bisquitchampions.navigation

sealed class ScreensList(val route: String) {
    object Sorting : ScreensList("Sorting")
    object Recorder : ScreensList("Recorder")
    object ApiTrash : ScreensList("ApiTrash")

    fun withArg(arg: Any): String {
        return buildString {
            append(route)
            append("/$arg")
        }
    }
}