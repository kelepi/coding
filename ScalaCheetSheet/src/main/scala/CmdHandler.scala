import scala.util.{Success, Failure, Try}
/**
 * Created with IntelliJ IDEA.
 * User: yf_liu
 * Date: 2015/1/22
 * Time: 16:27
 */
object CmdHandler {
  val supportedCmds: Seq[String] = Seq("ls","rm","mkdir")

  def isValidCmd(s: String): Boolean = supportedCmds.exists(_ == s)

  def process(s: String, args: Seq[String]): Try[String] = {
    s match {
      case "ls" => Success("List files in directory: " + args.mkString(" "))
      case "rm" => Success("Remove files in directory: " + args.mkString(" "))
      case "mkdir" => Success("Make directory: " + args.mkString(" "))
      case _ => Failure(new IllegalArgumentException)
    }
  }

  def apply(seq: Seq[String]): Try[String] = {
    val cmd: String = seq.head
    if(isValidCmd(cmd))
      process(cmd, seq.tail)
    else
      Failure(new IllegalArgumentException)
  }
}
