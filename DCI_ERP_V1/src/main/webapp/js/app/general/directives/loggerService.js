'use strict';
angular.module('neuboard').factory('logger', function() {

    var logIt;
    toastr.options = {
        "closeButton" : true,
        "positionClass" : "toast-top-right",
        "timeOut" : "10000"
    };
    logIt = function(message, type) {
        return toastr[type](message);
    };
    return {
        logGeneric : function(message, type) {
            logIt(message, type);
        },
        getErrorHtml : function(message) {
            var li = '';
            $.each(message, function(key,value) {
                li = li + '<li style="padding-right:10px;padding-bottom:2px;"><b class="capitalize">'+key+'</b> - '+value + '</li>';
            });
            li = '<ul>' + li + '</ul>';

            return li;
        },
        getErrorHtmlList : function(message) {
            var li = '';
            $.each(message, function(key,value) {
                $.each(value,function(key1,value1){
                    li = li + '<li style="padding-right:10px;padding-bottom:2px;"><b class="capitalize">'+key+'</b> - '+value1 + '</li>';
                })
            });
            li = '<ul>' + li + '</ul>';

            return li;
        },
        getErrorHtmlNew : function(messages) {
            var li = '';
            for (var index = 0; index < messages.length; index+=1) {
                var messageItem = messages[index];
                var messageItemName = messageItem.friendlyName;
                var	messageItemVal = messageItem.message ? messageItem.message : 'Field is required';
                li += '<li  style="padding-right:10px;padding-bottom:2px;"><b class="capitalize">' + messageItemName + '</b> - ' +  messageItemVal  + '</li>';
            }
            return '<ul>' + li + '</ul>';
        },
        logErrorHtml : function(message) {

            var div = $('<div />');

            var h3 = $('<h3/>');
            h3.css({
                "display" : "inline",
                "font-weight" : "bold",
                "font-size" : "14px",
                "padding" : "0px 0px 0px 29px",
            });

            h3.text(' The following fields are invalid: ')

            var ul = $('<ul />');

            ul.css({
                "margin" : "0px",
                "padding" : "0px 0px 0px 32px",
                "list-style" : "disc",
                "max-height" : "200px",
                "overflow-y" : "scroll"
            });

            ul.addClass("mCustomScrollbar content content1 fluid light");

            $.each(message, function(i) {
                var li = $('<li/>').text(message[i]).appendTo(ul);
            });

            div.append(h3);
            div.append(ul);
            logIt(div, 'error');
        },
        log : function(message) {
            logIt(message, 'info');
        },
        logWarning : function(message) {
            logIt(message, 'warning');
        },
        logSuccess : function(message) {
            logIt(message, 'success');
        },
        logError : function(message) {
            logIt(message, 'error');
        }
    };
});
