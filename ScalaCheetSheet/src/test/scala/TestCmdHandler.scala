import org.scalatest.FunSuite
/**
 * Created with IntelliJ IDEA.
 * User: yf_liu
 * Date: 2015/1/22
 * Time: 17:59
 */
class TestCmdHandler extends FunSuite {
  test("Test cmd ls with 3 args") {
    val result = CmdHandler(Seq("ls", "dirA", "dirB", "dirC"))
    assert(result.isSuccess)
    assert(result.get == "List files in directory: dirA dirB dirC")
  }
}
