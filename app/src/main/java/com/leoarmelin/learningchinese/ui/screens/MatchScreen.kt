package com.leoarmelin.learningchinese.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.leoarmelin.learningchinese.models.navigation.MainNavRoutes
import com.leoarmelin.learningchinese.models.strokes.Stroke
import com.leoarmelin.learningchinese.ui.components.StrokeCardList
import com.leoarmelin.learningchinese.viewmodels.NavigationViewModel
import com.leoarmelin.learningchinese.viewmodels.StrokeViewModel

@Composable
fun MatchScreen(navigationViewModel: NavigationViewModel, strokeViewModel: StrokeViewModel) {
    val context = LocalContext.current

    val onCharacterClick: (stroke: Stroke) -> Unit = { stroke ->
        strokeViewModel.selectMatchCharacter(
            if (strokeViewModel.matchSelectedCharacter == stroke) null else stroke,
            context
        )
    }

    val onPinyinClick: (stroke: Stroke) -> Unit = { stroke ->
        strokeViewModel.selectMatchPinyin(
            if (strokeViewModel.matchSelectedPinyin == stroke) null else stroke,
            context
        )
    }

    if (strokeViewModel.matchCompletedStrokeList.size == strokeViewModel.matchCharacterStrokeList.size) {
        navigationViewModel.setRoute(MainNavRoutes.Home.routeName)
        strokeViewModel.clearMatchStates()
    }

    StrokeCardList(
        completedStrokes = strokeViewModel.matchCompletedStrokeList,
        characterStrokes = strokeViewModel.matchCharacterStrokeList,
        pinyinStrokes = strokeViewModel.matchPinyinStrokeList,
        onCharacterClick = onCharacterClick,
        onPinyinClick = onPinyinClick,
        selectedCharacter = strokeViewModel.matchSelectedCharacter,
        selectedPinyin = strokeViewModel.matchSelectedPinyin
    )
}