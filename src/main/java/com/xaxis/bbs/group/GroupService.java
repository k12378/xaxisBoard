package com.xaxis.bbs.group;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xaxis.bbs.model.Group;

@Service
@Transactional
public class GroupService {
	
	@Autowired
	private SqlSession sqlSessionTemplate;
	
	private GroupDao groupDao;
	
	public List<Group> getGroupAllList(){
		groupDao = sqlSessionTemplate.getMapper(GroupDao.class);
		return groupDao.getGroupAllList();		
	}
	
	public Group getGroupItem(int groupID){
		groupDao = sqlSessionTemplate.getMapper(GroupDao.class);
		return groupDao.getGroupItem(groupID);
	}
	
	public void updateGroupItem(Group group){
		groupDao = sqlSessionTemplate.getMapper(GroupDao.class);
		groupDao.updateGroupItem(group);
	}
	
	public boolean checkUserAdmin(String memberId, String groupName){
		groupDao = sqlSessionTemplate.getMapper(GroupDao.class);
		return ( groupDao.checkUserAdmin(memberId, groupName) > 0 )? true : false;
	}
}
