package com.dci.tenant.operation.onBoard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.BasicResultBean;


@SuppressWarnings("serial")
public class OnBoardResultBean extends BasicResultBean implements Serializable {

	private List<SelectivityBean> vesselList = new ArrayList<SelectivityBean>();
	private List<SelectivityBean> voyageList = new ArrayList<SelectivityBean>();
	private List<SelectivityBean> portList = new ArrayList<SelectivityBean>();
	private List<SelectivityBean> slotList = new ArrayList<SelectivityBean>();
	private List<OnBoardBean> onBoardBeanList;
	private List<OnBoardBean> UnAllocatedList;
	private List<OnBoardBean> contList;
	
	private String bookingNo;
	private String pol;
	private String containerNo;
	private String onBoardNo;

	private String fileName;
	private String filePath;
	
	
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOnBoardNo() {
		return onBoardNo;
	}

	public void setOnBoardNo(String onBoardNo) {
		this.onBoardNo = onBoardNo;
	}

	public List<SelectivityBean> getSlotList() {
		return slotList;
	}

	public void setSlotList(List<SelectivityBean> slotList) {
		this.slotList = slotList;
	}

	public List<OnBoardBean> getOnBoardBeanList() {
		return onBoardBeanList;
	}

	public void setOnBoardBeanList(List<OnBoardBean> onBoardBeanList) {
		this.onBoardBeanList = onBoardBeanList;
	}

	public List<SelectivityBean> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<SelectivityBean> vesselList) {
		this.vesselList = vesselList;
	}

	public List<SelectivityBean> getVoyageList() {
		return voyageList;
	}

	public void setVoyageList(List<SelectivityBean> voyageList) {
		this.voyageList = voyageList;
	}

	public List<SelectivityBean> getPortList() {
		return portList;
	}

	public void setPortList(List<SelectivityBean> portList) {
		this.portList = portList;
	}

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getContainerNo() {
		return containerNo;
	}

	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}

	public List<OnBoardBean> getUnAllocatedList() {
		return UnAllocatedList;
	}

	public void setUnAllocatedList(List<OnBoardBean> unAllocatedList) {
		UnAllocatedList = unAllocatedList;
	}

	public List<OnBoardBean> getContList() {
		return contList;
	}

	public void setContList(List<OnBoardBean> contList) {
		this.contList = contList;
	}

 

}
