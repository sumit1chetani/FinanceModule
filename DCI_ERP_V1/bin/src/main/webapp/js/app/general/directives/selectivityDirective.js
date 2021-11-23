app.directive('hideon', function() {
    return function(scope, element, attrs) {
        scope.$watch(attrs.hideon, function(value, oldValue) {
            if (value) {
                var portIsoCodeList = scope.mloSlotMapDtl.portIsoCodeList;
                element.selectivity({
                    allowClear : true,
                    items : portIsoCodeList,
                    placeholder : ''
                });
                element.find('.selectivity-single-result-container').text(scope.mloSlotMapDtl.portIsoCode);
                element.on('selectivity-selected', function(obj) {
                    scope.$apply(function() {
                        scope.mloSlotMapDtl.portIsoCode = obj.item.text;
                        element.find('.fa-remove').on('click', function() {
                            scope.mloSlotMapDtl.portIsoCode = '';
                        })
                    });
                });
            }
        }, true);
    }
});

app.directive("selectivity", function() {
    var linkFunction = function(scope, element, attrs) {
        scope.$watch("list", function(value, oldValue) {
            $(element).find('.selectivityId').selectivity('destroy')
            $(element).find('.selectivityId').selectivity({
                allowClear : true,
                items : scope.list,
                placeholder : scope.placeholder,
                value : scope.property,
                showSearchInputInDropdown : false
            });
            scope.$watch("disabled", function(value, oldValue) {
                if (scope.disabled != undefined) {
                    if (scope.disabled == true) {
                        $(element).find('.selectivityId').find(':text').attr('disabled', true);
                        $(element).find('.selectivityId').click(function() {
                            $('.selectivity-dropdown').html('');
                            return false;
                        });
                    } else if (scope.disabled == false) {
                        $(element).find('.selectivityId').find(':text').attr('disabled', false);
                    }
                }
            });

            $(element).find('.selectivityId').on('selectivity-selected', function(obj) {
                scope.$apply(function() {
                    //if (scope.property != undefined) {
                        scope.property = obj.item.id;
                    //}
                   // if (scope.object != undefined) {
                        scope.object = obj.item;
                    //}
                });
            });
            $(element).find('.selectivityId').find(':text').blur(function() {
                var value = $(this).val();
                if (value.length == 0) {
                    scope.$apply(function() {
                        //if (scope.property != undefined) {
                            scope.property = '';
                       // }
                       // if (scope.object != undefined) {
                            scope.object = '';
                        //}
                    });
                }
            });
            $(element).find('.selectivityId').bind("keydown keypress", function (event) {
                event.stopPropagation();
                if(event.which === 9) {                     
                   
                    if(angular.isDefined(scope.nextvalue)) {
                        event.preventDefault();
                    var elementToFocus = $('#'+scope.nextvalue).find('input');
                  
                    if(angular.isDefined(elementToFocus) && elementToFocus.length>0){
                        elementToFocus.focus();
                    }else{
                        var elementToFocus = $('#'+attrs.nextvalue);
                        if(angular.isDefined(elementToFocus)&& elementToFocus.length>0){
                            elementToFocus.focus();
                        }  
                    }                  
                    }
                    
                }
            });
             
            scope.$watch("property", function(value, oldValue) {
                $(element).find('.selectivityId').selectivity('value', value);
            });
        });
    };
    var selectivityHtml = '<div class="selectivityId selectivity-input example-input selectivity-slot">' + '<div>' + '<input type="text" class="input-sm selectivity-single-select-input">' + '<div class="selectivity-single-result-container">' + '<div class="selectivity-placeholder"></div></div>' + '</div></div>';
    return {
        restrict : 'E',
        transclude : 'true',
        scope : {
            ngModel : '=',
            object : '=object',
            list : '=list',
            property : '=property',
            disabled : '=disabled',
            id : '@id',
            placeholder : '@placeholder',
            nextvalue:'@nextvalue'
            
        },
        template : selectivityHtml,
        link : linkFunction
    };
});
app.directive('nextvalue', [function () {
    return {
        restrict: "A",
        link: function (scope, el, attrs) {
            el.bind('keydown keypress', function(e) {
                e.stopPropagation();
               
                if(event.which === 9) {  
                    if(angular.isDefined(attrs.nextvalue)) {
                    e.preventDefault();
                    
                var elementToFocus = $('#'+attrs.nextvalue).find('input');
                if(angular.isDefined(elementToFocus) && elementToFocus.length>0){
                    elementToFocus.focus();
                }else{
                    var elementToFocus = $('#'+attrs.nextvalue);
                    if(angular.isDefined(elementToFocus) && elementToFocus.length>0){
                        elementToFocus.focus();
                    }  
                }
                   
                }
                }
                  
              
               
            });
        }
    }
  }]);
