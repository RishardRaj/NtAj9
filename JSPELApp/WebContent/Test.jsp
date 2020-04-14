
  sno : ${param.sno } <br>
  Sname : ${param.sname } <br>
   Address: ${paramValues.sadd[0] }, ${paramValues.sadd[1] }.
   <br><br>
   Browser name  : ${header['user-agent']} <br>
   Browser supported MIME types : ${header['accept']} <br>
   Browser supported MIME types : ${headerValues.accept[0]} <br>
   
   <br>
    user  init param value  ${initParam.user }
<%
   pageContext.setAttribute("attr1","val1");
   pageContext.setAttribute("attr2","val2",pageContext.REQUEST_SCOPE);
   pageContext.setAttribute("attr3","val3",pageContext.SESSION_SCOPE);
   pageContext.setAttribute("attr4","val4",pageContext.APPLICATION_SCOPE);
 %>
 <br><br>
  attr1 value : ${pageScope.attr1 } <br>
  attr2 value : ${requestScope.attr2 } <br>
  attr3 value : ${sessionScope.attr3 } <br>
  attr4 value : ${applicationScope.attr4 } <br>
  
  Session ID  ${cookie.JSESSIONID.value}
  
  
 
      
   
   
                                                                   
  
