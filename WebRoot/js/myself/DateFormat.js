 function   simpleDate(now)   { 
    var   year=now.getFullYear();   
    var   month=now.getMonth()+1; 
    if(month<10){
  	  month="0"+month;
    }
    var   date=now.getDate();   
     
    return   year+"-"+month+"-"+date;   
}


function longDate(now)   { 
      var   year=now.getFullYear();   
      var   month=now.getMonth()+1; 
      if(month<10){
    	  month="0"+month;
      }
      var   date=now.getDate();   
      var   hour=now.getHours();   
      var   minute=now.getMinutes();   
      var   second=now.getSeconds();  
      var Week = ['日','一','二','三','四','五','六'];   
      var    day= Week[now.getDay()];  
      return   year+"-"+month+"-"+date+"   "+hour+":"+minute+":"+second+"   星期"+day;   
}           


function   shortDate(now)   { 
          var   year=now.getFullYear();   
          var   month=now.getMonth()+1; 
          if(month<10){
        	  month="0"+month;
          }
          var   date=now.getDate();   
          var   hour=now.getHours();   
          var   minute=now.getMinutes();   
          var   second=now.getSeconds();   
          return   year+"-"+month+"-"+date+"   "+hour+":"+minute+":"+second;   
}   



 