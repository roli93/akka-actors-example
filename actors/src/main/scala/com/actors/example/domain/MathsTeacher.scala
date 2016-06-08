package com.actors.example.domain

/**
  * Created by roli on 08/06/16.
  */

trait MathsTeacher extends Teacher[MathsQuestion]{

  override def giveAnswerToQuestion(question:Question) = question match {
    case question:MathsQuestion => (answers withDefaultValue("It's indeterminate"))(question)
    case _ => yellForIgnorance
  }
}