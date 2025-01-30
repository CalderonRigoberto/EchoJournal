package com.rcalderon.echojournal.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rcalderon.echojournal.presentation.entries.EntriesScreen
import com.rcalderon.echojournal.presentation.settings.SettingsScreen
import kotlinx.coroutines.CoroutineScope

@Composable
fun EchoJournalNavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = EchoJournalDestinations.ENTRIES_ROUTE,
    navigationActions: EchoJournalNavigationActions = remember(navHostController) {
        EchoJournalNavigationActions(navHostController)
    }
) {
    val currentNavBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = EchoJournalDestinations.ENTRIES_ROUTE) {
            EntriesScreen(
                modifier = modifier,
                openSettings = {
                    navigationActions.navigateToSettings()
                }
            )
        }
        composable(route = EchoJournalDestinations.SETTINGS_ROUTE) {
            SettingsScreen(
                modifier = modifier,
                onBack = { navHostController.popBackStack() }
            )
        }
    }
}