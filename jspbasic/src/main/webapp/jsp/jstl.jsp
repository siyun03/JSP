<%-- 
	JSTL (JSP Standard Tag Libarary) : JSP에서 사용하는 표준 태그 라이브러리

	* 종류
	1) core (c, jakarta.tags.core)
	> set, remove, if, choose, forEach, forToken, import, redirect, url, catch, out
	2) format 국제화 (fmt, jakarta.tags.core)
	> setLocale, requestEncoding, bundle, message, setBundle, formatNumber, formatDate, 
	parseNumber, parseDate,setTimeZone, timeZone
	3) functions (fn, jakarta.tags.core)
	- length : 길이 
	- toUpperCase : 대문자로
	- toLowerCase : 소문자로
	- subString : 부분문자열 추출
	- trim : 앞뒤 공백문자 제거
	- replace : 문자열 대체
	- indexOf : 문자열의 인덱스
	- startWith : 어떤 문자열로 시작하는지
	- endWith : 어떤 문자열로 끝나는지
	- contains : 문자열을 포함하고 있는지
	- containsIgnoreCase : 대소문자 구별없이 문자열을 포함하고 있는지
	- split : 기준문자열로 잘라서 문자열로 배열 생성
	- join : 배열의 요소들을 붙여서 문자열을 생성
	- escapeXml : 태그를 태그로 인식한 건지의 여부
	nvc, printLisener, mybatis
--%>

<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- 변수 설정 --%>
<c:set var="v" value="1" />

<%-- 변수 출력 --%>
<c:out value="${v}" />

<%-- 변수 제거 --%>
<c:remove var="v" />

<%-- 변수 출력--%>
<c:out value="${v}"/><br>

<%-- 조건문 --%>
<c:set var="v1" value="3" />
<c:set var="v2" value="5" />
<c:if test="${v1>v2}">
	<c:out value="v1 이 v2 보다 큽니다" /><br>
</c:if>
<c:if test="${!v1>v2}">
	<c:out value="v1 이 v2 보다 크지않습니다" /><br>
</c:if>
${v1>v2 ? "i1이 i2보다 큼" : "i2가 i1보다 큼"}<br>

<%-- choose when otherwise --%>
<c:set var="v3" value="2" />
<c:choose>
	<c:when test="${v3==1}">
		<c:out value="v3는 1입니다!"/>
	</c:when>
	<c:when test="${v3==2}">
		<c:out value="v3는 2입니다!"/>
	</c:when>
	<c:otherwise>
		<c:out value="" />
	</c:otherwise>
</c:choose>

<%-- 
	forEach 반목문
	- var : 반복변수
	- begin : 반복시작
	- end : 반복종료
	- varStatus : 반복상태변수
	- step : 스텝
	- items : 배열, 리스트 등 반복대상
 --%>
<%-- 
<c:forEach var="i" begin="1" end="10" varStatus="stat" step="2">
	i변수 값 : <c:out value="${i}"/><br>
	반복인덱스 : <c:out value="${stat.index}"/><br>
	반복횟수 : <c:out value="${stat.count}"/><br>
</c:forEach>
<c:set var="arr" value="${[1,2,3,4,5]}" />
<c:forEach  var="ele" item="${arr}" varStatus="stat">
	i변수 값 : <c:out value="${ele}"/><br>
	반복인덱스 : <c:out value="${stat.index}"/><br>
	반복횟수 : <c:out value="${stat.count}"/><br>
</c:forEach>
--%>

<%-- 구구단 만들기 --%>
<c:forEach var="i" begin="1" end="9" varStatus="stat" step="1"><br>
	<c:forEach var="j" begin="1" end="9" varStatus="stat" step="1">
		<c:out value="${i}x${j} = ${i*j} "/>
	</c:forEach>
</c:forEach>

<%-- 
	forTokens
	var : 토큰 저장할 변수
	items : 코트나이징 대상 문자열
	delims : 구분자
 --%>
<c:forTokens var="token" items="010-8918-8899" delims="-">
	<c:out value="${token}" /><br>
</c:forTokens>

<%-- url 생성시 사용 --%>
<c:url var="url" value="https://www.google.com">
	<c:param name="name" value="홍두깨"/> 
	<c:param name="age" value="30"/> 
</c:url>
<c:out value="${url}" />
<%--
<c:import url="https://www.google.com"/>
<c:out value="${google}" />
<c:import var="posts" url="https://jsonplaceholder.typicode.com/post"/>
<c:out value="${posts}"/><br><br> 
--%>


