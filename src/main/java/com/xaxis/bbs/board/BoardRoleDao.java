package com.xaxis.bbs.board;

import org.apache.ibatis.annotations.Param;

public interface BoardRoleDao {	
	public Integer getBoardRoleCheck(@Param("boardCode")String boardCode, @Param("groupCode") int groupCode, @Param("roleName") String roleName);
	
	public void addBoardRole(@Param("boardCode")String boardCode, @Param("groupCode") int groupCode, @Param("roleName") int roleCode);
	
	public void deleteBoardRole(@Param("boardCode") String BoardCode);
}
