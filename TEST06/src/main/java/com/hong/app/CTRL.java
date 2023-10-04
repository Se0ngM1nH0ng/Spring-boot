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
	private InterfaceBoardService boardService; // 의존주입 
	@Autowired
	private InterfaceMemberService memberService; // 의존주입


	@RequestMapping("/")
	public String root() { // 메인 페이지 이동
		return "/main";
	}

	@RequestMapping("/main")
	public String main(BoardDTO bDTO, Model model, HttpSession session ) { // 메인 페이지 이동
		List<BoardDTO> bdatas =boardService.selectAll(bDTO);  // 로그인 시 전체 게시글이 뜰 수 있도록 
		
		model.addAttribute("bdatas", bdatas); // 전체 게시글 
		
		return "main"; // main.jsp
	}
	
	@RequestMapping("/login")
	public String login(MemberDTO mDTO, BoardDTO bDTO,HttpSession session, Model model) { // 로그인 수행 

	mDTO.setSk("INFO");
		mDTO =memberService.selectOne(mDTO); // 로그인을 위해 DB에 존재하는지 확인

		if(mDTO != null) { // 있다면
			session.setAttribute("mid", mDTO.getMid()); // 세션으로 MID 를 넘겨준다.

			mDTO.setSweetAlert("success"); // 스윗알럿 성공
			mDTO.setMessage("로그인에 "); // 안내 메세지
			mDTO.setLocation("/main"); // main.do

			model.addAttribute("data", mDTO); // "data" 에 모아서 sweetAlert 으로 보냄
			return "sweetAlert"; 
		}
		MemberDTO mDTO2 = new MemberDTO(); // mDTO객체가 null 일 시 이쪽으로 넘어오므로 객체가 null 이 될 수 있음 
		// Null Point Exception 이 발생할 수 있음 // 그래서 객체 생성 // 한번만 사용 되므로 커맨드 객체에는 넣지 않는다.
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
	public String signup(MemberDTO mDTO, Model model) { // 회원 가입 정보 기입 후 성공 실패 

		mDTO.setSk("SIGN");
		MemberDTO mdata = memberService.selectOne(mDTO); // 중복검사
		if(mdata == null) { // 다른 중복되는 아이디가 없다면 
			memberService.insert(mDTO); // 정보를 등록 해준다. 
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
	public String insertBoardPage() { // 글작성 페이지 이동

		return "insertBoard";
	}
	@RequestMapping(value="/insertBoard", method = RequestMethod.POST)
	public String insertBoard(BoardDTO bDTO, Model model) { // 글 제목 , 내용 , 아이디 기입후 등록


		boolean flag = boardService.insert(bDTO); // 글 정보 등록
		if(flag) { // 성공시
			bDTO.setSweetAlert("success");
			bDTO.setMessage("글 작성에 ");
			bDTO.setLocation("/main"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}else { // 실패시
			bDTO.setSweetAlert("fail");
			bDTO.setMessage("글 작성에 ");
			bDTO.setLocation("/insertBoard"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}

	}

	@RequestMapping(value ="/board" , method=RequestMethod.GET)
	public String boardPage(BoardDTO bDTO, Model model) {

		bDTO = boardService.selectOne(bDTO); // 글 번호 bid 입력시 글에 대한 내용 출력 
		model.addAttribute("bdata", bDTO); // 글 해당 번호에 대한 글 정보 보내주기 

		return "board";
	}

	@RequestMapping(value ="/board" , method=RequestMethod.POST)
	public String board(BoardDTO bDTO, Model model) {

		System.out.println("로그 bDTO.getBid() : "+bDTO.getBid());
		boolean flag = boardService.update(bDTO); // 글 수정을 누르면 받아온 내용으로 수정 

		if(flag) { // 성공
			bDTO.setSweetAlert("success");
			bDTO.setMessage("글 변경에 ");
			bDTO.setLocation("/main"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}
		bDTO.setSweetAlert("fail"); // 실패시
		bDTO.setMessage("글 변경에 ");
		bDTO.setLocation("/board"); // main.do

		model.addAttribute("data", bDTO);
		return "sweetAlert"; 
	}

	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardDTO bDTO, Model model) {

		boolean flag = boardService.delete(bDTO); // 글 삭제 

		if(flag) { // 성공
			bDTO.setSweetAlert("success");
			bDTO.setMessage("글 삭제에 ");
			bDTO.setLocation("/main"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}else { // 실패
			bDTO.setSweetAlert("fail");
			bDTO.setMessage("글 삭제에 ");
			bDTO.setLocation("/board"); // main.do

			model.addAttribute("data", bDTO);
			return "sweetAlert"; 
		}

	}

	@RequestMapping(value = "/mypageCheck", method=RequestMethod.GET )
	public String mypageCheckPage() { // 마이페이지 입장시 비밀번호 확인 페이지로 이동 

		return "mypageCheck";
	}
	@RequestMapping(value = "/mypageCheck", method=RequestMethod.POST)
	public String mypageCheck(MemberDTO mDTO, Model model) { // 비밀번호 확인 페이지에서 마이페이지로 이동 

		mDTO.setSk("SIGN");
		MemberDTO mdata = memberService.selectOne(mDTO); // 회원 비밀번호가 맞는지 확인 

		if(!mdata.getMpw().equals(mDTO.getMpw())) { // 입력한 비밀번호가 맞지 않을 때 
			mDTO.setSweetAlert("fail");
			mDTO.setMessage("정보확인에 ");
			mDTO.setLocation("/main"); // main.do

			model.addAttribute("data", mDTO);
			return "sweetAlert"; 
		}
		mDTO.setSweetAlert("success"); // 입력한 비밀번호가 맞을 때
		mDTO.setMessage("정보확인에 ");
		mDTO.setLocation("/mypage"); // main.do

		model.addAttribute("data", mDTO);
		return "sweetAlert"; 
	}
	
	@RequestMapping("/mypage")
	public String mypage() { // 마이 페이지로 이동 

		return "mypage";
	}
	
	@RequestMapping("/updateMember")
	public String updateMember(MemberDTO mDTO, Model model) { // 회원정보가 변경 됐다면 

		boolean flag = memberService.update(mDTO); // 입력한 정보로 변경해줌 

		if(flag) { // 성공시 
			mDTO.setSweetAlert("success");
			mDTO.setMessage("정보변경에 ");
			mDTO.setLocation("/logout"); // main.do

			model.addAttribute("data", mDTO);
			return "sweetAlert"; 
		}
		mDTO.setSweetAlert("fail"); // 실패시 
		mDTO.setMessage("정보변경에 ");
		mDTO.setLocation("/mypage"); // main.do

		model.addAttribute("data", mDTO);
		return "sweetAlert"; 
	}

	@RequestMapping("/deleteMember" )
	public String deleteMember(MemberDTO mDTO, Model model) { // 회원 탈퇴 

		boolean flag = memberService.delete(mDTO); // 회원의 mid 를 받아 탈퇴 
		if(flag) { // 성공
			mDTO.setSweetAlert("success");
			mDTO.setMessage("회원탈퇴에 ");
			mDTO.setLocation("/logout"); // main.do

			model.addAttribute("data", mDTO);
			return "sweetAlert"; 
		}
		mDTO.setSweetAlert("fail"); // 실패
		mDTO.setMessage("회원탈퇴에 ");
		mDTO.setLocation("/mypage"); // main.do

		model.addAttribute("data", mDTO);
		return "sweetAlert"; 
	}

	@RequestMapping("/logout") // 로그아웃
	public String logout(HttpSession session) { // 메인페이지 이동 

		session.removeAttribute("mid"); // 로그아웃이 되면서 세션이 살아있으면 안되므로 세션을 지워준다. 
	
		return "main";
	}

}
