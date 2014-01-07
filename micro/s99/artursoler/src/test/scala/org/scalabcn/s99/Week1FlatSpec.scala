package org.scalabcn.s99

import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.prop.PropertyChecks
import org.scalabcn.s99.Week1._

class Week1FlatSpec extends FlatSpec with Matchers with PropertyChecks {
  def p01[T](xs: List[T], result: T) =
    for(func <- Last.funcs[T])
      func(xs) should equal (result)

  "Last (solution 1)" should "return last element of list" in {
    forAll { (init: List[Int], last: Int) =>
      val complete = (last :: init).reverse
      p01(complete, last)
    }
  }

  def p02[T](xs: List[T], result: T) =
    for(func <- Penultimate.funcs[T])
      func(xs) should equal (result)

  "Penultimate (solution 2)" should "return the last but one element" in {
    forAll { (init: List[Int], penultimate: Int, last: Int) =>
      val complete = (last :: penultimate :: init).reverse
      p02(complete, penultimate)
    }
  }

  def p03[T](pos: Int, xs: List[T], result: T) =
    for(func <- Nth.funcs[T])
      func(pos, xs) should equal (result)

  "Nth (solution 3)" should "return the element at position n" in {
    forAll { (first: List[Int], second: List[Int], between: Int) =>
      val complete = first ::: (between :: second)
      p03(first.length, complete, between)
    }
  }

  def p04[T](xs: List[T], result: T) =
    for(func <- Length.funcs[T])
      func(xs) should equal (result)

  "Length (solution 4)" should "return the length of the list" in {
    forAll { (list: List[Int]) =>
      p04(list, list.length)
    }
  }

  def p05[T](xs: List[T], result: T) =
    for(func <- Reverse.funcs[T])
      func(xs) should equal (result)

  "Reverse (solution 5)" should "return the original list reversed" in {
    forAll { (list: List[Int]) =>
      p05(list, list.reverse)
    }
  }

}
