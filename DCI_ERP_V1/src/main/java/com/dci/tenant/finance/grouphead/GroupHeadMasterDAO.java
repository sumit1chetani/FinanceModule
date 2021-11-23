package com.dci.tenant.finance.grouphead;

import java.util.List;

public interface GroupHeadMasterDAO {

	public List<GroupHeadMasterListBean> getGroupHeadMasterList(int limit, int offset) throws Exception;

}
