
jQuery.jPrintArea=function(el)
{
var iframe=document.createElement('IFRAME');
var doc=null;
$(iframe).attr('style','position:absolute;width:0px;height:0px;left:-500px;top:-500px;');
document.body.appendChild(iframe);
doc=iframe.contentWindow.document;
doc.write('<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" />');
var links=window.document.getElementsByTagName('link');
for(var i=0;i<links.length;i++)
if(links[i].rel.toLowerCase()=='stylesheet')
doc.write('<link type="text/css" rel="stylesheet" href="'+links[i].href+'"></link>');
doc.write('</head><body>');
$("#list").addClass("search_mid1");
$("#user").addClass("search_mid1");
$("#listTable").addClass("data_list_a1");
doc.write('<div class="'+$(el).attr("class")+'">'+$(el).html()+'</div><br/>');
doc.write('</body></html>')
doc.close();
iframe.contentWindow.focus();
iframe.contentWindow.print();
document.body.removeChild(iframe);
}

