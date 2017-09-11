<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10048
  Date: 2017/9/6
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>企业日常事务管理系统-查看具体消息</title>
    <link href="css/css.css" type="text/css" rel="stylesheet" media="all" />
    <script src="js/menu.js" type="text/javascript"></script>
    <script src="/ueditor/ueditor.config.js"></script>
    <script src="/ueditor/ueditor.all.min.js"></script>
    <script src="/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
        UE.getEditor('myEditor');
        function clearLocalData () {
            UE.getEditor('myEditor').execCommand( "clearlocaldata" );
        }
    </script>
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

    <div id="place" style="margin-left: 274.6px; margin-right: 274.6px">当前位置：[<a href="index">首页</a>] - [消息列表] - [查看具体消息]</div>
    <div id="channelcont">
        <div id="channelleft" style="margin-left: 274.6px; margin-right: 274.6px">
            <div class="channelinleft">
                <br/>
                <h2 align="center">${message.title}</h2>
                <br/>
                ${message.content}
                <div align="right">
                    发布人：${message.employee.username}
                    发布时间：${message.publishTime}
                </div>

                <!--批复-->
                <div style="margin-top: 30px; margin-bottom: 20px;">
                    <c:choose>
                        <c:when test="${criticism != null}">        <%--已经有批复了，显示出来--%>
                            <h5 style="color:red">领导批复:${criticism.content}</h5>
                            <div align="right">
                                批复人：${criticism.employee.username}
                                批复时间：${criticism.criticismTime}
                            </div>
                            <hr/>
                        </c:when>
                        <c:otherwise>               <%--没有批复了，已经登录了，可以批复，没有登录，需要先登录--%>
                            <c:choose>
                                <c:when test="${employee == null}">
                                    请登录后才可以发表评论。
                                </c:when>
                                <c:when test="${employee.lead == false}">

                                </c:when>
                                <c:otherwise>       <%--如果领导已经批复了，则不能在批复了；没有批复，则可以批复。--%>
                                    <form action="criticismPublish" method="post">
                                        <p style="margin-top: 20px;margin-bottom: 20px;">批复内容：<textarea id="myEditor" name="content"></textarea></p>
                                        <input type="hidden" name="mId" value="${message.mId}">
                                        <p align="center">
                                            <input type="submit" value="提交" />
                                            <input type="reset" onclick="clearLocalData()" value="重置" />
                                        </p>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </div>


                <!--回复-->
                <c:forEach items="${replies}" var="reply">
                    <div style="margin-top: 30px;">
                            ${reply.content}
                        <div align="right">
                            回复人：${reply.employee.username}
                            回复时间：${reply.replyTime}</div>
                        <hr/>
                    </div>
                </c:forEach>

                <c:choose>  <%--非领导人员可以回复，不能批复。--%>
                    <c:when test="${employee == null}">
                    </c:when>
                    <c:when test="${employee.lead == false}">
                        <form action="replyPublish" method="post">
                            <p style="margin-top: 20px;margin-bottom: 20px;">回复内容：<textarea id="myEditor" name="content"></textarea></p>
                            <input type="hidden" name="mId" value="${message.mId}">
                            <p align="center">
                                <input type="submit" value="提交" />
                                <input type="reset" onclick="clearLocalData()" value="重置" />
                            </p>
                        </form>
                    </c:when>
                    <c:otherwise>

                    </c:otherwise>
                </c:choose>

                <%--<div align="center">--%>
                    <%--第<c:forEach varStatus="stat" begin="1" end="${page.totalPage}">--%>
                    <%--<a href="GetMessage?messageID=${message.messageID}&currentPage=${stat.index}">${stat.index}</a>--%>
                <%--</c:forEach>页--%>
                <%--</div>--%>

                <%--<div>--%>
                    <%--<div align="left">--%>
                        <%--<p>回复:</p>--%>
                        <%--<p><font color="red">${error }</font></p>--%>
                        <%--<form action="CommitReply" method="post">--%>
                            <%--<FCK:editor instanceName="replyContent" basePath="/fckeditor"--%>
                                        <%--toolbarSet="Basic" height="100" width="100%"></FCK:editor>--%>
                            <%--<input type="hidden" name="messageID" value="${message.messageID}"/>--%>
                            <%--<input type="submit" value="提交"/>--%>
                            <%--<input type="reset" value="重置"/>--%>
                        <%--</form>--%>
                    <%--</div>--%>

                    <%--<c:if test="${sessionScope.employee.lead}">--%>
                        <%--<div align="left">--%>
                            <%--<p>批复:</p>--%>
                            <%--<p><font color="red">${error }</font></p>--%>
                            <%--<form action="CommitCriticism" method="post">--%>
                                <%--<FCK:editor instanceName="criticismContent" basePath="/fckeditor"--%>
                                            <%--toolbarSet="Basic" height="100" width="100%"></FCK:editor>--%>
                                <%--<input type="hidden" name="messageID" value="${message.messageID}"/>--%>
                                <%--<input type="submit" value="提交"/>--%>
                                <%--<input type="reset" value="重置"/>--%>
                            <%--</form>--%>
                        <%--</div>--%>
                    <%--</c:if>--%>
                <%--</div>--%>
            </div>

        </div>
    </div>

    <%--<div id="indexsec"></div>--%>
    <div class="copyright" style="right: 0px; left: 0px; margin-top: 10px;">
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
