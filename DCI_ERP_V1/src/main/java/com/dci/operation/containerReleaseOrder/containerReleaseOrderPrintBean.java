package com.dci.operation.containerReleaseOrder;


import java.util.List;

public class containerReleaseOrderPrintBean {
	
	private String address1;
	private String remarks;
	private String commodity;
	private String volume;
	private String finalDest;
	private String pol;
	private String pod;
	private String etd;
	private String closeDate;
	private String eta;
	private String vesselVoy;
	private String croNo;
	private String scnNo;
	private String destinationName;
	private String vessel;
	private String shipLine;
	private String bookingNo;
	private String tel;
	private String customerName;
	private String scnNO;
	private String terminal;
	private String confirmDate;
	private String eta1;
	private String cgoWt;
	private String depotAddress;
	private String destination;

	private String presentDate;
	private String refNo;
	private String  licd;

	private String dicd;
	private String shipperName;
	private String vesselName;
	private String voyageNo;
	private String conType;
	private String temp;
	private String units;
	private String ventilation;
	private String humidity;
	private String  container_release_hdr_code;
	private String  booking_no;
	private String  agent;
	private String  vesselname;
	private String voyage;

	private String  vendor_name_head;
	private String  vendor_name;
	private String  vendor_address;
	private String  vendor_address1;
	private String  vendor_off_tel_num;
	private String vendor_telex_num;
	private String  depot_agent_name;
	private String  depot_address;
	private String  depot_phone_number;
	private String  depot_fax_number;
	private String  containersummary;

	private String  cutoff_dt;
	
	private String  depot;
	private String  customer;
	private String  userid;
	private String createddt;

	private List<containerReleaseOrderPrintBean> containerDtl;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCreateddt() {
		return createddt;
	}
	public void setCreateddt(String createddt) {
		this.createddt = createddt;
	}
	public List<containerReleaseOrderPrintBean> getContainerDtl() {
		return containerDtl;
	}
	public void setContainerDtl(List<containerReleaseOrderPrintBean> containerDtl) {
		this.containerDtl = containerDtl;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepot() {
		return depot;
	}
	public void setDepot(String depot) {
		this.depot = depot;
	}
	public String getContainer_release_hdr_code() {
		return container_release_hdr_code;
	}
	public void setContainer_release_hdr_code(String container_release_hdr_code) {
		this.container_release_hdr_code = container_release_hdr_code;
	}
	public String getBooking_no() {
		return booking_no;
	}
	public void setBooking_no(String booking_no) {
		this.booking_no = booking_no;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getVesselname() {
		return vesselname;
	}
	public void setVesselname(String vesselname) {
		this.vesselname = vesselname;
	}
	public String getVoyage() {
		return voyage;
	}
	public void setVoyage(String voyage) {
		this.voyage = voyage;
	}
	public String getVendor_name_head() {
		return vendor_name_head;
	}
	public void setVendor_name_head(String vendor_name_head) {
		this.vendor_name_head = vendor_name_head;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getVendor_address() {
		return vendor_address;
	}
	public void setVendor_address(String vendor_address) {
		this.vendor_address = vendor_address;
	}
	public String getVendor_address1() {
		return vendor_address1;
	}
	public void setVendor_address1(String vendor_address1) {
		this.vendor_address1 = vendor_address1;
	}
	public String getVendor_off_tel_num() {
		return vendor_off_tel_num;
	}
	public void setVendor_off_tel_num(String vendor_off_tel_num) {
		this.vendor_off_tel_num = vendor_off_tel_num;
	}
	public String getVendor_telex_num() {
		return vendor_telex_num;
	}
	public void setVendor_telex_num(String vendor_telex_num) {
		this.vendor_telex_num = vendor_telex_num;
	}
	public String getDepot_agent_name() {
		return depot_agent_name;
	}
	public void setDepot_agent_name(String depot_agent_name) {
		this.depot_agent_name = depot_agent_name;
	}
	public String getDepot_address() {
		return depot_address;
	}
	public void setDepot_address(String depot_address) {
		this.depot_address = depot_address;
	}
	public String getDepot_phone_number() {
		return depot_phone_number;
	}
	public void setDepot_phone_number(String depot_phone_number) {
		this.depot_phone_number = depot_phone_number;
	}
	public String getDepot_fax_number() {
		return depot_fax_number;
	}
	public void setDepot_fax_number(String depot_fax_number) {
		this.depot_fax_number = depot_fax_number;
	}
	public String getContainersummary() {
		return containersummary;
	}
	public void setContainersummary(String containersummary) {
		this.containersummary = containersummary;
	}
	public String getCutoff_dt() {
		return cutoff_dt;
	}
	public void setCutoff_dt(String cutoff_dt) {
		this.cutoff_dt = cutoff_dt;
	}
	public String getPresentDate() {
		return presentDate;
	}
	public void setPresentDate(String presentDate) {
		this.presentDate = presentDate;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public String getLicd() {
		return licd;
	}
	public void setLicd(String licd) {
		this.licd = licd;
	}
	public String getDicd() {
		return dicd;
	}
	public void setDicd(String dicd) {
		this.dicd = dicd;
	}
	public String getShipperName() {
		return shipperName;
	}
	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getVoyageNo() {
		return voyageNo;
	}
	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}
	public String getConType() {
		return conType;
	}
	public void setConType(String conType) {
		this.conType = conType;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	public String getVentilation() {
		return ventilation;
	}
	public void setVentilation(String ventilation) {
		this.ventilation = ventilation;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getDepotAddress() {
		return depotAddress;
	}
	public void setDepotAddress(String depotAddress) {
		this.depotAddress = depotAddress;
	}
	public String getScnNO() {
		return scnNO;
	}
	public String getTerminal() {
		return terminal;
	}
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	public String getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}
	public String getEta1() {
		return eta1;
	}
	public void setEta1(String eta1) {
		this.eta1 = eta1;
	}
	public String getCgoWt() {
		return cgoWt;
	}
	public void setCgoWt(String cgoWt) {
		this.cgoWt = cgoWt;
	}
	public void setScnNO(String scnNO) {
		this.scnNO = scnNO;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCommodity() {
		return commodity;
	}
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getFinalDest() {
		return finalDest;
	}
	public void setFinalDest(String finalDest) {
		this.finalDest = finalDest;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getPod() {
		return pod;
	}
	public void setPod(String pod) {
		this.pod = pod;
	}
	public String getEtd() {
		return etd;
	}
	public void setEtd(String etd) {
		this.etd = etd;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getVesselVoy() {
		return vesselVoy;
	}
	public void setVesselVoy(String vesselVoy) {
		this.vesselVoy = vesselVoy;
	}
	public String getCroNo() {
		return croNo;
	}
	public void setCroNo(String croNo) {
		this.croNo = croNo;
	}
	public String getScnNo() {
		return scnNo;
	}
	public void setScnNo(String scnNo) {
		this.scnNo = scnNo;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getVessel() {
		return vessel;
	}
	public void setVessel(String vessel) {
		this.vessel = vessel;
	}
	public String getShipLine() {
		return shipLine;
	}
	public void setShipLine(String shipLine) {
		this.shipLine = shipLine;
	}
	public String getBookingNo() {
		return bookingNo;
	}
	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	



}

