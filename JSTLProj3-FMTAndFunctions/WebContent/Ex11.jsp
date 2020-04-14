<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="fr_FR" />

<fmt:formatNumber  var="num" value="1234567.890"/>
Formatted nmber<c:out value="${num}"/><br><br>

<jsp:useBean id="dt" class="java.util.Date"/>
  <fmt:formatDate var="fdate" value="${dt}"/>
 Fomatted Date <c:out value="${fdate}"/>
  
  <br><br>
<fmt:setBundle   basename="com.nt.bundle.myfile"/>
<fmt:message  var="msg" key="wish.msg"/>
<c:out value="${msg}"/>
  

