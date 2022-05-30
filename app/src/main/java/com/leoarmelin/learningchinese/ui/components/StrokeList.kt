package com.leoarmelin.learningchinese.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.leoarmelin.learningchinese.models.strokes.Stroke

@Composable
fun StrokeList(strokes: List<Stroke>, onItemClick: (stroke: Stroke) -> Unit) {
    LazyColumn {
        items(strokes) { stroke ->
            StrokeListItem(stroke = stroke, onItemClick)

            Divider(color = Color.Black)
        }
    }
}