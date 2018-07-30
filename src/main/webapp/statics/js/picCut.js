////裁剪图片插件function
$(function(){
	
	maxWH($('#picCut'));
//	隐藏选择图片
	$('#upload').on('click',function(){
		$('#picCut').fadeOut();
	});
	$('#uploadCancel').on('click',function(){
		$('#picCut').fadeOut();
	});
	
	$('#chooseFile').on('click',function(){
		alert("aaa");
		$('#fileinput').click();
	})
	$(function() {
        var $editor = $('.image-editor');
        $editor.cropit();

        $('#upload').click(function() {
         	var imageData = $('.image-editor').cropit('export');
         	$.ajax({
         		type:"post",
         		data: {
         			flag : 1,
         			picImg: imageData
         		},
         		url: theUrl+'/common/sourceImg',
         	}).success(function(data) {
//       		imageUrl = data.data;
         		$.ajax({
	         		type:"post",
	         		data: {
	         			picImg: data.data
	         		},
	         		url: theUrl+'/web/personal/edit',
	         	}).success(function(data) {
	         		$('#author .face_wrap img').attr('src',imageData);
	//       		$('#header .headerRight img').attr('src',imageData);
	//       		$('#cen_head').attr('src',imageData);
	         	});
         	});
        });
    });
});