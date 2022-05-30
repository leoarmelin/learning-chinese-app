package com.leoarmelin.learningchinese.mockdata

import com.leoarmelin.learningchinese.models.strokes.Stroke

object MockStroke {
    fun getStrokeList(): List<Stroke> {
        return listOf(
            Stroke(
                character = "高",
                pinyin = "gāo",
                meanings = listOf("tall", "high", "high place")
            ),
            Stroke(
                character = "中",
                pinyin = "zhōng",
                meanings = listOf("middle", "center", "medium", "intermediary")
            ),
            Stroke(
                character = "日",
                pinyin = "rì",
                meanings = listOf("sun", "day", "time")
            ),
            Stroke(
                character = "山",
                pinyin = "shān",
                meanings = listOf("mountain", "hill")
            ),
            Stroke(
                character = "水",
                pinyin = "shuǐ",
                meanings = listOf("water", "river")
            ),
            Stroke(
                character = "火",
                pinyin = "huǒ",
                meanings = listOf("fire")
            ),
            Stroke(
                character = "木",
                pinyin = "mù",
                meanings = listOf("tree, wood")
            ),
            Stroke(
                character = "国",
                pinyin = "guó",
                meanings = listOf("country", "nation", "state")
            ),
            Stroke(
                character = "昨",
                pinyin = "zuó",
                meanings = listOf("yesterday")
            ),
            Stroke(
                character = "看",
                pinyin = "kàn",
                meanings = listOf("to see", "to look at", "to read", "to watch", "to visit")
            ),
            Stroke(
                character = "下",
                pinyin = "xià",
                meanings = listOf("down", "downwards", "below", "lower")
            ),
        )
    }
}