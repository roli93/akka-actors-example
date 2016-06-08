package com.actors.example

/**
  * Created by roli on 08/06/16.
  */

object types {
  type Homework = String
  type Answer = String
  trait TeacherFeedback
  case object Passed extends TeacherFeedback{override def toString = "Passed! :D"}
  case object Failed extends TeacherFeedback{override def toString = "Failed :("}
}
