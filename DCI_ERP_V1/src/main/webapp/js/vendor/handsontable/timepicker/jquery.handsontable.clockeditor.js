(function(Handsontable) {
    var TimeEditor = Handsontable.editors.BaseEditor.prototype.extend();

    TimeEditor.prototype.init = function() {
        
        this.clock = document.createElement('INPUT');
        
        Handsontable.Dom.addClass(this.clock, 'clockInput');
        this.clock.style.display = 'none';

        this.instance.rootElement.appendChild(this.clock);

        this.clock = $('<input>');

        this.clockInput = $('.clockInput').datetimepicker({
            useCurrent : false
        });
    };

    TimeEditor.prototype.open = function() {
        // make sure that editor position matches cell position
        var $td = $(this.TD);
        var offset = $td.offset();
        var originalValue = this.originalValue;
        
        var separators = [' ','-',':'];
        var extractedOriginalValue = originalValue.split(new RegExp(separators.join('|'), 'g'));
            console.log(extractedOriginalValue);
        
            originalValue =  extractedOriginalValue[2]+"-"+extractedOriginalValue[1]+"-"+
            extractedOriginalValue[0]+" "+extractedOriginalValue[3]+":"+extractedOriginalValue[4]+":"+
            extractedOriginalValue[5]   ;
            
        var value = this.originalValue;
        this.clockInput.datetimepicker('destroy')
         this.clockInput.datetimepicker('show');
       // this.clockInput.data('datetimepicker').setLocalDate(new Date(value));
        if(this.originalValue == ''){
            var parentElem = $(".bootstrap-datetimepicker-widget:visible");
            parentElem.find(".datepicker-days .active").removeClass('active');
        }
  
        // remove clockpicker event handlers
         $(document).off('click.clockpicker.cp1 focusin.clockpicker.cp1');
          
         var $cpop = $('.dropdown-menu'); 
         $cpop.offset({ top : offset.top + $td.height() + 10, left : offset.left });
    };

    TimeEditor.prototype.close = function() {
        this.clockInput.datetimepicker('hide');
        $(".bootstrap-datetimepicker-widget").hide();
    };
    TimeEditor.prototype.getValue = function() {
        var parentElem = $(".bootstrap-datetimepicker-widget:visible");
        var dateStr=(parentElem.find(".datepicker-days .active").text() +" "+parentElem.find(".datepicker-days .switch").text())+"\n"+ parentElem.find('.timepicker-hour').text() + ':' + parentElem.find('.timepicker-minute').text() + ':' + parentElem.find('.timepicker-second').text();
        var selectedDate = new Date(dateStr);
        console.log(this)
        selectedDate.setMonth(selectedDate.getMonth()+1);
        var dateString = "";
        if(parentElem.find(".datepicker-days .active").text() != ''){
            dateString=selectedDate.getMonth()+"-"+selectedDate.getDate() +"-" +selectedDate.getFullYear()+" "+ +selectedDate.getHours() +":"+selectedDate.getMinutes();
        }
        return dateString;
    };
    TimeEditor.prototype.setValue = function(newValue) {
        this.clock.append(newValue);
        $(".bootstrap-datetimepicker-widget").hide();
    };
    TimeEditor.prototype.focus = function() {
    };

    Handsontable.editors.TimeEditor = TimeEditor;
    Handsontable.editors.registerEditor('time', TimeEditor);
}(Handsontable));


(function(Handsontable) {
    var TimeEditor = Handsontable.editors.BaseEditor.prototype.extend();

        TimeEditor.prototype.init = function() {

        this.timePicker = document.createElement('INPUT');
        
        
        Handsontable.Dom.addClass(this.timePicker, 'timePicker');
        this.timePicker.style.display = 'none';
        this.instance.rootElement.appendChild(this.timePicker);

        this.timePicker = $('.timePicker');

        this.timePickerInput = $('.timePicker').datetimepicker({
           pickDate:false,
           pickSeconds: false 
                    });
    };

    TimeEditor.prototype.open = function() {
        var $td = $(this.TD);
        var offset = $td.offset();
        
        var value = this.originalValue ? new Date (new Date().toDateString() + ' ' + this.originalValue) :
            new Date();
        
        
        this.timePickerInput.data('datetimepicker').setLocalDate(new
         Date(value));
        
        this.timePickerInput.datetimepicker('show');
        
         
         $(document).off('click.clockpicker.cp1 focusin.clockpicker.cp1');
          
         var $cpop = $('.dropdown-menu'); 
         $cpop.offset({ top : offset.top + $td.height() + 10, left : offset.left });
         
    };

    TimeEditor.prototype.close = function() {
        this.timePickerInput.datetimepicker('hide');
        $(".bootstrap-datetimepicker-widget").hide();
    };
    TimeEditor.prototype.getValue = function() {
        var parentElem = $(".bootstrap-datetimepicker-widget:visible");
        
        var dateStr= parentElem.find('.timepicker-hour').text() + ':' + parentElem.find('.timepicker-minute').text() + ':' + parentElem.find('.timepicker-second').text();
        var selectedDate = new Date (new Date().toDateString() + ' ' + dateStr);
        var dateString= selectedDate.getHours() +":"+selectedDate.getMinutes();
        return dateString;
    };
    TimeEditor.prototype.setValue = function(newValue) {
        this.timePicker.val(newValue);
        $(".bootstrap-datetimepicker-widget").hide();
    };
    TimeEditor.prototype.focus = function() {
    };

    Handsontable.editors.TimeEditor = TimeEditor;
    Handsontable.editors.registerEditor('timePicker', TimeEditor);
}(Handsontable));





