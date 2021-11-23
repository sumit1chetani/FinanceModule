package com.dci.tenant.finance.shiftschememaster;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ShiftSchemeMasterDAO {

	public List<ShiftSchemeMasterBean> getShiftSchemeMasterList() throws Exception;

	public ShiftSchemeMasterResultBean getShiftNameList(ShiftSchemeMasterBean shiftSchemeMasterBean) throws Exception;

	public boolean deleteShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception;

	public ShiftSchemeMasterBean getShiftSchemeMasterEditList(String schemeName) throws Exception;

	public void updateShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception;

	public ArrayList getShiftSchemeMasterWeekList(String schemeName) throws Exception;

	public boolean uploadFile(MultipartFile file);

	public void addShiftSchemeMaster(ShiftSchemeMasterBean objShiftSchemeMasterBean) throws Exception;

}
