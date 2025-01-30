package com.rcalderon.echojournal.presentation.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

private object EchoJournalScreens {
    const val ENTRIES_SCREEN = "entries"
    const val ADD_ENTRY_SCREEN = "addEntry"
    const val SETTINGS_SCREEN = "settings"
}

object EchoJournalDestinations {
    const val ENTRIES_ROUTE = EchoJournalScreens.ENTRIES_SCREEN
    const val ADD_ENTRY_ROUTE = EchoJournalScreens.ADD_ENTRY_SCREEN
    const val SETTINGS_ROUTE = EchoJournalScreens.SETTINGS_SCREEN
}

class EchoJournalNavigationActions(private val navController: NavHostController) {

    fun navigateToSettings() {
        navController.navigate(EchoJournalDestinations.SETTINGS_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true

        }
    }
}