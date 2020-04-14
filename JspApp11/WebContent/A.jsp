<b><i> From A.jsp </i></b> <br>
<%
  //create attributes
  pageContext.setAttribute("attr1","val1");
  pageContext.setAttribute("attr2","val2",pageContext.REQUEST_SCOPE);
  pageContext.setAttribute("attr3","val3",pageContext.SESSION_SCOPE);
  pageContext.setAttribute("attr4","val4",pageContext.APPLICATION_SCOPE);
 %>
  <!-- forward the request -->
   <jsp:forward page="B.jsp"/>
   
