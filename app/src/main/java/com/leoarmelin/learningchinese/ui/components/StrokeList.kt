package com.leoarmelin.learningchinese.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import com.leoarmelin.learningchinese.models.strokes.Stroke
import com.leoarmelin.learningchinese.ui.ThemeColors

@Composable
fun StrokeList(strokes: List<Stroke>, onItemClick: (stroke: Stroke) -> Unit, onLongPress: (stroke: Stroke) -> Unit) {
    LazyColumn {
        items(strokes) { stroke ->
            StrokeListItem(stroke = stroke, onItemClick, onLongPress)

            Divider(color = ThemeColors.CurrentLine)
        }
    }
}