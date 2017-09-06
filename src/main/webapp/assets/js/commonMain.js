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
$(document).on('pjax:complete', function () {
    NProgress.set(0.6);
    layer.close(loadIndex);
})
$(document).on('pjax:end', function () {
    NProgress.done();
})
$(document).on('pjax:error', function () {
    NProgress.done();
})
$(document).on('pjax:timeout', function (event) {
    // Prevent default timeout redirection behavior
    event.preventDefault();
    NProgress.done();
    layer.alert("请求超时！");
})
/////////////////////////////////////////////////////
function pajaxRequest(url,continerID) {
    $.pjax({url: url, container: continerID,type: "post",timeout:3000})
}