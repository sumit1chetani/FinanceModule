'use strict';
angular.module('neuboard').factory('utilsService', function($http, logger, $log,$stateParams) {

    return {
        isUndefinedOrNull : function(val) {
            var isNull = false;
            if (angular.isUndefined(val)) {
                isNull = true;
            } else if (val === null) {
                isNull = true;
            } else {
                if (val === '') {
                    isNull = true;
                } else if (val === -1) {
                    isNull = true;
                } else if (val.length == 0) {
                    isNull = true;
                } else {
                    isNull = false;
                }
            }
            return isNull;
        },
        reportVoucherPrint : function(voucherNo) {
            var voucherNoSubString= voucherNo.indexOf("SE")>-1;          
            if((voucherNo.indexOf("SE")>-1) || (voucherNo.indexOf("SI")>-1)){
                var url = $stateParams.tenantid+'/app/seapurchaseinvoice/printGL?purInvNo=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();  
            }else  if((voucherNo.indexOf("AE")>-1) || (voucherNo.indexOf("AI")>-1)){
                var url = 'app/purchaseinvoice/printGL?purInvNo=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();  
            }
            
            
            else if(voucherNo.indexOf("BP")>-1){
                //var url = 'app/cashbankPayment/print?cbVoucherNo=' + voucherNo;
                var url = 'app/cashbankPayment/print?cbVoucherNo=' + voucherNo;

                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();   
            }else if(voucherNo.indexOf("CP")>-1){
               // var url = 'app/cashbankPayment/print?cbVoucherNo=' + voucherNo;
                var url = 'app/cashbankPayment/print?cbVoucherNo=' + voucherNo;

                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();   
            }else if(voucherNo.indexOf("BR")>-1){
                var url = 'app/cashbankreceipt/print?voucherNo=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();
            }else if(voucherNo.indexOf("CR")>-1){
                var url = 'app/cashbankreceipt/print?voucherNo=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();  
            }else if(voucherNo.indexOf("AR")>-1){
                var url = 'app/cashbankreceipt/print?voucherNo=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();  
            }else if(voucherNo.indexOf("PHC")>-1){
                var url = $stateParams.tenantid+'/app/PHCInvoice/print?phcInvoiceNo=' + voucherNo + '&selectedPrintOption=' + "both";
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print(); 
            }else if(voucherNo.indexOf("IN")>-1){
               // var url = $stateParams.tenantid+'/app/invoice/print?invoiceno=' + voucherNo + '&selectedDropDown=' + "both";
                
                var url = 'app/purchaseinvoice/print?puchaseInvoiceNo=' + voucherNo ;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();
            }else if(voucherNo.indexOf("GI")>-1){
                var url ='app/generalinvoice/print?invoiceNo=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print(); 
            }else if(voucherNo.indexOf("PCN")>-1){
                var url = 'app/purchaseCreditNote/print?creditCode=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();
            }else if(voucherNo.indexOf("DCN")>-1 || voucherNo.indexOf("SICN")>-1 || voucherNo.indexOf("MACN")>-1){ //Credit Note
                var url = 'app/creditNote/print?creditCode=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();
            }else if(voucherNo.indexOf("DR")>-1){ //Debit Note
                var url = 'app/debitnote/print?debitNoteNo=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();
            }else if(voucherNo.indexOf("LPO")>-1){ //LPO
                var url = $stateParams.tenantid+'/app/invoice/lpo/print?lpoNo=' + voucherNo;
                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();   
            }else if(voucherNo.indexOf("JV")>-1){
                //var url ='app/journalVoucher/print?journalNo=' + voucherNo;
                var url = 'app/journalVoucher/print?jvNumber=' + voucherNo;

                var wnd = window.open(url, 'Shipping', 'height=700,width=800,toolbar=no,scrollbars=yes,fullscreen=no,status=yes,menubar=no,location=no,directories=no,resizable=yes');
                wnd.print();   
            }
        },            

		requiredValidation : function(values) {
			var i = values.length
			while (i--) {
				var val = values[i].value;
				var isNull = false;
				if (angular.isUndefined(val)) {
					isNull = true;
				} else if (val === null) {
					isNull = true;
				} else {
					if (val === '') {
						isNull = true;
					} else if (val === -1) {
						isNull = true;
					} else if (val.length == 0) {
						isNull = true;
					} else {
						isNull = false;
					}
				}

				if(!isNull){
					values.splice(i, 1);
				}
			}
			return values;
		},
        toggleValueBool : function(boolValue) {
            return !boolValue;
        },

        toggleValue : function(newValue, originalValue) {
            if (originalValue != newValue) {
                return newValue;
            } else {
                return -1;
            }
        },

        buildErrorMessage : function(val) {
            var isNull = false;
            if (angular.isUndefined(val)) {
                isNull = true;
            } else if (val === null) {
                isNull = true;
            } else {
                if (val === '') {
                    isNull = true;
                } else if (val === -1) {
                    isNull = true;
                } else if (val.length == 0) {
                    isNull = true;
                } else {
                    isNull = false;
                }
            }
            return isNull;
        },
		ajaxService : function(requestObj, requestMethod, requestUrl, errorMessage, successMessage) {
			if (requestMethod == "post") {
				$http.get(requestUrl).success(function(result) {
					if (result == true) {
						logger.logSuccess(successMessage);
						return result;
					} else {
						logger.logError(errorMessage);
						return false;
					}
				}).error(function(result) {
					return false;
				});
			} else if (requestMethod == "post") {
				$http.post(requestUrl, requestMethod).success(function(result) {
					if (result == true) {
						logger.logSuccess(successMessage);
						return result;
					} else {
						logger.logError(errorMessage);
						return false;
					}
				}).error(function(result) {
					return false;
				});
			}
		}
    };
});
Number.prototype.formatMoney = function(c, d, t) {
	var n = this, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "." : d, t = t == undefined ? "," : t, s = n < 0 ? "-" : "", i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", j = (j = i.length) > 3 ? j % 3 : 0;
	return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
};

function days_between(date1, date2) {

	// The number of milliseconds in one day
	var ONE_DAY = 1000 * 60 * 60 * 24

	// Convert both dates to milliseconds
	var date1_ms = date1.getTime()
	var date2_ms = date2.getTime()

	// Calculate the difference in milliseconds
	var difference_ms = Math.abs(date1_ms - date2_ms)

	// Convert back to days and return
	return Math.round(difference_ms / ONE_DAY)
}

function withoutComma(value) {
	return value.toString().replace(/,/g, '');
}

function withoutCommaFilter(obj, properties) {
	for (var index = 0; index < properties.length; index++) {
		var property = properties[index];
		obj[property] = obj[property].toString().replace(/,/g, '');
	}
	return obj;
}