package train.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTrainDao")
public class TrainDao {
	private String ns = "train.model.TrainBean.";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insertTrain(TrainBean train) {
		System.out.println("insertTrain train:"+train.getT_num()+train.getT_type()+train.getT_way());
		int numchk = sqlSessionTemplate.selectOne(ns+"GetTnum", train);
		System.out.println("numchk:"+numchk);
		if(numchk > 0) {//t_num이 중복일경우
			return -1;
		}else {//중복되지 않을경우>삽입
			int cnt = sqlSessionTemplate.insert(ns+"InsertTrain", train);
			
			return cnt;			
		}
	}
	
	public int insertRace(RaceBean race) {
		System.out.println("insertTrain race:"+race.getR_start()+race.getR_end()+race.getR_price());
		int cnt = sqlSessionTemplate.insert(ns+"InsertRace", race);
		System.out.println("InsertTrain cnt:"+cnt);
		return cnt;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(ns+"GetTotalCount", map);
		return cnt;
	}

	public List<RaceBean> getTrainList(Paging pageInfo, Map<String, String> map) {//페이지가 있는
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<RaceBean> lists = new ArrayList<RaceBean>();
		lists = sqlSessionTemplate.selectList(ns+"GetAlldata", map, rowBounds);
		return lists;
	}

	public List<RaceBean> getData(RaceBean race) {//페이지가 없는(trainbook.jsp)
		//System.out.println("traindao:"+race.getR_start()+" "+race.getR_end()+" "+race.getR_starth());
		List<RaceBean> trainlist = new ArrayList<RaceBean>();
		trainlist = sqlSessionTemplate.selectList(ns+"GetTrainlist", race);
		//System.out.println("traindao list.size:"+trainlist.size());
		return trainlist;
	}

	public RaceBean getByRnum(int r_num) {
		RaceBean race = new RaceBean();
		race = sqlSessionTemplate.selectOne(ns+"GetByRnum", r_num);
		return race;
	}
	public int allTrainCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne(ns+"AllTrainCount", map);
		return cnt;
	}

	public List<TrainBean> allTrain(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<TrainBean> lists = new ArrayList<TrainBean>();
		lists = sqlSessionTemplate.selectList(ns+"AllTrain",map,rowBounds);
		return lists;
	}

	public int delTnum(int t_num) {
		// TODO Auto-generated method stub
		int cnt  = sqlSessionTemplate.delete(ns+"DelTrain",t_num);
		return cnt;
	}

	public int getTnum(int t_num) {
		// TODO Auto-generated method stub
		int cnt = sqlSessionTemplate.selectOne(ns+"GetTnum",t_num);
		return cnt;
	}

	public int getRinfo(RaceBean race) {
		// TODO Auto-generated method stub
		int cnt = sqlSessionTemplate.selectOne(ns+"GetRInfo",race);
		return cnt;
	}
	
	
	
}
