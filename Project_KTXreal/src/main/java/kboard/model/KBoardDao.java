package kboard.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("MyKBoard")
public class KBoardDao {
	
	private String ns = "kboard.KBoardBean.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void writeKBoard(KBoardBean kboard) {
		sqlSessionTemplate.insert(ns+"WriteKBoard", kboard);
	}
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(ns+"GetTotalCount",map);
		return cnt;
	}
	
	public List<KBoardBean> getDataList(Paging pageInfo, Map<String, String> map) {
		List<KBoardBean> lists = new ArrayList<KBoardBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(ns+"GetDataList",map,rowBounds);
		return lists;
	}
	public KBoardBean selectK_num(int k_num) {
		KBoardBean kbbean = sqlSessionTemplate.selectOne(ns+"SelectK_num",k_num);
		return kbbean;
	} 
	
	public int deleteArticle(int k_num, String k_passwd) {
		KBoardBean kbbean = new KBoardBean();
		kbbean.setK_num(k_num);
		kbbean.setK_passwd(k_passwd);
		int cnt = sqlSessionTemplate.delete(ns+"DeleteArticle",kbbean);
		return cnt;
	}

	public int getArticleCount() {

		int cnt2 = sqlSessionTemplate.selectOne(ns+"GetArticleCount");
		return cnt2;
	}
	
	public void upCount(int k_num) {
		sqlSessionTemplate.update(ns+"UpreadCount",k_num);		
	}

	public KBoardBean getData(int k_num) {
		KBoardBean kbbean = sqlSessionTemplate.selectOne(ns+"GetData",k_num);
		return kbbean;
	}
	public int updateKBoard(KBoardBean kboard) {
		int cnt = sqlSessionTemplate.update(ns+"UpdateKBoard", kboard);
		return cnt;
	}
	public List<KBoardBean> getmainklist() {
		List<KBoardBean> klists = new ArrayList<KBoardBean>();
		klists = sqlSessionTemplate.selectList(ns+"Getmainklist");
		return klists;
	}

		
	}
	

