<html>
<body>
<h2>Hello World!</h2>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.js"></script>
<script>
$.ajax({
	url: '/webdiapp/goods/listing',
	type: "get",
	dataType: 'json',
	
}).then(function(res) {
	debugger
}).fail(function(error) {
	debugger
})
</script>
</body>
</html>
