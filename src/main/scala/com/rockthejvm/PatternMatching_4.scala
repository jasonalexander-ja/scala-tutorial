package com.rockthejvm

object PatternMatching_4 extends App {
	
	// switch "expression"
	val anInteger = 55
	val order = anInteger match {
		case 1 => "first"
		case 1 => "second"
		case 1 => "third"
		case _ => anInteger + "th"
	}
	// PM is an EXPRESSION
	
	// Case class decomposition
	case class Person(name: String, age: Int)
	val bob = Person("Bob", 43) // Person.apply("Bob", 43)
	
	val personGreeting = bob match {
		case Person(n , a) => s"Hi my name is $n and I am $a years old"
		case _ => "Something else"
	}
	
	// deconstructing tuples
	val aTuple = ("Bon Jovi", "Rock")
	val bandDescription = aTuple match {
		case (band, genre) => s"$band, belongs to the genre $genre"
		case _ => "I don't what what your talking about"
	}
	
	// decomposing lists
	val aList = List(1, 2, 3)
	val aListDecomposition = aList match {
		case List(_, 2, _) => "List containing a 2 on its second position"
		case _ => "unknown list"
	}
	
	// if PM doesn't match anything, it will throw a MatchError
	// PM will try all cases in sequence
}
