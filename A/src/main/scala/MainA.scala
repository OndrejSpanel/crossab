import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object MainA extends App{
  val f  = Future {}
  // Scala 2.11 specific code
  f.transform(ok => ok, err => err)
  println("I am A")
  Common.common()
}
