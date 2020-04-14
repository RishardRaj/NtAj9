 <b><i> From D.jsp</i></b>
 <br>
<!-- read and dispaly the attribute value -->
attr1(page scope) attribute value: <%=pageContext.findAttribute("attr1") %>
<br>attr2(request scope) attribute value: <%=pageContext.findAttribute("attr2") %>
<br>attr3(session scope) attribute value: <%=pageContext.findAttribute("attr3") %>
<br>attr4(application scope) attribute value: <%=pageContext.findAttribute("attr4") %>
 