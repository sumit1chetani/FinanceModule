
<div class="wrapper-md">

	<div class="panel panel-default panel-default-form ">
		<%@include file="/views/templates/panel-header-form.jsp"%>
		<div class="panel-body">
			<form novalidate name="revenuecompForm" method="POST"
				class="form-horizontal">
				<div style="overflow: scroll; max-height: 700px;">
					<table class="table table-bordered table-striped">
						<tr>

							<th colspan=1 rowspan=2 class="text-center">VESSEL</th>
							<th colspan=1 rowspan=2 class="text-center">VOYAGE</th>
							<th colspan=1 rowspan=2 class="text-center">POL</th>
							<th colspan=1 rowspan=2 class="text-center">POD</th>
							<th colspan=1 rowspan=2 class=" text-center">MLO</th>
							<th colspan=1 rowspan=2 class=" text-center">SLOT</th>
							<th colspan=1 rowspan=2 class=" text-center">SUB SLOT</th>
							<th colspan=1 rowspan=2 class=" text-center">SAILING DATE</th>
							<th colspan=1 rowspan=2 class=" text-center">M20</th>
							<th colspan=1 rowspan=2 class=" text-center">M40</th>
							<th colspan=1 rowspan=2 class=" text-center">M45</th>
							<th colspan=1 rowspan=2 class=" text-center">D20</th>
							<th colspan=1 rowspan=2 class=" text-center">D40</th>
							<th colspan=1 rowspan=2 class=" text-center">D45</th>
							<th colspan=1 rowspan=2 class=" text-center">R20</th>
							<th rowspan=2 class=" text-center">R40</th>
							<th rowspan=2 class=" text-center">OOG20</th>
							<th rowspan=2 class=" text-center">OOG40</th>
							<th rowspan=2 class=" text-center">RI20</th>
							<th rowspan=2 class=" text-center">RI40</th>
							<th colspan=3 class=" text-center">TOTAL</th>
							<th rowspan=2 class=" text-center">WT</th>
							<th rowspan=2 class=" text-center">B/L NO</th>
							<th rowspan=2 class=" text-center">REMARKS</th>
							<th rowspan=2 class=" text-center">INVOICE STATUS</th>
							<th rowspan=2 class=" text-center">BILLING REMARKS</th>
							<th rowspan=2 class=" text-center">SPECIAL</th>
							<th rowspan=2 class=" text-center">BILLING TERMS</th>
							<th rowspan=2 class=" text-center">SHIPMENT</th>

						</tr>
						<tr>
							<th colspan=1 class=" text-center">20's</th>
							<th colspan=1 class=" text-center">40's</th>
							<th colspan=1 class=" text-center">Teus</th>
						</tr>
						<tbody ng-repeat="(trIndex, row) in rowCollection">

							<tr>

								<td colspan=1 class=" text-center"><span
									ng-if="rowCollection[$index].vessel != rowCollection[$index-1].vessel ">{{row.vessel}}</span></td>
								<td colspan=1 class=" text-center"><span
									ng-if="rowCollection[$index].voyage != rowCollection[$index-1].voyage ">{{row.voyage}}</span></td>
								<td colspan=1 class=" text-center"><span
									ng-if="rowCollection[$index].pol != rowCollection[$index-1].pol ">{{row.pol}}</span></td>
								<td colspan=1 class=" text-center"><span
									ng-if="rowCollection[$index].pod != rowCollection[$index-1].pod ">{{row.pod}}</span></td>
								<td colspan=1 class="  text-center">{{row.mlo}}</td>
								<td colspan=1 class="  text-center">{{row.slotAc}}</td>
								<td colspan=1 class="  text-center">{{row.subslot}}</td>
								<td colspan=1 class=" text-center">{{row.sailingDate}}</td>
								<td colspan=1 class="text-center">{{row.m20}}</td>
								<td colspan=1 class="text-center">{{row.m40}}</td>
								<td colspan=1 class="text-center">{{row.m45}}</td>
								<td colspan=1 class="text-center">{{row.d20}}</td>
								<td colspan=1 class="text-center">{{row.d40}}</td>
								<td colspan=1 class="text-center">{{row.d45}}</td>
								<td colspan=1 class="text-center">{{row.r20}}</td>
								<td colspan=1 class="text-center">{{row.r40}}</td>
								<td colspan=1 class="text-center">{{row.oog20}}</td>
								<td colspan=1 class="text-center">{{row.oog40}}</td>
								<td colspan=1 class="text-center">{{row.ri20}}</td>
								<td colspan=1 class="text-center">{{row.ri40}}</td>
								<td colspan=1 class="text-center">{{row.twenty}}</td>
								<td colspan=1 class="text-center">{{row.forty}}</td>
								<td colspan=1 class="text-center">{{row.totalTeus}}</td>
								<td colspan=1 class="text-center">{{row.weight}}</td>
								<td colspan=1 class="text-center">{{row.blno}}</td>
								<td colspan=1 class="text-center">{{row.remarks}}</td>

								<td colspan=1 class="text-center">{{row.invoiceType}}</td>
								<td colspan=1 class="text-center">{{row.bilRemarks}}</td>
								
								<td colspan=1 class="text-center">{{row.special}}</td>
								<td colspan=1 class="text-center">{{row.billTerm}}</td>
								<td colspan=1 class="text-center">{{row.shipment}}</td>
								
							</tr>
							<tr
								ng-if="rowCollection[$index].pod != rowCollection[$index+1].pod ">
								<td colspan=7 class=" text-center"><b>TOTAL FOR
										{{rowCollection[$index].pol}} to {{rowCollection[$index].pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'m20':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'m40':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'m45':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'d20':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'d40':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'d45':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'r20':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'r40':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'oog20':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'oog40':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'ri20':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'ri40':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'twenty':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'forty':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'totalTeus':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"><b>{{rowCollection|sumBySTKey:'weight':row.pol:row.pod}}</b></td>
								<td colspan=1 class=" text-center"></td>
								<td colspan=1 class=" text-center"></td>

								<td colspan=1 class="width_10 text-center"></td>
								<td colspan=1 class="width_10 text-center"></td>
							
							</tr>

						</tbody>
						<tr>
							<td colspan=8 class=" text-center"><b>Grand Total</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'m20'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'m40'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'m45'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'d20'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'d40'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'d45'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'r20'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'r40'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'oog20'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'oog40'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'ri20'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'ri40'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'twenty'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'forty'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'totalTeus'}}</b></td>
							<td colspan=1 class=" text-center"><b>{{rowCollection|sumByKey:'weight'}}</b></td>
							<td colspan=1 class=" text-center"></td>
							<td colspan=1 class=" text-center"></td>

							<td colspan=1 class="width_10 text-center"></td>
							<td colspan=1 class="width_10 text-center"></td>
						
						</tr>
					</table>
					
				</div>
				<br>
				<div class="row book-widget-row">
				
				
					<div class="col-sm-12 col-md-12 col-lg-12 text-center">
			     <button id="exportXl" class="btn btn-success"
              data-ng-click="excel(rowCollection);"
               type="button">
           <i class="fa fa-print"></i> Export Excel
          </button>
							<button class="btn btn-info" type="button" tooltip="Close"
								ng-click="cancel()">
								Cancel
							</button>
							</div>
				</div>
			</form>
		</div>

	</div>
</div>
