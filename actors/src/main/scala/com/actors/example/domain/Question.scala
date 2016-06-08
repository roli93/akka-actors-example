package com.actors.example.domain

/**
  * Created by roli on 08/06/16.
  */
trait Question

case class MathsQuestion(val value:String) extends Question
case class LanguageQuestion(val value:String) extends Question
