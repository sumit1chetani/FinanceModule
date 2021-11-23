package com.dci.tenant.finance.grouphead;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GroupHeadMasterServiceImpl implements GroupHeadMasterService {

	@Autowired
	GroupHeadMasterDAO objGroupHeadMasterDAO;

	@Override
	public List<GroupHeadMasterListBean> getGroupHeadMasterList(int limit, int offset) throws Exception {
		// TODO Auto-generated method stub
		return objGroupHeadMasterDAO.getGroupHeadMasterList(limit, offset);
	}
}
