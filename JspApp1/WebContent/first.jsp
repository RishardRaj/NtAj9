
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Date"%>
<%! public String generateWishMessage(String user){
     //get Sys date
     java.util.Calendar cl=java.util.Calendar.getInstance();
     // get curent hour (in 24 hrs format)
     int h=cl.get(java.util.Calendar.HOUR_OF_DAY);
     //write logic
     if(h<=12)
          return "GM:"+user;
      else if(h<=16)
         return "GA:"+user;
        else if(h<=20)
         return "GE:"+user;
        else 
         return "GN:"+user;
         }
         %>
       <marquee><h1> Welcome to the World of JSP</h1> </marquee>
       <b> Date and Time:</b> <%=new java.util.Date() %> <br>
       <%String user="ramesh"; %>
       <br><br> 
       Wish Message : <%=generateWishMessage(user) %>
        
     
     
      