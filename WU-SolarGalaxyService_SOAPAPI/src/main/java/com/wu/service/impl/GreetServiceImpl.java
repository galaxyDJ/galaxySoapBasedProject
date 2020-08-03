
package com.wu.service.impl;

import java.util.Date;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Service;

import com.wu.service.play.GreetService;
import com.wu.solargalaxyservice.galaxy.ObjectFactory;

@Service
public class GreetServiceImpl implements GreetService {

	@Override
	public JAXBElement<String> greet() {

		Date date = new Date();

		int day = date.getDay() + 1;

		String message;

		switch (day) {

		case 1:
			message = "Sunday";
			break;

		case 2:
			message = "Monday";
			break;

		case 3:
			message = "Tuesday";
			break;

		case 4:
			message = "Wenesday";
			break;

		case 5:
			message = "Thursday";
			break;

		case 6:
			message = "Friday";
			break;
		case 7:
			message = "Saturday";
			break;

		default:
			message = "Holiday";

		}

		ObjectFactory factory = new ObjectFactory();

		JAXBElement<String> greetMessage = factory.createGetGreetResponse("Welcome to " + message + "'s Solar Galaxy Online Shopping");

		return greetMessage;

	}

}
