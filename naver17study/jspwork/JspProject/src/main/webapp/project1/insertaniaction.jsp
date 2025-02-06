<%@page import="project1.AnimalDao"%>
<%@page import="project1.AnimalDto"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String aniname=request.getParameter("aniname");
	String anikind=request.getParameter("anikind");
	String aniphoto=request.getParameter("aniphoto");
	String animessage=request.getParameter("animessage");
	
	AnimalDto dto=new AnimalDto();
	dto.setAniname(aniname);
	dto.setAnikind(anikind);
	dto.setAniphoto(aniphoto);
	dto.setAnimessage(animessage);
	
	AnimalDao dao=new AnimalDao();
	dao.insertAnimal(dto);
	
	 // 업로드할 디렉토리 설정 (실제 서버의 경로로 변경)
    String uploadPath = application.getRealPath("/uploads");
    File uploadDir = new File(uploadPath);
    
    // 디렉토리가 존재하지 않으면 생성
    if (!uploadDir.exists()) {
        uploadDir.mkdirs();
    }

    // 업로드 파일의 최대 크기 설정 (10MB)
    int maxSize = 10 * 1024 * 1024;

    // MultipartRequest 객체 생성 (파일 업로드 처리)
    MultipartRequest multi = new MultipartRequest();

    // 업로드된 파일 정보 가져오기
    String srcName = multi.getFilesystemName("aaa");  // 클라이언트가 업로드한 파일명
    String fileType = multi.getContentType("aaa");    // 파일 타입 (MIME 형식)
    File file = multi.getFile("aaa");                 // 업로드된 파일 객체
    
    long fileSize = 0;
    if (file != null) {
        fileSize = file.length(); // 파일 크기
    }

    // 새로운 파일명 생성 (날짜 + 원본 파일명)
    String dstName = uploadPath + File.separator + new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + srcName;

    // 파일 이동 (이름 변경)
    if (file != null) {
        File newFile = new File(dstName);
        file.renameTo(newFile);
    }
%>
<data>
	<result><%=aniname %>을 DB에 추가했습니다</result></result>
</data>