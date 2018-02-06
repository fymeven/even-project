var chat={
    init:function () {
        this.method.loadUserList();
        this.event();
    },
    obj:{
        toId:''
    },
    method:{
        loadUserList:function () {
            Ep.ajax({
                url:'/message/getOnlineUserList',
                succFunc:function (result) {
                    var html=[];
                    $('#onlineCount').text(result.length);
                    $.each(result,function (i, o) {
                        html.push('<div class="chat-user"><img class="chat-avatar" src="'+o.userPhoto+'" alt=""><div class="chat-user-name"><a onclick="chat.method.chatToOther(\''+o.id+'\',\''+o.realName+'\');">'+o.realName+'</a></div></div>');
                    });
                    $('.users-list').html(html.join(''));
                }
            });
        },
        chatToOther:function (toId,toName) {
            chat.obj.toId=toId;
            $('#toUserName').html('正在与&nbsp;<span class="label label-primary" style="float:none;">'+toName+'</span>&nbsp;聊天');
        },
        sendMsg:function () {
            var data={
                toId:chat.obj.toId,
                fromId:$('#fromId').val(),
                fromName:$('#fromName').val(),
                fromUserPhoto:$('#fromUserPhoto').val(),
                content:$('#content').val()
            };
            var html=[];
            html.push('<div class="message-box"><div class="message-right"><img class="message-avatar" src="'+data.fromUserPhoto+'" alt=""><div class="message"><a class="message-author" href="javascript:void(0);">'+data.fromName+'</a><span class="message-date">'+new Date().format("yyyy-MM-dd hh:mm:ss")+'</span>');
            html.push('<span class="message-content">'+data.content+'</span></div></div></div>');
            $('.chat-discussion').append(html.join(''));
            webSocket.sendMsg(JSON.stringify(data));
        }
    },
    event:function () {
        $(document).on('keydown', '#content', function(e) {
            if(e.keyCode == 13 ) {
                chat.method.sendMsg();
            }
        })
    }
}
var webSocket={
    ws:{},//webocket对象
    init:function(){
        if ("WebSocket" in window){ //如果浏览器不支持 websocket 使用sockjs模拟
            this.ws = new WebSocket('ws://'+window.location.host+'/webSocket');
        } else {
            this.ws = new SockJS('http://'+window.location.host+'/sockJs/webSocket');
        }
        this.ws.onopen=function (evnt) {
            console.log('webSocket已成功连接服务器...');
        };
        this.ws.onmessage=function (evnt) {
            var message = JSON.parse(evnt.data);
            console.log('webSocket收到消息:'+message.content);
            var html=[];
            html.push('<div class="message-box"><div class="message-left"><img class="message-avatar" src="'+message.fromUserPhoto+'" alt=""><div class="message"><a class="message-author" href="javascript:void(0);">'+message.fromName+'</a><span class="message-date">'+new Date(message.sendTime).format("yyyy-MM-dd hh:mm:ss")+'</span>');
            html.push('<span class="message-content">'+message.content+'</span></div></div></div>');
            $('.chat-discussion').append(html.join(''));
        }
        this.ws.onerror = function(evnt) {
            console.log('webSocket出错,请尝试重新刷新页面');
        };
        this.ws.onclose = function(evnt) {
            console.log('webSocket已与服务器断开连接');
        }
    },
    sendMsg:function (data) {
        this.ws.send(data);
    }
}
