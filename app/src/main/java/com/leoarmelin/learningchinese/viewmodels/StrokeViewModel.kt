package com.leoarmelin.learningchinese.viewmodels

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.leoarmelin.learningchinese.R
import com.leoarmelin.learningchinese.mockdata.MockStroke
import com.leoarmelin.learningchinese.models.strokes.Stroke

class StrokeViewModel : ViewModel() {
    var selectedStroke by mutableStateOf<Stroke?>(null)

    /** Match GameMode Variables **/
    var matchCompletedStrokeList = mutableStateListOf<Stroke>()
    var matchCharacterStrokeList = mutableStateListOf<Stroke>()
    var matchPinyinStrokeList = mutableStateListOf<Stroke>()
    var matchSelectedCharacter by mutableStateOf<Stroke?>(null)
    var matchSelectedPinyin by mutableStateOf<Stroke?>(null)

    /** END Match GameMode Variables **/

    fun selectStroke(stroke: Stroke) {
        selectedStroke = stroke
    }

    fun getRandomMatchList(currentStroke: Stroke) {
        if (matchCharacterStrokeList.isNotEmpty()) return

        val fullStrokeList = MockStroke.getStrokeList()
        val partialStrokeList =
            mutableListOf(fullStrokeList.find { stroke -> stroke == currentStroke }
                ?: throw Exception("Stroke should exist"))

        partialStrokeList.addAll(fullStrokeList.filter { stroke -> stroke != currentStroke }
            .shuffled().subList(0, 3))

        matchCharacterStrokeList.addAll(partialStrokeList)
        matchPinyinStrokeList.addAll(matchCharacterStrokeList.shuffled())
    }

    /** Match GameMode Functions **/
    fun selectMatchCharacter(stroke: Stroke?, context: Context) {
        matchSelectedCharacter = stroke
        matchCharacterWithPinyinStrokes(context)
    }

    fun selectMatchPinyin(stroke: Stroke?, context: Context) {
        matchSelectedPinyin = stroke
        matchCharacterWithPinyinStrokes(context)
    }

    private fun matchCharacterWithPinyinStrokes(context: Context) {
        val characterStroke = matchSelectedCharacter
        val pinyinStroke = matchSelectedPinyin

        if (characterStroke == null || pinyinStroke == null) return

        if (characterStroke == pinyinStroke) {
            matchCompletedStrokeList.add(characterStroke)
        } else {
            val errorMediaPlayer = MediaPlayer.create(context, R.raw.sound_error)
            errorMediaPlayer.start()
        }

        matchSelectedCharacter = null
        matchSelectedPinyin = null
    }

    fun clearMatchStates() {
        matchCompletedStrokeList.clear()
        matchCharacterStrokeList.clear()
        matchPinyinStrokeList.clear()
        matchSelectedCharacter = null
        matchSelectedPinyin = null
    }
    /** END Match GameMode Functions **/
}