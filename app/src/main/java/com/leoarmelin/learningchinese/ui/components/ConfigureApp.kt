package com.leoarmelin.learningchinese.ui.components

import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.SystemUiController
import com.leoarmelin.learningchinese.ui.ThemeColors

@Composable
fun ConfigureApp(
    uiController: SystemUiController
) {
    uiController.setStatusBarColor(
        color = ThemeColors.Background,
        darkIcons = false
    )
    uiController.setNavigationBarColor(
        color = ThemeColors.Background,
        navigationBarContrastEnforced = true
    )
}