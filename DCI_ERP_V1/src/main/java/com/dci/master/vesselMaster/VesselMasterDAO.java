package com.dci.master.vesselMaster;
import java.util.List;



public interface VesselMasterDAO {
public List<VesselMasterBean> getVesselList();
	
	public VesselMasterBean insert(VesselMasterBean vessel) throws Exception;

	public VesselMasterBean delete(Integer vesselID) throws Exception;
	
	public VesselMasterBean getVesselEdit(Integer vesselID);
	
	public VesselMasterBean update(VesselMasterBean vessel) throws Exception;

	public List<VesselMasterBean> getDropDown();
	
}

