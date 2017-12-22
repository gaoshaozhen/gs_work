/**
 * 加载菜单
 */
(function(){
	
	function loadMenu(menuList){
		var dom = '';
		for(var i =0; i < menuList.length; i++){
			dom += '<div class="panel menu-group">'
		       	+ '		<div class="panel-heading">'
		       	+ '			<h3 class="panel-title ">'+menuList[i].text+'</h3>'
		       	+ '		</div>'
		       	+ '		<div class="panel-body"><ul>';
			if(typeof menuList[i].children != 'undefined' && menuList[i].children.length > 0){
				for(var j =0; j < menuList[i].children.length; j ++){
					dom += '<li><a href="' + menuList[i].children[j].action + '">' + menuList[i].children[j].text + '</li>';
				}
			}
			dom += '</ul></div>'
				+ '</div>';
		}
		console.debug(dom);
		$("#main-menu").html(dom);
	}
	$.get('/sys/menu/all', function(res){
		if(res.code == 1){
			alert(res.message);
			return;
		}
		loadMenu(res.data);
	}, 'json');
})();