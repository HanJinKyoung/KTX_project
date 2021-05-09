package display.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreditController {
	private final String command = "/credit.dis";
	private final String getPage = "credit";
	
	@RequestMapping(command)
	public String doCredit() {
		return getPage;
	}
}
