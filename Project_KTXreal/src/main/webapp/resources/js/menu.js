$(function() {
	$('.subNav').slideUp(0);
    $('.slide_menu').hover(function(){
        $('.subNav').stop().slideDown('fast');
    },function(){
        $('.subNav').stop().slideUp('fast');
    });
    
    $('.slide_menu > ul > li').hover(function(){
        $(this).find('>a').addClass('on');
    },function(){
        $(this).find('>a').removeClass('on');
    })

});


