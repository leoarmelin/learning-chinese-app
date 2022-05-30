package com.leoarmelin.learningchinese

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.leoarmelin.learningchinese.navigation.MainNavHost
import com.leoarmelin.learningchinese.viewmodels.NavigationViewModel
import com.leoarmelin.learningchinese.viewmodels.StrokeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val strokeViewModel = StrokeViewModel()
        val navigationViewModel = NavigationViewModel()

        setContent {
            MainNavHost(Modifier.fillMaxSize(), navigationViewModel, strokeViewModel)
        }
    }
}