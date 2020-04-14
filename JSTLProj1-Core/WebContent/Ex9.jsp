<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:set var="str" value=" Naresh IT  Solutions Ameerpet  hyd" scope="application"/>
 
 <c:forTokens var="tkn" items="${str}" delims="o">
           <c:out value="${tkn}"/> <br>
 </c:forTokens>
  
 

 
  
 