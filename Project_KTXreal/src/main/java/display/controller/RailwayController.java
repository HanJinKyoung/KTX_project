package display.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	
	@Controller
	public class RailwayController {
		private final String command = "/railway_rotue.dis";
		private final String getPage = "railway_rotue";
		
		@RequestMapping(value=command)
		public String railway_rotue() {
			return getPage;
		}
	}

