$(function(){	
	
	var rating = $('.star-rating .rating');

	rating.each(function(){
		var targetScore = $(this).attr('data-rate');
		console.log(targetScore);
		$(this).find('svg:nth-child(-n+' + targetScore + ')').css({color:'#F05522'});
	});
});