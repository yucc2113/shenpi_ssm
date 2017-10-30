<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" id="left_bg">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="../inc/tld.inc"%>
<link href="<%=path %>/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=path %>/css/sub.css" rel="stylesheet" type="text/css">
<script src="<%=path %>/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#btn_collapse2').height($(window).height()-12);
	$(window).resize(function() {
		$('#btn_collapse2').height($(window).height()-12);
		$('.left_menu_01').parent().find(' > ul').height($(window).height() - 28 - $('.left_menu_01').length * 25 );
	});
	$('.left_menu_01').parent().find(' > ul').height($(window).height() - 28 - $('.left_menu_01').length * 25 );
	$('.left_menu_01').click(function(event) {
		var event = event || window.event;
		event.preventDefault();
		$(this).blur();
		$('.left_menu_01').parent().find(' > ul').hide();
		$('.left_menu_01').find('.show_a').removeClass('a02').addClass('a01');
		$(this).parent().find(' > ul').show();
		$(this).parent().find(' > ul').height($(window).height() - 28 - $('.left_menu_01').length * 25 );
		$(this).find('.show_a').removeClass('a01').addClass('a02');
	});
	$('.left_menu_02').click(function(event) {
		var event = event || window.event;
		event.preventDefault();
		$(this).blur();
		var show = $(this).parent().find('.add_p').is('.end_expandable');
		if(show) {
			$(this).parent().parent().find(' > ul').show();
			$(this).parent().find('.add_p').removeClass('end_expandable').addClass('end_collapsable');
			$(this).parent().find('.folder_p').removeClass('folder_expandable').addClass('folder_collapsable');
		} else {
			$(this).parent().parent().find(' > ul').hide();
			$(this).parent().find('.add_p').removeClass('end_collapsable').addClass('end_expandable');
			$(this).parent().find('.folder_p').removeClass('folder_collapsable').addClass('folder_expandable');
		}
	});
	$('#btn_collapse').click(function(event) {
		var event = event || window.event;
		event.preventDefault();
		$(this).blur();
		$('#left').hide();
		$('#leftFrame', window.parent.document).attr('cols', '30,*');
		$('#btn_collapse2').show();
	});
	$('#btn_collapse2').click(function(event) {
		var event = event || window.event;
		event.preventDefault();
		$(this).blur();
		$('#left').show();
		$('#leftFrame', window.parent.document).attr('cols', '210,*');
		$('#btn_collapse2').hide();
	});
});
</script>
<title>吉林大学协同办公系统</title>
</head>
<body>
<div id="left">
	<h2><b class="fl">主菜单</b><a href="#" id="btn_collapse" title="收起"></a></h2>
	${leftMenu}
</div>
<div class="collapse" id="btn_collapse2" style="display:none;"><a href="#" title="展开"></a></div>
</body>
</html>
