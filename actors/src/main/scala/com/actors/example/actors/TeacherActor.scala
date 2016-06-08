package com.actors.example.actors

import akka.actor.Actor
import com.actors.example.types._
import scala.concurrent.{Future, ExecutionContext}
import akka.pattern.pipe
import com.actors.example.domain._

/**
  * Created by roli on 08/06/16.
  */


object TeacherActor{
  case class CorrectHomework(homework: Homework)
  case class AskQuestion(question:Question)
  case object Leave
}

class TeacherActor[SubjectQuestion <: Question](val answers:Map[SubjectQuestion,Answer])(implicit val ec: ExecutionContext) extends Actor{
  this: Teacher[SubjectQuestion] =>

  import TeacherActor._
  override def receive: Receive = {
    case CorrectHomework(homework) => correctHomework(homework) pipeTo sender
    case AskQuestion(question) => answerQuestion(question) pipeTo sender
  }
}

