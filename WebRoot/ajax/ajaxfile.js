// JScript 文件

var Obj_btn;
var Obj_btn1;
function createRequestObject()
{
    var ro;
    var browser = navigator.appName;
    if(browser=="Microsoft Internet Explorer")
    {
        ro=new ActiveXObject("Microsoft.XMLHTTP");//创建对象
    }
    else
        ro=new XMLHttpRequest();//创建对象
    return ro;
}
var http=createRequestObject();
function   sndReq(obj,url,filetype)
{
    Obj_btn=obj;
    http.open("get",url);//打开
    http.onreadystatechange=handleResponse;//调用函数
    http.send(null);
}
var http2=createRequestObject();
function   sndReq2(obj,url,filetype)
{
    Obj_btn1=obj;
    http2.open("get",url);//打开
    http2.onreadystatechange=handleResponse2;//调用函数
    http2.send(null);
}
function  handleResponse()
{
    if(http.readyState==4)
    {
        try{
 
        var response=http.responseText;
            if(response!="")
            {
                Obj_btn.className="btn_bmyj_s";

            }
            else
            {
                 Obj_btn.className="btn_bmyj";
            }
        }catch(e){}
    }
}
function  handleResponse2()
{
    if(http2.readyState==4)
    {
        try{
 
        var response=http2.responseText;
        var objDng=document.getElementById("btn_dng");   
     if(regexpSrt(response,"1")||regexpSrt(response,"2")||regexpSrt(response,"3")||regexpSrt(response,"4"))
        {
             Obj_btn1.className="btn_ckzw";
             
        }
        else
        {
            Obj_btn1.className="btn_jzzw_no";
        }
        if(objDng)
             {
                if(regexpSrt(response,"5"))
                {
                    objDng.className="sw_btn_dng_01_s";
                }
             }
        }catch(e){}
    }
}
function  regexpSrt(str1,str2) {

    var str1=str1;
    var str2=str2;
    var regexp=new  RegExp(str2,"i")
    var bool=regexp.exec(str1);
    if(bool!=null)
        return true;
    else
        return false;
}