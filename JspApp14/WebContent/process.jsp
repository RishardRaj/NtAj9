<!-- create or locate Bean class obj -->
<jsp:useBean id="rg" class="com.nt.ResultGenerator"/>
<!-- Set Form data to Bean properties -->
<jsp:setProperty  name="rg" property="*"/>
 <!--  call b.method -->
 <% rg.calcResult(); %>
<!-- read and display Bean property values -->
Avg : <jsp:getProperty name="rg" property="avg"/><br>
Result : <jsp:getProperty name="rg" property="result"/><br> 

