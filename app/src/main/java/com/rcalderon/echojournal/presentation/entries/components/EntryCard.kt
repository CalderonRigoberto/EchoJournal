package com.rcalderon.echojournal.presentation.entries.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.rcalderon.echojournal.R
import com.rcalderon.echojournal.core.data.model.EntryUiModel
import com.rcalderon.echojournal.core.data.model.TopicUiModel
import com.rcalderon.echojournal.presentation.enums.Mood
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rcalderon.echojournal.presentation.entries.EntriesScreenEvents
import com.rcalderon.echojournal.presentation.entries.EntriesScreenState
import com.rcalderon.echojournal.presentation.entries.EntriesViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EntryContent(
    entriesViewModel: EntriesViewModel = hiltViewModel()
) {
    val state by entriesViewModel.state.collectAsStateWithLifecycle()
    val playbackTimeState by entriesViewModel.playbackTimeState.collectAsStateWithLifecycle()
    val playbackFormattedTimeState by entriesViewModel.playbackFormattedTimeState.collectAsStateWithLifecycle()
    LazyColumn {
        itemsIndexed(state.entries) { index, entryUiModel ->
            EntryContent(
                entryUiModel = entryUiModel,
                isFirstItem = index == 0,
                isLastItem = index == state.entries.size - 1,
                isAudioOnPlayback = state.isPlaying,
                currentPosition = if(state.isPlaying && playbackTimeState != null) playbackTimeState!! else 0f,
                currentPositionFormated = playbackFormattedTimeState,
                onPlay = {
                    entriesViewModel.onEvent(
                        EntriesScreenEvents.PLayAudio(entryUiModel.source)
                    )
                }
            )
        }
    }
}


@Composable
fun EntryContent(
    entryUiModel: EntryUiModel,
    onPlay: () -> Unit,
    isFirstItem: Boolean,
    isLastItem: Boolean,
    isAudioOnPlayback: Boolean = false,
    currentPositionFormated: String = "0:00",
    currentPosition: Float = 0f
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()
            .height(intrinsicSize = IntrinsicSize.Min)
            .padding(horizontal = 5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = if(isFirstItem) Modifier.padding(top = 20.dp) else Modifier.padding(top = 0.dp )
        ) {
            Box (
             contentAlignment = Alignment.TopCenter,
            ){
                if (!isLastItem) {
                    VerticalDivider(
                        modifier = Modifier.fillMaxHeight()
                    )
                }
                Image(
                    imageVector = entryUiModel.mood.img,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
        EntryCard(
            entryUiModel = entryUiModel,
            isAudioOnPlayback = isAudioOnPlayback,
            currentPosition = currentPosition,
            currentPositionFormated = currentPositionFormated,
            onPlay = onPlay
        )
    }
}

@Composable
private fun EntryCard(
    entryUiModel: EntryUiModel,
    isAudioOnPlayback: Boolean = false,
    currentPosition: Float,
    currentPositionFormated: String,
    onPlay: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = entryUiModel.title, style = MaterialTheme.typography.bodyLarge)
            Text(text = entryUiModel.createdAt, style = MaterialTheme.typography.bodySmall)
        }

        AudioPlayer(
            entryUiModel = entryUiModel,
            isAudioOnPlayback = isAudioOnPlayback,
            currentPosition = currentPosition,
            currentPositionFormated = currentPositionFormated,
            onPlay = onPlay
        )

        if(entryUiModel.description != null) {
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(4.dp))
            ) {
                ExpandableText(
                    modifier = Modifier.padding(2.5.dp),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    text = entryUiModel.description,
                )
            }
        }

        if(!entryUiModel.topics.isNullOrEmpty()) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.5.dp),
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = if(entryUiModel.description.isNullOrEmpty()) 5.dp else 0.dp)
                    .height(20.dp)
                    .fillMaxWidth()
            ) {
                entryUiModel.topics.forEachIndexed { _, topic ->
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.1f))
                    ) {
                        Text(
                            text = "# ${topic.topic}",
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AudioPlayer(
    entryUiModel: EntryUiModel,
    isAudioOnPlayback: Boolean = false,
    currentPosition: Float,
    currentPositionFormated: String,
    onPlay: () -> Unit
) {
    val animatedProgress by animateFloatAsState(
        targetValue = currentPosition,
        animationSpec = tween(
            durationMillis = 300,
            easing = FastOutLinearInEasing
        ),
        label = "progress"
    )

    Box(
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clip(CircleShape)
            .background(entryUiModel.mood.colors[1])
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(5.dp)
        ) {
            ElevatedButton(
                onClick =  onPlay,
                shape = CircleShape,
                modifier = Modifier
                    .size(32.dp)
                    .aspectRatio(1f, matchHeightConstraintsFirst = true),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    painter = if(!isAudioOnPlayback) painterResource(R.drawable.ic_play)
                    else painterResource(R.drawable.ic_pause),
                    contentDescription = null,
                    tint = entryUiModel.mood.colors[0]
                )
            }
            Spacer(modifier = Modifier.width(2.dp))
            LinearProgressIndicator(
                progress = { animatedProgress },
                color =  entryUiModel.mood.colors[0],
                trackColor = entryUiModel.mood.colors[2],
                modifier = Modifier
                    .padding(horizontal = 2.5.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .weight(1f)

            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(text = "$currentPositionFormated / ", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    fontStyle: FontStyle? = null,
    text: String,
    collapsedMaxLine: Int = 3,
    showMoreText: String = "... Show More",
    showMoreStyle: SpanStyle = SpanStyle(fontWeight = FontWeight.W500),
    showLessText: String = " Show Less",
    showLessStyle: SpanStyle = showMoreStyle,
    textAlign: TextAlign? = null,
    fontSize: TextUnit
) {
    // State variables to track the expanded state, clickable state, and last character index.
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableIntStateOf(0) }

    // Box composable containing the Text composable.
    Box(
        modifier = Modifier
            .clickable(clickable) {
                isExpanded = !isExpanded
            }
            .then(modifier)
    ) {
        // Text composable with buildAnnotatedString to handle "Show More" and "Show Less" buttons.
        Text(
            modifier = textModifier
                .fillMaxWidth()
                .animateContentSize(),
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        // Display the full text and "Show Less" button when expanded.
                        append(text)
                        withStyle(style = showLessStyle) { append(showLessText) }
                    } else {
                        // Display truncated text and "Show More" button when collapsed.
                        val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLast(showMoreText.length)
                            .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                        append(adjustText)
                        withStyle(style = showMoreStyle) { append(showMoreText) }
                    }
                } else {
                    // Display the full text when not clickable.
                    append(text)
                }
            },
            // Set max lines based on the expanded state.
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            fontStyle = fontStyle,
            // Callback to determine visual overflow and enable click ability.
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = textLayoutResult.getLineEnd(collapsedMaxLine - 1)
                }
            },
            style = style,
            textAlign = textAlign,
            fontSize = fontSize
        )
    }
}



val _fakeEntries = listOf(
    EntryUiModel(
        title = "Aprendiendo Kotlin",
        description = null,
        topics = listOf(TopicUiModel("Programación"), TopicUiModel("Kotlin")),
        source = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3".toUri(),
        createdAt = "10:00",
        mood = Mood.Excited
    )
)