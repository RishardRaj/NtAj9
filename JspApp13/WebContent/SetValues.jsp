<%@page import="com.nt.StudentBean" %>

<!--  Create JavaBean class obj -->
<jsp:useBean id="st" class="com.nt.StudentBean"  scope="session"/>
<!--  Set values to bean properties -->
<jsp:setProperty name="st" property="*"/>

<b> Values are Set to Bean properties</b>




