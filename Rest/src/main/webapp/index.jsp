<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.InputStream" %>
<%@page import="java.util.Properties" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trade</title>
    </head>
    <body>
        <p>${pageContext.request.requestURL}</p>
        <p>Trade Validate REST URLS:</p>
        <ol type="A" title="BdiCodeRest">
            <li>${pageContext.request.requestURL}trade/validatebulk <i>(POST)</i></li>
            <li>${pageContext.request.requestURL}trade/validate <i>(GET)</i></li>
        </ol>
        
        <body>
   </body>
    </body>
</html>
