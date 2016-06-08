package com.actors.example.domain

/**
  * Created by roli on 08/06/16.
  */

trait LanguageTeacher extends Teacher[LanguageQuestion]{

  override def giveAnswerToQuestion(question:Question) = question match {
    case question:LanguageQuestion => (answers withDefaultValue("Well, it's subjective..."))(question)
    case _ => yellForIgnorance
  }
}