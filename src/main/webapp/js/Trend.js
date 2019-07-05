function upload() { 
  var form = document.getElementById('upload'); 
    formData = new FormData(form); 
    
    var strFileName=form.file.value;
    alert(strFileName);
    
    //var suffix = strFileName.lastIndexOf(".");
    
    var fileext=strFileName.substring(strFileName.lastIndexOf("."),strFileName.length)
   fileext= fileext.toLowerCase();
    alert(fileext);
    if (".xls" == fileext || ".xlsx" == fileext ) {
    	$.ajax({ 
    		   url:"http://localhost:8080/mei/GetSheet", 
    		   type:"post", 
    		   data:formData, 
    		   processData:false, 
    		   contentType:false, 
    		   success:function(res){ 
    		    if(res){ 
    		     alert("上传成功！"); 
    		    } 
    		   }, 
    		   error:function(err){ 
    		    alert("网络连接失败,稍后重试",err); 
    		   } 
    		  
    		  });
    }else{
	  alert("文件格式不对！");
  }
  
 }