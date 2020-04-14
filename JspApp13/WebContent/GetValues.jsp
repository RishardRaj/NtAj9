<%@page import="com.nt.StudentBean" %>

<!-- Locate Bean class obj -->
<jsp:useBean id="st" class="com.nt.StudentBean" scope="session"/>

<!--  Read and Display bean property values -->
sno = <jsp:getProperty property="sno" name="st"/> <br>
sname = <jsp:getProperty property="sname" name="st"/> <br>
Result = <jsp:getProperty property="result" name="st"/> <br>



