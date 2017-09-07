var mainContainerID="#pajaxMainContainer";//总的展示页面
jQuery(document).ready(function () {
    $("#defaultDisplay").click();//进入页面展开
    //点击出发请求
    $("p[class='zcd']").click(function () {
        var hrefVal = $(this).attr("href");
        if (hrefVal) {
            pajaxRequest(hrefVal,mainContainerID);
        }
    });
    if ($("#isRedirect").val()) {
        //刷新当前地址的请求
        $.pjax({
            url: '',
            container: mainContainerID
        });
    }
});