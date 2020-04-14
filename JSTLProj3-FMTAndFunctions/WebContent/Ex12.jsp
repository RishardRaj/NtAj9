<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="msg" value="hello how are u?"/>
${fn:length(msg)} <br>
${fn:toUpperCase(msg)} <br>
${fn:toLowerCase(msg)} <br>
${fn:substring(msg,4,20)} <br>
${fn:contains(msg,"are")} <br>
${fn:startsWith(msg,"hello")} <br>
${fn:endsWith(msg,"u?")} <br>
