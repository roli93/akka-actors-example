package com.actors.example.domain

import com.actors.example.types._

import scala.concurrent.{ExecutionContext, Future}

/**
  * Created by roli on 08/06/16.
  */
trait School {
  var passed: Int = 0
  var failed: Int = 0

  def checkHomeworkResults(teacherFeedback: TeacherFeedback) = teacherFeedback match{
    case Passed => passed += 1
    case Failed => failed += 1
  }

  def passingPercentage: Double = passed/(passed+failed)

}
