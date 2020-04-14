<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

    <html>
      <body>
        <form action="process.jsp" method="post">
        <%
          //ReCaptcha c = ReCaptchaFactory.newReCaptcha("your_public_key", "your_private_key", false);
        ReCaptcha captcha = ReCaptchaFactory.newReCaptcha("6LfwU-kSAAAAANon6jhYZbfeeH-vgCKncnzs9WOr", "6LfwU-kSAAAAAGiis8gP7kS42ty9Wt_1euOGzj3J", false);
          out.print(captcha.createRecaptchaHtml(null, null));
        %>
        <input type="submit" value="submit" />
        </form>
      </body>
    </html>
