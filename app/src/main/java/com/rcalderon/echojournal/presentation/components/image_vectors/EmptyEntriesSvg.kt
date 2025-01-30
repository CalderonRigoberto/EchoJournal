package com.rcalderon.echojournal.presentation.components.image_vectors

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EmptyEntries: ImageVector
    get() {
        if (_EmptyEntries != null) {
            return _EmptyEntries!!
        }
        _EmptyEntries = ImageVector.Builder(
            name = "EmptyEntries",
            defaultWidth = 152.dp,
            defaultHeight = 151.dp,
            viewportWidth = 152f,
            viewportHeight = 151f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(78f, 70f)
                moveToRelative(-65f, 0f)
                arcToRelative(65f, 65f, 0f, isMoreThanHalf = true, isPositiveArc = true, 130f, 0f)
                arcToRelative(65f, 65f, 0f, isMoreThanHalf = true, isPositiveArc = true, -130f, 0f)
            }
            path(fill = SolidColor(Color(0xFFBAC6E9))) {
                moveTo(42.67f, 61.52f)
                moveToRelative(-42.39f, 0f)
                arcToRelative(42.39f, 42.39f, 0f, isMoreThanHalf = true, isPositiveArc = true, 84.78f, 0f)
                arcToRelative(42.39f, 42.39f, 0f, isMoreThanHalf = true, isPositiveArc = true, -84.78f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(42.67f, 54.4f)
                curveTo(45.21f, 54.65f, 49.34f, 55.68f, 50.52f, 57.26f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(21.01f, 47.26f)
                curveTo(21.01f, 47.26f, 17.01f, 45.3f, 16.02f, 45.67f)
                curveTo(14.61f, 46.2f, 13.53f, 49.38f, 13.53f, 49.38f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(18.83f, 77.33f)
                curveTo(20.99f, 76.93f, 25.92f, 76.25f, 28.35f, 76.69f)
                curveTo(31.37f, 77.25f, 33.48f, 79.44f, 37.22f, 79.53f)
                curveTo(40.21f, 79.61f, 44.22f, 77.83f, 45.85f, 76.93f)
            }
            path(fill = SolidColor(Color(0xFF191A20))) {
                moveTo(17.95f, 58f)
                moveToRelative(-1.77f, 0f)
                arcToRelative(1.77f, 1.77f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.55f, 0f)
                arcToRelative(1.77f, 1.77f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.55f, 0f)
            }
            path(fill = SolidColor(Color(0xFF191A20))) {
                moveTo(43.14f, 61.14f)
                moveToRelative(-1.77f, 0f)
                arcToRelative(1.77f, 1.77f, 0f, isMoreThanHalf = true, isPositiveArc = true, 3.55f, 0f)
                arcToRelative(1.77f, 1.77f, 0f, isMoreThanHalf = true, isPositiveArc = true, -3.55f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(68.11f, 17.46f)
                curveTo(68.84f, 15.47f, 70.24f, 13.72f, 72.89f, 14.7f)
                curveTo(75.54f, 15.67f, 74.57f, 18.32f, 74.32f, 18.99f)
                curveTo(73.35f, 21.64f, 68.64f, 22.17f, 67.91f, 24.16f)
                curveTo(67.52f, 25.22f, 67.66f, 24.82f, 67.42f, 25.48f)
                moveTo(65.86f, 29.73f)
                lineTo(65.96f, 29.46f)
            }
            path(fill = SolidColor(Color(0xFFD9E2FF))) {
                moveTo(109.09f, 94.02f)
                moveToRelative(42.39f, 0f)
                arcToRelative(42.39f, 42.39f, 135f, isMoreThanHalf = true, isPositiveArc = false, -84.78f, 0f)
                arcToRelative(42.39f, 42.39f, 45f, isMoreThanHalf = true, isPositiveArc = false, 84.78f, 0f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(126.81f, 85.55f)
                curveTo(126.81f, 85.55f, 131.2f, 81.08f, 132.68f, 81.12f)
                curveTo(134.8f, 81.16f, 137.71f, 84.87f, 137.71f, 84.87f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(111.34f, 85.92f)
                curveTo(111.34f, 85.92f, 105.99f, 82.69f, 104.56f, 83.09f)
                curveTo(102.51f, 83.66f, 100.61f, 87.98f, 100.61f, 87.98f)
            }
            path(
                fill = SolidColor(Color(0xFF191A20)),
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.11957f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(134.39f, 99.67f)
                curveTo(132.82f, 104.51f, 130.11f, 112.87f, 122.28f, 113.64f)
                curveTo(114.99f, 114.36f, 109.26f, 105.97f, 107.67f, 102.29f)
                lineTo(134.39f, 99.67f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(51.15f, 127.93f)
                curveTo(57.51f, 127.93f, 59.63f, 115.22f, 59.63f, 115.22f)
                curveTo(59.63f, 115.22f, 61.75f, 127.93f, 68.11f, 127.93f)
                curveTo(61.75f, 127.93f, 59.63f, 140.65f, 59.63f, 140.65f)
                curveTo(59.63f, 140.65f, 57.51f, 127.93f, 51.15f, 127.93f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(69.52f, 142.07f)
                curveTo(72.7f, 142.07f, 73.76f, 135f, 73.76f, 135f)
                curveTo(73.76f, 135f, 74.82f, 142.07f, 78f, 142.07f)
                curveTo(74.82f, 142.07f, 73.76f, 149.13f, 73.76f, 149.13f)
                curveTo(73.76f, 149.13f, 72.7f, 142.07f, 69.52f, 142.07f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 2.36364f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(56.8f, 6.41f)
                curveTo(56.8f, 4.29f, 57.51f, 2.17f, 60.34f, 2.17f)
                curveTo(63.16f, 2.17f, 63.16f, 5f, 63.16f, 5.71f)
                curveTo(63.16f, 8.53f, 58.92f, 10.65f, 58.92f, 12.77f)
                curveTo(58.92f, 13.9f, 58.92f, 13.48f, 58.92f, 14.18f)
                moveTo(58.92f, 18.71f)
                verticalLineTo(18.42f)
            }
        }.build()

        return _EmptyEntries!!
    }

@Suppress("ObjectPropertyName")
private var _EmptyEntries: ImageVector? = null
