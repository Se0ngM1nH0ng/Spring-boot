package com.hong.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements InterfaceBoardService {

	@Autowired
	private InterfaceBoardDAO bDAO;
	
	@Override
	public List<BoardDTO> selectAll(BoardDTO bDTO) {
		return bDAO.selectAll(bDTO);
	}

	@Override
	public BoardDTO selectOne(BoardDTO bDTO) {
		return bDAO.selectOne(bDTO);
	}

	@Override
	public boolean insert(BoardDTO bDTO) {
		return bDAO.insert(bDTO);
	}

	@Override
	public boolean update(BoardDTO bDTO) {
		return bDAO.update(bDTO);
	}

	@Override
	public boolean delete(BoardDTO bDTO) {
		return bDAO.delete(bDTO);
	}

}
