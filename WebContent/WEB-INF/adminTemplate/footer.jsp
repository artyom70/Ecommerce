 	</div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/js/plugins/morris/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/morris/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/morris/morris-data.js"></script>
   <script>
   		var i = 1;
    	$("#customImage").click(function(){
            console.log("sdfsdf");
    		$("#productImages").append("<div class='form-group\'> <label>Image"+ i +" </label><input type='file' name='image"+ i +"'></div>");
    		if(i == 4) {
            	$(this).css("display", "none");
            }
   			i++;
    		
    	})
    		
    </script>
</body>

</html>
