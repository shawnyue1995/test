//如果如下函数封装ajax的get请求
//思考：对于一个请求而言，往往不同的是什么？
//1)url可能不同
//2)参数可能不同
//3)处理结果的方式不同
//思考:一般我们在程序中对共性提取，进行封装，变化数据通过参数进行传递。
(function () {
    var ajax = function () {
    }
    ajax.prototype = {

        doAjaxGet: function (url, params, callback) {
            //1.创建异步请求对象XHR
            var xhr = new XMLHttpRequest();
            //2.设置状态监听
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    callback(xhr.responseText);
                }
            };
            //3.建立连接
            xhr.open("GET", url + "?" + params, true);
            //4.发送请求
            xhr.send(null);
        },
        doAjaxPost: function (url, params, callback) {
            //1.创建异步请求对象XHR
            var xhr = new XMLHttpRequest();
            //2.设置状态监听
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    callback(xhr.responseText);
                }
            };
            //3.建立连接(请求方式为post方式)
            xhr.open("POST", url, true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
            //4.发送请求
            xhr.send(params);//post请求将将参数写到send方法内部
        }
    }
    window.Ajax = new ajax();
})()





