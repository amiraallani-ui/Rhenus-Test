package com.rhenus.rest.controller;

import java.util.ArrayList;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rhenus")
public class InputController {

	@GetMapping(produces = "application/json")
	public ArrayList<String> getResultFromNumber(@RequestParam(required = false) final String input) throws Exception {

		if (StringUtils.isEmpty(input)) {
			throw new Exception("Please add '?input=value' parameter to your request");
		}

		final ArrayList<String> result = new ArrayList<String>();
		try {
			int number = Integer.parseInt(input);
			for (int i = 1; i <= number; i++) {
				if (i % 15 == 0)
					result.add(i + " FizzBuzz");
				else if (i % 3 == 0)
					result.add(i + " Fizz");
				else if (i % 5 == 0)
					result.add(i + " Buzz");
				else
					result.add("" + i);
			}

		} catch (final Exception e) {
			throw new Exception("You should enter a number !!!", e);
		}

		return result;
	}

}
