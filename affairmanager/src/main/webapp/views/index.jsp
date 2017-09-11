<%@ page import="com.miao.test.pojo.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>企业日常事务管理系统-首页</title>
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

    <div id="indexfirst">
        <div id="thenew">
            <div class="tit">
                <h1>最新消息</h1>
            </div>
            <div class="STYLE1" id="therecom">
                <table class="gridtable">
                    <tr>
                        <th>序号</th>
                        <th>标题</th>
                        <th>发布时间</th>
                        <th>作者</th>
                    </tr>
                    <c:forEach items="${messages}" var="message">
                        <tr>
                            <td><a href="message?mId=${message.mId}"> ${message.mId}</a></td>
                            <td><a href="message?mId=${message.mId}"> ${message.title}</a></td>
                            <td>${message.publishTime}</td>
                            <td>${message.employee.username}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div id="menunav">
            <div class="tit">
                <h1>员工信息</h1>
            </div>
            <div id="employee">
                <c:choose>
                    <c:when test="${employee == null}">
                        没有进行身份识别，请先进行身份识别!
                    </c:when>
                    <c:otherwise>
                        <ul>
                            <li>员工编号：${employee.eId}</li>
                            <li>员工姓名：${employee.username}</li>
                            <li>员工性别：${employee.male ? "男" : "女"}</li>
                            <li>出生日期：${employee.birth }</li>
                            <li>办公室电话：${employee.phone }</li>
                            <li>住址：${employee.place }</li>
                            <li>管理层领导：${employee.lead ? '是' : '否'}</li>
                        </ul>
                    </c:otherwise>
                </c:choose>
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
