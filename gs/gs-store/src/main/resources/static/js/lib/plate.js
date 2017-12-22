/**
 * 核心js
 */
(function($){
	//返回401证明访问被拒绝，处于未上线状态，返回登录页
	$.ajaxSetup({
		cache: false,
		timeout: 300000,
		statusCode: {
			401: function() {
				window.top.location.href="/store/login";
			},
			400: function() {
				alert('请求被拒绝：含有非法参数或非法字符。');
			}
		}
	});
})(jQuery);

/**
 * 全局字典
 */
var Dictionary = {
		successCode:0,
		failCode:1
}