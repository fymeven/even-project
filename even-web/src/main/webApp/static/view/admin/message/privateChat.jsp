<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/chat_view.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:48 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>聊天窗口</title>
    <link rel="shortcut icon" href="/static/plugin/hplus/favicon.ico">
    <link href="/static/plugin/hplus/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/static/plugin/hplus/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/animate.min.css" rel="stylesheet">
    <link href="/static/plugin/hplus/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/static/plugin/hplus/css/plugins/toastr/toastr.min.css" rel="stylesheet">
    <link href="/static/css/hieven.css" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <input type="hidden" id="fromId" value="<shiro:principal property="id"/>">
        <input type="hidden" id="fromName" value="<shiro:principal property="realName"/>">
        <input type="hidden" id="fromUserPhoto" value="<shiro:principal property="userPhoto"/>">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox chat-view">
                    <div class="ibox-title">
                        <div style="text-align: center" id="toUserName"></div>
                        <small class="pull-right text-muted">当前<i class="label" id="onlineCount" style="float:none;">0</i>人在线</small> 聊天窗口
                    </div>
                    <div class="ibox-content">
                        <div class="row">
                            <div class="col-md-9 ">
                                <div class="chat-discussion">

                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="chat-users">
                                    <div class="users-list">

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="chat-message-form">
                                    <div class="form-group">
                                        <textarea class="form-control message-input" id="content" name="content" placeholder="输入消息内容，按回车键发送"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/static/plugin/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="/static/plugin/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="/static/plugin/hplus/js/plugins/layer/layer.min.js"></script>
    <script src="/static/plugin/hplus/js/content.min.js?v=1.0.0"></script>
    <script src="/static/plugin/hplus/js/plugins/toastr/toastr.min.js"></script>
    <script src="/static/plugin/hplus/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="/static/js/evenPack.js"></script>
    <script src="/static/js/ToolUtil.js"></script>
    <script src="/static/js/admin/message/privateChat.js"></script>
    <script>
        $(function(){
            chat.init();
        });
    </script>
</body>
</html>
