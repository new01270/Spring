<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html><head><title>getBoardList.jsp</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h3>게시글 목록</h3>
<script>
function goList(p) {
	searchFrm.page.value=p;
	searchFrm.submit();
}
</script>
<hr>
<form name="searchFrm">
	<input type="hidden" name="page" value="1">
	정렬기준<select	name="sort">
		<option value="title">title
		<option value="writer">writer
		<option value="seq">seqaop
	</select><br>
	검색조건 <my:boardSelect/> <br>
	<input type="text" name="searchKeyword" 
	       value="${boardVO.searchKeyword}">
	<button>검색</button>
</form>
<script>
searchFrm.sort.value = "${boardVO.sort}"=="" 
							?searchFrm.sort.options[0].value 
							:"${boardVO.sort}" ;
searchFrm.searchCondition.value = "${boardVO.searchCondition}"==""
							?searchFrm.searchCondition.options[0].value
							:"${boardVO.searchCondition}" ;
</script>
<form action="deleteBoard.do">
<button>삭제</button>
<table class="table">
	<tr><th>선택</th><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th></tr>
	<c:forEach items="${result.boardList}" var="board">
		<tr>
			<td><input type="checkbox" name="seqList" 
			           value="${board.seq}"></td>
			<td>${board.seq}</td>
			<td><a href="updateBoardForm.do?seq=${board.seq}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.regDate}</td>
		</tr>
	</c:forEach>
</table>
</form>
<my:paging jsFunc="goList" paging="${result.paging}" />
</body>
</html>