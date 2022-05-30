package com.leoarmelin.learningchinese.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.leoarmelin.learningchinese.models.strokes.Stroke
import com.leoarmelin.learningchinese.models.strokes.StrokeInfoType

@Composable
fun StrokeCardList(
    completedStrokes: List<Stroke>,
    characterStrokes: List<Stroke>,
    pinyinStrokes: List<Stroke>,
    onCharacterClick: (stroke: Stroke) -> Unit,
    onPinyinClick: (stroke: Stroke) -> Unit,
    selectedCharacter: Stroke?,
    selectedPinyin: Stroke?
) {
    Row {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(characterStrokes) { stroke ->
                StrokeCardListItem(
                    stroke = stroke,
                    onClick = onCharacterClick,
                    textType = StrokeInfoType.Character,
                    isSelected = stroke == selectedCharacter,
                    isCompleted = completedStrokes.contains(stroke)
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(pinyinStrokes) { stroke ->
                StrokeCardListItem(
                    stroke = stroke,
                    onClick = onPinyinClick,
                    textType = StrokeInfoType.Pinyin,
                    isSelected = stroke == selectedPinyin,
                    isCompleted = completedStrokes.contains(stroke)
                )
            }
        }
    }
}