package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

import scala.concurrent.ExecutionContext.Implicits.global

object Advanced_5 extends App {
	
	// lazy evaluation
	lazy val aLazyVal = 2
	lazy val lazyValueWithSideEffect = {
		println("I am so very lazy!")
		43
	}
	
	val eagerValue = lazyValueWithSideEffect + 1
	// useful in infinite collections
	
	// "pseudo-collections": Option, Try
	def methodWhichCanReturnNull(): String = "hello, Scala"
	// option = "collection" which contains at most one element: Some(value) or None
	val anOption = Option(methodWhichCanReturnNull()) // Some("hello, scala")
	
	val stringProcessing = anOption match {
		case Some(string) => s"I have obtained a valid string: $string"
		case None => "I obtained nothing"
	}
	// map, flatMap, filter
	
	def methodWhichCanThrowException(): String = throw new RuntimeException
	val aTry = Try(methodWhichCanReturnNull())
	// a try = "collection" with either a value is the code went well, or an exception if the code threw one
	
	val anotherStringProcessing = aTry match {
		case Success(valid) => s"I have obtained a valid string: $valid"
		case Failure(ex) => s"I have obtained an exception: $ex"
	}
	// map, flatMap, filter
	
	/*
		Evaluate something on another thread
		(asynchronous programming)
	 */
	val aFuture = Future { // Future.apply
		println("Loading...")
		Thread.sleep(1000)
		println("I have computed a value")
		67
	}
	
	// future is a "collection" which contains a value when it's evaluating
	// future is composable with map, flatMap and filter
	// monads
	
	/*
		Implicits
	 */
	// #1: Implicit arguments
	def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
	implicit val myImplicitInt: Int = 46
	println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)
	
	// #2: implicit conversion
	implicit class MyRichInteger(n: Int) {
		def isEven() = n % 2 == 0
	}
	println(23.isEven())
}
