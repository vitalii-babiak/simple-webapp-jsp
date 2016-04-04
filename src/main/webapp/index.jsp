<%@ page import="java.util.List" %>
<%@ page import="homework.model.FileRecord" %>
<%@ page language="java" contentType="text/html; US-ASCII" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Homework</title>
<style>
    .fxwidth {
        max-width: 900px;
        margin: 0 auto;
        position: relative;
    }
    .entry {
        margin: 20px 0;
        clear: both;
    }
    .letter {
        width: 0px;
        overflow: visible;
        float: left;
        font-size: 50px;
    }
    .letter:before{
        content: '';
        position: absolute;
        left: 0;
        right: 0;
        border-top: 1px solid #666;
    }
    .title {
        margin-left: 100px;
        float: left;
        width: 30%;
    }
    fieldset {
        padding: 2% 5%;
        margin: 5% 0;
    }
    #uploadbtn {
        float: right;
    }
</style>
<body>
<div class="fxwidth">
    <form action="MainServlet" method="post" enctype="multipart/form-data">
        <fieldset>
            <legend>Upload ZIP file</legend>
            <input type="file" name="zipfile" size="100" id="zipfile"
                   onchange="document.getElementById('uploadbtn').disabled=this.value.match('\.zip$')?false:true;"><br>
            <input name="upload" type="submit" id="uploadbtn" value="Upload" disabled="disabled">
        </fieldset>
    </form>
    <br>
    <% List<FileRecord> dt = (List<FileRecord>)request.getAttribute("dt");%>
    <% if(dt != null) { %>
      <% char letter = '\0'; %>
      <% for (FileRecord r : dt) { %>
      <div class="entry">
          <% if(letter != r.getLetter()) { %>
            <% letter = r.getLetter(); %>
            <div class="letter"><%=r.getLetter()%></div>
          <% } %>
          <div class="title"><%=r.getTitle()%></div>
          <div class="filename"><%=r.getFilename()%></div>
      </div>
      <% } %>
    <% } %>
<!-- JSTL Not working
    ${dt} ${requestScope["dt"]}<br>
    <c:if test="${requestScope.dt ne null}">
    <c:set var="letter" value="\0"/>
    <c:forEach items="${requestScope.dt}" var="r">
    <div class="entry">
        <c:if test="${letter} != ${r.getLetter()}">
            <c:set var="letter" value="${r.getLetter()}"/>
            <div class="letter"><c:out value="${letter}"/></div>
        </c:if>
        <div class="title"><c:out value="${r.getTitle()}"/></div>
        <div class="filename"><c:out value="${r.getFilename()}"/></div>
    </div>
    </c:forEach>
    </c:if>
    -->
</div>
</body>
</html>