<%--  다른 페이지로 리다이렉션시 사용 가능 
<c:redirect url="/jsp/el.jsp"/>  --%>


<%-- 로케일 설정 --%>
<fmt:setLocale value="ko_KR"/>
<fmt:setLocale value="en_US"/>
<%
	pageContext.setAttribute("now", new Date());
%>

<%-- 
	타임존 설정 
	fmt:timeZon : 태그영역 안에서 타임존 적용을 받음
	fmt:setTimeZone : 설정 후부터 타임존 적용을 받음
--%>
<fmt:setTimeZone value="Asia/Seoul"/>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/><br>

<fmt:setTimeZone value="America/New_York"/>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/><br>

<fmt:setTimeZone value="Europe/London"/>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/><br>


<%-- 요청데이터 인코딩 --%>
<fmt:requestEncoding value="utf-8"/>

<%--
	fmt:bundle : properties 파일 사용시
	basename : package명 + properties파일명
	prefix : 키 앞에 붙일 문자열
	
	fmt:setBundle : 설정 후부터 properties 사용
 --%>
<fmt:bundle basename="jsbasic.props.hong" prefix="hong_" >
	<fmt:message key="name"/><br>
	<fmt:message key="age"/><br>
</fmt:bundle>

<fmt:bundle basename="jsbasic.props.hong" prefix="hong_">
    <fmt:message key="hong_name"/><br>
    <fmt:message key="hong_age"/><br>
</fmt:bundle>


<fmt:setLocale value="ko_KR"/>
<fmt:setTimeZone value="Asia/Seoul"/>

<%-- fmt:formatNumber : 숫자 형식화--%>
<fmt:formatNumber value="12345" pattern="00,000"/><br>
<fmt:formatNumber value="12345" pattern="000,000"/><br>
<fmt:formatNumber value="12345" pattern="00,000$"/><br>
<fmt:formatNumber value="12345" pattern="00,000원"/><br>
<fmt:formatNumber value="12345" pattern="currency"/><br>
<fmt:formatNumber value="12345" pattern="percent"/><br>

<%-- fmt:parseNumber : 숫자타입으로 변환 --%>
<fmt:parseNumber value="12345" pattern="00.000"/><br>

<%-- fmt:formatDate : 날짜 형식화 --%>
<c:set var="now" value="<%=new Date()%>"/>
<fmt:formatDate value="${now}" type="time" /> <br>
<fmt:formatDate value="${now}" type="date" /> <br>
<fmt:formatDate value="${now}" type="both" /> <br>
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/> <br>

<%-- fmt:parseDate : 날짜타입으로 변환 --%>
<fmt:parseDate var="pd" value="2025년 01월 01일 00시 00분 00초"
	pattern="yyyy년 MM월 dd일 HH시 mm분 ss초"/>
<fmt:formatDate value="${pd}" pattern="yyyy-MM-dd HH:mm:ss" /> <br>

<c:set var="str" value="Hello JSP"/>
<c:out value="${fn:length(str)}"/><br>
<c:out value="${fn:toUpperCase(str)}"/><br>
<c:out value="${fn:toLowerCase(str)}"/><br>
<c:out value="${fn:substring(str,0,5)}"/><br>
<c:out value="${fn:trim(str)}"/><br>
<c:out value="${fn:replace(str,'Hello', 'Hi')}"/><br>
<c:out value='${fn:indexOf(str,"JSP")}'/><br>
<c:out value='${fn:startsWith(str,"JSP")}'/><br>
<c:out value='${fn:endsWith(str,"JSP")}'/><br>
<c:out value='${fn:contains(str,"JSP")}'/><br>
<c:out value='${fn:containsIgnoreCase(str,"JSP")}'/><br>


<%--
	fn:split : 문자열 > 배열
	fn:join : 배열 > 문자열
 --%>
<c:set var="str2" value="1,2,3,4,5"/>
<c:set var="arr" value='${fn:split(str2, ",")}'/>
<c:set var="str3" value='${fn:join(arr, "")}'/>
<c:out value="${str3}"/><br>

<%-- 
	fn:escapeXml : 태그 해석하지 않고 태그 자체로 표시
--%>
<c:set var="html" value="<hr><p>방가룽 @!</P></hr>" />
<c:out value="${html}" escapeXml="true"/><br>
${html}
<c:out value="${html}" escapeXml="false"/><br>
${fn:escapeXml(html)}
























