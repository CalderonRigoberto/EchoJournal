package com.rcalderon.echojournal.presentation.entries

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rcalderon.echojournal.R
import com.rcalderon.echojournal.core.ui.theme.PrimaryContainer
import com.rcalderon.echojournal.core.ui.theme.Surface
import com.rcalderon.echojournal.presentation.components.EntriesEmptyState
import com.rcalderon.echojournal.presentation.components.FilterEntriesChip
import com.rcalderon.echojournal.presentation.enums.Mood

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntriesScreen(
    modifier: Modifier = Modifier,
    openSettings: () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.title_app_bar_entries)
                    )
                },
                actions = {
                    IconButton(onClick = openSettings) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Settings description"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton (
                onClick = {},
                shape = CircleShape,
                containerColor = PrimaryContainer
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    tint = Surface,
                    contentDescription = "Initialize to add new entry"
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                FilterEntriesChip(
                    modifier,
                    onClearFilters = {

                    },
                    onMoodSelected = {
                        Log.d("onMoodSelected", "EntriesScreen: ${it.toString()}")
                    }
                )
            }
            EntriesEmptyState()
        }
    }
}

