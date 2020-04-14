<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!-- SetUp DataSoruce /create Con obj-->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="scott" password="tiger" />
<!-- Execute Select Query and get ResultSet obj -->
<sql:query var="res_set" sql="select * from emp" dataSource="${ds}"/> 
<!--  Process the ResultSet-->
<c:forEach var="row"  items="${res_set.rows}">
<br>
   <c:out value="${row.empno }"/> &nbsp; &nbsp;
   <c:out value="${row.ename }"/>
   
</c:forEach>



