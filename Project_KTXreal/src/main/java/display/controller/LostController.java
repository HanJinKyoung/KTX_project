package display.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LostController {
	private final String command = "/lost.dis";
	private final String getPage = "lost";
	
	@RequestMapping(value=command)
	public String lost() {
		return getPage;
	}
}
