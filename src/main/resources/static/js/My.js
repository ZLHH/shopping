

//登录
function login() {
    var account = $("#memberAcct").val();
    var password = $("#memberPwd").val();
    $.ajax({
        url: '/shopping/login',
        type: 'post',
        dataType: "json",
        data: "account=" + account + "&password=" + password,
        success: function (data) {
            if (data.code == '100') {
                alert(data.msg);
                window.location.href = "index.html";
            } else {
                alert(data.msg);
            }
        }
    });
}



//注册
function register() {
    var account = $("#memberSignupAccount").val();
    var password = $("#memberSignupPwd").val();
    var repwd = $("#memberSignupRepwd").val();
    var email = $("#email").val();
    var verifycode = $("#memberSignupCaptcha").val();
    if (password != repwd){
        alert("两次密码输入不一致");
    }
    $.ajax({
        url: '/shopping/register',
        type: 'post',
        dataType: "json",
        data: "account=" + account + "&password=" + password+"&email="+email+"&code="+verifycode,
        success: function (data) {
            if (data.code == '100') {
                alert(data.msg);
                window.location.href = "index.html";
            } else {
                alert("注册失败");
            }
        }
    });
}

function getCode(n) {
    var all = "azxcvbnmsdfghjklqwertyuiopZXCVBNMASDFGHJKLQWERTYUIOP0123456789";
    var b = "";
    for (var i = 0; i < n; i++) {
        var index = Math.floor(Math.random() * 62);
        b += all.charAt(index);

    }
    return b;
};

function change() {
    document.getElementById("memberSignupCaptchaImg").innerHTML = getCode(4);

}


function showOrders(ele, data) {
    $(ele).empty();
    $.ajax({
        url: 'querry/list',
        type: 'GET',
        data: data,
        success: function (data) {
            if (data.code == 100) {
                var list = data.map.pageInfo.list;
                console.log(list);
                var num=0;
                $(list).each(function (index, data) {
                    console.log(data);
                    var ProductInfo = '<div class="rcr"><div class="rcr-top"><img src="images/rc-'+data.productIcon+'" width="100%"></div><div class="rcr-bot"><div class="rb-top">' + data.productName + '</div><div class="second_P"><span class="fk-prop">￥</span><span class="fk-prop-price">' + data.productPrice + '</span> ' +
                        '<span class="second_Marketprice">￥0.00</span></div><div class="buy"><a class="second_mallBuy" href="orange.html?data='+data.productId+'"><span style="color: white;">购买</span></a></div></div></div>';
                    $(ele).append(ProductInfo);
                });
                var ele1 = $(".pages");
                build_pageInfo_teacherRequire(ele1, data)
            } else {
                $(".pages").empty();
            }
        }
    });
}






function build_pageInfo_teacherRequire(ele, data) {
    $(ele).empty();
    var pager_div = $("<div></div>").addClass("pager");
    var ul = $("<ul></ul>");
    $(ul).appendTo(pager_div)
    //首页
    var shouye_li = $("<li></li>").append($("<a></a>").append("首页"));
    shouye_li.click(function () {
        to_page_teacherRequire(1,data);
    });
    ul.append(shouye_li).addClass("banner-bottom");
    //上一页
    var prePageLi = $("<li></li>").append($("<span></span>").append("&laquo;")).addClass("net");
    prePageLi.click(function () {
        to_page_teacherRequire(data.map.pageInfo.pageNum - 1,data);
    });
    ul.append(prePageLi);
    //页码
    $.each(data.map.pageInfo.navigatepageNums, function (index, item) {

        var Li = $("<li></li>").append(
            $("<a></a>").append(item).addClass("active"));
        if (data.map.pageInfo.pageNum == item) {
            Li.find("a").addClass("active");
        }
        Li.click(function () {
            to_page_teacherRequire(item,data);
        });
        ul.append(Li);
    });
    //下一页
    var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;")).addClass("next");
    nextPageLi.click(function () {
        to_page_teacherRequire(data.map.pageInfo.pageNum + 1,data);
    });
    ul.append(nextPageLi);

    //末页
    var lastPageLi = $("<li></li>").append(
        $("<a></a>").append("末页"));
    lastPageLi.click(function () {
        to_page_teacherRequire(data.map.pageInfo.pages,data);
    });
    ul.append(lastPageLi);
    ul.appendTo(pager_div);
    pager_div.appendTo(ele);
    var clear = $("<div></div>").addClass("clear");
    clear.appendTo(ele);
}

function to_page_teacherRequire(pageNum,data) {
    var ele = $(".rec-right");
    if (pageNum>(data.map.pageInfo.pages)){
        pageNum=data.map.pageInfo.pages;
    }else if (pageNum<1){
        pageNum=1;
    }


    var data =  "&pageNum=" + pageNum;
    showOrders(ele, data);
}


