package voc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;


	@Component("MyVoc")
	public class VocDao {
		
		private String ns = "voc.model.VocBean.";
		@Autowired
		SqlSessionTemplate sqlSessionTemplate;


	public void writeVoc(VocBean voc) {
		sqlSessionTemplate.insert(ns+"WriteVoc", voc);		
	}	
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(ns+"GetTotalCount",map);
		return cnt;
	}	
	public List<VocBean> getDataList(Paging pageInfo, Map<String, String> map) {
		List<VocBean> lists = new ArrayList<VocBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(ns+"GetDataList",map,rowBounds);
		return lists;
	}
	public VocBean getContent(int q_num) {
		VocBean vbean = sqlSessionTemplate.selectOne(ns+"GetContent",q_num);
		return vbean;
	}
	public void delete(VocBean vbean) {
		int q_num = vbean.getQ_num();
		int q_ref = vbean.getQ_ref();
		if(q_num != q_ref) {
			sqlSessionTemplate.delete(ns+"DeleteVoc", vbean);
		}
		else {
			sqlSessionTemplate.delete(ns+"DeleteVocRef", vbean);
		}
	}
	public int insertReply(VocBean vbean) {
		int cnt = 0;
		sqlSessionTemplate.update(ns+"UpdateRestep", vbean);
		int q_re_step = vbean.getQ_re_step();
		q_re_step++;
		vbean.setQ_re_step(q_re_step);
		int q_re_level = vbean.getQ_re_level();
		q_re_level++;
		vbean.setQ_re_level(q_re_level);
		cnt = sqlSessionTemplate.insert(ns+"InsertReply", vbean);
		if(cnt>0) {
			sqlSessionTemplate.update(ns+"StateUpdate", vbean);			
		}
		return cnt;
	}
	public void updateVoc(VocBean vbean) {
		sqlSessionTemplate.update(ns+"UpdateVoc", vbean);
	}
	
	}
