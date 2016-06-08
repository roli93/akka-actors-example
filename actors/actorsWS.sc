
import java.util.concurrent.TimeUnit
import akka.actor.{Props, ActorSystem}
import akka.pattern.ask
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}
import com.actors.example.actors._

println("tttaaa")

val as = ActorSystem("teachers")
implicit val ec = as.dispatcher

val mainActor = as.actorOf(Props(new TeacherActor[MathsQuestion](Map()) with MathsTeacher), "mainActor")
