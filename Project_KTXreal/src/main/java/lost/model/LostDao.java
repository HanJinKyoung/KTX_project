package lost.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myLost")
public class LostDao {
	private String ns = "lost.model.LostBean.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void writeLost(LostBean lost) {
		sqlSessionTemplate.insert(ns+"WriteLost", lost);		
	}	
	public int getArticleCount() {
		int cnt  = sqlSessionTemplate.selectOne(ns+"GetArticleCount");
		return cnt;
	}
	
	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(ns+"GetTotalCount",map);
		return cnt;
	}

	public List<LostBean> getDataList(Paging pageInfo, Map<String, String> map) {
		List<LostBean> lists = new ArrayList<LostBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(ns+"GetDataList",map,rowBounds);
		return lists;
	}

	public LostBean getData(int l_num) {
		LostBean lost = sqlSessionTemplate.selectOne(ns+"GetData", l_num);
		return lost;
	}

	public int deletaData(int l_num) {
		int cnt = sqlSessionTemplate.delete(ns+"DeleteData", l_num);
		return cnt;
	}

	public void updateLost(LostBean lbean) {
		int cnt = sqlSessionTemplate.update(ns+"UpdateData",lbean);
	}
	public void noUpImage(LostBean lbean) {
		int cnt = sqlSessionTemplate.update(ns+"NoUpImage",lbean);
	}

	public void upexist(LostBean lbean) {
		sqlSessionTemplate.update(ns+"UpExist",lbean);
	}
}
