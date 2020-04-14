<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach var="x" begin="1" end="10" step="1">
   <c:out value="2 * ${x}=${2*x }"/> <br>
</c:forEach>
<br><br>
 <jsp:scriptlet>
   String colors[]=new String[]{"red","true","black"};
   request.setAttribute("colors",colors);
 </jsp:scriptlet>
 
    <c:forEach var="item"   items="${colors}">
     <c:out value="${item}"/>
  </c:forEach>
 
  
 