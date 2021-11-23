"use strict";
app.directive('megaMenu', function($state, $rootScope) {
        return {
            restrict : 'A',
            link : function(scope, element, attrs) {
                var $body = $('body');

                var $collapsible = element.find('.mzr-drop');
                $collapsible.each(function(idx, li) {
                    var $li = $(li);
                    $li.hover(function() {
                        if($(this).find('.mzr-content').length == 0){
                            $(this).find('ul:first').css({
                                'top' : '38px',
                                'opacity' : '1',
                                'overflow' : 'visible',
                                'visibility' : 'visible'
                            });
                        }else{
                            $(this).find('.mzr-content').css({
                                'top' : '38px',
                                'opacity' : '1',
                                'overflow-y' : 'auto',
                                'overflow-x' : 'visible',
                                'visibility' : 'visible'
                            });
                        }
                    }, function() {
                        if($(this).find('.mzr-content').length == 0){
                            $(this).find('ul:first').css({
                                'top' : '',
                                'opacity' : '',
                                'overflow' : '',
                                'visibility' : ''
                            });
                        }else{
                            $(this).find('.mzr-content').css({
                                'top' : '',
                                'opacity' : '',
                                'overflow' : '',
                                'visibility' : ''
                            });
                        }
                    });
                    $li.on('click', 'a', function(e) {
                        if($(this).closest('.mzr-content').length == 0){
                            $(this).closest('.mzr-drop').find('ul:first').css({
                                'top' : '',
                                'opacity' : '',
                                'overflow' : '',
                                'visibility' : ''
                            });
                        }else{
                            $(this).closest('.mzr-content').css({
                                'top' : '',
                                'opacity' : '',
                                'overflow' : '',
                                'visibility' : ''
                            });
                        }
                    });

                });
            }
        }
   

});
