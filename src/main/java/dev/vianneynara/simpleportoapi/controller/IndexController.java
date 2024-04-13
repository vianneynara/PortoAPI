package dev.vianneynara.simpleportoapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * This class handles the root URL of the API (/).
 * */
@Controller
public class IndexController {
	/**
	 * Index method returns the API status, whether it is running or not and a greeting message.
	 * Returns a static html page.
	 * */
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.html");
		return modelAndView;
	}
}
