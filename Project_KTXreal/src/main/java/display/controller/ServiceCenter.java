package display.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceCenter {
	private final String command = "/serviceCenter.dis";
	private final String getPage = "serviceCenter";
	
	@RequestMapping(value=command)
	public String login() {
		return getPage;
	}
}
