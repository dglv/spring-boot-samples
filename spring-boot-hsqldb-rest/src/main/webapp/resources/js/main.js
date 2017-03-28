function doGet() {
	$.ajax({
        type: 'GET',
        url: getContextPath(),
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
	$.ajax({
        type: 'POST',
        url: getContextPath(),
        dataType: 'json',
        data: getInputData(),
        contentType: "application/json",
        async: true,
        success: function(result) {
        	output(JSON.stringify(result));
        },
        error: function(jqXHR, textStatus, errorThrown) {
        	output(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
}

function doDelete(){
	$.ajax({
        type: 'DELETE',
        url: getContextPath(),
        async: true,
        success: function(result) {
        	output(JSON.stringify(result));
        },
        error: function(jqXHR, textStatus, errorThrown) {
        	output(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
} 

function getInputData(){
	return document.getElementById('input-textarea').value;
}

function getContextPath(){
	return document.getElementById('input-context-path').value;
} 

function output(data){
	document.getElementById('output-textarea').value = data;
}