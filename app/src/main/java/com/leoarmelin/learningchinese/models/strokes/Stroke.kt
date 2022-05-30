package com.leoarmelin.learningchinese.models.strokes

data class Stroke(
    val character: String,
    val pinyin: String,
    val meanings: List<String>,
)
