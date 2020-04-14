<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!-- SetUp DataSoruce /create Con obj-->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="scott" password="tiger" />

<sql:transaction dataSource="${ds}">
    <sql:update sql="update emp set sal=sal+? where empno=?">
       <sql:param value="2000"/>
       <sql:param value="7499"/>
    </sql:update>
    
</sql:transaction>
<b> Record Updated</b>

