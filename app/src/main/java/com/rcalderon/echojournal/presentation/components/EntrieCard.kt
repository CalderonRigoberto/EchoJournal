package com.rcalderon.echojournal.presentation.components

import androidx.compose.animation.animateContentSize
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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


@Composable
fun EntrieContent(
    entries: List<EntryUiModel> = emptyList()
) {
    LazyColumn {
        itemsIndexed(_fakeEntries) { index, entryUiModel ->
            EntrieContent(
                entryUiModel = entryUiModel,
                isFirstItem = index == 0,
                isLastItem = index != 3,
                isAudioOnPlayback = true,
                onPlay = {}
            )
        }

    }
}


@Composable
fun EntrieContent(
    entryUiModel: EntryUiModel,
    onPlay: () -> Unit,
    isFirstItem: Boolean,
    isLastItem: Boolean,
    isAudioOnPlayback: Boolean = false,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
        modifier = Modifier
            .height(intrinsicSize = IntrinsicSize.Min)
            .padding(horizontal = 5.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = if (isFirstItem) 10.dp else 0.dp)
        ) {
            Image(
                imageVector = entryUiModel.mood.img,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            if (isLastItem) VerticalDivider(
                modifier = Modifier.fillMaxHeight()
            )
        }

        EntryCard(
            entryUiModel = entryUiModel,
            isAudioOnPlayback = isAudioOnPlayback,
            onPlay = onPlay
        )
    }

}

@Composable
private fun EntryCard(
    entryUiModel: EntryUiModel,
    isAudioOnPlayback: Boolean = false,
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
            Text(text = entryUiModel.createdAt, style = MaterialTheme.typography.labelLarge)
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
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
                        .size(30.dp)
                        .aspectRatio(1f, matchHeightConstraintsFirst = true),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        painter = if(!isAudioOnPlayback) painterResource(R.drawable.ic_play)
                        else painterResource(R.drawable.ic_pause),
                        contentDescription = null,
                        modifier = Modifier.size(34.dp)
                    )
                }
                Spacer(modifier = Modifier.width(2.dp))
                LinearProgressIndicator(
                    progress = {
                        .50f
                    },
                    trackColor = Color.Gray,
                    modifier = Modifier
                        .padding(horizontal = 2.5.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .weight(1f)

                )
                Spacer(modifier = Modifier.width(2.dp))
                // TODO El estado de reporduccion debe verse aqui
                Text(text = "7:05/12:30", style = MaterialTheme.typography.bodySmall)
            }
        }

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
                            .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f))
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
        source = "https://developer.android.com/kotlin".toUri(),
        createdAt = "10:00",
        mood = Mood.Excited
    ),
    EntryUiModel(
        title = "Cómo usar Jetpack Compose",
        description = "Jetpack Compose facilita la construcción de interfaces modernas en Android.",
        topics = null,
        source = "https://developer.android.com/jetpack/compose".toUri(),
        createdAt = "15:30",
        mood = Mood.Sad
    ),
    EntryUiModel(
        title = "Introducción a Kafka",
        description = "Conceptos básicos sobre mensajería en Kafka.",
        topics = listOf(TopicUiModel("Mensajería"), TopicUiModel("Kafka")),
        source = "https://kafka.apache.org/documentation/".toUri(),
        createdAt = "09:45",
        mood = Mood.Neutral
    ),
    EntryUiModel(
        title = "Dockerizando aplicaciones",
        description = "Pasos para contenedorización con Docker.",
        topics = listOf(TopicUiModel("DevOps"), TopicUiModel("Docker")),
        source = "https://docs.docker.com/get-started/".toUri(),
        createdAt = "18:10",
        mood = Mood.Sad
    )
)