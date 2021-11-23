app.controller('chartOfAccountCtrl', function($scope, $rootScope, $http, $location, logger, utilsService,
        $state,sharedProperties,$window,coaListService,$timeout,$compile,$stateParams) {
   
    $scope.groupHeadList=[];
    $scope.subGroupHeadList=[];
    $scope.accountHeadList=[];
    $scope.strGrpHeadList='';
    $scope.strSubGrpHeadList='';
    $scope.filePath='';    
    
    $('document').ready(function(){
        loadAcctHeadDataNew(); 
    });
    
    $scope.exportExcel =function(){
        $http.get($stateParams.tenantid+'/app/chartofaccounts/exportExcel').success(function(datas) {
            debugger;
            $("#COAExport").bind('click', function() {
                logger.logSuccess("Exported successfully!");

            });
            $('#COAExport').simulateClick('click');
        }).error(function(data) {
            logger.logError("No Records Found");

        });
    }
    
    $.fn.simulateClick = function() {
        return this.each(function() {
            if ('createEvent' in document) {
                var doc = this.ownerDocument, evt = doc.createEvent('MouseEvents');
                evt.initMouseEvent('click', true, true, doc.defaultView, 1, 0, 0, 0, 0, false, false, false, false, 0, null);
                this.dispatchEvent(evt);
            } else {
                this.click(); // IE
            }
        });
    }
    
    function loadAcctHeadDataNew(){
        
            var grpHeadVal=fetchGroupHeadList();
            
            var str=grpHeadVal.replace('undefined', '');
            
            $('.tree').append(str);
            $('.tree li').each(function() {
                if($(this).children('ul') ) {
                    $(this).addClass('parent');
                }
            });

            $('.tree li.parent > a').click( function( ) {
                $(this).parent().toggleClass( 'active' );
                $(this).parent().children( 'ul' ).slideToggle( 'fast' );
            });
            
            $('#all').click( function() {                
                $('.tree li').each(function(){
                    $(this).toggleClass('active');
                    $(this).children('ul').slideToggle('fast');
                });
            });     
    }
    
    /**
     * fetch group Head Data into <li> element
     */
    
    function fetchGroupHeadList(){
            var strLI, strULstart='<ul>';
            
            $.ajax({
                type : "GET",
                url : $stateParams.tenantid+"/app/chartofaccounts/getGroupHead",
                data : "",
                async: false,
                contentType: false,
                processData: false,
                success : function(datas) {
                    
                    $scope.groupHeadList = datas.lChartOfAccountsBean;
                    $.each($scope.groupHeadList, function() {
                        strLI+='<li class=\'parent\' id='+this.groupHeadCode+' ><a>'+this.groupHeadName+'</a>';
                        var subgrpData=fetchSubGroupHeadData(this.groupHeadCode);
                        strLI+=subgrpData.replace('undefined', '')+'</li>';
                    });                  
                 }
               
            });
            var strULend='</ul>';
            var strGrpHeadULEle=strULstart+strLI+strULend;
              
        
        return strGrpHeadULEle;
    }
    
    /**
     * fetch Sub Group Head List with group head code  into <li> element
     */
    function fetchSubGroupHeadData(groupHeadCode){
        var strSgLI, strSgULstart='<ul>';
        var frmData=new FormData();        
        frmData.append('groupHeadCode', groupHeadCode);
        $.ajax({
            type: "POST",
            url: $stateParams.tenantid+"/app/chartofaccounts/getSubGroupHeadList",
            data: frmData,
            async: false,
            contentType: false,
            processData: false,
            success: function(datas) {                
                $scope.subGroupHeadList = datas.lChartOfAccountsBean;
                $.each($scope.subGroupHeadList, function() {
                    strSgLI+='<li class=\'parent\' id='+this.subGroupAcctCode+' ><a><b>'+this.subGroupAcctCode+'</b>-'+this.subGroupAcctName+'</a>';
                    
                    var acctHeadStr=fetchAccountHeadData(this.subGroupAcctCode);                    
                    strSgLI+=acctHeadStr.replace('undefined', '')+'</li>';                  
                            
                });                  
             }           
        });
        
        var strSgULend='</ul>';
        var strSubGrpULele=strSgULstart+strSgLI+strSgULend;
        
        return strSubGrpULele;
    }
    
    /**
     * fetch Account Head List with subGroupAcctCode into <li> element
     */
    function fetchAccountHeadData(subGroupAcctCode){
        var strAccLi, strAccULstart='<ul>';
        var frmData=new FormData();        
        frmData.append('subGroupAcctCode', subGroupAcctCode);
        $.ajax({
            type : "POST",
            url : 	$stateParams.tenantid+"/app/chartofaccounts/getAccountHeadList",
            data : frmData,
            async: false,
            contentType: false,
            processData: false,
            success : function(datas) {
                
                $scope.accountHeadList = datas.lChartOfAccountsBean;
                $.each($scope.accountHeadList, function() {
                    strAccLi+='<li class=\'parent\' id='+this.accountHeadCode+' ><a><b>'+this.accountHeadCode+'</b>-'+this.accountHeadName+'</a></li>';
                    //str+=subgrpData.replace('undefined', '')+'</li>';
                });                  
             }
           
        });
        
        var strAccULend='</ul>';
        var s=strAccULstart+strAccLi+strAccULend;
        
        return s;
    }
    /***
     * Try 1 ***********************************
     */
    
    $scope.loadAcctheadData = function() {
        
        $scope.dataGHList = coaListService.fetchGroupHead();
        $scope.dataGHList.then(function(groupHeadLists){
                $scope.groupHeadList = groupHeadLists;
                var strLIlist, strULstart='<ul>',strList='';          
            
                $.each($scope.groupHeadList, function() {
                    strLIlist+='<li class=\'parent\' id='+this.groupHeadCode+' ><a>'+this.groupHeadName+'</a>';                    
                });
                var strULend='</ul>';
                strList=strULstart+strLIlist+strULend;     
                $scope.strGrpHeadList =strList;
                
                /*$scope.dataSubGrpHeadList=coaListService.fetchSubGroupHeadData(this.groupHeadCode);                                   
                $scope.dataSubGrpHeadList.then(function(subGroupHeadLists){
                    $scope.subGroupHeadList=subGroupHeadLists;
                });*/
                
                $scope.strGrpHeadList =strList;   
                var str=$scope.strGrpHeadList.replace('undefined', '');
                console.log("str:::::::::::::::::::::::::::::");
                console.log(str);
                $('.tree').append(str);  
                
                $( '.tree li' ).each( function() {
                        
                        if( $( this ).children( 'ul' )) {
                                $( this ).addClass( 'parent' );     
                        }
                    
                });
                
                $( '.tree li.parent > a' ).click( function( ) {
                        $( this ).parent().toggleClass( 'active' );
                        $( this ).parent().children( 'ul' ).slideToggle( 'fast' );
                        
                });
                
                $( '#all' ).click( function() {
                    
                    $( '.tree li' ).each( function() {
                        $( this ).toggleClass( 'active' );
                        $( this ).children( 'ul' ).slideToggle( 'fast' );
                    });
                });
            
       });
    }
});

app.service("coaListService",function($http,$q){
    
    this.fetchGroupHead = function(){ 
        
        var groupHeadList = $q.defer();
        $http.get($stateParams.tenantid+'/app/chartofaccounts/getGroupHead').success(function(datas) {
            
            groupHeadList.resolve(datas.lChartOfAccountsBean);
            
        }).error(function(data) {
            groupHeadList.reject("Failed to get Group Head List");
        });           
        return groupHeadList.promise;
    }
    
   this.fetchSubGroupHeadData= function(groupHeadCode){
    
        var subGroupHeadList = $q.defer();
        $http.get($stateParams.tenantid+'/app/chartofaccounts/getSubGroupHeadList?groupHeadCode='+groupHeadCode).success(function(datas) {
            subGroupHeadList.resolve(datas.lChartOfAccountsBean);            
            
            
        }).error(function(data) {
            subGroupHeadList.reject("Failed to get Group Head List");
        });           
        return subGroupHeadList.promise;
    }
});