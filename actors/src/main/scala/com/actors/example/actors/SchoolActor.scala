package com.actors.example.actors

import akka.actor.Actor
import com.actors.example.domain.{Teacher, Question}
import com.actors.example.types._
import com.actors.example.domain._
import scala.concurrent.ExecutionContext

/**
  * Created by roli on 08/06/16.
  */
object SchoolActor{
  case class CheckHomeworkResults(teacherFeedback: TeacherFeedback)
}

class SchoolActor(implicit val ec: ExecutionContext) extends Actor with School{

  import SchoolActor._
  override def receive: Receive = {
    case CheckHomeworkResults(teachingFeedback) => checkHomeworkResults(teachingFeedback)
  }
}