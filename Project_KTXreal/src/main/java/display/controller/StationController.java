	package display.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class StationController {
		private final String command = "/기차역안내.dis";
		private final String getPage = "기차역안내";
		
		@RequestMapping(value=command)
		public String station() {
			return getPage;
		}
	}


