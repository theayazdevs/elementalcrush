package com.aa.elementalcrush

//model class for questions
data class Question (
    //class properties
    val questionTxt: String,
    val answers: List<String>,
    val correctAnswer: String
)
