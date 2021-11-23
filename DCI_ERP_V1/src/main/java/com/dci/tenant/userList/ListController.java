package com.dci.tenant.userList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;


@Controller
@RequestMapping(value = "{tenantid}/app/userList")
public class ListController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ListDaoImpl.class);

	@Autowired
	private ListService ListService;
	
	@RequestMapping("/searchlist")
	public @ResponseBody ListResultBean getList(@RequestBody ListBean invoicelist) throws CustomException, InterruptedException {
		ListResultBean resultBean = new ListResultBean();

	
			try {
				resultBean.setListBean(ListService.getList(invoicelist));
				resultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		
		return resultBean;
	}
//	@RequestMapping(value = "/invoicemovetodraft", method = RequestMethod.POST)
//	public @ResponseBody UserMasterResultBean invoicemovetodraft(@RequestBody ListBean invoiceDraft)
//			throws Exception {
//		UserMasterResultBean objUserMasterResultBean = new UserMasterResultBean();
//		boolean isSuccess=userMasterService.invoicemovetodraft(invoiceDraft) ;
//		objUserMasterResultBean.setSuccess(isSuccess);
//		return objUserMasterResultBean;
//	}
	
}
