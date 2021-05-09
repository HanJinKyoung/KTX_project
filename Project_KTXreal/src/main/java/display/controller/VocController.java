package display.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VocController {
	private final String command = "/voc.dis";
	private final String getPage = "고객의소리";
	
	@RequestMapping(value=command)
	public String login() {
		return getPage;
	}
}
