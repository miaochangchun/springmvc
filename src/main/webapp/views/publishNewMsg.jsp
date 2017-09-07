<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10048
  Date: 2017/9/6
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>企业日常事务管理系统-发布新消息</title>
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


<div id="place" style="margin-left: 274.6px; margin-right: 274.6px">当前位置：[<a href="index">首页</a>] - [发布新消息]</div>
<div id="channelcont">
    <div id="channelleft">
        <div class="channelinleft" style="margin-left: 274.6px; margin-right: 274.6px; padding-left: 168px; padding-right: 168px;margin-top: 20px;margin-bottom: 20px;">
            <div id="messageBox">
                <c:choose>
                    <c:when test="${error != null}">
                        <p>
                            <font color="red">${error}</font>
                        </p>
                    </c:when>
                    <c:otherwise>
                        <form action="msgPublish" method="post">
                            <p>消息标题：
                                <input type="text" name="title" size="50"/>
                            </p>
                            <p>消息内容： <input type="text" name="content" size="50"></p>

                            <p align="center">
                                <input type="submit" value="提交" />
                                <input type="reset" value="重置" />
                            </p>
                        </form>
                    </c:otherwise>
                </c:choose>
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
