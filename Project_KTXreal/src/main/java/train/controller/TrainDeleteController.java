package train.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import train.model.TrainBean;
import train.model.TrainDao;
import utility.Paging;

@Controller
public class TrainDeleteController {
	private final String command = "/deleteTrain.tr";
	private final String getPage = "trainDelete";
	private final String delcommm = "deleteNum.tr";
	
	@Autowired
	private TrainDao tdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public ModelAndView doGet(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			@RequestParam(value="pageSize",required = false) String pageSize,
			HttpServletRequest request
			) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", keyword);
		
		int totalCount = tdao.allTrainCount(map);
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
		List<TrainBean> trainLists = tdao.allTrain(pageInfo,map);
		ModelAndView mav = new ModelAndView();
		mav.addObject("trainLists", trainLists);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value=delcommm, method=RequestMethod.GET)
	public String actionDel(
			@RequestParam(value="t_num",required=true) int t_num,
			HttpServletResponse response
			) throws IOException {
		System.out.println(t_num);
		int cnt  = tdao.delTnum(t_num);
		
		PrintWriter pw = response.getWriter(); 
		response.setContentType("text/html; charset=UTF-8");
		if(cnt>0) {
			pw.print("<script>");
			pw.print("alert('삭제 성공했습니다'); location.replace('deleteTrain.tr')");
			pw.print("</script>");
			pw.flush();
			return null;
		} else {
			pw.print("<script>");
			pw.print("alert('삭제 실패했습니다'); location.replace('deleteTrain.tr')");
			pw.print("</script>");
			pw.flush();
			return null;
		}
	}
}
