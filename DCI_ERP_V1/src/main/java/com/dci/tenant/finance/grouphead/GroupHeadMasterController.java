package com.dci.tenant.finance.grouphead;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

@Controller
@RequestMapping(value = "app/groupHeadMaster")
public class GroupHeadMasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(GroupHeadMasterController.class);

	@Autowired
	private GroupHeadMasterService groupHeadMasterService;

	@RequestMapping("/getList")
	public @ResponseBody
	GroupHeadMasterResultBean getGroupHeadMasterListBean(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException {
		GroupHeadMasterResultBean objGrpHeadMasterResultBean = new GroupHeadMasterResultBean();
		if (offset < 5000) {
			try {
				objGrpHeadMasterResultBean.setObjGrpHeadMasterBean(groupHeadMasterService.getGroupHeadMasterList(limit, offset));
				objGrpHeadMasterResultBean.setSuccess(true);
			} catch (Exception e) {
				LOGGER.error("Error", e);
				throw new CustomException();
			}
		}
		return objGrpHeadMasterResultBean;
	}
}
