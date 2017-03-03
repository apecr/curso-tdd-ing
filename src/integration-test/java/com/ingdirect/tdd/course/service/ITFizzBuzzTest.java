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


@RunWith(MockitoJUnitRunner.class)
public class ITFizzBuzzTest {

	private static final String BUZZ = "Buzz";
	@InjectMocks
	private FizzBuzz fizzBuzz;
	@Mock
	private FizzBuzzDao fizzDao;

	@Test
	public void notNull() {
		assertNotNull(this.fizzBuzz);
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
	

}
