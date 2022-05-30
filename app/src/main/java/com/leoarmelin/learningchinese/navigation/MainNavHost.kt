package com.leoarmelin.learningchinese.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leoarmelin.learningchinese.models.navigation.MainNavRoutes
import com.leoarmelin.learningchinese.ui.screens.HomeScreen
import com.leoarmelin.learningchinese.ui.screens.MatchScreen
import com.leoarmelin.learningchinese.viewmodels.NavigationViewModel
import com.leoarmelin.learningchinese.viewmodels.StrokeViewModel

@Composable
fun MainNavHost(
    modifier: Modifier,
    navigationViewModel: NavigationViewModel,
    strokeViewModel: StrokeViewModel
) {
    val navController = rememberNavController()

    Box(modifier = modifier) {
        NavHost(navController = navController, startDestination = MainNavRoutes.Home.routeName) {
            composable(MainNavRoutes.Home.routeName) {
                HomeScreen(navigationViewModel, strokeViewModel)
            }
            composable(MainNavRoutes.Match.routeName) {
                strokeViewModel.getRandomMatchList(
                    strokeViewModel.selectedStroke ?: throw Exception("Stroke should exist")
                )
                MatchScreen(navigationViewModel, strokeViewModel)
            }
        }
    }

    navController.navigate(navigationViewModel.currentRoute)
}