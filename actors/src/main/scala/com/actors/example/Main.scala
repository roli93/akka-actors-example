package com.actors.example


import akka.actor.{Props, ActorSystem}
import akka.util.Timeout
import com.actors.example.actors.TeacherActor.{AskQuestion, CorrectHomework}
import com.actors.example.actors._
import akka.pattern.ask
import com.actors.example.domain._
import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success}
import java.util.concurrent.TimeUnit


/**
  * Created by roli on 08/06/16.
  */

object Main extends App{

  override def main(args: Array[String]) {
    println("Teachers Working...")

    val as = ActorSystem("teachers")
    implicit val ec = as.dispatcher
    implicit val timeOut: Timeout = FiniteDuration(5, TimeUnit.SECONDS)

    val sumQuestion = new MathsQuestion("How much is 2+2?")
    val differentialQuestion = new MathsQuestion("How much d(2x)/dx?")

    val spellingQuestion = new LanguageQuestion("How d'ypu spell 'hello'?")
    val grammarQuestion = new LanguageQuestion("Is 'People' a plural or a singuar noun?")

    val mathAnswers = Map(sumQuestion -> "It's 4", differentialQuestion -> "It's 2")
    val langAnswers = Map(spellingQuestion -> "H-E-L-L-O", grammarQuestion -> "It's both, depending on the context")

    val mathsTeacher = as.actorOf(Props(new TeacherActor[MathsQuestion](mathAnswers) with MathsTeacher), "mathsTeacher")

    mathsTeacher ? CorrectHomework("lalalal") onComplete {
      case Success(feedback) => println("And so... I " + feedback)
      case Failure(error) => println("Couldn't finish correcting homework due to:" + error.getMessage)
    }

    mathsTeacher ? CorrectHomework("l") onComplete {
      case Success(feedback) => println("And so... I " + feedback)
      case Failure(error) => println("Couldn't finish correcting homework due to:" + error.getMessage)
    }

    mathsTeacher ? AskQuestion(sumQuestion) onComplete {
      case Success(feedback) => println("The teacher said: " + feedback)
      case Failure(error) => println("The teacher couldn't answer, he just said: " + error.getMessage)
    }

    mathsTeacher ? AskQuestion(grammarQuestion) onComplete {
      case Success(feedback) => println("The teacher said: " + feedback)
      case Failure(error) => println("The teacher couldn't answer, he just said: " + error.getMessage)
    }

    mathsTeacher ? AskQuestion(MathsQuestion("What's the integral of e^(x^2)")) onComplete {
      case Success(feedback) => println("The teacher said: " + feedback)
      case Failure(error) => println("The teacher couldn't answer, he just said: " + error.getMessage)
    }
  }
}