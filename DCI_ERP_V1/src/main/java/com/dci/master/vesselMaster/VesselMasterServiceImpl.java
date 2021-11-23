package com.dci.master.vesselMaster;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class VesselMasterServiceImpl  implements VesselMasterService{
	
	@Autowired
	VesselMasterDAO vesselDAO;
	@Override
	public List<VesselMasterBean> getVesselList() {
		
		return vesselDAO.getVesselList();
	}
	
	@Override
	public VesselMasterBean insert(VesselMasterBean vessel) throws Exception {
		// TODO Auto-generated method stub
		return vesselDAO.insert(vessel);
	}
	
	@Override
	public VesselMasterBean delete(Integer vesselID) throws Exception {
		return vesselDAO.delete(vesselID);
	}

	@Override
	public VesselMasterBean getVesselEdit(Integer vesselID) {
		return vesselDAO.getVesselEdit(vesselID);
	}

	@Override
	public VesselMasterBean update(VesselMasterBean vessel) throws Exception {
		// TODO Auto-generated method stub
		return vesselDAO.update(vessel);
	}
	
	@Override
	public List<VesselMasterBean> getDropDown() {
		// TODO Auto-generated method stub
		return vesselDAO.getDropDown();
	}

}
