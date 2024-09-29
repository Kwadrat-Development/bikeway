package io.bikeway.ui

import androidx.navigation.NavHost
import androidx.navigation.NavHostController

object Routes {
    val HOME = "/"
    val BOOKMARKS = "/bookmarks"
    val NEW_TRIP = "/new-trip"
}

interface NavigatorMixin {
    val navController: NavHostController

    fun navigateTo(route: String) {
        navController.navigate(route)
    }

    fun navigateBack() {
        navController.popBackStack()
    }
}