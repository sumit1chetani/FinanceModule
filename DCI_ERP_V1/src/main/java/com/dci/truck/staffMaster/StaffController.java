package com.dci.truck.staffMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;

//import com.mbk.tenant.finance.transaction.cashflowledger.CashflowBean;
//import com.mbk.tenant.finance.transaction.cashflowledger.CashflowResultBean;

@Controller
@RequestMapping(value = "{tenantid}/staff")
public class StaffController {
	
	@Autowired
	StaffService staffservice;

	
	@RequestMapping(value = "/employeelist")
	public @ResponseBody StaffResultBean getemployeelist() {
		StaffResultBean StaffResultBean = new StaffResultBean();
		try {
			StaffResultBean = staffservice.getemployeelist();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return StaffResultBean;
	}
 
	@RequestMapping("/save")
	public @ResponseBody StaffBean save(@RequestBody StaffBean  bean) throws CustomException {

		StaffBean staffbean=new StaffBean();
		try {

			

			staffbean = staffservice.save(bean);

		} catch (Exception e) {
			throw new CustomException();
		}

		return staffbean;

	}
	
	@RequestMapping("/list")
	public @ResponseBody StaffResultBean  list() throws CustomException {

		StaffResultBean ResultBean;
		 
		try {

			ResultBean = new StaffResultBean();

			ResultBean.setList(staffservice.getList());

		} catch (Exception e) {
			throw new CustomException();
		}

		return ResultBean;

	}
	
	@RequestMapping("/delete")
	public @ResponseBody boolean deleteStaff(@RequestBody String staffId) throws Exception {
		boolean isDeleted = false;

		try{
		isDeleted = staffservice.deleteStaff(staffId);

		} catch (Exception e)
		{
			e.printStackTrace();
			throw new CustomException();
		}
		return isDeleted;
	}
}
