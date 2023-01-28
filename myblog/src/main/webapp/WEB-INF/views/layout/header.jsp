<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyBlog</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>

<link href="/css/header.css" rel="stylesheet" type="text/css" />


</head>
<body>
	<div id="header--div"
		style="background-image: url('http://localhost:8090/myblogimg/${headLineEntity.img}');">

		<div id="header--start">
			<div id="header--title">
				<h1>${headLineEntity.name }</h1>
				<a href="#pop--set2" class="btn--open"> <img class="img--logo"
					id="set--logo" alt="설정로고" src="images/set_logo.png">
				</a>
			</div>

			<div id="header--sns">
				<a href="http://www.instagram.com/${headLineEntity.instaUrl}"> <img
					class="img--logo" alt="인스타로고" src="images/insta_logo.png">
				</a> <a href="http://www.youtube.com/${headLineEntity.youtubeUrl}">
					<img class="img--logo" alt="유튜브로고" src="images/youtube_logo.png">
				</a>
			</div>

		</div>
	</div>


	<div></div>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<div id="pop--set2" class="popup--wrap" style="display: none;">
			<div class="inner--outbox">
				<div class="pop--inner">

					<div class="pop--raw">
						<div class="raw--left">
							<b>블로그명</b>
						</div>
						<div class="raw--right">
							<input id="pop--name" name="name" value="${headLineEntity.name }"
								onkeyup="characterCheck(this);"
								onkeydown="characterCheck(this);"> <small>한글,
								영문, 숫자, 혼용가능 (4~25자 이내)</small>
						</div>
					</div>

					<div class="pop--raw">
						<div class="raw--left">
							<b>블로그 상단 배경</b>
						</div>
						<div class="raw--right">

							<div class="custom-file">
								<!-- 보내는인풋 -->
								<label id="header--label" class="custom-file-label"
									for="customfile">이미지 등록</label> <input type="file" name="file"
									class="custom-file-input" id="customfile"> <input
									id="filename" name="filename" disabled="disabled"> <img
									class="img--trash" alt="이미지휴지통" src="images/trashcan.png">

							</div>


							<small> 가로 1000px, 세로 80 ~ 300px </small>
						</div>
					</div>

					<div class="pop--raw">
						<div class="raw--left">
							<b>YouTube URL</b>
						</div>
						<div class="raw--right">
							<span class="sns--url">http://www.youtube.com/@</span> <input
								onkeyup="socialCheck(this);" onkeydown="socialCheck(this);"
								class="sns--input" name="youtubeUrl"
								value="${headLineEntity.instaUrl }"> <small>
								User ID 입력 </small>
						</div>
					</div>

					<div class="pop--raw">
						<div class="raw--left">
							<b>Instagram URL</b>
						</div>
						<div class="raw--right">
							<span class="sns--url">http://www.instagram.com/</span> <input
								onkeyup="socialCheck(this);" onkeydown="socialCheck(this);"
								class="sns--input" name="instaUrl"
								value="${headLineEntity.youtubeUrl }"> <small>
								User ID 입력 </small>
						</div>
					</div>

					<div class="pop--btn">
						<button class="popup--cancel" id="btn--popcancel" type="button">
							<b>취소</b>
						</button>
						<button id="btn--popsave" type="submit">
							<b>확인</b>
						</button>
					</div>

				</div>
			</div>

		</div>
	</form>




	<script type="text/javascript" src="/js/header.js"></script>