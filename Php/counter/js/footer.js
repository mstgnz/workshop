jQuery(document).ready(function() {
    $(window).bind("load", function() {
        $.getScript("./js/social.js", function() {});
    });
    $('#w0').authchoice();
    $('a[data-link="signupFormLink"]').click(function() {
        $('.login-form').addClass('hidden');
        $('.signup-form').removeClass('hidden');
    });
    $('a[data-link="loginFormLink"]').click(function() {
        $('.login-form').removeClass('hidden');
        $('.signup-form').addClass('hidden');
    });
    $('#w1').authchoice();
    jQuery('#login-form').yiiActiveForm([{
        "id": "loginform-email",
        "name": "email",
        "container": ".field-loginform-email",
        "input": "#loginform-email",
        "error": ".help-block.help-block-error",
        "enableAjaxValidation": true,
        "validate": function(attribute, value, messages, deferred, $form) {
            yii.validation.required(value, messages, {
                "message": "Email cannot be blank."
            });
            yii.validation.email(value, messages, {
                "pattern": /^[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$/,
                "fullPattern": /^[^@]*<[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?>$/,
                "allowName": false,
                "message": "Email is not a valid email address.",
                "enableIDN": false,
                "skipOnEmpty": 1
            });
        }
    }, {
        "id": "loginform-password",
        "name": "password",
        "container": ".field-loginform-password",
        "input": "#loginform-password",
        "error": ".help-block.help-block-error",
        "enableAjaxValidation": true,
        "validate": function(attribute, value, messages, deferred, $form) {
            yii.validation.required(value, messages, {
                "message": "Password cannot be blank."
            });
        }
    }], {
        "errorSummary": ".error-summary.alert.alert-danger"
    });
    jQuery('#signup-form').yiiActiveForm([{
        "id": "signupform-email",
        "name": "email",
        "container": ".field-signupform-email",
        "input": "#signupform-email",
        "error": ".help-block.help-block-error",
        "enableAjaxValidation": true,
        "validate": function(attribute, value, messages, deferred, $form) {
            yii.validation.required(value, messages, {
                "message": "Email cannot be blank."
            });
            yii.validation.email(value, messages, {
                "pattern": /^[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?$/,
                "fullPattern": /^[^@]*<[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-zA-Z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?>$/,
                "allowName": false,
                "message": "Email is not a valid email address.",
                "enableIDN": false,
                "skipOnEmpty": 1
            });
            yii.validation.string(value, messages, {
                "message": "Email must be a string.",
                "max": 255,
                "tooLong": "Email should contain at most 255 characters.",
                "skipOnEmpty": 1
            });
        }
    }, {
        "id": "signupform-email_repeat",
        "name": "email_repeat",
        "container": ".field-signupform-email_repeat",
        "input": "#signupform-email_repeat",
        "error": ".help-block.help-block-error",
        "enableAjaxValidation": true,
        "validate": function(attribute, value, messages, deferred, $form) {
            yii.validation.required(value, messages, {
                "message": "Email Repeat cannot be blank."
            });
        }
    }, {
        "id": "signupform-password",
        "name": "password",
        "container": ".field-signupform-password",
        "input": "#signupform-password",
        "error": ".help-block.help-block-error",
        "enableAjaxValidation": true,
        "validate": function(attribute, value, messages, deferred, $form) {
            yii.validation.required(value, messages, {
                "message": "Password cannot be blank."
            });
            yii.validation.string(value, messages, {
                "message": "Password must be a string.",
                "min": 6,
                "tooShort": "Password should contain at least 6 characters.",
                "skipOnEmpty": 1
            });
        }
    }, {
        "id": "signupform-password_repeat",
        "name": "password_repeat",
        "container": ".field-signupform-password_repeat",
        "input": "#signupform-password_repeat",
        "error": ".help-block.help-block-error",
        "enableAjaxValidation": true,
        "validate": function(attribute, value, messages, deferred, $form) {
            yii.validation.required(value, messages, {
                "message": "Password Repeat cannot be blank."
            });
        }
    }], {
        "errorSummary": ".error-summary.alert.alert-danger"
    });
});

/*
var dataObj;
if ($.cookie('optionsObject')) {
    dataObj = JSON.parse($.cookie('optionsObject'));
    $("#theme").attr("href", $('#data-block').data('css-path') + dataObj.theme + '.css');
} else {
    $("#theme").attr("href", $('#data-block').data('css-path') + 'default.css');
}*/

// navbar aktive link color
var url = window.location.pathname;
var a_href = url.split('/');
a_href = "./"+a_href[a_href.length-1];
var links = [];
$('#wc_navbar').find('a').each(function(key, value) {
    links.push($(value).attr('href'))
    if ($(value).attr('href')==a_href) {
        $(value).css({
            'color':'#fff',
            'background':'#2a6496'
        });
    } else {
        $(value).css({
            'color':'#fff',
            'background':'rgb(62,139,200)'
        });
    }
});
if(!links.includes(a_href)){
    $('a[data-tr-detail=our-tools]').css({
        'color':'#fff',
        'background':'#2a6496'
    })
}

// Progress Bar
var SetGlobalPreloaderState = function(percentFrom, percentTo) {
    $('#globalPreloader div').css({
        width: percentFrom + '%'
    });
    $('#globalPreloader').show();
    $('#globalPreloader div').animate({
        width: percentTo + '%'
    }, 1000, function() {
        jQuery('#globalPreloader').hide();
    });
};
var InitiatializeGlobalPreloader = function() {
    window.onbeforeunload = function() {
        SetGlobalPreloaderState(0, 30);
    };
};
$(document).ready(function() {
    InitiatializeGlobalPreloader();
    SetGlobalPreloaderState(30, 100);
});
