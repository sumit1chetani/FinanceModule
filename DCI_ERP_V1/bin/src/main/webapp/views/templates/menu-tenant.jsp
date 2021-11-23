<script src="../../js/vendor/smartmenu/jquery.smartmenus.bootstrap.js"></script>
<!-- buttons -->
<ul class="nav navbar-nav navbar-nav-custom" ng-show="leftMenuBar"
	style="width: 76%">
	<!-- <li><a href="javascript:" ui-sref="organization.show"
			title="Company List"><i class="fa fa-university"></i>Organization
		</a></li> -->
	<li><a href="javascript:"
		ui-sref="company.show({tenantid:tenantId})" title="Master"><i
			class="fa fa-fw fa-user"></i> Master </a>
		<ul class="dropdown-menu">
			<li><a href="" title="Company"
				ui-sref="company.show({tenantid:tenantId})"> <!--  <i
						class="fa fa-fw fa-tachometer"></i> --> <span
					style="font-family: Open Sans;"> Company</span>
			</a></li>
			<li><a href="" title="Container Type"
				ui-sref="containerType.list({tenantid:tenantId})"> <!--  <i
						class="fa fa-fw fa-tachometer"></i> --> <span
					style="font-family: Open Sans;"> Container Type</span>
			</a></li>
			<li><a href="" title="User"
				ui-sref="user.list({tenantid:tenantId})"><span
					style="font-family: Open Sans;">User</span></a></li>
			<li><a href="javascript:" title="Truck"
				ui-sref="truck.list({tenantid:tenantId})"> <i></i> <span
					style="font-family: Open Sans;">Truck</span>
			</a></li>
			<li><a href="javascript:" title="Driver"
				ui-sref="driver.list({tenantid:tenantId})"> <i></i> <span
					style="font-family: Open Sans;">Driver</span>
			</a></li>
			<li><a href="javascript:" title="Customer Master"
				ui-sref="customer.list({tenantid:tenantId})"> <i></i> <span
					style="font-family: Open Sans;">Customer</span>
			</a></li>
			<li><a href="" title="Manage Stopping"
				ui-sref="stopping.list({tenantid:tenantId})"><span
					style="font-family: Open Sans;">Stopping</span></a></li>
			<li><a href="" title="Movement Status"
				ui-sref="movement.list({tenantid:tenantId})"><span
					style="font-family: Open Sans;">Movement Status</span></a></li>
		</ul></li>
	<li><a href="javascript:" title="Operation"><i
			class="fa fa-wrench"></i> <span style="font-family: Open Sans;">Operation</span>
	</a>
		<ul class="dropdown-menu">
			<li><a href="" title="Manage Route"
				ui-sref="route.list({tenantid:tenantId})"><span
					style="font-family: Open Sans;">Route</span></a></li>
			<li><a href="" title="Manage Trip"
				ui-sref="trip.list({tenantid:tenantId})"><span
					style="font-family: Open Sans;">Trip</span></a></li>
		</ul></li>
	<li><a href="javascript:" title="Admin"><i
			class="fa fa-user-md"></i> <span style="font-family: Open Sans;">Admin
		</span></a>
		<ul class="dropdown-menu">
			<li><a href="" title="User Rights"><span
					style="font-family: Open Sans;">User Rights</span></a></li>
			<li><a href="" title="User Log"><span
					style="font-family: Open Sans;">User Log</span></a></li>
		</ul></li>
	<li><a href="javascript:" title="Sales"><i
			class="fa fa-credit-card"></i> <span style="font-family: Open Sans;">Sales</span>
	</a>
		<ul class="dropdown-menu">
			<li><a href="" title="Booking"><span
					style="font-family: Open Sans;">Booking</span></a></li>
			<li><a href="" title="Quotation"><span
					style="font-family: Open Sans;">Quotation</span></a></li>
		</ul></li>
	<li><a href="javascript:" title="Finance"><i
			class="fa fa-star-half-empty"></i> <span
			style="font-family: Open Sans;">Finance</span> </a>
		<ul class="dropdown-menu">
			<li><a href="" title="Invoice"><span
					style="font-family: Open Sans;">Invoice</span></a> <i
				class="icon icon-caret-right"></i>
				<ul class="dropdown-menu">
				</ul></li>
			<li><a href="" title="Control Screen"><span
					style="font-family: Open Sans;">Control Screen</span></a> <i
				class="icon icon-caret-right"></i>
				<ul class="dropdown-menu">
					<li><a href="" title="Account Head"><span
							style="font-family: Open Sans;">Account Head</span></a></li>
					<li><a href="" title="Exchange Rate"><span
							style="font-family: Open Sans;">Exchange Rate</span></a></li>
					<li><a href="" title="Sub-Group Accounts"><span
							style="font-family: Open Sans;">Sub-Group Accounts</span></a></li>
					<!--    <li class="divider"></li> -->
					<li><a href="" title="Chart Of Accounts"><span
							style="font-family: Open Sans;">Chart Of Accounts</span></a></li>
				</ul></li>
			<li><a href="" title="Transaction"><span
					style="font-family: Open Sans;">Transaction</span></a> <i
				class="icon icon-caret-right"></i>
				<ul class="dropdown-menu">
					<li><a href="" title="Credit Note"><span
							style="font-family: Open Sans;">Credit Note</span></a></li>
					<li><a href="" title="Journal Voucher"><span
							style="font-family: Open Sans;">Journal Voucher</span></a></li>
					<li><a href="" title="Debit Note"><span
							style="font-family: Open Sans;">Debit Note</span></a></li>
					<!--    <li class="divider"></li> -->
					<li><a href="" title="Cash Bank Payments"><span
							style="font-family: Open Sans;">Cash Bank Payments</span></a></li>
					<li><a href="" title="Cash Bank Receipts"><span
							style="font-family: Open Sans;">Cash Bank Receipts</span></a></li>
					<li><a href="" title="Payment Order"><span
							style="font-family: Open Sans;">Payment Order</span></a></li>
					<li><a href="" title="Payment Information"><span
							style="font-family: Open Sans;">Payment Information</span></a></li>
				</ul></li>


		</ul></li>


	<li><a href="javascript:" title="Reports"><i
			class="fa fa-book"></i> <span style="font-family: Open Sans;">Reports</span>
	</a>
		<ul class="dropdown-menu">
			<li><a href="" title="Trial Balance"><span
					style="font-family: Open Sans;">Trial Balance</span></a></li>
			<li><a href="" title="Profit & Loss"><span
					style="font-family: Open Sans;">Profit & Loss</span></a></li>
			<li><a href="" title="Balance Sheet"><span
					style="font-family: Open Sans;">Balance Sheet</span></a></li>
			<!--    <li class="divider"></li> -->
			<li><a href="" title="General Ledger"><span
					style="font-family: Open Sans;">General Ledger</span></a></li>
			<li><a href="" title="Receivable-Agewise"><span
					style="font-family: Open Sans;">Receivable-Agewise</span></a></li>
			<li><a href="" title="Payable-Agewise"><span
					style="font-family: Open Sans;">Payable-Agewise</span></a></li>
			<li><a href="" title="SOA Customer As On Date"><span
					style="font-family: Open Sans;">SOA Customer As On Date</span></a></li>
			<li><a href="" title="Account Settled Invoices"><span
					style="font-family: Open Sans;">Account Settled Invoices</span></a></li>
			<li><a href="" title="Account Settled Invoices Payable"><span
					style="font-family: Open Sans;">Account Settled Invoices
						Payable</span></a></li>
		</ul></li>
</ul>
