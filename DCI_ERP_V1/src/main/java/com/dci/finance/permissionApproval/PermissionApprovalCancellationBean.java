package com.dci.finance.permissionApproval;

public class PermissionApprovalCancellationBean {

	private String requestedby;
	private String permissiondate;
	private String requesteddate;
	private String reason;
	private String fromtime;
	private String totime;
	private String status;
	private String remarks;
	private String permissionrequestid;
	private boolean isEdit;
	private boolean success;

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getPermissionrequestid() {
		return permissionrequestid;
	}

	public void setPermissionrequestid(String permissionrequestid) {
		this.permissionrequestid = permissionrequestid;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotime() {
		return totime;
	}

	public void setTotime(String totime) {
		this.totime = totime;
	}

	public String getFromtime() {
		return fromtime;
	}

	public void setFromtime(String fromtime) {
		this.fromtime = fromtime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRequesteddate() {
		return requesteddate;
	}

	public void setRequesteddate(String requesteddate) {
		this.requesteddate = requesteddate;
	}

	public String getPermissiondate() {
		return permissiondate;
	}

	public void setPermissiondate(String permissiondate) {
		this.permissiondate = permissiondate;
	}

	public String getRequestedby() {
		return requestedby;
	}

	public void setRequestedby(String requestedby) {
		this.requestedby = requestedby;
	}

}
