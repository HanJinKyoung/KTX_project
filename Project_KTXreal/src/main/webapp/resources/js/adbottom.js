/**
 * 
 */
$(function(){
      $('.content').css("background",'none');
	  $('#notice').load("notice.kbd");
      $('#innotice').load("innotice.ib");
      $('#credit').load("credit.dis");      
	  $('.flexslider').flexslider({
	    animation: "slide",
	    slideshowSpeed: 5000
	  });
   });