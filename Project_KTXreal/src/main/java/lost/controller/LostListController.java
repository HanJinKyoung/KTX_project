package lost.controller;
	
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lost.model.LostBean;
import lost.model.LostDao;
import utility.Paging;

@Controller
public class LostListController {
	private final String command = "/lostlist.lt";
	private final String getPage = "lostList";
	
	@Autowired
	private LostDao lostDao;
		
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView lostAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request) {
			
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		int totalCount = lostDao.getTotalCount(map);
		
		String url = request.getContextPath() + command; 
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		List<LostBean> lostLists = lostDao.getDataList(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lostLists", lostLists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
	}
}


	
	
	
	
	
	
	


