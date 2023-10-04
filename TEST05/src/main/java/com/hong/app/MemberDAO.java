package com.hong.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO implements InterfaceMemberDAO {
		
		@Autowired
		private JdbcTemplate jdbcTemplate; // 의존관계(멤버변수)
	
		//좁은 의미로 응집도를 높여줌 
		private final String SELECTALL="SELECT * FROM MEMBER"; // 이 쿼리문을 빠르게 관리하기 위해 상단에 
		private final String SELECTONE_INFO="SELECT * FROM MEMBER WHERE MID=? AND MPW=?"; // 상수화 된것들은 대문자로 쓴다 
		private final String SELECTONE_SIGN="SELECT * FROM MEMBER WHERE MID=? "; // 상수화 된것들은 대문자로 쓴다 
		private final String INSERT="INSERT INTO MEMBER (MID, MPW) VALUES (?,?)";
		private final String UPDATE="UPDATE MEMBER SET MPW=? WHERE MID=?";
		private final String DELETE="DELETE FROM MEMBER WHERE MID =?"; 
		
		@Override
		public List<MemberDTO> selectAll(MemberDTO mDTO){
		//	jdbcTemplate.query(query문, new 받아올 클래스 타입());
			
			return	jdbcTemplate.query(SELECTALL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
			// 반복적인 로직을 대신 수행하는 "템플릿 패턴"을 활용 
			
		}
		@Override
		public MemberDTO selectOne(MemberDTO mDTO){
			
				try {
					if(mDTO.getSk().equals("INFO")) {
					Object[] args= {mDTO.getMid(), mDTO.getMpw()};
					return jdbcTemplate.queryForObject(SELECTONE_INFO, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
					}else if(mDTO.getSk().equals("SIGN")) {
					Object[] args= {mDTO.getMid()};
					return jdbcTemplate.queryForObject(SELECTONE_SIGN, args, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
					}
				} catch (DataAccessException e) {
					e.printStackTrace();
					return null;
				}
			return null;
		}
		@Override
		public boolean insert(MemberDTO mDTO){ 
			int rs = jdbcTemplate.update(INSERT, mDTO.getMid(), mDTO.getMpw());
			
			if(rs<=0) {
				return false; 
			}
			
			return true;
		}
		@Override
		public boolean update(MemberDTO mDTO){
			int rs = jdbcTemplate.update(UPDATE, mDTO.getMpw(),mDTO.getMid());
			if(rs<=0) {
				return false;
			}
			return true;
		}
		@Override
		public boolean delete(MemberDTO mDTO){
			int rs = jdbcTemplate.update(DELETE, mDTO.getMid());
			if(rs<=0) {
				return false;
			}
			return true;
		}
}



