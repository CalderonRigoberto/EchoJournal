package com.rcalderon.echojournal.presentation.enums

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.rcalderon.echojournal.core.ui.theme.ExcitedBg
import com.rcalderon.echojournal.core.ui.theme.ExcitedPrimary
import com.rcalderon.echojournal.core.ui.theme.ExcitedSecondary
import com.rcalderon.echojournal.core.ui.theme.NeutralBg
import com.rcalderon.echojournal.core.ui.theme.NeutralPrimary
import com.rcalderon.echojournal.core.ui.theme.NeutralSecondary
import com.rcalderon.echojournal.core.ui.theme.PeacefulBg
import com.rcalderon.echojournal.core.ui.theme.PeacefulPrimary
import com.rcalderon.echojournal.core.ui.theme.PeacefulSecondary
import com.rcalderon.echojournal.core.ui.theme.SadBg
import com.rcalderon.echojournal.core.ui.theme.SadPrimary
import com.rcalderon.echojournal.core.ui.theme.SadSecondary
import com.rcalderon.echojournal.core.ui.theme.StressedBg

// TODO Create a class or replace the list of colors to access in a better and
// documented way
enum class Mood(val img: ImageVector, val colors: List<Color>) {
    Sad(
        com.rcalderon.echojournal.core.ui.general_components.image_vectors.Sad,
        listOf(
            SadBg,
            SadPrimary,
            SadSecondary
        )
    ),
    Peaceful(
        com.rcalderon.echojournal.core.ui.general_components.image_vectors.Peaceful,
        listOf(
            PeacefulBg,
            PeacefulPrimary,
            PeacefulSecondary
        )
    ),
    Neutral(
        com.rcalderon.echojournal.core.ui.general_components.image_vectors.Neutral,
        listOf(
            NeutralBg,
            NeutralPrimary,
            NeutralSecondary
        )
    ),
    Excited(
        com.rcalderon.echojournal.core.ui.general_components.image_vectors.Excited,
        listOf(
            ExcitedBg,
            ExcitedPrimary,
            ExcitedSecondary
        )
    ),
    Stressed(
        com.rcalderon.echojournal.core.ui.general_components.image_vectors.Stressed,
        listOf(
            StressedBg,
            SadPrimary,
            SadSecondary
        )
    )
}