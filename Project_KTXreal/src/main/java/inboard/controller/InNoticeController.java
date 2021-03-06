package inboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import inboard.model.InBoardBean;
import inboard.model.InBoardDao;
import utility.Paging;

@Controller
public class InNoticeController {
	private final String command = "innotice.ib";
	private final String getPage = "Innotice";
	
	@Autowired
	private InBoardDao ibdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		int totalCount = ibdao.getTotalCount(map);
		
		String url = request.getContextPath() + command; 
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);        
		
		List<InBoardBean> inlists = ibdao.getDataList(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("inlists", inlists);
		mav.addObject("pageInfo", pageInfo);		
		mav.setViewName(getPage);
		return mav;   
	}
}
