

 <% //read bill amount form Bill.jsp as additional req param value
      float bAmt=Float.parseFloat(request.getParameter("bAmt"));
      // Calc Discount Amount
     float  discount=bAmt*0.3f;  %>
     <!--  Display bill amt details -->
     Item Name: <%=request.getParameter("tname") %> <br>
     Item Price: <%=request.getParameter("tprice") %> <br>
     Item Qty: <%=request.getParameter("tqty") %> <br>
     Bill amount :  <%=bAmt %> <br>
     Disocunt :  <%=discount %> <br>
     Final Bill amount :  <%=bAmt-discount %>
     
     
      
     
     
     
      