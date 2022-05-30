package com.leoarmelin.learningchinese.ui.screens

import androidx.compose.runtime.Composable
import com.leoarmelin.learningchinese.mockdata.MockStroke
import com.leoarmelin.learningchinese.models.navigation.MainNavRoutes
import com.leoarmelin.learningchinese.models.strokes.Stroke
import com.leoarmelin.learningchinese.ui.components.StrokeList
import com.leoarmelin.learningchinese.viewmodels.NavigationViewModel
import com.leoarmelin.learningchinese.viewmodels.StrokeViewModel

@Composable
fun HomeScreen(navigationViewModel: NavigationViewModel, strokeViewModel: StrokeViewModel) {
    val onItemClick: (stroke: Stroke) -> Unit = { stroke ->
        strokeViewModel.selectStroke(stroke)
        navigationViewModel.setRoute(MainNavRoutes.Match.routeName)
    }

    StrokeList(strokes = MockStroke.getStrokeList(), onItemClick)
}