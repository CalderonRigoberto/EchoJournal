package com.rcalderon.echojournal.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rcalderon.echojournal.core.ui.theme.InterFont
import com.rcalderon.echojournal.presentation.enums.Mood
import java.util.stream.Collectors


@Composable
fun FilterEntriesChip(
    modifier: Modifier = Modifier,
    onClearFilters: (Set<Mood>) -> Unit,
    onMoodSelected: (Set<Mood>) -> Unit,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val selectedMoods = rememberSaveable { mutableStateOf(emptySet<Mood>()) }

    Box(
        modifier = modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)
    ) {
        FilterChip(
            shape = CircleShape,
            onClick = { expanded = !expanded },
            label = {
                // TODO Implement a function to get just the 2 first elements of the list
                val text = selectedMoods.value.asSequence()
                    .map { it.name }
                    .toList()
                    .take(2)
                    .joinToString { ", " }

                Text(if(selectedMoods.value.isNotEmpty()) "$text, ${(selectedMoods.value.size - 2).coerceAtLeast(0)}" else "All moods")
            },
            selected = false,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            },
            trailingIcon = {
                if(selectedMoods.value.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            selectedMoods.value = emptySet()
                            onClearFilters(selectedMoods.value)
                        }
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Clean filter")
                    }
                }
            }
        )

        DropdownMenu(
            modifier = Modifier.fillMaxWidth(0.95f),
            expanded = expanded, onDismissRequest = { expanded = false }
        ) {
            Mood.entries.toSet().forEach {
                DropdownMenuItem(
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 2.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(if(it in selectedMoods.value) Color.Gray.copy(alpha = 0.15f) else Color.Transparent),
                    text = {
                        Text(
                            it.name, style = TextStyle(
                                fontFamily = InterFont,
                                fontWeight = FontWeight.Medium,
                                fontSize = 14.sp,
                                lineHeight = 20.sp
                            )
                        )
                    },
                    leadingIcon = {
                        Image(
                            modifier = Modifier.size(30.dp),
                            imageVector = it.img,
                            contentDescription = "Image filter ${it.name}",
                        )
                    },
                    trailingIcon = {
                        if(it in selectedMoods.value) {
                            Icon(Icons.Default.Check, contentDescription = "Mood selected")
                        }
                    },
                    onClick = {
                        if(it in selectedMoods.value) {
                            selectedMoods.value -= it
                        } else {
                            selectedMoods.value += it
                        }

                        onMoodSelected(selectedMoods.value)
                    }
                )
            }
        }
    }
}