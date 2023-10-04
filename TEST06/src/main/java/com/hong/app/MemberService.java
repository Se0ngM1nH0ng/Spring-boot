package com.hong.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements InterfaceMemberService {

	@Autowired
	private InterfaceMemberDAO mDAO;
	
	@Override
	public List<MemberDTO> selectAll(MemberDTO mDTO) {
		return mDAO.selectAll(mDTO);
	}

	@Override
	public MemberDTO selectOne(MemberDTO mDTO) {
		Map <String , String> map = new HashMap <String, String>(); // map 컬렉션 사용 
		map.put("sk", mDTO.getSk());
		map.put("data1", mDTO.getMid()); // 첫번째 값 
		map.put("data2", mDTO.getMpw()); // 두번 째 인자값
		return mDAO.selectOne(map);
	}
	
	@Override
	public boolean insert(MemberDTO mDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("data1", mDTO.getMid()); // 첫번째 
		map.put("data2", mDTO.getMpw()); // 두번째
		return mDAO.insert(map);
	}

	@Override
	public boolean update(MemberDTO mDTO) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("data1", mDTO.getMpw()); // 첫번째 
		map.put("data2", mDTO.getMid()); // 두번째
		return mDAO.update(map);
	}

	@Override
	public boolean delete(MemberDTO mDTO) {
		return mDAO.delete(mDTO.getMid()); // param 인자 방식 
	}

}
