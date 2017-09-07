var loadIndex;
$(document).on('pjax:beforeSend', function () {
    NProgress.start();
})
$(document).on('pjax:send', function () {
    NProgress.set(0.3);
    loadIndex = layer.load(0, {
        shade: [0.1, '#fff']
    });
})
$(document).on('pjax:complete', function (xhr, textStatus) {
    NProgress.set(0.6);
    layer.close(loadIndex);
})
$(document).on('pjax:end', function () {
    NProgress.done();
})
$(document).on('pjax:error', function (xhr, textStatus, errorThrown) {
    NProgress.done();
    if (textStatus.status == 404) {
        layer.alert("无此页面！");
    } else if (textStatus.status == 0) {
        layer.alert("服务器已关闭！");
    } else {
        layer.alert("服务器错误！ 错误码：" + textStatus.status);
    }
})
$(document).on('pjax:timeout', function (event) {
    // Prevent default timeout redirection behavior
    NProgress.done();
    layer.alert("请求超时！");
    event.preventDefault();
})
/////////////////////////////////////////////////////
function pajaxRequest(url, continerID, pushstate) {
    var push = true;
    if (!pushstate) {
        push = pushstate;
    }
    //post不用设置超时时间
    $.pjax({url: url, container: continerID, type: "post", push: push})
}
////////
function initPajaxRequestForClick(continerID) {
    var $click = $("[pajax-data]");
    $click.click(function () {
        var href = $(this).attr("href");
        var del = $(this).attr("del");
        if (href) {
            if (del) {
                layer.confirm('请谨慎操作！', {icon: 3, title:'删除条目'}, function(index){
                    //do something
                    pajaxRequest(href, continerID);
                    layer.close(index);
                });
            } else {
                pajaxRequest(href, continerID);
            }
        } else {
            layer.alter("缺少请求地址！");
        }
    });
}
////
function initPajaxFormRequestForClick(continerID) {
    var $form = $("[pajax-form]");
    //$.pjax.submit(event, '#pjax-container')
    $form.submit(function (event) {
        var action = $(this).attr("action");
        if (action) {
            $.pjax.submit(event, continerID)
        } else {
            layer.alert("表单没有提交路径！");
        }
        return false;
    })
}