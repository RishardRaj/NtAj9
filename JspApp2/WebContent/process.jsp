
<% int v1=Integer.parseInt(request.getParameter("t1"));
 int v2=Integer.parseInt(request.getParameter("t2"));
 int sum=v1+v2; %>
 
 <B>Sum is</B> <%=sum %>
<% 
 if(sum>=1000){ %>
    <b> sum is too big</b>
 <%   }
  else{ %>
   <b> Sum is too small</b>
  <%  } %>
   
   
 