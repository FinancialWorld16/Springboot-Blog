<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container-fluid">
<form>
  <div class="form-group">
    <label for="memberName">아이디</label>
    <input type="email" class="form-control" placeholder="ID 입력" id="memberName">
  </div>
  <div class="form-group">
      <label for="password">비밀번호</label>
      <input type="password" class="form-control" placeholder="Password 입력" id="password">
  <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" class="form-control" placeholder="Email 입력" id="email">
    </div>

  </div>
</form>
  <button id="btn-save" class="btn btn-primary">회원가입 완료</button>
</div>
<br>
<script src="/js/member.js"></script>
<%@ include file="../layout/footer.jsp"%>



