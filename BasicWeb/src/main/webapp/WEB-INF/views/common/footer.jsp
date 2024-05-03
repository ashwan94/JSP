<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<footer>
		(c) copyright 2024 Nextit all right reserved.
	</footer>
<script>
	function deleteBoard() {
		if (confirm("삭제하시겠습니까?")) {
			location.href = "/board/delete?no=${board.no}"
			alert("삭제가 완료되었습니다.");
		} else {
			alert("삭제를 취소하셨습니다.");
		}
	}
</script>
</body>
</html>