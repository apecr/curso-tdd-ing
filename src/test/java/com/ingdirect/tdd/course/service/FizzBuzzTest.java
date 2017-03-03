package com.ingdirect.tdd.course.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ingdirect.tdd.course.dao.FizzBuzzDao;

//write a program that prints numbers from 1 to 100. But for multiples of three prints "Fizz"
//instead of the number and for the multiples of five prints "Buzz". For numbers wich are multiples of both
//three and five prints "FizzBuzz"
//

//You have a DAO with two methods:
//getStringWhenThreeNumber
//getStringWhenFiveNumber

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {

	private static final String BUZZ = "Buzz";
	private static final String FIZZ = "Fizz";
	@InjectMocks
	private FizzBuzz fizzBuzz;
	@Mock
	private FizzBuzzDao fizzDao;

	@Test
	public void notNull() {
		assertNotNull(this.fizzBuzz);
	}

	@Test
	public void returnOneWhenNumber1() {
		// Given
		// When
		String number = this.fizzBuzz.getNumberFizzBuzz(1);
		// Then
		assertEquals("1", number);
	}

	@Test
	public void returnTwoWhenNumber2() {
		// Given
		// When
		String number = this.fizzBuzz.getNumberFizzBuzz(2);
		// Then
		assertEquals("2", number);
	}

	@Test
	public void returnFizzWhenNumber3() {
		// Given
		// When
		when(this.fizzDao.getStringWhenThreeNumber()).thenReturn(FIZZ);
		String number = this.fizzBuzz.getNumberFizzBuzz(3);
		// Then
		verify(this.fizzDao).getStringWhenThreeNumber();
		assertEquals(FIZZ, number);
	}
	
	@Test
	public void returnBuzzWhenNumber5() {
		// Given
		// When
		when(this.fizzDao.getStringWhenFiveNumber()).thenReturn(BUZZ);
		String number = this.fizzBuzz.getNumberFizzBuzz(5);
		// Then
		verify(this.fizzDao).getStringWhenFiveNumber();
		assertEquals(BUZZ, number);
	}
	
	@Test
	public void returnFizzBuzzWhenNumber15() {
		// Given
		// When
		when(this.fizzDao.getStringWhenThreeNumber()).thenReturn(FIZZ);
		when(this.fizzDao.getStringWhenFiveNumber()).thenReturn(BUZZ);
		String number = this.fizzBuzz.getNumberFizzBuzz(15);
		// Then
		//verify(this.fizzDao).getStringWhenFiveNumber();
		assertEquals(FIZZ+BUZZ, number);
	}
	
	@Test
	public void returnFizzBuzzWhenNumber45() {
		// Given
		// When
		when(this.fizzDao.getStringWhenThreeNumber()).thenReturn(FIZZ);
		when(this.fizzDao.getStringWhenFiveNumber()).thenReturn(BUZZ);
		String number = this.fizzBuzz.getNumberFizzBuzz(45);
		// Then
		//verify(this.fizzDao).getStringWhenFiveNumber();
		assertEquals(FIZZ+BUZZ, number);
	}

}
