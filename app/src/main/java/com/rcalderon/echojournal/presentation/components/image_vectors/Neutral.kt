package com.rcalderon.echojournal.presentation.components.image_vectors

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Neutral: ImageVector
    get() {
        if (_Neutral != null) {
            return _Neutral!!
        }
        _Neutral = ImageVector.Builder(
            name = "Neutral",
            defaultWidth = 32.dp,
            defaultHeight = 48.dp,
            viewportWidth = 32f,
            viewportHeight = 48f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFC4F3DB),
                        1f to Color(0xFF71EBAC)
                    ),
                    start = Offset(16f, 9f),
                    end = Offset(16f, 39f)
                )
            ) {
                moveTo(14f, 9f)
                lineTo(18f, 9f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 31f, 22f)
                lineTo(31f, 26f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18f, 39f)
                lineTo(14f, 39f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1f, 26f)
                lineTo(1f, 22f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 9f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(20f, 19.175f)
                curveTo(21.63f, 19.511f, 22.701f, 20.448f, 23.248f, 22.02f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(11.248f, 19.175f)
                curveTo(9.618f, 19.511f, 8.548f, 20.448f, 8f, 22.02f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(10f, 29f)
                curveTo(11.25f, 29.444f, 13.6f, 30f, 16f, 30f)
                curveTo(18.4f, 30f, 21.25f, 29.444f, 22f, 29f)
            }
        }.build()

        return _Neutral!!
    }

@Suppress("ObjectPropertyName")
private var _Neutral: ImageVector? = null
