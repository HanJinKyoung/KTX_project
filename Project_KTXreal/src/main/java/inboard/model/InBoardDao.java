package inboard.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("MyInBoard")
public class InBoardDao {
	
	private String ns = "inboard.InBoardBean.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int writeIBoard(InBoardBean inboard) {
		int cnt = sqlSessionTemplate.insert(ns+"WriteIBoard", inboard);
		return cnt;
	}
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(ns+"GetTotalCount",map);
		return cnt;
	}
	
	public List<InBoardBean> getDataList(Paging pageInfo, Map<String, String> map) {
		List<InBoardBean> lists = new ArrayList<InBoardBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(ns+"GetDataList",map,rowBounds);
		return lists;
	}
	public InBoardBean selectI_num(int i_num) {
		InBoardBean inbean = sqlSessionTemplate.selectOne(ns+"SelectI_num",i_num);
		return inbean;
	} 
	
	public int deleteArticle(int i_num, String i_passwd) {
		InBoardBean inbean = new InBoardBean();
		inbean.setI_num(i_num);
		inbean.setI_passwd(i_passwd);
		int cnt = sqlSessionTemplate.delete(ns+"DeleteArticle",inbean);
		return cnt;
	}

	public int getArticleCount() {
		int cnt2 = sqlSessionTemplate.selectOne(ns+"GetArticleCount");
		return cnt2;
	}
	
	public void upCount(int i_num) {
		sqlSessionTemplate.update(ns+"UpreadCount",i_num);		
	}

	public InBoardBean getData(int i_num) {
		InBoardBean inbean = sqlSessionTemplate.selectOne(ns+"GetData",i_num);
		return inbean;
	}
	public int updateIBoard(InBoardBean inboard) {
		int cnt = sqlSessionTemplate.update(ns+"UpdateIBoard", inboard);
		return cnt;
	}
	public int noUpFile(InBoardBean inboard) {
		// TODO Auto-generated method stub
		int cnt = sqlSessionTemplate.update(ns+"noUpFile", inboard);
		return cnt;
	}
	public void upexist(InBoardBean inboard) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(ns+"UpExist",inboard);
	}
		
}
	

