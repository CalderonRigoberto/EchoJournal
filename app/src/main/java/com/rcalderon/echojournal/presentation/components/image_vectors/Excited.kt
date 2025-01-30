package com.rcalderon.echojournal.presentation.components.image_vectors

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Excited: ImageVector
    get() {
        if (_Excited != null) {
            return _Excited!!
        }
        _Excited = ImageVector.Builder(
            name = "Excited",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF5CB6F),
                        1f to Color(0xFFF6B01A)
                    ),
                    start = Offset(12f, 0f),
                    end = Offset(12f, 24f)
                )
            ) {
                moveTo(23.25f, 10.5f)
                curveTo(23.25f, 17.127f, 19.5f, 24f, 12f, 24f)
                curveTo(4.5f, 24f, 0f, 17.127f, 0f, 10.5f)
                curveTo(0f, 3.873f, 5.373f, 0f, 12f, 0f)
                curveTo(18.627f, 0f, 23.25f, 3.873f, 23.25f, 10.5f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF191A20)),
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.125f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(18f, 12.75f)
                curveTo(17.375f, 14.125f, 16.294f, 16.5f, 13.875f, 16.5f)
                curveTo(11.625f, 16.5f, 10.125f, 13.875f, 9.75f, 12.75f)
                lineTo(18f, 12.75f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.125f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(17.25f, 7.252f)
                lineTo(19.689f, 9.675f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.125f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(9.939f, 7.252f)
                lineTo(7.5f, 9.675f)
            }
        }.build()

        return _Excited!!
    }

@Suppress("ObjectPropertyName")
private var _Excited: ImageVector? = null
