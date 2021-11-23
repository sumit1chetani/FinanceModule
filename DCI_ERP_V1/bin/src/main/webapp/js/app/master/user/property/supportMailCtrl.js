
'use strict';
app.controller('supportMailCtrl', function($scope,$filter, $rootScope, $controller,$http, $location, logger, $log, ngDialog, $modal, utilsService, sharedProperties, $state,validationService,toaster,$injector,$timeout) {
    $scope.pageCounters = [14, 16, 17, 18, 150, 500, 1000 ];

    $scope.offsetCount = 0;
    $scope.limitCount = 1000;
    $scope.rowCollection = [];
    $scope.displayedCollection = [];
    $scope.itemsByPage = 14;
    $scope.initial = {}; 
    $scope.isAdd = true; 
   
    
    $scope.supportMail = {
            issueDate : '',
            status : '',
            assignedTo : '',
            sender : '',
            issueType : '',
            popAssignedTo : '',
            popStatus : '',
           
     }
    $scope.supportMailPop = {
            mailDate : '',
            sender : '',
            subject : '',
            issueType : '',
            popAssignedTo : '',
            popStatus : '',
            resolution : ''
    }
    $scope.issueTypeList = [
        {
            "id" : "A",
            "text" : "Amendment"   
        },
        {
            "id" : "B",
            "text" : "Bug"   
        },
        {
            "id" : "C",
            "text" : "Change"
        },
       
        {
            "id" : "R1",
            "text" : "Request"   
        },
        {
            "id" : "R2",
            "text" : "Reply"   
        },
        {
            "id" : "R3",
            "text" : "Reminder"   
        },
        {
            "id" : "I",
            "text" : "Internal Communication"   
        },
    ]
    
    $scope.statusList = [
            {
                "id" : "O",
                "text" : "Open"   
            },
            {
                "id" : "N",
                "text" : "Not to be replied"   
            },
            {
                "id" : "C",
                "text" : "Closed"
            },
            {
                "id" : "W",
                "text" : "Work In Progress"
            }
    ];
    
    $scope.assignedToList = [
            {
                "id" : "abbas",
                "text" : "Abbas"
            },{
                "id" : "anand",
                "text" : "Anand"
            }, {
                "id" : "bharath",
                "text" : "Bharath"
            }, {
                "id" : "bhuvana",
                "text" : "Bhuvana"
            }, {
                "id" : "dhivya",
                "text" : "Dhivya"   
            },   {
                "id" : "dr",
                "text" : "Dr."
            }, {
                "id" : "gopi",
                "text" : "Gopi"
            },{
                "id" : "harsha",
                "text" : "Harsha"
            },{
                "id" : "jayanthi",
                "text" : "Jayanthi"
            }, {
                "id" : "joseph",
                "text" : "Joseph"
            },{
                "id" : "muthu",
                "text" : "Muthu"
            }, {
                "id" : "vijitha",
                "text" : "Vijitha"   
            },{
                "id" : "gowtham",
                "text" : "Gowtham"   
            },{
                "id" : "sakthi",
                "text" : "Sakthi"   
            },{
                "id" : "mani",
                "text" : "Mani"   
            }      ];
    
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1; // January is 0!

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    var today = dd + '/' + mm + '/' + yyyy;
    $scope.supportMail.startDate = today;
    
   
    
    $timeout(function() {
        $("#issueDate").datetimepicker({
            format : 'DD/MM/YYYY',
            pickTime : false
        })
    }, 500);
    
    $scope.supportMail.issueDate = today;  
    
    $scope.pushToDB = function(){
        $scope.supportMail.issueDate = $('#txtIssueDate').val();
        $http.get('app/supportMail/pushToDB').success(function(result) {
            if (result == true) {
                logger.logSuccess("Datas pushed successfully");
            }
        });
    }
    
    $scope.list = function(){
        $scope.supportMail.issueDate = $('#txtIssueDate').val();
        $http.post('app/supportMail/list',$scope.supportMail).success(function(result) {
            if (result) {
                $scope.displayedCollection = result;
            }
        });
    }
//    $scope.displayedCollection[index] = collection;
    $scope.editRow = function(collection ,index) {
        /*$state.go('app.master.user.supportMailEdit', ({
            'mailDate' : collection.mailDate,
            'subject' : collection.subject
            
        }));*/
        
        console.log("Collection ::"+collection);
        console.log("Index:"+index);
        if(collection.edit == false){
            collection.edit =true;
            var tableData = $scope.displayedCollection;
            console.log("Answer::"+$scope.displayedCollection.splice(index, 1));
            $scope.displayedCollection[index] = collection;
            var obj2 = $filter('filter')($scope.issueTypeList, {
                text : collection.issueType
            },true);
            var obj = $filter('filter')($scope.assignedToList, {
                text : collection.popAssignedTo
            },true);
            var objs = $filter('filter')($scope.statusList, {
                text : collection.popStatus
            },true);
           
           
            console.log(objs);
            if(obj2!=undefined && obj2.length>0){
                collection.issueType=obj2[0].id;
                }
            if(obj!=undefined && obj.length>0){
                collection.popAssignedTo=obj[0].id;
            }
            if(objs!=undefined && objs.length>0){
                collection.popStatus=objs[0].id;
            }
 
        }
        else{
            collection.edit =false;
        }
    };
    

    $scope.check = function(supportMailForm){
        if($scope.supportMail.status == 'C'){
            $scope.supportMail.endDate = $('#txtendDate').val();
            if($scope.supportMail.endDate == '')
                logger.logError("Please enter End Date")
            else
                $scope.update();
           
        }
        else
            $scope.update();
    }
    
    $scope.update = function(collection ,index){
        $scope.supportMail.startDate = $('#txtstartDate').val();
        $scope.supportMail.endDate = $('#txtendDate').val();
        console.log("Collection ::"+collection);
        console.log("Index:"+index);
        $http.post('app/supportMail/update',$scope.displayedCollection[index]).success(function(result) {
            if (result == true) {
                ngDialog.close();
                logger.logSuccess("Updated Successfully");
                $scope.list();
            }else
                logger.logError("Updation failed")
        });
    }
    

    $scope.submit = function(supportMailForm){
        var issueDate = $scope.supportMail.issueDate;
        $scope.supportMail.issueDate = $('#txtIssueDate').val();
        //if (new validationService().checkFormValidity($scope.supportMailForm)) {
            $http.post('app/supportMail/mailRead', $scope.supportMail).success(function(result) {
                $('#exportXl').append('<a id="tbExcelExport" stype="display:none" href="filePath/SupportMail.xlsx" download="SupportMail.xlsx"></a>');
                $("#tbExcelExport").bind('click', function() {
                });
                $('#tbExcelExport').simulateClick('click');
    
         }).error(function(result) {
             logger.logError("Error Please Try Again");
         });
                       $.fn.simulateClick = function() {   return this.each(function() {
                     if ('createEvent' in document) {
                         var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                         evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                          this.dispatchEvent(evt);
                      } else {
                         this.click(); // IE
                     }
                 });
             }
       /* }else {
            toaster.pop('error', "Please fill the required fields", logger.getErrorHtmlNew($scope.supportMailForm.$validationSummary), 555000, 'trustedHtml');
        }*/
    }
  
 
});

