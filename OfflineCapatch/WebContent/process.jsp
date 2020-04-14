<%@page import="nl.captcha.Captcha"%>
<%
Captcha captcha=(Captcha)session.getAttribute(Captcha.NAME);
//request.setCharacterEncoding("UTF-8");

String answer=request.getParameter("answer");

if(captcha.isCorrect(answer))
out.println("Correct");

else 
out.println("Incorrect");
%>

