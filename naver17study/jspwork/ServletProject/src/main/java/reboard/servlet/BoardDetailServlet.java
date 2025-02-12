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

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	BoardDao dao=new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//num읽기
		int num=Integer.parseInt(request.getParameter("num"));
		
		//조회수 증가
		dao.updateReadCount(num);
		
		//dto읽기
		BoardDto dto=dao.getData(num);
		
		//request에 dto 저장
		request.setAttribute("dto", dto);
		
		//포워드
		RequestDispatcher rd=request.getRequestDispatcher("./content.jsp");
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
