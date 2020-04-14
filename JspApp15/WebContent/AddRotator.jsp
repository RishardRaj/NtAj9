<%@page import="java.util.*"  %>

<jsp:useBean id="rotator"  class="com.nt.Rotator" scope="application"/>
<%
  rotator.nextAdvertisement();
  response.setHeader("refresh","2");
 %>
 <br>
 <a href="<jsp:getProperty name="rotator" property="link"/>">
    <img  src="<jsp:getProperty name="rotator" property="image" />" width="300" height="300"/>
 </a>

