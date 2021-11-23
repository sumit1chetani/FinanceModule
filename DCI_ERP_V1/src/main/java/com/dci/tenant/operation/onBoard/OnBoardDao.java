package com.dci.tenant.operation.onBoard;

import java.io.IOException;
import java.util.List;

import com.dci.common.model.SelectivityBean;


public interface OnBoardDao {

	List<SelectivityBean> getVesselList();
	
	List<SelectivityBean> getSlotList();

	List<SelectivityBean> getVoyageList(String vesselCode);

	List<SelectivityBean> getPortList(String voyage);

	OnBoardResultBean getContainerData(OnBoardBean onBoardBean);

	OnBoardResultBean save(OnBoardBean onBoardBean);

	List<OnBoardBean> getList();

	OnBoardResultBean delete(String onBoardNo);

	OnBoardBean getOnBoardDetails(String onBoardNo);

	List<SelectivityBean> getPort();
	
	OnBoardBean getOnBoardDetailsForMail(String onBoardNo);

	List<SelectivityBean> getbookList(String vesselCode);

	public String generateExcelReport(String onBoardID, String path, String number) throws IOException;

	List<OnBoardBean> getSearchList(OnBoardBean onBoardBean);

}
