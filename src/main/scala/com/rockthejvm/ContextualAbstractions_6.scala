package com.rockthejvm

object ContextualAbstractions_6 {
	/*
		1 - context parameters/arguments
	 */
	val aList = List(2, 1, 3, 4)
	val anOrderedList = aList.sorted // contextual argument: (descendingOrdering)
	
	// Ordering
	given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) // (a, b) => a > b
	
	// analogous to an implicit
	
	trait Combinator[A] { // monoid
		def combine(a: A, y: A): A
	}
	
	def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
		list.reduce(combinator.combine)
	
	given intCombinator: Combinator[Int] = new Combinator[Int] {
		override def combine(x: Int, y: Int) = x + y
	}
	val theSum = combineAll(aList) // (intCombinator)
	
	/*
		Given places
		- local scope
		- imported scope
		- the companions of all the types involved in the method call
			- the companion of list and int
	*/
	
	// context bounds
	def combineAll_v2[A](list: List[A])(using Combinator[A]): A = {
		def foo[A](l: List[A])(using c: Combinator[A]): A = l.reduce(c.combine)
		foo(list)
	}
	def combineAll_v3[A: Combinator](list: List[A]): A = {
		def foo[A](l: List[A])(using c: Combinator[A]): A = l.reduce(c.combine)
		foo(list)
	}
	
	/*
		where context args are useful
		- type classes
		- dependency injection
    	- context-dependant functionality
		- type-level programming
	*/
	
	/*
		2 - extension methods
	*/
	
	case class Person(name: String) {
		def greet(): String = s"Hi my name is $name, I love Scala"
	}
	
	extension (string: String)
		def greet(): String = new Person(string).greet()
	
	val danielsGreeting = "Daniel".greet() // "type enrichment"
	
	// POWER
	extension [A] (list: List[A])
		def combineAllValues(using combinator: Combinator[A]): A =
			list.reduce(combinator.combine)
		
	val theSum_v2 = aList.combineAllValues
	
	def main(args: Array[String]): Unit = {
		println(anOrderedList)
		println(theSum_v2)
		
		(1 to 100).foreach { e =>
			if(e % 3 == 0 && e % 5 == 0) println("fizzbuzz")
			else if(e % 5 == 0) println("fizz")
			else if(e % 3 == 0) println("buzz")
			else println(s"$e")
		}
	}
}
