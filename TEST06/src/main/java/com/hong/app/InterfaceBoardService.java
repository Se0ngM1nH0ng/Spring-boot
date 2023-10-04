package com.hong.app;

import java.util.List;

public interface InterfaceBoardService { // 다형성 , 오버라이딩을 위해서라도 메서드가 맞아 떨어져야 한다. 
	// 인터페이스의 바디는 추상 메서드 이기 때문에 메서드 바디를 가질수 없다. 
	// 퍼블릭 이 기본이기 때문에 생략 가능 
	
		List<BoardDTO> selectAll(BoardDTO bDTO);
		BoardDTO selectOne(BoardDTO bDTO);
		boolean insert(BoardDTO bDTO);
		boolean update(BoardDTO bDTO);
		boolean delete(BoardDTO bDTO);
}
