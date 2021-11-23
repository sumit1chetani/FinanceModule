<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
 
#dt_basic1>tbody>tr>.conType {
	text-align: center !important;
}

.headSel:hover {
	color: #393c88;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inward BL</title>
</head>
<body>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<div class="wrapper-md" >
<div class="panel panel-default panel-default-list">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		</div>
		 <form class="" method="POST" name="blForm"
			novalidate>
  <div class="col-md-12">
 
<div class="col-md-12" style="border: 1px solid rgba(0, 0, 0, 0.22);">
<br>
          <div class="col-md-6">
          <label class="control-label">B/L No  <span style="color: red;">*</span></label>
             <div>
                <input class="form-control" type="text" placeholder="B/L No"  class="form-control" id="blNo"  
                ng-model="blNoData.blNo" name="blNo" form-name="blForm" validation="required"  friendly-name="B/L No" > </div>
              </div>

              
         <!--      <div class="col-md-6">
                <label class="control-label">Booking No</label>
                <div>
                 <selectivity list="bookingList" property="blNoData.bookingNo" id="bookingNo" ng-model="blNoData.bookingNo"
               name="bookingNo" form-name="blForm" 
                friendly-name="Booking No"></selectivity> </div>
                 
  
    </div> -->
      <br>
    </div>
     <div class="col-md-12" style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
                <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

                <div class="col-md-4">
                 <label class="control-label">Issue Place  <span style="color: red;">*</span></label>
                <selectivity list="portlist" property="blNoData.issuePlace" id="issuePlace" ng-model="blNoData.issuePlace"
               name="issuePlace" form-name="blForm" validation="required" 
                friendly-name="Issue Place"></selectivity>  
                <!--  
                  <selectivity list="issuePlaceList" property="blNoData.issuePlace" id="issuePlace" ng-model="blNoData.issuePlace"
               name="issuePlace" form-name="blForm" validation="required" 
                friendly-name="Issue Place"></selectivity> -->
                </div>


                  <div class="col-md-4">
                  <label class="control-label">Issue Date  <span style="color: red;">*</span></label>
				<ng-bs3-datepicker data-ng-model="blNoData.issueDate"
											name="issueDate" form-name="blForm" validation="required" 
											friendly-name="Issue Date" validation="required" />
</div>

<div class="col-md-4">
              <label class="control-label">On Board</label>
              <ng-bs3-datepicker data-ng-model="blNoData.onBoard"
											name="onBoard" form-name="blForm" 
										   />
</div>
                </div><br>
                <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

                  <div class="col-md-4">
                    <label class="control-label">Vsl.Voyage  <span style="color: red;">*</span></label>
									   <selectivity list="vesselVoyageList" property="blNoData.vslVoyage" id="vslVoyage" ng-model="blNoData.vslVoyage"
               name="mVoyage" form-name="blForm" validation="required" 
                friendly-name="Vsl.Voyage"></selectivity> 
                  </div>
                       
                  <div class="col-md-4">
                  <label class="control-label">Receipt at  <span style="color: red;">*</span></label>
                 <!--    <selectivity list="issuePlaceList" property="blNoData.receiptAt" id="receiptAt" ng-model="blNoData.receiptAt"
               name="receiptAt"  form-name="blForm" validation="required" 
                friendly-name="Receipt at"></selectivity> -->
                  <selectivity list="portlist" property="blNoData.receiptAt" id="receiptAt" ng-model="blNoData.receiptAt"
               name="receiptAt" form-name="blForm" validation="required" 
                friendly-name="Receipt at "></selectivity>    
                
                
          </div>
          <div class="col-md-4">
                <label class="control-label">P.O.L  <span style="color: red;">*</span></label>
                <selectivity list="portlist" property="blNoData.pol" id="pol" ng-model="blNoData.pol"
               name="pol" form-name="blForm" validation="required" 
                friendly-name="POL"></selectivity>         
        
              </div>
                </div><br>
                <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">    
            <div class="col-md-4">
                <label class="control-label">P.O.D  <span style="color: red;">*</span></label>  
                 <selectivity list="portlist" property="blNoData.pod" id="pod" ng-model="blNoData.pod"
               name="pod" form-name="blForm" validation="required" 
                friendly-name="POD"></selectivity> 
              </div>
            
         
          <div class="col-md-4">
                <label class="control-label">P.O.T  <span style="color: red;"></span></label>
               <selectivity list="portlist" property="blNoData.pot" id="pot" ng-model="blNoData.pot"
               name="pot" form-name="blForm" 
                friendly-name="POT"></selectivity>                            </div>

               <div class="col-md-4">
                <label class="control-label">F.P.O.D  <span style="color: red;">*</span></label> 
              <selectivity list="portlist" property="blNoData.fpod" id="fpod" ng-model="blNoData.fpod"
               name="fpod" form-name="blForm" validation="required" 
                friendly-name="FPOD"></selectivity>     
              </div>
                </div>
              <br>
              <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
          <div class="col-md-4">
                <label class="control-label">Terms  <span style="color: red;">*</span></label>
                 <selectivity list="termsOfPayment" property="blNoData.terms" id="terms" ng-model="blNoData.terms"
               name="terms" form-name="blForm" validation="required"
                friendly-name="Terms Of Payment"></selectivity>         
                
              </div>
           

              <div class="col-md-4">
                <label class="control-label">No.Bls  <span style="color: red;">*</span></label>
                <input type="number" placeholder="No.Bls" class="form-control" id="noBls"  friendly-name="No.Bls"
                ng-model="blNoData.noBls" name="noBls"  form-name="blForm" validation="required" >  
              </div>
              <div class="col-md-4">
                <label class="control-label">REF  <span style="color: red;">*</span></label>
                <input class="form-control" type="text" placeholder="REF" class="form-control" id="ref" friendly-name="Ref"  ng-model="blNoData.ref" name="ref" form-name="blForm" validation="required|numeric" >
              </div>
              </div>
      <br>
                <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">
            <div class="col-md-4">
                <label class="control-label">M.Voyage</label>
                 <selectivity list="vesselVoyageList" property="blNoData.mVoyage" id="mVoyage" ng-model="blNoData.mVoyage"
               name="mVoyage" form-name="blForm" 
                 ></selectivity> 
               
                </div>
              
             
              <div class="col-md-4">
                  <label class="control-label">Load Type  <span style="color: red;">*</span></label>  
                  
                  <selectivity list="load" property="blNoData.loadType" id="loadType" ng-model="blNoData.loadType"
               name="loadType"friendly-name="Load Type"
                form-name="blForm" validation="required" ></selectivity>
        
                </div>
<div class="col-md-4">
                  <label class="control-label">Shipment Type  <span style="color: red;">*</span></label> 
                   <selectivity list="serviceList" property="blNoData.service" id="service" ng-model="blNoData.service"
               name="service"  friendly-name="Shipment Type"
                form-name="blForm" validation="required" ></selectivity>
                
               
 </div>
 
</div>
 <div class="col-md-12" style="margin-top: 1%; margin-bottom: 1%;">

   <div class="col-md-4">
                <label class="control-label">Client  <span style="color: red;">*</span></label>
                    <selectivity list="customerList" property="blNoData.client" id="client" ng-model="blNoData.client"
               name="client" friendly-name="Client"   form-name="blForm" validation="required" ></selectivity>
              </div>
<div class="col-md-4">
                <label class="control-label">Remarks</label>
                <input class="form-control" type="text" placeholder="Remarks"  class="form-control" id="remarks"  ng-model="blNoData.remarks" name="remarks">
           </div>
          <div class="col-md-4">
                  <label class="control-label">Agent</label>
                <selectivity list="agentList" property="blNoData.agent" id="agent" ng-model="blNoData.agent"
               name="agent" form-name="blForm" 
                friendly-name="Load Type"></selectivity>        
                  
              </div>
 </div>
             <br>
             <div class="col-md-12" style="margin-top: 1%; margin-bottom: 2%;">
             

           <div class="col-md-4">
                <label class="control-label">Shipment  <span style="color: red;">*</span></label>
                   <selectivity list="shipmentList" property="blNoData.shipment" id="shipment" ng-model="blNoData.shipment"
               name="shipment"    form-name="blForm" validation="required" friendly-name="Shipment"></selectivity>   
              </div>
               
             <div class="col-md-4">
                <label class="control-label">Status</label>
                <selectivity list="statusList" property="blNoData.status" id="status" ng-model="blNoData.status"
               name="status" form-name="blForm" 
                friendly-name="Staus"></selectivity>
                  </div>
                  <div class="col-md-4">
                      <label class="control-label" style="margin-top: 8%;">Released</label>                 
                    <input  type="checkbox" id="released"  ng-model="blNoData.released" name="released">       
       </div>
             </div>
             <br>
             
                </div> 
             <br>
       <br>
             <div class="col-md-12" style="border: 1px solid rgba(0, 0, 0, 0.22); margin-top: 2%;">
        <br>
        <tabset justified="true" class="tab-container"> 
        <tab heading="Names" style="background:#23225c">
	<div class="panel-body">
  			<div class="row">
				<div class="col-md-12">
					<fieldset>
					 <div class="col-md-12">
              <label class="control-label">Messers</label>
              <input class="form-control" type="text"  name="messers" id="messers" ng-model="blNoData.messers" placeholder="Messers">

            </div>

            <div class="col-md-6">
              <label class="control-label">Shippers</label>
              <textarea class="form-control" type="text"  name="shipper" id="shipper" ng-model="blNoData.shipper"  placeholder="Shippers">
                            </textarea>

            </div>

            <div class="col-md-6">
              <label class="control-label">Cnee</label>
              <textarea class="form-control" type="text" name="cnee" id="cnee"ng-model="blNoData.cnee"  placeholder="Cnee">
                            </textarea>

            </div>

            <div class="col-md-6">
              <label class="control-label">Notify1</label>
              <textarea class="form-control" type="text"  name="notify1" id="notify1"ng-model="blNoData.notify1"  placeholder="Notify1">
                            </textarea>

            </div>
            <div class="col-md-6">
              <label class="control-label">Notify2</label>
              <textarea class="form-control" type="text"  name="notify2" id="notify2"ng-model="blNoData.notify2"  placeholder="Notify2">
                            </textarea>

            </div>

            <div class="col-md-6">
              <label class="control-label">Forwarder</label>
              <textarea class="form-control" type="text"  name="forwarder" id="forwarder" ng-model="blNoData.forwarder"  placeholder="Forwarder">
                            </textarea>


            </div>
					</fieldset>
				</div>
				
			</div>
			<br>
			 
 		<!--  </div>
	</div>
	</div> -->
	</div>
	</tab> 
	<tab heading="Goods" style="background:#23225c">
	<div class="panel-body">
	 
			<div class="row">
<div class="col-md-12">
              <label class="control-label">Main Com</label>
              <input class="form-control" type="text" name="maincom" id="maincom" ng-model="blNoData.maincom"  placeholder="Main Com">

            </div>

            <div class="col-md-2">
              <label class="control-label">T.WGT</label>
              <input class="form-control" type="text" name="t_wgt" id="t_wgt" ng-model="blNoData.t_wgt"  placeholder="T.WGT" validation="numeric">

            </div>

            <div class="col-md-3">
              <label class="control-label">G.WGT</label>
              <input class="form-control" type="text"name="g_wgt" id="g_wgt" ng-model="blNoData.g_wgt"   placeholder="G.WGT" validation="numeric">

            </div>

            <div class="col-md-3">
              <label class="control-label">N.WGT</label>
              <input class="form-control" type="text" name="n_wgt" id="n_wgt" ng-model="blNoData.n_wgt"  placeholder="N.WGT" validation="numeric">

            </div>
            <div class="col-md-2">
              <label class="control-label">CBM</label>
              <input class="form-control" type="text" name="cbm" id="cbm" ng-model="blNoData.cbm"  placeholder="CBM" validation="numeric">

            </div>

            <div class="col-md-2">
              <label class="control-label">PKGS</label>
              <input class="form-control" type="text" name="pkgs" id="pkgs" ng-model="blNoData.pkgs"  placeholder="PKGS" validation="numeric">

            </div>

            <div class="col-md-6">
              <label class="control-label">Goods</label>
              <textarea class="form-control" type="text" name="goods" id="goods" ng-model="blNoData.goods"  placeholder="Goods">
                      </textarea>

            </div>

            <div class="col-md-6">
              <label class="control-label">Marks</label>
              <textarea class="form-control" type="text" name="marks" id="marks" ng-model="blNoData.marks"  placeholder="Marks">
                      </textarea>

            </div>
			</div>
			<br>
			 
 	</div>
	</tab> 
	<tab heading="Containers" style="background:#23225c">
	 <div class="col-md-12">
	 <div class="table-responsive ">
	<div class="panel-body" style="width: 220%;">
	 
			<div class="row" id="items">
			
			
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_2">select</th>
									<th colspan=1 class="width_6 text-center">Cntr No <span style="color: red;">*</span></th>
 									<th colspan=1 class="width_6 text-center">Type <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">Seal No <span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center">TW <span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center">GW <span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center">CB <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">Net <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">FLE <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">SOC <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">Package <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">No Of Package <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">G </th>
									<th colspan=1 class="width_6 text-center">Isoog</th>
									<th colspan=1 class="width_6 text-center">Mar</th>
									<th colspan=1 class="width_6 text-center">POL Term <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term <span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center">Action</th>

								</tr>
							</thead>
							<tbody ng-repeat="(trIndex, blcntrDtl) in blNoData.blcntrDtlList">
								<tr>
												 <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="blcntrDtl.select"><i></i></label></td>
									<td class="text-center"> 
					<input class="form-control" type="text" form-name="blForm" validation="required" friendly-name="Container No" name="ContainerNo" id="ContainerNo" ng-model="blcntrDtl.cntrNo"  placeholder="Container No">				
					<!-- 				
									<selectivity list="containerList" property="blcntrDtl.cntrNo" id="cntrNo" ng-model="blcntrDtl.cntrNo"
               name="cntrNo"  form-name="blForm" validation="required" friendly-name="Contaier No"></selectivity> --> </td>
 <td class="text-center">
    <selectivity list="containerTypeList" property="blcntrDtl.type" id="type" ng-model="blcntrDtl.type"
               name="type"  
                friendly-name="Con Type"></selectivity>	</td>								 
									<td class="text-center"><input class="form-control" type="text" form-name="blForm" validation="required" friendly-name="Sea No" name="sealNo" id="sealNo" ng-model="blcntrDtl.sealNo"  placeholder="Seal No"></td>
									<td class="text-center"><input class="form-control" type="text" form-name="blForm" validation="required|numeric" friendly-name="tw" name="tw" id="tw" ng-model="blcntrDtl.tw"  placeholder="TW"></td>
									<td class="text-center"><input class="form-control" type="text" form-name="blForm" validation="required|numeric" friendly-name="gw"name="gw" id="gw" ng-model="blcntrDtl.gw"  placeholder="GW"></td>
									<td class="text-center"><input class="form-control" type="text" form-name="blForm" validation="required|numeric" friendly-name="cb" name="cb" id="cb" ng-model="blcntrDtl.cb"  placeholder="CB"></td>
									<td class="text-center"><input class="form-control" type="text" name="net" form-name="blForm" validation="required|numeric" friendly-name="net" id="net" ng-model="blcntrDtl.net"  placeholder="NET"></td>
									<td class="text-center">
									 <selectivity list="fleList" property="blcntrDtl.fle" id="fle" ng-model="blcntrDtl.fle" validation="required"
               name="fle" form-name="blForm" 
                friendly-name="FLE"></selectivity>
									 </td>
									<td class="text-center">
									   <selectivity list="socList" property="blcntrDtl.so" id="SOC" ng-model="blcntrDtl.so" validation="required"
               name="SOC" form-name="blForm" 
                friendly-name="SOC"></selectivity>
									 </td>
									 <td class="text-center">
    <selectivity list="packageList" property="blcntrDtl.packageType" id="packageType" ng-model="blcntrDtl.packageType"
               name="packageType"   form-name="blForm" validation="required" friendly-name="Package Type"
                friendly-name="Package Type"></selectivity>	</td>	
 									<td class="text-center"><input class="form-control" type="text" name="noo" id="noo" ng-model="blcntrDtl.noOfPckgs" form-name="blForm" validation="required|numeric" friendly-name="No Of Package"  placeholder="NoO"></td>
									<td class="text-center"><input class="form-control" type="text" name="g" id="g" ng-model="blcntrDtl.goods"  placeholder="G" validation="required|numeric"></td>
									<td class="text-center">   <input type="checkbox" name="iso" id="iso" ng-model="blcntrDtl.iso"><i></i> </td>
									<td class="text-center"><input class="form-control" type="text" name="mar" id="mar" ng-model="blcntrDtl.marks"  placeholder="MAR"></td>
									 <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.polTer" id="polTer" ng-model="blcntrDtl.polTer"
          form-name="blForm" validation="required" friendly-name="POL Term"     name="polTer"   ></selectivity>	</td>
                 <td class="text-center">
    <selectivity list="termsOfPayment" property="blcntrDtl.podTer" id="podTer" ng-model="blcntrDtl.podTer"
         form-name="blForm" validation="required" friendly-name="POD Term"      name="podTer"   ></selectivity>	</td>
 									<td class="text-center"> <button ng-click="addinnercntrDtl(blcntrDtl)" class="btn btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button>
								</td>						
									
								</tr>
								<tr>
									<td></td>
									<td colspan="15">
										<table class="table table-striped b-t b-light">
											<tr>
												<th class="width_6 text-center subTable-brs">Charge Code</th>
												<th class="width_5 text-center subTable-brs">Currency</th>
												<th class="width_6 text-center subTable-brs">Unit Rate</th>
												<th class="width_6 text-center subTable-brs">MEA Rate</th>
												<th class="width_6 text-center subTable-brs">WG Rate</th>
												<th class="width_8 text-center subTable-brs">From Place</th>
												<th class="width_8 text-center subTable-brs">To Place</th>
												<th class="width_6 text-center subTable-brs">Min Rate</th>
												<th class="width_6 text-center subTable-brs">Terms</th>
												<th class="width_6 text-center subTable-brs">Real Amount</th>
												<th class="width_3 text-center subTable-brs">Action</th>
											</tr>
											<tr ng-repeat="(bTrIndex, blcntrinnerDtl) in blcntrDtl.chargeList track by bTrIndex">
 												<td class="subTable-brs text-center">  <selectivity list="surchargeList" property="blcntrinnerDtl.chargeCode" id="chargeCode" ng-model="blcntrinnerDtl.chargeCode"
               name="chargeCode"   ></td>
	<td class="subTable-brs text-center">  <selectivity list="currencyList" property="blcntrinnerDtl.currency" id="currency" ng-model="blcntrinnerDtl.currency"
               name="currency"   ></td>               
 												<td class="subTable-brs"><input class="form-control" type="text" name="unitRate" id="unitRate" ng-model="blcntrinnerDtl.unitRate"  placeholder="Unit Rate"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="meaRate" id="meaRate" ng-model="blcntrinnerDtl.meaRate"  placeholder="MEA Rate"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="wgRate" id="wgRate" ng-model="blcntrinnerDtl.wgRate"  placeholder="WG Rate"></td>
												<td class="subTable-brs">  <selectivity list="portlist" property="blcntrinnerDtl.fromPlace" id="fromPlace" ng-model="blcntrinnerDtl.fromPlace"
               name="fromPlace" form-name="blForm" 
                friendly-name="From Place"> </td>
												<td class="subTable-brs"><selectivity list="portlist" property="blcntrinnerDtl.toPlace" id="toPlace" ng-model="blcntrinnerDtl.toPlace"
               name="toPlace" form-name="blForm" 
                friendly-name="To Place"> </td>
												<td class="subTable-brs"><input class="form-control" type="text" name="minRate" id="minRate" ng-model="blcntrinnerDtl.minRate"  placeholder="Min Rate"></td>
												<td class="subTable-brs">
												  <selectivity list="termsOfPayment" property="blcntrinnerDtl.terms" id="terms" ng-model="blcntrinnerDtl.terms"
               name="terms" form-name="blForm"  
                friendly-name="Terms Of Payment"></selectivity></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blcntrinnerDtl.realAmount"  placeholder="Real Amount"></td>
										<td class="subTable-brs"><button ng-click="deleteinnercntrDtl(blcntrDtl,bTrIndex)"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button></td>
											</tr>
										</table>
									</td>
									 
								</tr>
							</tbody>
						</table>
				  <button type="button" class="btn btn-sm btn-success " ng-click="addcntrDtl()"><i class="fa fa-plus"></i></button>
				 <button type="button" class="btn btn-sm btn-danger" ng-click="removecntrDtl(blNoData.blcntrDtlList)"><i class="fa fa-minus"></i></button>
						
						<div class="padding-right-5">
							<div class="col-md-4">
								
								
							</div>
						</div>
					
			
			</div>
			<br>
			
			 
		 
		</div>
	</div>
	</div>
	</tab> 
	<tab heading="Package" style="background:#23225c">
 <div class="col-md-12">
	 <div class="table-responsive ">
	<div class="panel-body" style="width: 220%;">
		 
			<div class="row" id="items">
			
			 <div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th colspan=1 class="width_2">select</th>
									<th colspan=1 class="width_6 text-center">Cntr No<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Type<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Seal No<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center"> TW<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center"> GW<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> CB<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Net<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> FLE<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> SOC<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Package<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> No Of Package<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> G<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">Isoog</th>
									<th colspan=1 class="width_6 text-center">Mar</th>
									<th colspan=1 class="width_6 text-center">POL Term<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">POD Term<span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center">Action</th>

								</tr>
							</thead>
							<tbody ng-repeat="(trIndex1, blpckDtl) in blNoData.blpckDtlList">
								<tr>
<td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="blpckDtl.select"><i></i></label></td>
					 <td class="text-center">
		<!-- 			 <selectivity list="containerList" property="blpckDtl.cntrNo" id="cntrNo" ng-model="blpckDtl.cntrNo"
               name="cntrNo" form-name="blForm" validation="required"  
                friendly-name="Cntr No"></selectivity> -->
                	<input class="form-control" type="text" form-name="blForm" validation="required" friendly-name="Container No" name="ContainerNo" id="ContainerNo" ng-model="blpckDtl.cntrNo"  placeholder="Container No">
                	</td>
                 <td class="text-center">
    <selectivity list="containerTypeList" property="blpckDtl.type" id="type" ng-model="blpckDtl.type"
               name="type"  form-name="blForm" validation="required"   
                friendly-name="Container Type"></selectivity>	</td>
 									<td class="text-center"><input class="form-control" type="text" name="sealNo" id="sealNo" ng-model="blpckDtl.sealNo"  form-name="blForm" validation="required" friendly-name="Seal No" placeholder="Seal No"></td>
									<td class="text-center"><input class="form-control" type="text" name="tw" id="tw" ng-model="blpckDtl.tw"  form-name="blForm" validation="required|numeric" friendly-name="TW" placeholder="TW"></td>
									<td class="text-center"><input class="form-control" type="text" name="gw" id="gw" ng-model="blpckDtl.gw"  form-name="blForm" validation="required|numeric" friendly-name="GW" placeholder="GW"></td>
									<td class="text-center"><input class="form-control" type="text" name="cb" id="cb" ng-model="blpckDtl.cb" form-name="blForm" validation="required|numeric" friendly-name="CB" placeholder="CB"></td>
									<td class="text-center"><input class="form-control" type="text" name="net" id="net" ng-model="blpckDtl.net"  form-name="blForm" validation="required|numeric" friendly-name="NET" placeholder="NET"></td>
									<td class="text-center"> <selectivity list="fleList" property="blpckDtl.fle" id="fle" ng-model="blpckDtl.fle" validation="required"
               name="fle" form-name="blForm" 
                friendly-name="FLE"></selectivity></td>
									<td class="text-center">
									 <selectivity list="socList" property="blpckDtl.so" id="SOC" ng-model="blpckDtl.so" validation="required"
               name="SOC" form-name="blForm" 
                friendly-name="SOC"></selectivity>
									 </td>
										 <td class="text-center">
    <selectivity list="packageList" property="blpckDtl.packageType" form-name="blForm" id="packageType" ng-model="blpckDtl.packageType"
               name="packageType"  
                friendly-name="Package Type"></selectivity>	</td>
 									<td class="text-center"><input class="form-control" type="text" name="no" id="no" ng-model="blpckDtl.noOfPckgs"  form-name="blForm" validation="required" friendly-name="No of Package"    placeholder="NO"></td>
									<td class="text-center"><input class="form-control" type="text" name="g" id="g" ng-model="blpckDtl.goods"  placeholder="G" validation="required|numeric"></td>
									<td class="text-center"> <input type="checkbox" name="iso" id="iso" ng-model="blpckDtl.iso"><i></i> </td>
									<td class="text-center"><input class="form-control" type="text" name="mar" id="mar" ng-model="blpckDtl.marks"  placeholder="MAR"></td>
								<td class="text-center">
    <selectivity list="termsOfPayment" property="blpckDtl.polTer" id="polTer" ng-model="blpckDtl.polTer"
               name="polTer"  form-name="blForm" validation="required" friendly-name="Pol Term"    ></selectivity>	</td>
                 <td class="text-center">
    <selectivity list="termsOfPayment" property="blpckDtl.podTer" id="podTer" ng-model="blpckDtl.podTer"
               name="podTer"  form-name="blForm"  validation="required" friendly-name="Pod Term"   ></selectivity>	</td>
<td>
									<button ng-click="addinnerpckDtl(blpckDtl)" class="btn btn-info"
									tooltip="Add Row" type="button">
									<i class="fa fa-plus"></i>
								</button></i> </td>					
									
								</tr>
								<tr  >
									<td></td>
									<td colspan="15">
										<table class="table table-striped b-t b-light">
											<tr>
												<th class="width_2 text-center subTable-brs"> HSCode<span style="color: red;">*</span></th>
												<th class="width_8 text-center subTable-brs"> Package Type<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs"> No of Packages<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs"> GW<span style="color: red;">*</span></th>
												<th class="width_6 text-center subTable-brs">Goods</th>
												<th class="width_3 text-center subTable-brs">Action</th>
											</tr>
											<tr ng-repeat="($index, blpckinnerDtl) in blpckDtl.packageList track by $index">
												 
												<td class="subTable-brs text-center"><input class="form-control" type="text" name="hsCode" id="hsCode" ng-model="blpckinnerDtl.hsCode"  form-name="blForm" validation="required" friendly-name="HSCode"   placeholder="HSCode"></td>
												<td class="subTable-brs text-center">
    <selectivity list="packageList" property="blpckinnerDtl.packageType" id="packageType" ng-model="blpckinnerDtl.packageType"  name="packageType"     form-name="blForm" validation="required"  friendly-name="Package Type"></selectivity>	</td>
                
 												<td class="subTable-brs"><input class="form-control" type="text" name="noofPcks" id="noofPcks" ng-model="blpckinnerDtl.noofPcks" form-name="blForm" validation="required" friendly-name="No of Packages"    placeholder="No of Packages"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="gw_" id="gw_" ng-model="blpckinnerDtl.gw_"  form-name="blForm" validation="required" friendly-name="GW"   placeholder="GW"></td>
												<td class="subTable-brs"><input class="form-control" type="text" name="goods" id="goods" ng-model="blpckinnerDtl.goods"  placeholder="Goods"></td>
									
										<td class="subTable-brs"><button ng-click="deleteinnerpckDtl(blpckDtl,$index)"
									class="btn btn-sm btn-danger" type="button" tooltip="Delete">
									<i class="fa  fa-trash-o"></i>
								</button></td>
											</tr>
										</table>
									</td>
									
								</tr>
							</tbody>
						</table>
				  <button type="button" class="btn btn-sm btn-success" ng-click="addpckDtl()"><i class="fa fa-plus"></i></button>
									  <button type="button" class="btn btn-sm btn-danger" ng-click="removepckDtl(blNoData.blpckDtlList)"><i class="fa fa-minus"></i></button>
						
						<div class="padding-right-5">
							<div class="col-md-4">
								
								
							</div>
						</div>
					</div>
			
			</div>
			<br>
			 
	 
	</div>
	</div>
	</div>
	</tab> 
	<tab heading="Charges" style="background:#23225c">
 <div class="col-md-12">
	 <div class="table-responsive ">
	<div class="panel-body" style="width: 220%;">
		 
			<div class="row" id="items">
			
			 <div class="table-responsive clear">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
								<th colspan=1 class="width_1"></th>
									<th colspan=1 class="width_4">Seq<span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center">Charges Code<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Currency <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Qty <span style="color: red;">*</span></th>
									<th colspan=1 class="width_4 text-center"> Rate<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_4 text-center"> Amount<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> PayAt <span style="color: red;">*</span></th>
									<th colspan=1 class="width_6 text-center"> Terms<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> From Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> To Place<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Invoice Amount<span style="color: red;">*</span> </th>
									<th colspan=1 class="width_6 text-center"> Real Amount<span style="color: red;">*</span></th>
									  

								</tr>
							</thead>
							<tbody ng-repeat="(trIndex1, blCharge) in blNoData.blCharges">
								<tr>
					 <td><label class="i-checks m-b-none"> <input type="checkbox" ng-model="blCharge.select"><i></i></label></td>
					 
<td> <input class="form-control" type="text" name="seq" id="seq" ng-model="blCharge.seq"  form-name="blForm"  form-name="blForm" validation="required"  friendly-name="Sequence"></td>
					 <td class="text-center">
					  <selectivity list="surchargeList" property="blCharge.chargeCode" id="chargeCode" ng-model="blCharge.chargeCode"
               name="chargeCode"  form-name="blForm" validation="required"  friendly-name="Charge Code" ></td>
                 <td class="text-center">
    <selectivity list="currencyList" property="blCharge.currency" id="currency" ng-model="blCharge.currency"
               name="currency" form-name="blForm" validation="required"  friendly-name="Currency"  >	</td>
 									<td class="text-center"><input class="form-control" type="text" name="qty" id="qty" ng-model="blCharge.qty"      form-name="blForm" validation="required"  friendly-name="Qty"></td>
									<td class="text-center"><input class="form-control" type="text" name="rate" id="rate" ng-model="blCharge.rate"     form-name="blForm" validation="required"  friendly-name="Rate" ></td>
									<td class="text-center"><input class="form-control" type="text" name="amount" id="amount" ng-model="blCharge.amount"  form-name="blForm" validation="required"  friendly-name="Amount"  ></td>
									<td class="text-center">  <selectivity list="issuePlaceList" property="blCharge.payAt" id="payAt" ng-model="blCharge.payAt"
               name="payAt"  form-name="blForm" validation="required"  friendly-name="PayAt"  ></selectivity></td>
									<td class="text-center">  <selectivity list="termsOfPayment" property="blCharge.terms" id="terms" ng-model="blCharge.terms"
               name="terms" form-name="blForm" validation="required"
                friendly-name="Terms"></selectivity>      </td>
									<td class="text-center"><selectivity list="portlist" property="blCharge.fromPlace" id="fromPlace" ng-model="blCharge.fromPlace"
               name="fromPlace" form-name="blForm" validation="required"  friendly-name="From Place"  ></td>
									<td class="text-center"><selectivity list="portlist" property="blCharge.toPlace" id="toPlace" ng-model="blCharge.toPlace"
               name="toPlace" form-name="blForm" form-name="blForm" validation="required"  friendly-name="To Place" ></td>
										 <td class="text-center"><input class="form-control" type="text" name="invAmount" id="invAmount" ng-model="blCharge.invAmount"  form-name="blForm" validation="required"  friendly-name="Invoice Amount" ></td>
 									<td class="text-center"><input class="form-control" type="text" name="realAmount" id="realAmount" ng-model="blCharge.realAmount" form-name="blForm" validation="required"  friendly-name="Real Amount"></td>
									 
 			
									
								</tr>
								<tr  >
									<td></td>
								 
									
								</tr>
							</tbody>
						</table>
				  <button type="button" class="btn btn-sm btn-success" ng-click="addcharges()"><i class="fa fa-plus"></i></button>
									  <button type="button" class="btn btn-sm btn-danger" ng-click="removepckCharge(blNoData.blCharges)"><i class="fa fa-minus"></i></button>
						
						<div class="padding-right-5">
							<div class="col-md-4">
								
								
							</div>
						</div>
					</div>
			
			</div>
			<br>
			 
	 
	</div>
	</div>
	</div>
	</tab> 
	</tabset>
	<br>
      </div>
      
        </div>
      <br>
         <br>
      <div align="center">
          <div ng-if="!isEdit">
              <button  type="button" class="btn btn-success" ng-click="saveData(blForm)">Save</button>
              <button type="reset" class="btn btn-info">Reset</button>
              <button type="button" class="btn btn-danger" ng-click="cancel()">Cancel</button>
            </div> 
            <div ng-if="isEdit">
            <button  type="button" class="btn btn-success" ng-click="updateData(blForm)">Update</button>
            <button type="button" class="btn btn-info" ng-click="Reset()">Reset</button>
            <button type="button" class="btn btn-danger" ng-click="cancel()">Cancel</button>
         </div>
         <br>
		</div>

      </form>
      </div>
      </div>
</body>
</html>