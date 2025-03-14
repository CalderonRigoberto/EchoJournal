package com.rcalderon.echojournal.core.ui.general_components.image_vectors

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
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFC4F3DB),
                        1f to Color(0xFF71EBAC)
                    ),
                    start = Offset(16f, 1f),
                    end = Offset(16f, 31f)
                )
            ) {
                moveTo(14f, 1f)
                lineTo(18f, 1f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 31f, 14f)
                lineTo(31f, 18f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18f, 31f)
                lineTo(14f, 31f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 1f, 18f)
                lineTo(1f, 14f)
                arcTo(13f, 13f, 0f, isMoreThanHalf = false, isPositiveArc = true, 14f, 1f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(20f, 11.175f)
                curveTo(21.63f, 11.511f, 22.701f, 12.448f, 23.248f, 14.02f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(11.248f, 11.175f)
                curveTo(9.618f, 11.511f, 8.548f, 12.448f, 8f, 14.02f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(10f, 21f)
                curveTo(11.25f, 21.444f, 13.6f, 22f, 16f, 22f)
                curveTo(18.4f, 22f, 21.25f, 21.444f, 22f, 21f)
            }
        }.build()

        return _Neutral!!
    }

@Suppress("ObjectPropertyName")
private var _Neutral: ImageVector? = null
