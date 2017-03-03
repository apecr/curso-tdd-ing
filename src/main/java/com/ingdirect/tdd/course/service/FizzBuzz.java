package com.ingdirect.tdd.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ingdirect.tdd.course.dao.FizzBuzzDao;

@Component
public class FizzBuzz {

	@Autowired
	private FizzBuzzDao fizzBuzzDao;

	/**
	 * Devuelve el string correspondiente a la kata FizzBuzz
	 * 
	 * @param number
	 * @return String con el nombre correcto
	 */
	public String getNumberFizzBuzz(int number) {
		String outputNumberAsString = isNumberMultipleOfThree(number) ? this.fizzBuzzDao.getStringWhenThreeNumber()
				: "";
		outputNumberAsString = isNumberMultipleOfFive(number)
				? outputNumberAsString + this.fizzBuzzDao.getStringWhenFiveNumber()
				: outputNumberAsString;

		if ("".equals(outputNumberAsString)) {
			outputNumberAsString = String.valueOf(number);
		}
		return outputNumberAsString;
	}

	private boolean isNumberMultipleOfThree(int number) {
		return 0 == number % 3;
	}

	private boolean isNumberMultipleOfFive(int number) {
		return 0 == number % 5;
	}

}
