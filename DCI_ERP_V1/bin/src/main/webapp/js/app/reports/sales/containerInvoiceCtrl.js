
    'use strict';
    
    app.factory('InvoiceRetriever', function($http, $q, $timeout){
    	  var InvoiceRetriever = new Object();

    	  InvoiceRetriever.getInvoice = function(i) {
    		  var invoicedata = $q.defer();
    		    var invoice;
    		  $http.post('app/containerInvoice/invoice', i).success(function(data) {
    			  invoice =data.lContainerInvoiceReportBean;
    			  var list=[];
    			  angular.forEach(data.lContainerInvoiceReportBean, function(bean, idx) {
                      
    				  list.push(bean.invoice);
                 
              });
                  $timeout(function(){
                	  invoicedata.resolve(list);
            	    },1000);

              }).error(function(data) {
                  logger.logError("Error Please Try Again");
              });
    	  

    	    return invoicedata.promise
    	  }

    	  return InvoiceRetriever;
    	});
    
    app.factory('ContainerRetriever', function($http, $q, $timeout){
  	  var ContainerRetriever = new Object();

  	ContainerRetriever.getContainer = function(i) {
  		  var containerdata = $q.defer();
  		    var container;
  		  $http.post('app/containerInvoice/container', i).success(function(data) {
  			container =data.lContainerInvoiceReportBean;
  			  var list=[];
  			  angular.forEach(data.lContainerInvoiceReportBean, function(bean, idx) {
                    
  				  list.push(bean.container);
               
            });
                $timeout(function(){
                	containerdata.resolve(list);
          	    },1000);

               /* $scope.$apply();*/
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
  	  

  	    return containerdata.promise
  	  }

  	  return ContainerRetriever;
  	});
  
    
    app.factory('BLRetriever', function($http, $q, $timeout){
        var BLRetriever = new Object();

        BLRetriever.getBl = function(i) {
            var bldata = $q.defer();
              var bl;
            $http.post('app/containerInvoice/blnumber', i).success(function(data) {
                bl =data.lContainerInvoiceReportBean;
                var list=[];
                angular.forEach(data.lContainerInvoiceReportBean, function(bean, idx) {
                    
                    list.push(bean.bl_no);
               
            });
                $timeout(function(){
                    bldata.resolve(list);
                  },1000);

               /* $scope.$apply();*/
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        

          return bldata.promise
        }

        return BLRetriever;
      });
    app.controller('containerInvoiceCtrl', function($scope, $rootScope, $http, logger, $log, ngDialog, $modal, $location, $filter, utilsService,InvoiceRetriever,ContainerRetriever,BLRetriever) {
    	
        $scope.contInvoice = {           
                invoice : '',
                container : '',
                bl:''
        };
        
        $('#invoice').selectivity({
            ajax : {
                url : 'app/containerInvoice/invoice',
                dataType : 'json',
                minimumInputLength : 3,
                quietMillis : 250,
                params : function(term, offset) {
                    return {
                        invoice : term,
                        page : 1 + Math.floor(offset / 30)
                    };
                },
                processItem : function(item) {
                    return {
                        id : item.id,
                        text : item.text
                    };
                },
                results : function(data, offset) {
                    return {
                        results : data.lContainerInvoiceReportBean,
                        more : (offset + data.lContainerInvoiceReportBean.length > data.total_count)
                    };
                }
            },
            allowClear : true,
            placeholder : ' ',
            showSearchInputInDropdown : false,
            templates : {
                resultItem : function(item) {
                    return (

                    '<div class="selectivity-result-item"  data-item-id="' + item.id + '">' + '<l>' + escape(item.text) + '</l>' + '</div>'

                    );
                }
            }
        });

        $('#invoice').on('selectivity-selected', function(obj) {
            $scope.searchObject = {           
                    invoice : obj.id,
                    container : '',
                    bl_no:''
            };
            $('#blnumber').selectivity('val','');
            $('#container').selectivity('val','');
           
            $scope.contInvoice.invoice = obj.id;
            $http.post('app/containerInvoice/list', $scope.searchObject).success(function(data) {
                $scope.rowCollection = [];
                
                if (data.success == true) {
                    $scope.pushTranslationListUtil(data);
                } else {

                    $scope.showEmptyLabel = true;

                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        });
        
        $('#container').selectivity({
            ajax : {
                url : 'app/containerInvoice/container',
                dataType : 'json',
                minimumInputLength : 3,
                quietMillis : 250,                
                params : function(term, offset) {
                    return {
                        container : term,
                        page : 1 + Math.floor(offset / 30)
                    };
                },
                processItem : function(item) {
                    return {
                        id : item.id,
                        text : item.text
                    };
                },
                results : function(data, offset) {
                    return {
                        results : data.lContainerInvoiceReportBean,
                        more : (offset + data.lContainerInvoiceReportBean.length > data.total_count)
                    };
                }
            },
            allowClear : true,
            placeholder : ' ',
            showSearchInputInDropdown : false,
            templates : {
                resultItem : function(item) {
                    return (

                    '<div class="selectivity-result-item"  data-item-id="' + item.id + '">' + '<l>' + escape(item.text) + '</l>' + '</div>'

                    );
                }
            }
        });

        $('#container').on('selectivity-selected', function(obj) {
            $scope.searchObject = {           
                    invoice : '',
                    container : obj.id,
                    bl_no:''
            };
            $('#blnumber').selectivity('val','');
            $('#invoice').selectivity('val','');
            $scope.contInvoice.container = obj.id;
            $http.post('app/containerInvoice/list', $scope.searchObject).success(function(data) {
                $scope.rowCollection = [];
                
                if (data.success == true) {
                    $scope.pushTranslationListUtil(data);
                } else {

                    $scope.showEmptyLabel = true;

                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        });
       
        
        $('#blnumber').selectivity({
            ajax : {
                url : 'app/containerInvoice/blnumber',
                dataType : 'json',
                minimumInputLength : 3,
                quietMillis : 250,
                
                params : function(term, offset) {
                    return {
                        blnumber : term,
                        page : 1 + Math.floor(offset / 30)
                    };
                },
                processItem : function(item) {
                    return {
                        id : item.id,
                        text : item.text
                    };
                },
                results : function(data, offset) {
                    return {
                        results : data.lContainerInvoiceReportBean,
                        more : (offset + data.lContainerInvoiceReportBean.length > data.total_count)
                    };
                }
            },
            allowClear : true,
            placeholder : ' ',
            showSearchInputInDropdown : false,
            templates : {
                resultItem : function(item) {
                    return (

                    '<div class="selectivity-result-item"  data-item-id="' + item.id + '">' + '<l>' + escape(item.text) + '</l>' + '</div>'

                    );
                }
            }
        });

        $('#blnumber').on('selectivity-selected', function(obj) {
            $scope.searchObject = {           
                    invoice : '',
                    container :'',
                    bl_no: obj.id
            };
           
            $('#container').selectivity('val','');
            $('#invoice').selectivity('val','');
            $scope.contInvoice.bl = obj.id;
            $http.post('app/containerInvoice/list', $scope.searchObject).success(function(data) {
                $scope.rowCollection = [];
                
                if (data.success == true) {
                    $scope.pushTranslationListUtil(data);
                } else {

                    $scope.showEmptyLabel = true;

                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        });
        
    	
        $scope.search = function(contInvoice) {
            console.log(contInvoice);
            $scope.searchObject = {           
                    invoice : '',
                    container : '',
                    bl_no:''
            };
            
            
            
            
            if(contInvoice ==undefined){
                logger.logError("please select one criteria");
                return false;
            }
            if (contInvoice.invoice != '' && contInvoice.invoice != null)
                $scope.searchObject.invoice = contInvoice.invoice;
         
            if (contInvoice.container != '' && contInvoice.container != null)
                $scope.searchObject.container = contInvoice.container;
            
            if (contInvoice.bl != '' && contInvoice.bl != null)
                $scope.searchObject.bl_no = contInvoice.bl;
            

            if (contInvoice.container != '' && contInvoice.container != null  && contInvoice.invoice != '' && contInvoice.invoice != null  ){
                logger.logError("please select only one criteria");
                return false;
            }if (contInvoice.invoice != '' && contInvoice.invoice != null  && contInvoice.bl != '' && contInvoice.bl != null){
                logger.logError("please select only one criteria");
                return false;
            }if (contInvoice.container != '' && contInvoice.container != null  &&  contInvoice.bl != '' && contInvoice.bl != null){
                logger.logError("please select only one criteria");
                return false;
            }
            if ((contInvoice.container == '' || contInvoice.container == null)  && (contInvoice.invoice == '' || contInvoice.invoice == null) && (contInvoice.bl == '' || contInvoice.bl == null)){
                logger.logError("please select  one criteria");
                return false;
            }

            console.log($scope.searchObject);
            $http.post('app/containerInvoice/list', $scope.searchObject).success(function(data) {
                $scope.rowCollection = [];
                
                if (data.success == true) {
                    $scope.pushTranslationListUtil(data);
                } else {

                    $scope.showEmptyLabel = true;

                    logger.logError("Error Please Try Again");
                }
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
        }
        
        $scope.exportData = function(contInvoice) {
            console.log(contInvoice);
            $scope.searchObject = {           
                    invoice : '',
                    container : '',
                    bl_no:''
            };
           
            if(contInvoice ==undefined){
                logger.logError("please select one criteria");
                return false;
            }
            if (contInvoice.invoice != '' && contInvoice.invoice != null)
                $scope.searchObject.invoice = contInvoice.invoice;
         
            if (contInvoice.container != '' && contInvoice.container != null)
                $scope.searchObject.container = contInvoice.container;
            
            if (contInvoice.bl != '' && contInvoice.bl != null)
                $scope.searchObject.bl_no = contInvoice.bl;
            

            if (contInvoice.container != '' && contInvoice.container != null  && contInvoice.invoice != '' && contInvoice.invoice != null  ){
                logger.logError("please select only one criteria");
                return false;
            }if (contInvoice.invoice != '' && contInvoice.invoice != null  && contInvoice.bl != '' && contInvoice.bl != null){
                logger.logError("please select only one criteria");
                return false;
            }if (contInvoice.container != '' && contInvoice.container != null  &&  contInvoice.bl != '' && contInvoice.bl != null){
                logger.logError("please select only one criteria");
                return false;
            }
            if ((contInvoice.container == '' || contInvoice.container == null)  && (contInvoice.invoice == '' || contInvoice.invoice == null) && (contInvoice.bl == '' || contInvoice.bl == null)){
                logger.logError("please select  one criteria");
                return false;
            }

            $http.post('app/containerInvoice/viewExcel', $scope.searchObject).success(function(data) {
                $("#tbPdfExport").bind('click', function () {
                  //  alert('clicked');
                    
                 });
                $('#tbPdfExport').simulateClick('click');
            }).error(function(data) {
                logger.logError("Error Please Try Again");
            });
          
        }
        $.fn.simulateClick = function() {
            return this.each(function() {
        if('createEvent' in document) {
            var doc = this.ownerDocument,
                evt = doc.createEvent('MouseEvents');
            evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
            this.dispatchEvent(evt);
        } else {
            this.click(); // IE
        }
        });
        }
        $scope.pushTranslationListUtil = function(data) {
            if (utilsService.isUndefinedOrNull(data.lContainerInvoiceReportBean)) {

                $scope.showEmptyLabel = true;

            } else {

                $scope.rowCollection = $scope.rowCollection.concat(data.lContainerInvoiceReportBean);

            }
        };
   });
    
    