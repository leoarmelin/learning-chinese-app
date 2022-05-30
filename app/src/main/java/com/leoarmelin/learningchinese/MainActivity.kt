package com.leoarmelin.learningchinese

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.leoarmelin.learningchinese.navigation.MainNavHost
import com.leoarmelin.learningchinese.ui.components.ConfigureApp
import com.leoarmelin.learningchinese.viewmodels.NavigationViewModel
import com.leoarmelin.learningchinese.viewmodels.StrokeViewModel
import java.util.*

class MainActivity : ComponentActivity(), TextToSpeech.OnInitListener {
    private var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val strokeViewModel = StrokeViewModel()
        val navigationViewModel = NavigationViewModel()

        textToSpeech = TextToSpeech(this, this)

        setContent {
            val systemUiController = rememberSystemUiController()

            ConfigureApp(uiController = systemUiController)
            MainNavHost(Modifier.fillMaxSize(), navigationViewModel, strokeViewModel)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = textToSpeech?.setLanguage(Locale.SIMPLIFIED_CHINESE)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TextToSpeech","The Language not supported!")
            }
        }
    }

    override fun onDestroy() {
        if (textToSpeech != null) {
            textToSpeech?.stop()
            textToSpeech?.shutdown()
        }

        super.onDestroy()
    }

    fun readText(text: String) {
        if (textToSpeech == null) return

        textToSpeech?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }
}