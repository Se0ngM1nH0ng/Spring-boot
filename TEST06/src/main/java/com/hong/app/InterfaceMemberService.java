package com.hong.app;

import java.util.List;

public interface InterfaceMemberService {
	 List<MemberDTO> selectAll(MemberDTO mDTO);
	 MemberDTO selectOne(MemberDTO mDTO);
	 boolean insert(MemberDTO mDTO);
	 boolean update(MemberDTO mDTO);
	 boolean delete(MemberDTO mDTO);
}
