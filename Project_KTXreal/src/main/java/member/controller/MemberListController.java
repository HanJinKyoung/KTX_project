package member.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberListController { //MemberRegisterController에서 옴
	private final String command = "/list.mem";
	private final String getPage = "memberList";
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam(value="m_grade",required = false) String grade,
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request) {
		
		Map<String, String> map = new HashMap<String, String>();		
		map.put("grade", grade); 
		map.put("whatColumn", whatColumn); 
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = memberDao.getTotalCount(map);
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		List<MemberBean> memberLists = memberDao.getMemberList(pageInfo,map);
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberLists", memberLists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
	}
}

