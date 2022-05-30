package com.leoarmelin.learningchinese.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoarmelin.learningchinese.models.strokes.Stroke

@Composable
fun StrokeListItem(stroke: Stroke, onItemClick: (stroke: Stroke) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 16.dp)
            .clickable { onItemClick(stroke) }
    ) {
        Text(
            text = stroke.character,
            color = Color.Black,
            fontSize = 48.sp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        Text(
            text = stroke.pinyin,
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp)
        )
    }
}