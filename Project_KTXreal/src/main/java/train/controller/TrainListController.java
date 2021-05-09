package train.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import train.model.RaceBean;
import train.model.TrainDao;
import utility.Paging;

@Controller
public class TrainListController {
	private final String command = "/trainlist.tr";
	private final String getPage = "trainlist";
	
	@Autowired
	private TrainDao tdao;
	
	@RequestMapping(command)
	public ModelAndView doGet(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request,
			HttpSession session,HttpServletResponse response
			) throws IOException {

		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", keyword);
		
		int totalCount = tdao.getTotalCount(map);
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		ModelAndView mav = new ModelAndView();
		List<RaceBean> trainLists = tdao.getTrainList(pageInfo,map);

		mav.addObject("trainLists", trainLists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;

		
	}
}
