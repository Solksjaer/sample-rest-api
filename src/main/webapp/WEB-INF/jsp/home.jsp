<%@page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Entry page</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/helpers.js"></script>
</head>
<body>

<script type="text/javascript">
    var contextPath = '${pageContext.request.contextPath}';
</script>

WELCOME!

<div>
    <form name="ajaxform" id="ajaxform">
        <div>
            <label for="currency">Currency</label>
            <select name="currency" id="currency">
                <option value="bitcoin">Bitcoin</option>
                <option value="dogecoin">Dogecoin</option>
            </select>
        </div>
        <div>
            <label for="locale">Locale IP</label>
            <input name="locale" id="locale" value="" placeholder="IP to obtain the locale">
        </div>
    </form>
    <div>
        <button id="send">Get values</button>
    </div>

    <div id="results">
        Current unit price:
        <pre id="resultsContent" class=resultsContent"></pre>
    </div>
</div>

</body>
</html>