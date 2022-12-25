package com.karaew.learning.crimenalintent

import java.util.Date
import java.util.UUID

data class Crime(
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var date: Date,
    var isSolved: Boolean
)