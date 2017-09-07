<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10048
  Date: 2017/9/6
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>企业日常事务管理系统-消息列表</title>
    <link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
    <script src="js/menu.js" type="text/javascript"></script>
</head>
<body>
<div id="topexplain">企业日常事务管理系统，为企业内部通信提供最简便的服务！</div>
<div id="topmenu">
    <img src="img/banner.jpg" width="970" height="136" />
</div>
<div id="bookmunu">
    <div class="jsmenu" id="jsmenu">
        <ul>
            <li class="normal">
                <a href="index" urn="#jsmenu1" rel="">首页</a>
            </li>
            <li class="normal">
                <a urn="jsmenu2" rel="conmenu" href="GetMessageList?currentPage=0">消息列表</a>
            </li>
            <li class="normal">
                <a urn="jsmenu3" rel="conmenu" href="publishNewMsg">发布新消息</a>
            </li>
            <li class="active">
                <a urn="default_Info" rel="conmenu" href="statusRecognise">身份识别</a>
            </li>
        </ul>
    </div>
    <div id="conmenu"></div>
</div>

<div id="place" style="margin-left: 274.6px; margin-right: 274.6px">当前位置：[<a href="index">首页</a>] - [消息列表]</div>
<div id="channelcont">
    <div id="channelleft">
        <div class="channelinleft" style="margin-left: 274.6px; margin-right: 274.6px; padding-left: 168px; padding-right: 168px;margin-top: 20px;margin-bottom: 20px;">
            <div class="channeltit"></div>
            <table class="gridtable">
                <tr>
                    <th>序号</th>
                    <th>标题</th>
                    <th>发布时间</th>
                    <th>作者</th>
                </tr>
                <c:forEach items="${messageList}" var="message">
                    <tr>
                        <td><a href="message?mId=${message.mId}"> ${message.mId}</a></td>
                        <td><a href="message?mId=${message.mId}"> ${message.title}</a></td>
                        <td>${message.publishTime}</td>
                        <td>${message.employee.username}</td>
                    </tr>
                </c:forEach>
            </table>
            <div style="margin-left: 150px;margin-right: 150;font-size: 14;margin-top: 5px;margin-bottom: 5px;">
                每页显示12条数据
                <s:if test="${page.curPage > 0}">
                    <a href="GetMessageList?currentPage=0"><span>首页</span></a>
                    <a href="GetMessageList?currentPage=${page.curPage - 1}"><span>上一页</span></a>
                </s:if>
                <span>共${page.rowCount}条数据，共${page.curPage}/${page.pageCount}页</span>
                <s:if test="${page.curPage < page.pageCount}">
                    <a href="GetMessageList?currentPage=${page.curPage + 1}"><span>下一页</span></a>
                    <a href="GetMessageList?currentPage=${page.pageCount}"><span>尾页</span></a>
                </s:if>
            </div>
        </div>
    </div>
</div>

<div id="indexsec"></div>
<div class="copyright" style="right: 0px; left: 0px;">
    <ul>
        <li></li>
        <li>企业日常事务管理系统 &nbsp;&copy;2009-2010</li>
    </ul>
</div>
<div class="end"></div>

<script type=text/javascript>
    startajaxtabs("jsmenu");
    var iTab=GetCookie("nets_jsmenu");
    iTab = iTab ? parseInt(iTab):parseInt(Math.random()*5);
    if(iTab!=0) getElement("jsmenu").getElementsByTagName("h1")[iTab].LoadTab();
    iTab++;
    if(iTab>4) iTab=0;
    SetCookie("nets_jsmenu",iTab,365);
    function getElement(aID)
    {
        return (document.getElementById) ? document.getElementById(aID)
            : document.all[aID];
    }
</script>
</body>
</html>
