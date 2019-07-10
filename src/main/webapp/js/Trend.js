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
    		   //dataType:"json",
    		   success:function(req){ 
    			  

    				   alert(req);
    				   var a=[1,2,3,4,5,7,7,8,9,7,7,10];
    				   showImg(a);
                  
 
    		   }, 
    		 error:function(err){ 
    			   alert("error");
    		   } 
    		  
    		  });
    }else{
	  alert("文件格式不正确");
  }
       
    
 }


function showImg(dataset){

	var width = 1500;
	var height = 400;

	//鍦� body 閲屾坊鍔犱竴涓� SVG 鐢诲竷   
	var svg = d3.select("#img")
	    .append("svg")
	    .attr("width", width)
	    .attr("height", height);

	//鐢诲竷鍛ㄨ竟鐨勭┖鐧�
	 var padding = {left:30, right:30, top:20, bottom:20};

	 //x杞寸殑姣斾緥灏�
	 var xScale = /*d3.scale.ordinal()
	     .domain(d3.range(dataset.length))
	     .rangeRoundBands([0, 1440]);*/
		 d3.scale.linear()
	     .domain([1440,0])
	     .range([1440,0]);

	 //y杞寸殑姣斾緥灏�
	 var yScale = d3.scale.linear()
	     .domain([0,d3.max(dataset)])
	     .range([height - padding.top - padding.bottom, 0]);
	 
	//瀹氫箟x杞�
	 var xAxis = d3.svg.axis()
	     .scale(xScale)
	     .orient("bottom");

	 //瀹氫箟y杞�
	 var yAxis = d3.svg.axis()
	     .scale(yScale)
	     .orient("left");
	 
	//鐭╁舰涔嬮棿鐨勭┖鐧�
	var rectPadding = 0;

	 //娣诲姞鐭╁舰鍏冪礌
	 var rects = svg.selectAll(".MyRect")
	         .data(dataset)
	         .enter()
	         .append("rect")
	         .attr("class","MyRect")
	         .attr("transform","translate(" + padding.left + "," + padding.top + ")")
	         .attr("x", function(d,i){
	             return xScale(i);
	         } )
	         .attr("y",function(d){
	             return yScale(d);
	         })
	        /* .attr("width", xScale.rangeBand() - rectPadding )*/
	         .attr("width", '1px' )
	         .attr("height", function(d){
	             return height - padding.top - padding.bottom - yScale(d);
	         })
	         .attr("fill", "steelblue") ;

	 //娣诲姞鏂囧瓧鍏冪礌
	/* var texts = svg.selectAll(".MyText")
	         .data(dataset)
	         .enter()
	         .append("text")
	         .attr("class","MyText")
	         .attr("transform","translate(" + padding.left + "," + padding.top + ")")
	         .attr("x", function(d,i){
	             return xScale(i) + rectPadding/2;
	         } )
	         .attr("y",function(d){
	             return yScale(d);
	         })
	         .attr("dx",function(){
	             return (xScale.rangeBand() - rectPadding)/2;
	         })
	         .attr("dy",function(d){
	             return 20;
	         })
	         .text(function(d){
	             return d;
	         });*/
	 
	//娣诲姞x杞�
	 svg.append("g")
	   .attr("class","axis")
	   .attr("transform","translate(" + padding.left + "," + (height - padding.bottom) + ")")
	   .call(xAxis); 

	 //娣诲姞y杞�
	 svg.append("g")
	   .attr("class","axis")
	   .attr("transform","translate(" + padding.left + "," + padding.top + ")")
	   .call(yAxis);
};