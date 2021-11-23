app.directive('bootstrapdatetimepicker', function() {
    var onBlurFunction = function(scope, element, attrs) {
        
        
        $(element).find('.datetimepick').datetimepicker({
            format: 'DD/MM/YYYY HH:mm',    
        });
        $(element).find(':text').blur(function(){
            var textValue = $(this).val();
            scope.$apply(function() {
                //if(scope.property != undefined){
                    scope.property = textValue;
                 //}
            });
        });
     
        $(element).on("dp.change", function(e)
                {
          //  console.log(element);
          //  console.log(e.date);
            scope.$apply(function() {
                if(e.date._i.d!=undefined){
                    scope.property = e.date._i.d+"/"+(e.date._i.M+1)+"/"+e.date._i.y+" "+e.date._i.h+":"+e.date._i.m;
                    $(element).find(':text').val(e.date._i.d+"/"+(e.date._i.M+1)+"/"+e.date._i.y+" "+e.date._i.h+":"+e.date._i.m);
                   
                }else{
                    scope.property = e.date._i;
                    $(element).find(':text').val(e.date._i);
                   
                }
          
          
            });
                });
        
        scope.$watch("property", function(value, oldValue) {
            $(element).find(':text').val(value);
        });
    }
    console.log(datetimepickerHtml);
    var datetimepickerHtml = "<div class='input-group date datetimepick'>"
        +"<input type='text' class='form-control'" 
           +"placeholder='dd/mm/yyyy hh:mm'>"
          +"<span class='input-group-addon'> <span class='glyphicon glyphicon-calendar'></span></span></div>";
    return {
        restrict : 'E',
        scope : {
            property : '=property',
            id : '@id'
        },
        template : datetimepickerHtml,
        link : onBlurFunction
    };
});
app.directive('bootstrapdatepicker', function() {
    var onBlurFunction = function(scope, element, attrs) {
        $(element).find('.datetimepick').datetimepicker({
            format: 'DD/MM/YYYY',    
        });
        $(element).find(':text').blur(function(){
            var textValue = $(this).val();
            scope.$apply(function() {
               // if(scope.property != undefined){
                    scope.property = textValue;
                // }
            });
        });
        scope.$watch("property", function(value, oldValue) {
            $(element).find(':text').val(value);
        });
    }
    var datetimepickerHtml = "<div class='input-group date datetimepick'>"
        +"<input type='text' class='form-control'"
           +"placeholder='dd/mm/yyyy'>"
          +"<span class='input-group-addon'> <span class='glyphicon glyphicon-calendar'></span></span></div>";
    return {
        restrict : 'E',
        scope : {
            property : '=property',
            id : '@id'
        },
        template : datetimepickerHtml,
        link : onBlurFunction
    };
});
app.directive('bootstraptimepicker', function() {
    var onBlurFunction = function(scope, element, attrs) {
        $(element).find('.timepick').datetimepicker({
            format: 'HH:mm',    
        });
        
        
        $(element).find(':text').blur(function(){
            var textValue = $(this).val();
            scope.$apply(function() {
                //if(scope.property != undefined){
                    scope.property = textValue;
               // }
            });
        });
        scope.$watch("property", function(value, oldValue) {
            $(element).find(':text').val(value);
        });
    }
    var datetimepickerHtml = "<div class='input-group date timepick'>"
        +"<input type='text' class='form-control' "
           +"placeholder='hh:mm'>"
          +"<span class='input-group-addon'> <span class='glyphicon glyphicon-calendar'></span></span></div>";
    return {
        restrict : 'E',
        scope : {
            property : '=property',
            id : '@id'
        },
        template : datetimepickerHtml,
        link : onBlurFunction
    };
});