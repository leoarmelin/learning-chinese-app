package com.leoarmelin.learningchinese.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoarmelin.learningchinese.models.strokes.Stroke
import com.leoarmelin.learningchinese.ui.ThemeColors

@Composable
fun StrokeListItem(stroke: Stroke, onItemClick: (stroke: Stroke) -> Unit, onLongPress: (stroke: Stroke) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onItemClick(stroke) },
                    onLongPress = { onLongPress(stroke) }
                )
            }
            .padding(16.dp)
    ) {
        Text(
            text = stroke.character,
            color = ThemeColors.Foreground,
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Text(
            text = stroke.pinyin,
            color = ThemeColors.Foreground,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp)
        )
    }
}