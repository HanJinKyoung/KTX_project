package admin.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import admin.model.AdminDao;
import admin.model.CheckBean;
import utility.Paging;

@Controller
public class CheckListController {
	private final String command = "checklist.ad";
	private final String getPage = "checklist";
	
	
	@Autowired
	private AdminDao aDao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doGet(HttpSession session,Model model,
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request
			) {
		int num = (Integer)session.getAttribute("m_num");
		
		String snum = String.valueOf(num);
		List<CheckBean> clist = aDao.numCheckList(num);
		int cnt = aDao.prePost(num);
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); 
		map.put("keyword", keyword);
		map.put("m_num", snum);

		int totalCount = aDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		
		model.addAttribute("clist", clist);
		model.addAttribute("cnt", cnt);
		model.addAttribute("pageInfo", pageInfo);
		return getPage;
	}
	
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doPost(HttpSession session,
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword1",required = false) String keyword1,
			@RequestParam(value="keyword2",required = false) String keyword2,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request) {
		int num2 = (Integer)session.getAttribute("m_num");
		String num = String.valueOf(num2);
		
		int year = Integer.parseInt(keyword1);
		int month = Integer.parseInt(keyword2);
		int day = 1;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(year,month-1,day);
		int maxday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		String keywd1 = keyword1+keyword2+"0"+day;
		String keywd2 = keyword1+keyword2+maxday;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); 
		map.put("keyword1", keywd1);
		map.put("keyword2", keywd2);
		map.put("m_num", num);

		
		int totalCount = aDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keywd2);
		
		ModelAndView mav = new ModelAndView();
		
		List<CheckBean> clist = aDao.getCheckList(pageInfo,map);
		int cnt = aDao.dayCount(map);
		
		mav.addObject("clist", clist);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("cnt", cnt);
		mav.setViewName(getPage);
		return mav;
	}
	
}
