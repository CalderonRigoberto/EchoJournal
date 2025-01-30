package com.rcalderon.echojournal.presentation.components.image_vectors

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Stressed: ImageVector
    get() {
        if (_Stressed != null) {
            return _Stressed!!
        }
        _Stressed = ImageVector.Builder(
            name = "Stressed",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF69193),
                        1f to Color(0xFFED3A3A)
                    ),
                    start = Offset(12f, 0f),
                    end = Offset(12f, 24f)
                )
            ) {
                moveTo(22.5f, 12f)
                curveTo(22.5f, 18.627f, 18.627f, 24f, 12f, 24f)
                curveTo(5.373f, 24f, 0.75f, 18.627f, 0.75f, 12f)
                curveTo(0.75f, 5.373f, 6.75f, 0f, 12f, 0f)
                curveTo(17.25f, 0f, 22.5f, 5.373f, 22.5f, 12f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(6f, 16.5f)
                curveTo(6.625f, 15.125f, 7.706f, 12.75f, 10.125f, 12.75f)
                curveTo(12.375f, 12.75f, 13.875f, 15.375f, 14.25f, 16.5f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(13.5f, 9.75f)
                lineTo(17.25f, 7.5f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(3.75f, 7.5f)
                lineTo(7.5f, 9.75f)
            }
        }.build()

        return _Stressed!!
    }

@Suppress("ObjectPropertyName")
private var _Stressed: ImageVector? = null
