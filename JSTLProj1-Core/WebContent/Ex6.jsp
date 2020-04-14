<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
   <c:if test="${!empty param.uname  }">
     Hello <c:out value="${param.uname }"/>
   </c:if>
   <c:set var="a" value="10"/>
   <c:set var="b"  value="20"/>
   <c:if test="${a<b}">
       ${a}  is less than ${b}
    </c:if>
   
   
