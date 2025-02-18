package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	
	BoardDao dao=new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이징 처리
		int perPage=10;//한 페이지당 출력할 글의 갯수
		int perBlock=5;//한 블럭당 출력할 블럭(12345 다음)의 갯수
		int totalCount;//전체 게시글 갯수
		int totalPage;//총 페이지 수
		int startNum;//각 페이지에서 가져올 시작번호(mysql은 첫 데이터가 0번, 오라클은 1번) 오라클은 endNum변수 필요
		int startPage;//각 블럭에서 출력할 시작 페이지
		int endPage;//각 블럭에서 출력할 끝 페이지
		int no;//각 페이지에서 출력할 시작번호
		int pageNum;//현재 페이지 번호
		
		List<BoardDto> list=null; //페이징에 필요한 데이타
		
		//현재 페이지를 얻는다(null 일 경우 1페이지로)
		try {
			pageNum=Integer.parseInt(request.getParameter("pageNum"));
		}catch(NumberFormatException e) {
			pageNum=1;
		}
		
		totalCount=dao.getTotalCount();//총 글 갯수
		//totalPage=totalCount/perPage+(totalCount%perPage>0?1:0);//총 페이지 갯수, 나머지가 있으면 무조건 1페이지를 더한다
		totalPage=(int)Math.ceil((double)totalCount/perPage);//방법2, 무조건 올림 함수를 이용해서 구하는 방법,이게 반환 타입이 double이라서 형변환
		//시작 페이지 
		startPage=(pageNum-1)/perBlock*5+1;//예 현재페이지가 7일경우 startPage 6(perBolck이 5일 경우)
		endPage=startPage+perBlock-1;//끝 페이지
		//endPage는 totalPage를 넘을 수 없음
		if(endPage>totalPage)
			endPage=totalPage;
		
		startNum=(pageNum-1)*perPage;//mysql은 첫 글이 0번(오라클은 1번이므로 여기서 -1)
		
		
		//System.out.println("totalPage="+totalPage);
		
		list=dao.getPaginList(startNum, perPage);
		//마지막 남은 페이지의 1개 남은 글을 지우고 다시 해당 페이지를
		//왔을 경우 데이터가 안나오는 현상
		if(list.size()==0) {
			response.sendRedirect("./list?pageNum="+(pageNum-1));
		}
		
		//각 페이지의 글 앞에 출력할 시작번호(예: 총 글이 20개일 경우 1페이지는 20, 2페에이지는 15...)
		no=totalCount-(pageNum-1)*perPage;
		
		//request 에 저장
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		//페이지 출력에 필요한 모든 변수를 request에 넣는다
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("no", no);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("totalPage", totalPage);
		
		RequestDispatcher rd=request.getRequestDispatcher("./boardlist.jsp");
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
