package com.xaxis.bbs.group;

import java.util.List;

import com.xaxis.bbs.model.Group;

public interface GroupDao {
	
	/**
	 * 그룹의 모든 리스트 정보를 가져온다.
	 * @return
	 */
	public List<Group> getGroupAllList();
	
	/**
	 * 유저의 그룹 리스트를 가져온다.
	 * @param userID
	 * @return
	 */
	public List<Group> getUserGroupList(String userID);
	
	/**
	 * 그룹 정보를 가져온다.
	 * @param groupID
	 * @return
	 */
	public Group getGroupItem(int groupID);
	
	/**
	 * 그룹 정보를 업데이트 한다.
	 * @param group
	 */
	public void updateGroupItem(Group group);
	
	/**
	 * 그룹 정보를 삭제한다.
	 * @param groupID
	 */
	public void deleteGroupItem(int groupID);
	
	/**
	 * 그룹 정보를 추가한다.
	 * @param group
	 */
	public void addGroupItem(Group group);
}
