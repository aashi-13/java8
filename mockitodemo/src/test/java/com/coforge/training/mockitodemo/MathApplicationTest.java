package com.coforge.training.mockitodemo;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MathApplicationTest {
	@InjectMocks //It is used to create and inject mock object
	MathApplication mathApplication;

	@Mock
	CalculatorService calcService;

	@BeforeEach
	void setUp() throws Exception {
		mathApplication = new MathApplication();
		MockitoAnnotations.initMocks(this);//to process the annotations
	}

	@Test
	void testAdd() {
	//add the behavior of calculator service to add two numbers
	when(calcService.add(10.0,20.0)).thenReturn(30.00);

	//test the add functionality
	assertEquals(mathApplication.add(10.0,20.0),30.0,0);

	//verify the behavior
	verify(calcService).add(10.0,20.0);
	System.out.println(verify(calcService).add(10.0,20.0));
	}



	@Test
	void testSubtract() {
	when(calcService.subtract(30.0,20.0)).thenReturn(10.00);

	//test the add functionality
	assertEquals(mathApplication.subtract(30.0,20.0),10.0,0);

	//verify the behavior
	verify(calcService).subtract(30.0,20.0);
	System.out.println(verify(calcService).subtract(30.0,20.0));
	}



	@Test
	void testMultiply() {
	when(calcService.multiply(30.0,20.0)).thenReturn(600.00);

	//test the add functionality
	assertEquals(mathApplication.multiply(30.0,20.0),600.0,0);

	//verify the behavior
	verify(calcService).multiply(30.0,20.0);
	System.out.println(verify(calcService).multiply(30.0,20.0));
	}



	@Test
	void testDivide() {
	when(calcService.divide(100.0,10.0)).thenReturn(10.00);

	//test the add functionality
	assertEquals(mathApplication.divide(100.0,10.0),10.0,0);

	//verify the behavior
	verify(calcService).divide(100.0,10.0);
	System.out.println(verify(calcService).divide(100.0,10.0));
	}
}
