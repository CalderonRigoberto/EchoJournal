package com.rcalderon.echojournal.core.ui.general_components.image_vectors

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Sad: ImageVector
    get() {
        if (_Sad != null) {
            return _Sad!!
        }
        _Sad = ImageVector.Builder(
            name = "Sad",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7BBCFA),
                        1f to Color(0xFF2993F7)
                    ),
                    start = Offset(12f, 0f),
                    end = Offset(12f, 24f)
                )
            ) {
                moveTo(24f, 14.25f)
                curveTo(24f, 20.877f, 18.627f, 24f, 12f, 24f)
                curveTo(5.373f, 24f, 0f, 20.877f, 0f, 14.25f)
                curveTo(0f, 7.623f, 5.373f, 0f, 12f, 0f)
                curveTo(18.627f, 0f, 24f, 7.623f, 24f, 14.25f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(14.25f, 18.059f)
                curveTo(13.588f, 17.232f, 11.584f, 15.627f, 8.861f, 15.825f)
                curveTo(6.139f, 16.024f, 5.534f, 17.397f, 5.25f, 18.059f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(6.169f, 8.609f)
                curveTo(5.976f, 9.687f, 4.84f, 10.733f, 3.75f, 10.837f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(12.302f, 8.388f)
                curveTo(12.372f, 9.48f, 13.383f, 10.648f, 14.454f, 10.875f)
            }
            path(fill = SolidColor(Color(0xFFDFEEFC))) {
                moveTo(16.5f, 14.25f)
                curveTo(16.5f, 14.871f, 15.996f, 15.375f, 15.375f, 15.375f)
                curveTo(14.754f, 15.375f, 14.25f, 14.871f, 14.25f, 14.25f)
                curveTo(14.25f, 13.629f, 15.375f, 12f, 15.375f, 12f)
                curveTo(15.375f, 12f, 16.5f, 13.629f, 16.5f, 14.25f)
                close()
            }
        }.build()

        return _Sad!!
    }

@Suppress("ObjectPropertyName")
private var _Sad: ImageVector? = null
