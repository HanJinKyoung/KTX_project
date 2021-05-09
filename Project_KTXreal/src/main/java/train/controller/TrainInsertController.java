package train.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import train.model.RaceBean;
import train.model.TrainBean;
import train.model.TrainDao;

@Controller
public class TrainInsertController {
	private final String command = "/insert.tr";
	private final String getPage = "train";
	
	@Autowired
	private TrainDao tdao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String goGet(){
			return getPage;
	}

	@RequestMapping(value = "/insertTrain.tr", method = RequestMethod.POST)
	public String train(
			TrainBean train,
			HttpServletResponse response
			) throws IOException {
		
		String t_way1 = train.getT_way1();
		String t_way2 = train.getT_way2();
		train.setT_way(t_way1+t_way2);
		int cnt = tdao.insertTrain(train);
		System.out.println("train cnt:"+cnt);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		if(cnt>0) {
			System.out.println("열차정보 삽입성공");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('열차정보가 등록되었습니다')");
			pw.print("</script>");
			pw.flush();
		}else {
			System.out.println("열차정보 삽입실패");
			pw.print("<script type='text/javascript'>");
			pw.print("alert('실패:기존 열차번호와 동일합니다')");
			pw.print("</script>");
			pw.flush();
		}
		return getPage;
	}
	
	@RequestMapping(value = "/insertRace.tr", method = RequestMethod.POST)
	public String race(
			RaceBean race,
			HttpServletResponse response
			) throws IOException {

		int precnt = tdao.getTnum(race.getT_num());
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		if(precnt<1) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('일치하는 열차번호가 없습니다')");
			pw.print("</script>");
			pw.flush();
			return getPage;
		} else {

			int cnt2 = tdao.getRinfo(race);
			if(cnt2>0) {
				pw.print("<script type='text/javascript'>");
				pw.print("alert('이미 동일한 경로가 있습니다')");
				pw.print("</script>");
				pw.flush();
				return getPage;
			}
			
			int cnt = tdao.insertRace(race);
			System.out.println("race cnt:"+cnt);
			
			if(cnt>0) {
				System.out.println("운행정보 삽입성공");
				pw.print("<script type='text/javascript'>");
				pw.print("alert('운행정보 등록되었습니다')");
				pw.print("</script>");
				pw.flush();
			}else {
				System.out.println("운행정보 삽입실패");
				pw.print("<script type='text/javascript'>");
				pw.print("alert('실패:열차번호가 없습니다')");
				pw.print("</script>");
				pw.flush();
			}
		}
		
		return getPage;
	}
}
