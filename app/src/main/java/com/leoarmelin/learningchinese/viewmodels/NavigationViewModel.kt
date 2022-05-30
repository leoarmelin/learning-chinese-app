package com.leoarmelin.learningchinese.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.leoarmelin.learningchinese.models.navigation.MainNavRoutes

class NavigationViewModel : ViewModel() {
    var currentRoute by mutableStateOf(MainNavRoutes.Home.routeName)

    fun setRoute(route: String) {
        currentRoute = route
    }
}