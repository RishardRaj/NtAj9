
  <b>from Search.jsp (start)</b>
<% 
//read form data
     String ss=request.getParameter("ss");
     //redirect the request to google search engg
      response.sendRedirect("https://www.google.co.in/search?q="+ss);
      %>
     <b> From Search.jsp (end)</b>
      