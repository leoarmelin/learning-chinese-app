package com.leoarmelin.learningchinese.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leoarmelin.learningchinese.models.strokes.Stroke
import com.leoarmelin.learningchinese.models.strokes.StrokeInfoType

@Composable
fun StrokeCardListItem(
    stroke: Stroke,
    onClick: (stroke: Stroke) -> Unit,
    textType: StrokeInfoType,
    isSelected: Boolean,
    isCompleted: Boolean
) {
    val delayDuration = 300

    val colorState = animateColorAsState(
        when {
            isCompleted -> Color.Transparent
            isSelected -> Color.White
            else -> Color.Black
        },
        animationSpec = tween(delayDuration)
    )
    val backgroundColorState = animateColorAsState(
        when {
            isCompleted -> Color.Transparent
            isSelected -> Color.Black
            else -> Color.White
        },
        animationSpec = tween(delayDuration)
    )

    val alphaState =
        animateFloatAsState(if (isCompleted) 0f else 1f, animationSpec = tween(delayDuration))

    Text(
        text = when (textType) {
            StrokeInfoType.Character -> stroke.character
            StrokeInfoType.Pinyin -> stroke.pinyin
            StrokeInfoType.Meaning -> stroke.meanings.joinToString(", ")
        },
        fontSize = 24.sp,
        color = colorState.value,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(shape = RoundedCornerShape(8.dp), color = backgroundColorState.value)
            .border(width = 1.dp, color = colorState.value, shape = RoundedCornerShape(8.dp))
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onClick(stroke) }
                )
            }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .alpha(alphaState.value)
    )
}