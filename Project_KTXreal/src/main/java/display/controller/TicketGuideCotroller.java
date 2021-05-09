package display.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketGuideCotroller {
	private final String command = "/승차권이용안내.dis";
	private final String getPage = "승차권이용안내";
	
	@RequestMapping(value=command)
	public String TicketGuide() {
		return getPage;
	}
}




