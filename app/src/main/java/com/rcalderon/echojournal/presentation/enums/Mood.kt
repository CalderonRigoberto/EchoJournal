package com.rcalderon.echojournal.presentation.enums

import androidx.compose.ui.graphics.vector.ImageVector

enum class Mood(val img: ImageVector) {
    Sad(com.rcalderon.echojournal.presentation.components.image_vectors.Sad),
    Peaceful(com.rcalderon.echojournal.presentation.components.image_vectors.Peaceful),
    Neutral(com.rcalderon.echojournal.presentation.components.image_vectors.Neutral),
    Excited(com.rcalderon.echojournal.presentation.components.image_vectors.Excited),
    Stressed(com.rcalderon.echojournal.presentation.components.image_vectors.Stressed)
}