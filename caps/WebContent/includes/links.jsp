<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- font-awesome -->    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">
		
</script>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnAddCourse").click(function() {
		var sDate = $("#id_start_date").val();
		var eDate = $("#id_end_date").val();
		if (eDate < sDate) {
			alert('End Date cannot be less than Start Date!');
			return false;
		}
	});
});
</script>


