package com.rcalderon.echojournal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rcalderon.echojournal.core.ui.theme.EchoJournalTheme
import com.rcalderon.echojournal.presentation.navigation.EchoJournalNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            EchoJournalApp()
        }
    }
}



@Composable
fun EchoJournalApp() {
    EchoJournalTheme {
        EchoJournalNavGraph()
    }
}