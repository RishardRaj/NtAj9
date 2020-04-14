
<% //read form data
  String name=request.getParameter("tname");
  int price=Integer.parseInt(request.getParameter("tprice"));
  int qty=Integer.parseInt(request.getParameter("tqty"));
  float billAmt=price*qty;
  if(billAmt>=50000){  %>
     <jsp:forward page="discount.jsp">
          <jsp:param name="bAmt"   value="<%=billAmt%>"/>
     </jsp:forward>
   <%}
       else{
    %>
            <h2>Bill Amount with out discount </h2> 
              Item Name: <%=name %> <br>
              Item Price : <%=price %> <br>
              Item Qty :  <%=qty %> <br>
              Bill amoint : <%=billAmt %>
     <%} %>

