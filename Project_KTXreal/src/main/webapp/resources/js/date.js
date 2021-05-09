/**
 * 
 */
$(function(){
var today = new Date();
var yyyy = today.getFullYear();
var mm = today.getMonth()+1;
var dd = today.getDate();
	if(mm<10){mm='0'+mm} 
	if(dd<10){dd='0'+dd}
minday = yyyy+'-'+mm+'-'+dd;
document.getElementById("startday").setAttribute("min", minday);
//최대예매일(1달_30일)
maxday = new Date(today.valueOf()+(24*60*60*1000)*30);
  	maxy = maxday.getFullYear();
    maxm = maxday.getMonth()+1;
    maxd = maxday.getDate();
	if(maxm<10){maxm='0'+maxm} 
	if(maxd<10){maxd='0'+maxd} 
maxday = maxy+'-'+maxm+'-'+maxd;
document.getElementById("startday").setAttribute("max", maxday);

});