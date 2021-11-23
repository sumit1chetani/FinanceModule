package  com.dci.finance.shiftallocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dci.common.util.CustomException;


@Controller
@RequestMapping(value = "{tenantid}/hr/shiftAllocation")
public class ShiftAllocationController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ShiftAllocationController.class);

	@Autowired
	private ShiftAllocationService shiftAllocationService;

	@RequestMapping(value = "/list")
	public @ResponseBody ShiftAllocationResultBean getShiftAllocationList() {
		ShiftAllocationResultBean shiftAllocationBean = new ShiftAllocationResultBean();
		try {

			shiftAllocationBean.setShiftAllocationList(shiftAllocationService.getShiftAllocationList());
			shiftAllocationBean.setSuccess(true);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shiftAllocationBean;
	}

	@RequestMapping(value = "/getBranchList")
	public @ResponseBody ShiftAllocationResultBean getBranchList(@RequestBody String companyId) {
		ShiftAllocationResultBean objshiftAllocationResultBean = new ShiftAllocationResultBean();
		try {
			objshiftAllocationResultBean = shiftAllocationService.getBranchList(companyId);
			objshiftAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objshiftAllocationResultBean;
	}

	@RequestMapping(value = "/getSchemeList")
	public @ResponseBody ShiftAllocationResultBean getSchemeList(@RequestBody ShiftAllocationBean shiftAllocationBean) {
		ShiftAllocationResultBean objshiftAllocationResultBean = new ShiftAllocationResultBean();
		try {
			objshiftAllocationResultBean = shiftAllocationService.getSchemeList(shiftAllocationBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objshiftAllocationResultBean;
	}

	@RequestMapping(value = "/getShiftList")
	public @ResponseBody ShiftAllocationResultBean getShiftList() {
		ShiftAllocationResultBean objshiftAllocationResultBean = new ShiftAllocationResultBean();
		try {
			objshiftAllocationResultBean = shiftAllocationService.getShiftList();
			objshiftAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objshiftAllocationResultBean;
	}

	@RequestMapping(value = "/getDepartmentList")
	public @ResponseBody ShiftAllocationResultBean getDepartmentList(@RequestBody String branchId) {
		ShiftAllocationResultBean objshiftAllocationResultBean = new ShiftAllocationResultBean();
		try {
			objshiftAllocationResultBean = shiftAllocationService.getDepartmentList(branchId);
			objshiftAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objshiftAllocationResultBean;
	}

	@RequestMapping(value = "/getEmployeeList")
	public @ResponseBody ShiftAllocationResultBean getEmployeeList(@RequestBody ShiftAllocationBean bean) {
		ShiftAllocationResultBean objshiftAllocationResultBean = new ShiftAllocationResultBean();
		try {
			objshiftAllocationResultBean = shiftAllocationService.getEmployeeList(bean);
			objshiftAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objshiftAllocationResultBean;
	}

	@RequestMapping(value = "/getDateList")
	public @ResponseBody ShiftAllocationResultBean getDateList(@RequestBody String schemeName) {
		ShiftAllocationResultBean objshiftAllocationResultBean = new ShiftAllocationResultBean();
		try {
			objshiftAllocationResultBean = shiftAllocationService.getDateList(schemeName);
			objshiftAllocationResultBean.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objshiftAllocationResultBean;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody ShiftAllocationBean addShiftAllocation(@RequestBody ShiftAllocationBean objShiftAllocationBean) throws CustomException {
		ShiftAllocationBean objAllocationBean = new ShiftAllocationBean();
		ShiftAllocationResultBean objShiftAllocationResultBean = new ShiftAllocationResultBean();
		try {

			objAllocationBean = shiftAllocationService.addShiftAllocation(objShiftAllocationBean);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return objAllocationBean;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody boolean updateShiftAllocation(@RequestBody ShiftAllocationBean objShiftAllocationBean) throws CustomException {
		boolean isSuccess = false;
		ShiftAllocationResultBean objShiftAllocationResultBean = new ShiftAllocationResultBean();
		try {

			isSuccess = shiftAllocationService.updateShiftAllocation(objShiftAllocationBean);
			objShiftAllocationResultBean.setSuccess(isSuccess);

		} catch (Exception e) {
			LOGGER.error("Error", e);

			throw new CustomException();
		}

		return isSuccess;
	}

	@RequestMapping("/delete")
	public @ResponseBody boolean deleteShiftAllocation(@RequestParam("schemeId") int schemeId, @RequestParam("employeeId") String employeeId, @RequestParam("validFrom") String validFrom, @RequestParam String validTo) throws Exception {
		boolean isDeleted = false;
		isDeleted = shiftAllocationService.deleteShiftAllocation(schemeId, employeeId, validFrom, validTo);
		return isDeleted;
	}

	@RequestMapping("/getShiftAllocationEditList")
	public @ResponseBody ShiftAllocationBean getShiftAllocationEditList(@RequestParam("schemeId") int schemeId, @RequestParam("employeeId") String employeeId, @RequestParam("validFrom") String validFrom, @RequestParam("validTo") String validTo) throws Exception {
		ShiftAllocationBean objShiftAllocationBean = new ShiftAllocationBean();
		objShiftAllocationBean = shiftAllocationService.getShiftAllocationEditList(schemeId, employeeId, validFrom, validTo);
		return objShiftAllocationBean;
	}

}
