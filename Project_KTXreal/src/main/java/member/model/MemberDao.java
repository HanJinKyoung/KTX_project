package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("myMemberDao")
public class MemberDao {
	private String ns = "member.model.MemberBean.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate; 
	
	public int insertMember(MemberBean member) {
		int cnt = sqlSessionTemplate.insert(ns+"InsertMember",member);
		return cnt;
	}
	
	public MemberBean getMember(String m_id) {
		MemberBean member = sqlSessionTemplate.selectOne(ns+"GetMember",m_id);
		
		return member;
	}
	
	public MemberBean getData(String m_id) {
	      MemberBean member = sqlSessionTemplate.selectOne(ns+"GetData",m_id);
	      return member;
	}
	
	public MemberBean findId(MemberBean member) {
		MemberBean mem = sqlSessionTemplate.selectOne(ns+"FindId", member);
		return mem;
	}

	public MemberBean findPw(MemberBean member) {
		MemberBean mem = sqlSessionTemplate.selectOne(ns+"FindPw", member);
		return mem;
	}

	public int ChkId(String m_id) {
		int cnt = sqlSessionTemplate.selectOne(ns+"ChkId", m_id);
		return cnt;
	}

	public void updateMember(MemberBean member) {
		sqlSessionTemplate.update(ns+"UpdateMember", member);
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(ns+"GetTotalCount",map);
		return cnt;
	}

	public List<MemberBean> getMemberList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		List<MemberBean> lists = new ArrayList<MemberBean>();
		lists = sqlSessionTemplate.selectList(ns+"GetMemberList",map,rowBounds);
		return lists;
	}

	public int deleteMember(int m_num) {
		int cnt = sqlSessionTemplate.delete(ns+"DeleteMember",m_num);
		return cnt;
	}

	public MemberBean getBynum(int m_num) {
	      MemberBean member = sqlSessionTemplate.selectOne(ns+"GetbyNum", m_num);
	      return member;
	   }

	public MemberBean getGrade(String m_grade) {
		MemberBean member = sqlSessionTemplate.selectOne(ns+"GetGrade",m_grade);
		
		return member;
	}
	public void updateMeminfo(MemberBean member) {
		sqlSessionTemplate.update(ns+"UpdateMeminfo", member);	
	}

	public int chkEmail(String m_email) {
		// TODO Auto-generated method stub
		int cnt  = sqlSessionTemplate.selectOne(ns+"GetEmail",m_email);
		return cnt;
	}

}