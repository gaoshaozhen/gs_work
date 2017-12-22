/**
 * 
 */
(function($){
	//要渲染的数据面板
	var panel = null;
	var defaultOptions = {
		method:'get',
		dataType:'json',
		width:'100%',
		height:'500',
		columns:[],
		data:[],
		fit:false,
		url:'',
		pageNumber:[10, 20, 30],
		//是否显示分页栏
		showPage:true,
		//返回参数不一致时可由此回调方法返回组件需要的格式
		success:null,
		addDataParams:null
	};	
	//缓存组件dom
	var $tableDom = {};
	var rowsStart = 0;
	var pageNumber = 1;
	
	//创建标题栏
	function createHeaders(){
		
		var dom = '<thead>';
		for(var i=0; i < defaultOptions.columns.length; i++){
			var column = defaultOptions.columns[i];
			
			dom += '<th style="width:' + column.actualWidth + '">' + column.text + '</th>';
		}		
		dom += '</thead>';
		return dom;
	}
	//创建table
	function createTable(){
		var dom = '<table class="gs-table"  border="1">'
				+ createHeaders()
				+ '<tbody></tbody>'
				+ '</table>';
		return dom;
	}
	function previousPage(){
		refresh('pre');
	}
	
	function nextPage(){
		refresh('next');
	}
	
	//刷新数据
	var refresh = function(params){
		function reLoadTable(data){
			var dom = '';
			for(var i = 0, len = data.rows.length; i < len; i++){
				dom += '<tr>';
			    for(var j =0, comLen = defaultOptions.columns.length; j < comLen; j++){
			    	var render = defaultOptions.columns[j].render;
			    	if(typeof render == 'function'){
			    		dom += '<td style="min-width:' + defaultOptions.columns[j].actualWidth + '">' + render(data.rows[i]) + '</td>'; 
			    	}else{
			    		dom += '<td style="min-width:' + defaultOptions.columns[j].actualWidth + '">' + data.rows[i][defaultOptions.columns[j].field] + '</td>';
			    	}
			    }
			    dom += '</tr>';
			}
			panel.find('tbody').html(dom);			
			$tableDom.totalDom.html(data.total);
			$tableDom.currentPageDom.text(rowsStart);
			//rowsStart代表当前数据的起始行
			rowsStart += rowsStart > 0 ? data.rows.length : 0;
			if(rowsStart > 1){//可向前翻页
				$tableDom.previousPageBtnDom.on('click', previousPage);
			}else if(rowsStart + ajaxParams < data.total){//可向后翻页
				$tableDom.nextPageBtnDom.on('click', nextPage);
			}
			if(params == 'pre'){
				pageNumber--;
			}else if(params == 'next'){
				pageNumber++;
			}
			$tableDom.currentPageDom.text(pageNumber);
		}
		
		var ajaxParams = {
				"limit" : $tableDom.pageNumberDom.find("select[name=pageNumber]").val()
		};
		if(params === 'pre'){
			ajaxParams.offset = rowsStart -   ajaxParams.limit;
		}else if(params === 'next'){
			ajaxParams.offset = rowsStart + ajaxParams.limit;
		}else{
			ajaxParams.offset = rowsStart;
		}
		if(ajaxParams.offset < 0){
			ajaxParams.offset = 0;
		}
		//获取额外参数
		if(typeof defaultOptions.addDataParams == 'function'){
			var extendsParams = defaultOptions.addDataParams();
			var keys = Object.keys(extendsParams);
			if(keys.length > 0){
				for(var i =0; i < keys.length; i++){
					ajaxParams[keys[i]] = extendsParams[keys[i]];
				}
			}
		}
		$.ajax({
			type:defaultOptions.method,
			url:defaultOptions.url,
			data:ajaxParams,
			dataType:defaultOptions.dataType,
			beforeSend:function(){},
			complete:function(){
				$tableDom.previousPageBtnDom.off();
				$tableDom.nextPageBtnDom.off();				
			},
			error:function(res){
				alert(res);
			},
			success:function(res){
				reLoadTable(typeof defaultOptions.success == 'function' ? defaultOptions.success(res) : res);
			}
		});
	}
	//修改默认参数
	function initOptions(options){
		if(typeof options == 'object'){
			var keys = Object.keys(defaultOptions);
			var k = Object.keys(options);
			for(var i =0; i < keys.length; i++){
				for(var j =0; j < k.length; j++){
					if(keys[i] == k[j]){
						defaultOptions[keys[i]] = options[k[j]];
					}
				}
			}
		}
		initColumnsWidth();
	}
	//计算标题宽度比例
	function initColumnsWidth(){
		var headers = defaultOptions.columns;
		var maxWidth = panel.width() - 25;
		var count = 0;
		for(var i=0; i < headers.length; i++){
			count += typeof headers[i].width == 'number' ? headers[i].width : 0;  
		}
		for(var i=0; i < headers.length; i++){
			if(typeof headers[i].width == 'number'){
				if(defaultOptions.fit){
					headers[i].actualWidth = (headers[i].width / count) * maxWidth + 'px';
				}else{
					headers[i].actualWidth= headers[i].width + 'px';
				}
			}else{
				headers[i].actualWidth = 'auto';
			}			
		}
	}
	//创建分页栏
	function createPage(){
		var dom = '<div class="gs-pagination">数量<select name="pageNumber">';
			for(var i =0; i < defaultOptions.pageNumber.length; i++){
				if(i ==0 ){
					dom += '<option value="num" selected="selected">num</option>'.replace(/num/g, defaultOptions.pageNumber[i]);
				}else{
					dom += '<option value="num">num</option>'.replace(/num/g, defaultOptions.pageNumber[i]);
				}
			}
			dom += '</select>';
			dom += '<a class="previous-page">上一页</a><span class="current-page">0</span><a class="next-page">下一页</a><span>共<span class="total">0</span>条数据</span>';
			var $dom = $(dom);
			$tableDom.pageNumberDom = $dom;
			$tableDom.previousPageBtnDom = $dom.find(".previous-page");
			$tableDom.nextPageBtnDom = $dom.find(".next-page");
			$tableDom.currentPageDom = $dom.find(".current-page");
			$tableDom.totalDom = $dom.find(".total");
			return $dom;
	}
	//数据面板
	var gsTable = function(options, target){
		$tableDom = {};
		panel = target;		
		initOptions(options);
		var table = this;
		//初始化数据面板
		this.init = function(){
			//初始化表格
			panel.css({
				width:defaultOptions.width,
				height:defaultOptions.height+'px'
			});
			
			panel.html(createTable()); 
			panel.find('thead').css('height','80px');
			panel.find('.gs-table').width(defaultOptions.width);
			if(defaultOptions.showPage){
				panel.append(createPage());
				panel.find('gs-pagination').height('80px');
			}								
			return table;
		};
		this.load = function(){
			refresh();
		};
	}
	
	$.fn.extend({
		gsTable : function(options){
			return new gsTable(options, this); 
		}
	});
})(jQuery);