package com.dci.tenant.finance.shiftmaster;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ShiftMasterService {

	public List<ShiftMasterBean> getShiftMasterList() throws Exception;

	public ShiftMasterBean getShiftMasterEditList(int shiftId) throws Exception;

	public boolean deleteShiftMaster(int shiftId) throws Exception;

	public boolean uploadFile(MultipartFile file);

	public void addShiftMaster(ShiftMasterBean objShiftMasterBean) throws Exception;

	public void updateShiftMaster(ShiftMasterBean objShiftMasterBean) throws Exception;
}
