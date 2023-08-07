<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container-fluid">
<form action="/action_page.php">
  <div class="form-group">
    <label for="memberName">아이디</label>
    <input type="email" class="form-control" placeholder="ID 입력" id="memberName">
  </div>
  <div class="form-group">
    <label for="password">비밀번호</label>
    <input type="password" class="form-control" placeholder="Password 입력" id="password">
  </div>
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
</form>
</div>
<br>
<%@ include file="../layout/footer.jsp"%>



