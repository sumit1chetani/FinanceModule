package com.dci.tenant.userList;

import java.util.List;

public interface ListDao {
	List<ListBean> getList(ListBean invoicelist) throws Exception;

}
