package ticket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ticket.model.TicketDao;

@Controller
public class TicketPayController {
	private final String paytk = "/pay.tk";
	private final String canceltk = "/cancel.tk";
	private final String allpay = "allpay.tk";
	private final String alldel = "alldelete.tk";
	
	@Autowired
	private TicketDao kdao;
	
	@RequestMapping(value = paytk, method = RequestMethod.GET)
	public String dopay(
			@RequestParam("tk_num")String tk_num,
			HttpServletResponse response
			) throws IOException {
		System.out.println("tkpay:"+tk_num);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		int cnt = kdao.paytk(tk_num);
		if(cnt>0) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('결제가 완료되었습니다'); location.href='tklist.tk'");
			pw.print("</script>");
			pw.flush();
		}else {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('실패! 다시 시도해주세요'); history.go(-1);");
			pw.print("</script>");
			pw.flush();
		}
		return null;
	}
	@RequestMapping(value = canceltk, method = RequestMethod.GET)
	public String docancel(
			@RequestParam("tk_num")String tk_num,
			HttpServletResponse response
			) throws IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		int cnt = kdao.cancletk(tk_num);
		if(cnt>0) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('예매/결제가 취소되었습니다'); location.href='tklist.tk'");
			pw.print("</script>");
			pw.flush();
		}else {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('실패! 다시 시도해주세요'); history.go(-1);");
			pw.print("</script>");
			pw.flush();
		}
		return null;
	}
	
	@RequestMapping(value=allpay, method=RequestMethod.POST)
	public String allPay(
			@RequestParam("rowcheck1") String[] rowcheck1,
			HttpServletResponse response
			) throws IOException {
//		for(int i=0; i<rowcheck.length; i++) {
//			System.out.println(rowcheck[i]);
//		}
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		int cnt = kdao.allpay(rowcheck1);
		if(cnt>0) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('결제가 완료되었습니다'); location.href='tklist.tk'");
			pw.print("</script>");
			pw.flush();
		}else {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('실패! 다시 시도해주세요'); history.go(-1);");
			pw.print("</script>");
			pw.flush();
		}
		return null;
		
	}
	
	@RequestMapping(value=alldel, method=RequestMethod.POST)
	public String allDel(
			@RequestParam("rowcheck2") String[] rowcheck2,
			HttpServletResponse response
			) throws IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		int cnt = kdao.alldel(rowcheck2);
		if(cnt>0) {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('취소가 완료되었습니다'); location.href='tklist.tk'");
			pw.print("</script>");
			pw.flush();
		}else {
			pw.print("<script type='text/javascript'>");
			pw.print("alert('실패! 다시 시도해주세요'); history.go(-1);");
			pw.print("</script>");
			pw.flush();
		}
		
		return null;
	}
}
