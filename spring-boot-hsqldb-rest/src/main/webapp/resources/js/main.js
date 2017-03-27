function doGet() {
    var contextPath = document.getElementById('input-context-path').value;
	
	$.ajax({
        type: 'GET',
        url: contextPath,
        dataType: 'json',
        async: true,
        success: function(result) {
        	output(JSON.stringify(result));
        },
        error: function(jqXHR, textStatus, errorThrown) {
        	output(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
}

function doPost() {
	
}

function doDelete(){
	
} 

function output(data){
	document.getElementById('output-textarea').value = data;
}