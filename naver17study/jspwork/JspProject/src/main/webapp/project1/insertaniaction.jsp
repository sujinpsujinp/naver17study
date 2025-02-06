<%@page import="project1.AnimalDao"%>
<%@page import="project1.AnimalDto"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*, javax.servlet.*, javax.servlet.http.*, com.oreilly.servlet.MultipartRequest, com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<%
    String saveDirectory = application.getRealPath("./upload"); // 업로드 경로
    int sizeLimit = 5 * 1024 * 1024 ; // 5메가까지 제한 넘어서면

    String encoding = "UTF-8";
    DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
    MultipartRequest multi = new MultipartRequest(request, saveDirectory, sizeLimit,encoding, policy);

    String aniname = multi.getParameter("aniname");
    String anikind = multi.getParameter("anikind");
    String animessage = multi.getParameter("animessage");
    String aniphoto = multi.getFilesystemName("aniphoto"); // 업로드된 파일명 가져오기
    if (aniphoto == null) {
        aniphoto = "default.jpg"; // 기본 이미지 설정
    }

    // DB에 데이터 저장
    AnimalDto dto = new AnimalDto();
    dto.setAniname(aniname);
    dto.setAnikind(anikind);
    dto.setAnimessage(animessage);
    dto.setAniphoto(aniphoto);

    AnimalDao dao = new AnimalDao();
    dao.insertAnimal(dto, multi);

    out.print("success");
%>
<data>
	<result><%=aniname %>을 DB에 추가했습니다</result></result>
</data>