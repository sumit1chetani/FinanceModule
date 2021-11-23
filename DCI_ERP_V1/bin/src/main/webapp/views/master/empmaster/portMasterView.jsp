<div class="wrapper-md">
 <div class="panel panel-default panel-default-form">
 
  <div class="panel-body">
   <form class="form-horizontal" name="PortMasterForm" novalidate method="post">
    <div class="row">
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6">Port Code </label>
        <div class="col-md-6">
          <label class="col-md-6 text-left control-label"> {{portMaster.portCode}}</label>
        </div>
       </div>
        <div class="form-group">
      <label class="col-md-6 control-label">
      Port Type
      </label>
      <div class="col-md-6">
          <div class="col-md-6 inputGroupContainer">
              <label class="col-md-6 text-left control-label"> {{portMaster.portType}}</label>
        </div>
     </div>
     </div>
       
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6">Docks</label>
        <div class="col-md-6 inputGroupContainer">
              <label class="col-md-6 text-left control-label"> {{portMaster.docksId}}</label>
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">RTG</label>
        <div class="col-md-6">
       
            <label class="col-md-6 text-left control-label"> {{portMaster.rtg}}</label>
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">RMQC</label>
        <div class="col-md-6">
       
            <label class="col-md-6 text-left control-label"> {{portMaster.rmqc}}</label>
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">RMGC</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.rmgc}}</label>
       
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">No.of Cranes</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.noOfCranes}}</label>
        
        </div>
       </div>
      
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Active</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.portStatus}}</label>
        </div>
       </div>
       
           <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6">Berths</label>
        <div class="col-md-6 inputGroupContainer">
           <label class="col-md-6 text-left control-label"> {{portMaster.berthId}}</label>
        </div>
       </div>
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Port Name </label>
        <div class="col-md-6">
        
            <label class="col-md-6 text-left control-label"> {{portMaster.portName}}</label>
        </div>
       </div>
   
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">QGC</label>
        <div class="col-md-6">
          <label class="col-md-6 text-left control-label"> {{portMaster.qgc}}</label>
       
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Refer Points</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.referPoints}}</label>
        
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Reach Stack</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.reachStack}}</label>
         
        </div>
       </div>
        <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Transhipment Free days</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.transFreeDays}}</label>
        </div>
       </div>
      <div class="form-group"  ng-show="portMaster.portType == 'Port'" >
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Terminals</label>
        <div class="col-md-6"  ng-repeat="item in portlist track by $index">
          <span>{{item}}</span>
                 <!--   <span>{{portlist[$index]})</span> -->
        </div>
       </div>
         <div class="form-group">
        <label class="col-md-6 control-label">Created By</label>
        <div class="col-md-6">
<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedBy" ng-model="surchargeData.modifiedBy:" > -->
           <label class="col-md-12 control-label" style="text-align: left;">{{portMaster.createdBy}}</label>
        </div>
       </div>
        <div class="form-group">
        <label class="col-md-6 control-label">Created Date</label>
        <div class="col-md-6">
<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedDate" ng-model="surchargeData.modifiedDate" > -->
           <label class="col-md-12 control-label" style="text-align: left;">{{portMaster.createdDate}}</label>
        </div>
       </div>
      </fieldset>
     </div>
     <div class="col-sm-12 col-md-4 col-lg-4">
      <fieldset>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">ICD / Rail</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.icd}}</label>
        
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Empty Handlers</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.emptyHandlers}}</label>

        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Country Name</label>
        <div class="col-md-6 inputGroupContainer">
            <label class="col-md-6 text-left control-label"> {{portMaster.countryName}}</label>
        </div>
       </div>
        <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Website Address</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.websiteAddress}}</label>
         
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Port Email</label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.portEmail}}</label>
        
        </div>
       </div>
       <div class="form-group">
        <label for="inputPassword" class="control-label col-md-6 col-lg-6">Port ISO Code  </label>
        <div class="col-md-6">
           <label class="col-md-6 text-left control-label"> {{portMaster.portIsoCode}}</label>
      
        </div>
       </div>
         <div class="form-group">
        <label class="col-md-6 control-label">ModifiedBy</label>
        <div class="col-md-6">
<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedBy" ng-model="surchargeData.modifiedBy:" > -->
           <label class="col-md-12 control-label" style="text-align: left;">{{portMaster.modifiedBy}}</label>
        </div>
       </div>
        <div class="form-group">
        <label class="col-md-6 control-label">ModifiedDate</label>
        <div class="col-md-6 ">
<!--          <input type="text" class="text-left form-control input-sm"
          name="modifiedDate" ng-model="surchargeData.modifiedDate" > -->
           <label class="col-md-12 control-label" style="text-align: left;">{{portMaster.modifiedDate}}</label>
        </div>
       </div>
      </fieldset>
     </div>
    </div>
    <div class="form-actions">
     <div class="row">

       
        <button class="btn btn-danger" type="button" class="btn btn-success"  ng-click="cancel()">
        <i class="fa fa-close"></i>
        Cancel
       </button>
      </div>
      </div>
      </form>
      </div>
      </div>
      </div>
      
