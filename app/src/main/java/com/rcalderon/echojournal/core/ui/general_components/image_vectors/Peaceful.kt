package com.rcalderon.echojournal.core.ui.general_components.image_vectors

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Peaceful: ImageVector
    get() {
        if (_Peaceful != null) {
            return _Peaceful!!
        }
        _Peaceful = ImageVector.Builder(
            name = "Peaceful",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCCDEE),
                        1f to Color(0xFFF991E0)
                    ),
                    start = Offset(12f, 0f),
                    end = Offset(12f, 24f)
                )
            ) {
                moveTo(24f, 12f)
                curveTo(24f, 18.627f, 19.377f, 22.5f, 12.75f, 22.5f)
                curveTo(6.123f, 22.5f, 0f, 18.627f, 0f, 12f)
                curveTo(0f, 5.373f, 6.123f, 0.75f, 12.75f, 0.75f)
                curveTo(19.377f, 0.75f, 24f, 5.373f, 24f, 12f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(9f, 15.75f)
                curveTo(9.772f, 16.853f, 11.063f, 18.75f, 14.25f, 18.75f)
                curveTo(17.625f, 18.75f, 19.169f, 16.632f, 19.5f, 15.75f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(17.25f, 9.028f)
                curveTo(17.675f, 10.201f, 19.154f, 11.158f, 20.398f, 11.065f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(11.398f, 9.028f)
                curveTo(10.974f, 10.201f, 9.495f, 11.158f, 8.25f, 11.065f)
            }
        }.build()

        return _Peaceful!!
    }

@Suppress("ObjectPropertyName")
private var _Peaceful: ImageVector? = null
