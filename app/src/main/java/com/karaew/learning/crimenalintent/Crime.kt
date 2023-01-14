package com.karaew.learning.crimenalintent

import java.text.DateFormat
import java.util.*

data class Crime(
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    var date: DateFormat = DateFormat.getDateInstance(),
    var isSolved: Boolean = false,
    var requarePolice:Boolean = false
)
