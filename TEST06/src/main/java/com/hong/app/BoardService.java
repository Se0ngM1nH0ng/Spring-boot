package com.hong.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements InterfaceBoardService { // 인터페이스의 강제를 받고 있다. 

	@Autowired
	private InterfaceBoardDAO bDAO; // InterfaceBoardDAO 를 의존 주입
	
	@Override
	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		return bDAO.selectAll(bDTO);
	}

	@Override
	public BoardDTO selectOne(BoardDTO bDTO) {
		return bDAO.selectOne(bDTO.getBid()); // param 으로 인자 하나를 받은 방식 
	}
	

	@Override
	public boolean insert(BoardDTO bDTO) {
		Map<String , String> map = new HashMap<String, String>(); // map 컬렉션을 사용 
		map.put("data1", bDTO.getMid()); // 첫번째 인자에 해당하는 값
		map.put("data2", bDTO.getTitle()); // 두번째 
		map.put("data3", bDTO.getContent()); // 세번째
		return bDAO.insert(map);
	}

	@Override
	public boolean update(BoardDTO bDTO) {
		Map<String, String> map = new HashMap<String , String >();
		map.put("data1", bDTO.getTitle()); // 첫번째 
		map.put("data2", bDTO.getContent()); // 두번째 
		map.put("data3", String.valueOf(bDTO.getBid())); // 값 자리가 String 타입이어서 bid는 숫자이므로 String 타입으로 형변환
		return bDAO.update(map);
	}

	@Override
	public boolean delete(BoardDTO bDTO) {
		return bDAO.delete(bDTO.getBid()); // #{BID} 라고 특정 이름을 정한 인자를 기입 
	}

}
