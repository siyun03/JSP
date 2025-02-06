<%@ page contentType="text/html; charset=UTF-8"%>
		<div id = "login">
		<%
			if(session.getAttribute("sid") == null){
		%>
			<form action="loginProc.jsp" method="post">&nbsp;
            	아이디 : <input type="text" name="mid">&nbsp;
            	비밀번호 : <input type="text" name="mpass">
            	<input type="submit" value="로그인">
			</form>
			<%
			}else{
			%>
			<p>
			<%=session.getAttribute("sid") %>(<%=session.getAttribute("sname") %>)님&nbsp;
			로그인 중 &nbsp;&nbsp;
			<button onclick="location.href='logout.jsp';">로그아웃</button>
			</p>
			<%
			}
			%>
        <nav>
            <ul class="menu">
                <li>메뉴1</li>
                <li>메뉴2</li>
                <li>메뉴3</li>
                <li>메뉴4</li>
            </ul>
        </nav>
        <section>
            <nav>
                <ul class="menu1">메뉴1
                    <li>메뉴1-1</li>
                    <li>메뉴1-2</li>
                    <li>메뉴1-3</li>
                    <li>메뉴1-4</li>
                    <li>메뉴1-5</li>
                </ul>
            </nav>
            <div id="banner">
                <img src="img/banner.png" alt="배너 이미지">
            </div>            
            <article>
                <p id="menupan">메뉴 1-1의 컨텐츠입니다</p>
            </article>
        </section>