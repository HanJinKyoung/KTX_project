package voc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import voc.model.VocBean;
import voc.model.VocDao;
import utility.Paging;


@Controller
public class VocListController {

      
   private final String command = "/voclist.vd";
   private final String getPage = "voclist";
   
   @Autowired
   private VocDao vdao;
   
   @RequestMapping(value=command)
   public String doAction(
         @RequestParam(value="whatColumn",required = false) String whatColumn,
         @RequestParam(value="keyword",required = false) String keyword,
         @RequestParam(value="pageNumber",required = false) String pageNumber,
         @RequestParam(value="pageSize",required = false) String pageSize,
         HttpServletRequest request,
         HttpSession session,
         Model model
       ) {
	   String m_id = (String)session.getAttribute("m_id");
		if(m_id == null) {
			session.setAttribute("destination", "redirect:/voclist.vd");
			return "redirect:/login.mem";
		}else {
			
      Map<String,String> map = new HashMap<String,String>();
      map.put("whatColumn", whatColumn);
      map.put("keyword", "%"+keyword+"%");
      map.put("m_id", m_id);
      int totalCount = vdao.getTotalCount(map);
      
      String url = request.getContextPath() + command; 
      Paging pageInfo = new Paging(pageNumber, pageSize, totalCount, url, whatColumn, keyword);
      
      List<VocBean> lists = vdao.getDataList(pageInfo,map);
      model.addAttribute("lists", lists);
      model.addAttribute("pageInfo", pageInfo);
      return getPage;
		}
   }
}