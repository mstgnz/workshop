$(document).ready(function() {
    // Bootstrap Validator
    $('#form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
           phone: {
                validators: {
                    notEmpty: {
                        message: "Please do not leave blank"
                    },
                    stringLength: {
                        min: 10,
                        max: 20,
                        message: "Must be between 10 and 20"
                    },
                    regexp: {
                        regexp: /^[0-9\s\+]+$/,
                        message: "Please enter a valid phone number"
                    },
                    callback: {
                        message: "Please enter a valid country code",
                        callback: function(value, validator, $field){
                            if(phoneCode(value)){
                                $('#countryName').html(phoneCode(value));
                                return true;
                            }
                            return false;
                        }
                    }
                }
            }
        }
    });
});

function phoneCode(value){
	let result = false;
	$.ajax({
		url: 'phoneCodes.json',
		async: false,
		dataType: 'json',
		success: function (data) {
			$.each( data, function( key, val ) {
				if(Array.isArray(val)){
					val.forEach(function(v){
						if(value.startsWith(v)) result = key;
					})
				}
				if(!result){
					if(value.startsWith(val)) result = key;
				}
			});
		}
	});
	return result;
}