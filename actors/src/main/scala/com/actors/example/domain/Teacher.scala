package com.actors.example.domain

import com.actors.example.types._

import scala.concurrent.{Future, ExecutionContext}

/**
  * Created by roli on 08/06/16.
  */

trait Teacher[SubjectQuestion <: Question]{

  val answers: Map[SubjectQuestion,String]

  def correctHomework(homework: Homework)(implicit ec: ExecutionContext) :Future[TeacherFeedback] =Future{
    println("Wow! I've got a lot to correct")
    Thread.sleep(5000)
    val mark = (homework.length % 10)
    println("At last! I've finished! You've got a " + mark + "!")
    if(mark>3) Passed else Failed
  }

  def answerQuestion(question: Question)(implicit ec: ExecutionContext): Future[Answer] = Future{
    println("Mmm... let me think...")
    Thread.sleep(5000)
    giveAnswerToQuestion(question)
  }

  def giveAnswerToQuestion(question: Question): Answer

  protected def yellForIgnorance: Nothing = throw new RuntimeException("I can't answer that!")
}