app.directive("multiselectivity", function() {
    var linkFunction = function(scope, element, attrs) {
      
        scope.$watch("list", function(value, oldValue) { 
            var data=[];
          $(element).find('.selectivityId').selectivity('destroy')
          $(element).find('.selectivityId').selectivity({
              allowClear : true,
              items : scope.list,
              placeholder : '',
              value : scope.property,
              showSearchInputInDropdown : false,
              multiple : true
          });
            scope.$watch("disabled", function(value, oldValue) {
                if (scope.disabled != undefined) {
                    if (scope.disabled == true) {
                        $(element).find('.selectivityId').find(':text').attr('disabled', true);
                        $(element).find('.selectivityId').click(function() {
                            $('.selectivity-dropdown').html('');
                            return false;
                        });
                    } else if (scope.disabled == false) {
                        $(element).find('.selectivityId').find(':text').attr('disabled', false);
                    }
                }
                
                $(element).find('.fa-remove').on('click', function(obj) {
                    var value = $(this).closest('.selectivity-multiple-selected-item').attr('data-item-id');
                    
                    scope.$apply(function() {
                        
                        var selData = [];
                        angular.forEach(data, function(list, idx) {
                            if (list != value) {
                                selData.push(list);
                            }
                        });
                        data = selData;
                       
                       // if (scope.property != undefined) {
                            scope.property = data;
                       // }
                        //if (scope.object != undefined) {
                            scope.object = obj.item;
                        //}
                    });
                    });
            });

            $(element).find('.selectivityId').on('selectivity-selected', function(obj) {
                
        
                scope.$apply(function() {
                    var selData = [];
                    angular.forEach(data, function(list, idx) {
                        if (list != obj.item.id) {
                            selData.push(list);
                        }
                    });
                    data = selData;
                    data.push(obj.item.id);
                    //if (scope.property != undefined) {
                        scope.property = data;
                    //}
                   // if (scope.object != undefined) {
                        scope.object = obj.item;
                   // }
                 });
                
            
                $(element).find('.fa-remove').on('click', function(obj) {
                    var value = $(this).closest('.selectivity-multiple-selected-item').attr('data-item-id');
                    console.log(value);
                    scope.$apply(function() {
                        var selData = [];
                        angular.forEach(data, function(list, idx) {
                            if (list != value) {
                                selData.push(list);
                            }
                        });
                        data = selData;
                       
                       // if (scope.property != undefined) {
                            scope.property = data;
                       // }
                        //if (scope.object != undefined) {
                            scope.object = obj.item;
                        //}
                    });
                    });
            });
          
           
            $(element).find('.selectivityId').find(':text').blur(function() {
                $(element).find('.fa-remove').on('click', function(obj) {
                    var value = $(this).closest('.selectivity-multiple-selected-item').attr('data-item-id');
                    console.log(value);
                    scope.$apply(function() {
                        var selData = [];
                        angular.forEach(data, function(list, idx) {
                            if (list != value) {
                                selData.push(list);
                            }
                        });
                        data = selData;
                       
                       // if (scope.property != undefined) {
                            scope.property = data;
                       // }
                       // if (scope.object != undefined) {
                            scope.object = obj.item;
                       // }
                    });
                    });
            });
            scope.$watch("property", function(value, oldValue) {
                if (value != '') {
                    $(element).find('.selectivityId').selectivity('value', value);
                }

            });
        });
    };
    var selectivityHtml = '<div class="selectivityId selectivity-input example-input selectivity-slot">' + '<div>' + '<input type="text" class="input-sm selectivity-single-select-input">' + '<div class="selectivity-single-result-container">' + '<div class="selectivity-placeholder"></div></div>' + '</div></div>';
    return {
        restrict : 'E',
        transclude : 'true',
        scope : {
            ngModel : '=',
            object : '=object',
            list : '=list',
            property : '=property',
            disabled : '=disabled',
            id : '@id',
        },
        template : selectivityHtml,
        link : linkFunction
    };
});
app.directive('yearDrop', function() {
    return {
        link : function(scope, element, attrs) {
            var startYear = +attrs.start
            scope.years = [];
            for (var i = 0; i < +attrs.range + 1; i++) {
                scope.years.push(startYear + i);
            }
            scope.selected = startYear;
        },
        template : '<select class="input-sm" ng-model="selected" ng-options="y for y in years"></select>'
    }
});

function formatDate(dateVal) {
    return moment(dateVal, "DD/MM/YYYY").format("YYYY-MM-DD");
}
function formatDateTime(dateVal) {
    return moment(dateVal, "DD/MM/YYYY hh24:mi").format("YYYY-MM-DD hh24:mi");
}
function findObjectIndex(insId, list, prop) {
    for (var index = 0; index < list.length; index++) {
        if (list[index][prop] == insId) {
            return index;
        }
    }
}