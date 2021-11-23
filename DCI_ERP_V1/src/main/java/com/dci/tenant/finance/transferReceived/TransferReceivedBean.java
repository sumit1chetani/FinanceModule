package com.dci.tenant.finance.transferReceived;

import java.util.ArrayList;
import java.util.List;

import com.dci.common.util.CommonUtillityAssetTrackDetailBean;

public class TransferReceivedBean {

	private int id;
	private String text;
	private int receivedId;
	private String receivedNo;
	private int transferId;
	private String transferNo;
	private String receivedDate;
	private String receivedNote;
	private String receivedByCode;
	private String receivedByName;
	private int stockTransferId;
	private int itemId;

	/* To Show Stock/Consignment/Asset Transer Details */

	private int destLocId;
	private String destLocName;
	private int sourceLocId;
	private String sourceLocName;
	private String requestedBy;
	private String requestedDate;
	private String transferDate;
	private int transferType;
	private String companyId;
	private String companyName;

	private ArrayList<CommonUtillityAssetTrackDetailBean> commonTrackList = null;

	private String formName;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	private List<TransferReceivedDetailBean> transferDtls;

	public List<TransferReceivedDetailBean> getTransferDtls() {
		return transferDtls;
	}

	public void setTransferDtls(List<TransferReceivedDetailBean> transferDtls) {
		this.transferDtls = transferDtls;
	}

	public int getTransferType() {
		return transferType;
	}

	public void setTransferType(int transferType) {
		this.transferType = transferType;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getReceivedId() {
		return receivedId;
	}

	public void setReceivedId(int receivedId) {
		this.receivedId = receivedId;
	}

	public String getReceivedNo() {
		return receivedNo;
	}

	public void setReceivedNo(String receivedNo) {
		this.receivedNo = receivedNo;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getReceivedNote() {
		return receivedNote;
	}

	public void setReceivedNote(String receivedNote) {
		this.receivedNote = receivedNote;
	}

	public String getReceivedByCode() {
		return receivedByCode;
	}

	public void setReceivedByCode(String receivedByCode) {
		this.receivedByCode = receivedByCode;
	}

	public String getReceivedByName() {
		return receivedByName;
	}

	public void setReceivedByName(String receivedByName) {
		this.receivedByName = receivedByName;
	}

	public int getDestLocId() {
		return destLocId;
	}

	public void setDestLocId(int destLocId) {
		this.destLocId = destLocId;
	}

	public String getDestLocName() {
		return destLocName;
	}

	public void setDestLocName(String destLocName) {
		this.destLocName = destLocName;
	}

	public int getSourceLocId() {
		return sourceLocId;
	}

	public void setSourceLocId(int sourceLocId) {
		this.sourceLocId = sourceLocId;
	}

	public String getSourceLocName() {
		return sourceLocName;
	}

	public void setSourceLocName(String sourceLocName) {
		this.sourceLocName = sourceLocName;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getTransferNo() {
		return transferNo;
	}

	public void setTransferNo(String transferNo) {
		this.transferNo = transferNo;
	}

	public ArrayList<CommonUtillityAssetTrackDetailBean> getCommonTrackList() {
		return commonTrackList;
	}

	public void setCommonTrackList(ArrayList<CommonUtillityAssetTrackDetailBean> commonTrackList) {
		this.commonTrackList = commonTrackList;
	}

	/**
	 * @return the stockTransferId
	 */
	public int getStockTransferId() {
		return stockTransferId;
	}

	/**
	 * @param stockTransferId the stockTransferId to set
	 */
	public void setStockTransferId(int stockTransferId) {
		this.stockTransferId = stockTransferId;
	}

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
