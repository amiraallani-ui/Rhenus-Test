package com.rhenus.rest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rhenus.rest.controller.InputController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InputControllerTest {

	private static final String NULL_ERROR_MESSAGE = "Please add '?input=value' parameter to your request";
	private static final String NOT_A_NUMBER_ERROR_MESSAGE = "Please add '?input=value' parameter to your request";

	
	@MockBean
	private InputController controller;

	@Test
	public void test_getResultFromNumber_whenInputIsNull() {
		try {
			controller.getResultFromNumber(null);
		} catch (Exception e) {
			assertTrue(NULL_ERROR_MESSAGE.equals(e.getMessage()));
		}
	}

	
	@Test
	public void test_getResultFromNumber_whenInputNotNumber() {
		try {
			controller.getResultFromNumber("2ddx");
		} catch (Exception e) {
			assertTrue(NOT_A_NUMBER_ERROR_MESSAGE.equals(e.getMessage()));
		}
	}

	@Test
	public void test_getResultFromNumber_whenInputIsNumber() {
		try {
			final ArrayList<String> result = controller.getResultFromNumber("6");
			assertTrue(result.get(0).equals("5 Buzz"));
			
		} catch (Exception e) {
			
		}
	}
	
}
