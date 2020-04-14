<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- create the variable email with value x@y.com in application scope -->
<c:set var="email" value="x@y.com" scope="application"/>
<!-- Display variable value -->
Value : <c:out value="${email}"/> <br>
<!-- Remove Variable -->
<c:remove var="email" scope="application"/>
<!-- Display variable value -->
Value : <c:out value="${email}"/> <br>

p1 requst param value ${param.p1}
<br>                                   <c:out value="${param.p1}"/>





