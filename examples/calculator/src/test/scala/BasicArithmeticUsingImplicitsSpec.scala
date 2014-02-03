
import org.scalatest.{ShouldMatchers, FunSpec}
import com.timgroup.test.narrative._
import com.timgroup.test.narrative.Implicits._

class BasicArithmeticWithImplicitsSpec extends FunSpec with ShouldMatchers {

  describe("the calculator") {

    it("can add two numbers") {

      val operator = new CalculatorActor

      Given.the(operator).was_able_to(press('2'))
                         .was_able_to(press('+'))
                         .was_able_to(press('2'))

      When.the(operator).attempts_to(press('='))

      Then.the(operator).expects_that(the_displayed_value)(_ should be("4"))
                        .and_that(the_displayed_value)(_ should be ("5"))
    }

    it("can subtract two numbers") {

      val operator = new CalculatorActor

      Given.the(operator).was_able_to(press('3'))
                         .was_able_to(press('-'))
                         .was_able_to(press('1'))

      When.the(operator).attempts_to(press('='))

      Then.the(operator).expects_that(the_displayed_value)(_ should be("2"))
    }
  }

  def press(keypress: Char) = (_: CalculatorActor).tool().press(keypress)
  def the_displayed_value   = (_: CalculatorActor).tool().read()
}
