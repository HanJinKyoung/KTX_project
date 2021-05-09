package admin.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("check")
public class AdminDao {
	private String ns = "admin.model.CheckBean.";
	
	@Autowired
	SqlSessionTemplate sql;

	public void InTimeChk(CheckBean cbean) {
		// TODO Auto-generated method stub
		System.out.println("ㅊㄱ");
		sql.insert(ns+"InCheck", cbean);
	}

	public void OutTimeChk(CheckBean cbean) {
		// TODO Auto-generated method stub
		System.out.println("ㅌㄱ");
		sql.update(ns+"OutCheck", cbean);
	}

	public CheckBean findIncheck(CheckBean cbean) {
		// TODO Auto-generated method stub
		CheckBean check = sql.selectOne(ns+"FindIn", cbean);
		return check;
	}
	
	public int getTotalCount(Map<String, String> map) {
		// TODO Auto-generated method stub
		int cnt = sql.selectOne(ns+"GetTotalCount", map);
		return cnt;
	}

	public List<CheckBean> getCheckList(Paging pageInfo, Map<String, String> map) {
		// TODO Auto-generated method stub
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<CheckBean> lists = new ArrayList<CheckBean>();
		lists = sql.selectList(ns+"GetCheckList", map,rowBounds);
		return lists;
	}

	public List<CheckBean> numCheckList(int num) {
		// TODO Auto-generated method stub
		List<CheckBean> clists = sql.selectList(ns+"NumCheckList",num);
		return clists;
	}
	public int dayCount(Map<String, String> map) {
		int cnt = sql.selectOne(ns+"DayCount",map);
		return cnt;
	}
	public int prePost(int num) {
		int cnt = sql.selectOne(ns+"PrePost",num);
		return cnt;
	}

	public int returnCheck(int num) {
		// TODO Auto-generated method stub
		int cnt = sql.selectOne(ns+"ReCheck",num);
		System.out.println(cnt);
		return cnt;
	}
	

}
