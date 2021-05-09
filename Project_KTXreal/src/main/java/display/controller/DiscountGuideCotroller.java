package display.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiscountGuideCotroller {
	private final String command = "/할인안내.dis";
	private final String getPage = "할인안내";
	
	@RequestMapping(value=command)
	public String DiscountGuide() {
		return getPage;
	}
}
	
	
	

