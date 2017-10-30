	function getIframeOs(){
		var browsers = {};
		var ua = navigator.userAgent.toLowerCase();
	    window.ActiveXObject ? browsers.ie = ua.match(/msie ([\d.]+)/)[1] :
	    document.getBoxObjectFor ? browsers.firefox = ua.match(/firefox\/([\d.]+)/)[1] :
	    window.MessageEvent && !document.getBoxObjectFor ? browsers.chrome = ua.match(/chrome\/([\d.]+)/)[1] :0;
	    if(browsers.ie){return 'ie';}
	    else if(browsers.firefox){return 'firefox';}
	    else if(browsers.chrome){return 'chrome';}
	    else{return 'nothing';}
	}
	var this_os = getIframeOs();
	function onlyNum_hp(){
		var evt = arguments.callee.caller.arguments[0]||window.event;
		var currentKey = evt.which ? evt.which :evt.keyCode;
		if(!(currentKey==46)&&!(currentKey==8)&&!(currentKey==37)&&!(currentKey==39)){
			if(!((currentKey>=48&&currentKey<=57)||(currentKey>=96&&currentKey<=105))){
				if(this_os=='ie'){window.event.returnValue=false;}
	    		if(this_os=='firefox'){evt.preventDefault();}
	    		if(this_os=='chrome'){evt.preventDefault();}
			}
		}
	}
	function onlyNum_phone(){
		var evt = arguments.callee.caller.arguments[0]||window.event;
		var currentKey = evt.charCode||evt.keyCode;
		if(!(currentKey==46)&&!(currentKey==8)&&!(currentKey==37)&&!(currentKey==39)){
			if(!((currentKey>=48&&currentKey<=57)||(currentKey>=96&&currentKey<=105) || currentKey==189 || currentKey==32)){
				if(this_os=='ie'){window.event.returnValue=false;}
	    		if(this_os=='firefox'){evt.preventDefault();}
	    		if(this_os=='chrome'){evt.preventDefault();}
			}
		}
	}
	function onlyNum_double(){
		var evt = arguments.callee.caller.arguments[0]||window.event;
		var currentKey = evt.charCode||evt.keyCode;
	 	if(!(currentKey==46)&&!(currentKey==8)&&!(currentKey==37)&&!(currentKey==39)){
	 	 	if(!((currentKey>=48&&currentKey<=57)||(currentKey>=96&&currentKey<=105) || currentKey==190 || currentKey==110)){
	    		if(this_os=='ie'){window.event.returnValue=false;}
	    		if(this_os=='firefox'){evt.preventDefault();}
	    		if(this_os=='chrome'){evt.preventDefault();}
	   	 	}
	  	}
	}