package com.hong.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements InterfaceBoardDAO { // 결합도가 매우 낮고 
		
		@Autowired
		private JdbcTemplate jdbcTemplate; // 의존관계(멤버변수)
	
		//좁은 의미로 응집도를 높여줌 
		private final String SELECTALL="SELECT * FROM BOARD ORDER BY BID DESC"; // 이 쿼리문을 빠르게 관리하기 위해 상단에 
		private final String SELECTONE="SELECT * FROM BOARD WHERE BID=?"; // 상수화 된것들은 대문자로 쓴다 
		private final String INSERT="INSERT INTO BOARD (MID, TITLE, CONTENT)  VALUES (?,?,?)";
		private final String UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE BID=?";
		private final String DELETE="DELETE FROM BOARD WHERE BID = ?"; 
		
		@Override
		public List<BoardDTO> selectAll(BoardDTO bDTO){
		//	jdbcTemplate.query(query문, new 받아올 클래스 타입());
			
			return	jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
			// 반복적인 로직을 대신 수행하는 "템플릿 패턴"을 활용 
			
		}
		@Override
		public BoardDTO selectOne(BoardDTO bDTO){
			try {
				Object[] args = {bDTO.getBid()};
				return jdbcTemplate.queryForObject(SELECTONE, args, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
			} catch (DataAccessException e) {
				e.printStackTrace();
				return null;
			}
		}
		@Override
		public boolean insert(BoardDTO bDTO){ 
			int rs = jdbcTemplate.update(INSERT, bDTO.getMid(), bDTO.getTitle(), bDTO.getContent());
			
			if(rs<=0) {
				return false; 
			}
			
			return true;
		}
		@Override
		public boolean update(BoardDTO bDTO){
			int rs = jdbcTemplate.update(UPDATE, bDTO.getTitle(),bDTO.getContent(), bDTO.getBid());
			if(rs<= 0) {
				return false;
			}
			return true;
		}
		@Override
		public boolean delete(BoardDTO bDTO){
			int rs = jdbcTemplate.update(DELETE, bDTO.getBid());
			if(rs<=0) {
				return false;
			}
			return true;
		}
}



