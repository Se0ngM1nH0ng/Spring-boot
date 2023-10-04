package com.hong.app;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterfaceMemberDAO {
	public List<MemberDTO> selectAll(MemberDTO mDTO);
	public MemberDTO selectOne(Map<String , String> map); // 인자가 2개이상이라 map 컬레션 사용 
	public boolean insert(Map<String, String> map); // 인자가 2개이상이라 map 컬레션 사용 
	public boolean update(Map<String, String> map); // 인자가 2개이상이라 map 컬레션 사용 
	public boolean delete(String mid); // #{param} 방식
}
