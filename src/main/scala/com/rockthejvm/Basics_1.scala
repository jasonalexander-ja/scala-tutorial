package com.rockthejvm


object Basics_1 extends App {
	
	// Defining a value
	val meaningOfLife: Int = 42 // const int meaningOfLife = 42;
	
	// Int Boolean, Char, Float, String
	val aBoolean = false // type is optional
	
	val aString = "I love Scala"
	val aComposedString = "I" + " " + "love" + " " + "Scala"
	val anInterpolatedString = s"The meaning of life is $meaningOfLife"
	
	// expressions = structures that can be reduced to a value
	val anExpression = 2 + 3
	
	// if-expression
	val ifExpression = if (meaningOfLife > 43) 56 else 999
	val chainedIfExpression = {
		if (meaningOfLife > 43) 56
		else if (meaningOfLife < 0) -2
		else if (meaningOfLife > 999) 78
		else 4
	}
	
	val aCodeBlock = {
		val aLocalValue = 67
		
		// value of the entire block is the last expression of the code block
		aLocalValue + 3
	}
	
	def myFunction(x: Int = 5, y: String): String = {
		y + " " + x
	}
	
	myFunction(x = 5, y = "Hello")
	
	def factorial(n: Int): Int =
		if (n <= 1) 1
		else n * factorial(n - 1)
	
	/*
		factorial(5) = 5 * factorial(4) = 5 * 24
		factorial(4) = 4 * factorial(3) = 4 * 6
		factorial(3) = 3 * factorial(2) = 3 * 2
		factorial(2) = 2 * factorial(1) = 2 * 1
		factorial(1) = 1
	*/
	
	// In scala we don't use loops or iteration, we use RECURSION!
	
	// The Unit type
	
	// the Unit type = no meaningful value === "void" in other languages
	// type of SIDE EFFECTS
	println("I love Scala")
	
	def myUnitReturningFunction(): Unit = {
		println("I don't love returning Unit")
	}
	
	val theUnit: Unit = ()
}
