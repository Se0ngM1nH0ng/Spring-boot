package com.hong.app;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;

@Controller
public class CTRL {

	@Autowired
	private InterfaceBoardService boardService;
	@Autowired
	private InterfaceMemberService memberService;


	@RequestMapping("/")
	public String root() { // 메인 페이지 이동
		return "/main";
	}

	@RequestMapping("/main")
	public String main(BoardDTO bDTO, Model model, HttpSession session ) { // 메인 페이지 이동
		List<BoardDTO> bdatas =boardService.selectAll(bDTO);
		
		model.addAttribute("bdatas", bdatas);
		
		return "main"; // main.jsp
	}
	
	@RequestMapping("/login")
	public String login(MemberDTO mDTO, BoardDTO bDTO,HttpSession session, Model model) { // 로그인 수행 

		mDTO.setSk("INFO");
		mDTO =memberService.selectOne(mDTO);

		if(mDTO != null) {
			session.setAttribute("mid", mDTO.getMid());

			mDTO.setSweetAlert("success");
			mDTO.setMessage("로그인에 ");
			mDTO.setLocation("/main"); // main.do

			model.addAttribute("data", mDTO);
			return "sweetAlert"; 
		}
		MemberDTO mDTO2 = new MemberDTO();
		mDTO2.setSweetAlert("fail");
		mDTO2.setMessage("로그인에 ");
		mDTO2.setLocation("/main"); // main.do

		model.addAttribute("data", mDTO2);
		return "sweetAlert"; // main.jsp
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET )
	public String signupPage() { // 회원 가입 페이지 이동 
		return "signup";
	}
	@RequestMapping(value= "/signup" , method = RequestMethod.POST)
	public String signup(MemberDTO mDTO, Model model) { // 회원 가입 페이지 이동

		mDTO.setSk("SIGN");
		MemberDTO mdata = memberService.selectOne(mDTO);
		if(mdata == null) {
			memberService.insert(mDTO);
			mDTO.setSweetAlert("success");
			mDTO.setMessage("회원가입에 ");
			mDTO.setLocation("/main"); // main.do

			model.addAttribute("data", mDTO);
			return "sweetAlert"; 
			
		}
		mDTO.setSweetAlert("fail");
		mDTO.setMessage("회원가입에 ");
		mDTO.setLocation("/signup"); // main.do

		model.addAttribute("data", mDTO);
		return "sweetAlert"; 
	}
	@RequestMapping(value="/insertBoard", method = RequestMethod.GET)
	public String insertBoardPage() {

		return "insertBoard";
	}
	@RequestMapping(value="/insertBoard", method = RequestMethod.POST)
	public String insertBoard(BoardDTO bDTO, Model model) {


		boolean flag = boardService.insert(bDTO);
		if(flag) {
			bDTO.setSweetAlert("success");
			bDTO.setMessage("글 작성에 ");
			bDTO.setLocation("/main"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}else {
			bDTO.setSweetAlert("fail");
			bDTO.setMessage("글 작성에 ");
			bDTO.setLocation("/insertBoard"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}

	}

	@RequestMapping(value ="/board" , method=RequestMethod.GET)
	public String boardPage(BoardDTO bDTO, Model model) {

		bDTO = boardService.selectOne(bDTO);
		model.addAttribute("bdata", bDTO);

		return "board";
	}

	@RequestMapping(value ="/board" , method=RequestMethod.POST)
	public String board(BoardDTO bDTO, Model model) {

		System.out.println("로그 11111111111111111 : "+bDTO.getBid());
		boolean flag = boardService.update(bDTO);

		if(flag) {
			bDTO.setSweetAlert("success");
			bDTO.setMessage("글 변경에 ");
			bDTO.setLocation("/main"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}
		bDTO.setSweetAlert("fail");
		bDTO.setMessage("글 변경에 ");
		bDTO.setLocation("/board"); // main.do

		model.addAttribute("data", bDTO);
		return "sweetAlert"; 
	}

	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardDTO bDTO, Model model) {

		boolean flag = boardService.delete(bDTO);

		if(flag) {
			bDTO.setSweetAlert("success");
			bDTO.setMessage("글 삭제에 ");
			bDTO.setLocation("/main"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}else {
			bDTO.setSweetAlert("fail");
			bDTO.setMessage("글 삭제에 ");
			bDTO.setLocation("/board"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}

	}

	@RequestMapping(value = "/mypageCheck", method=RequestMethod.GET )
	public String mypageCheckPage() {

		return "mypageCheck";
	}
	@RequestMapping(value = "/mypageCheck", method=RequestMethod.POST)
	public String mypageCheck(MemberDTO mDTO, Model model) {

		mDTO.setSk("SIGN");
		MemberDTO mdata = memberService.selectOne(mDTO);

		if(!mdata.getMpw().equals(mDTO.getMpw())) {
			mDTO.setSweetAlert("fail");
			mDTO.setMessage("정보확인에 ");
			mDTO.setLocation("/main"); // main.do

			model.addAttribute("data", mDTO);
			return "sweetAlert"; 
		}
		mDTO.setSweetAlert("success");
		mDTO.setMessage("정보확인에 ");
		mDTO.setLocation("/mypage"); // main.do

		model.addAttribute("data", mDTO);
		return "sweetAlert"; 
	}
	
	@RequestMapping("/mypage")
	public String mypage() {

		return "mypage";
	}
	
	@RequestMapping("/updateMember")
	public String updateMember(MemberDTO mDTO, Model model) {

		boolean flag = memberService.update(mDTO);

		if(flag) {
			mDTO.setSweetAlert("success");
			mDTO.setMessage("정보변경에 ");
			mDTO.setLocation("/logout"); // main.do

			model.addAttribute("data", mDTO);
			return "sweetAlert"; 
		}
		mDTO.setSweetAlert("fail");
		mDTO.setMessage("정보변경에 ");
		mDTO.setLocation("/mypage"); // main.do

		model.addAttribute("data", mDTO);
		return "sweetAlert"; 
	}

	@RequestMapping("/deleteMember" )
	public String deleteMember(MemberDTO mDTO, Model model) {

		boolean flag = memberService.delete(mDTO);
		if(flag) {
			mDTO.setSweetAlert("success");
			mDTO.setMessage("회원탈퇴에 ");
			mDTO.setLocation("/logout"); // main.do

			model.addAttribute("data", mDTO);
			return "sweetAlert"; 
		}
		mDTO.setSweetAlert("fail");
		mDTO.setMessage("회원탈퇴에 ");
		mDTO.setLocation("/mypage"); // main.do

		model.addAttribute("data", mDTO);
		return "sweetAlert"; 
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) { // 메인페이지 이동 

		session.removeAttribute("mid");
	
		return "main";
	}

}
