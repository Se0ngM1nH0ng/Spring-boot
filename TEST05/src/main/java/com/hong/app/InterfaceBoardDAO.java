package com.hong.app;

import java.util.List;

public interface InterfaceBoardDAO {
	public List<BoardDTO> selectAll(BoardDTO bDTO);
	public BoardDTO selectOne(BoardDTO bDTO);
	public boolean insert(BoardDTO bDTO);
	public boolean update(BoardDTO bDTO);
	public boolean delete(BoardDTO bDTO);
}
