package com.hong.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface InterfaceBoardDAO {
	public List<BoardDTO> selectAll(BoardDTO bDTO);
	public BoardDTO selectOne(int bid); // #{param1}
	public boolean insert(Map<String, String> map); // 인자가 2개 이상이라 map 컬렉션 사용 
	public boolean update(Map<String, String> map); // 인자가 2개 이상이라 map 컬렉션 사용 
	public boolean delete(@Param("BID")int bid); // #{BID} // 특정 이름으로 지정 
}


