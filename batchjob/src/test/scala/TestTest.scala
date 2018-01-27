import org.scalatest.FunSpec

class SetSpec extends FunSpec {

  it("should pass with no reason") {
    assert("reason" == "reason")
  }

  it("should fail with no reason") {
    assert("reason" == "no")
  }
}