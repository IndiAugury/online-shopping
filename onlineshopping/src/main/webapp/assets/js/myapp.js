$(function(){
	
	//solving active menu issue
	
	switch(menu)
	{
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProduct').addClass('active');
		break;
	default :
			$('#listProducts').addClass('active');
	$('#a_'+menu).addClass('active');
		break;
	}
});