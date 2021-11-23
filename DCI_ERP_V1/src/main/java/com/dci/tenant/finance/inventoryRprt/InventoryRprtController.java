package com.dci.tenant.finance.inventoryRprt;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping(value = "app/inventoryRprt")
public class InventoryRprtController {
	private final static Logger LOGGER = LoggerFactory.getLogger(InventoryRprtController.class);

	@Autowired
	private InventoryRprtService inventoryRprtService;

	@RequestMapping("/inventroyList")
	public @ResponseBody InventroyRprtListBean getInventoryMasterList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean.setInventoryMasterList(inventoryRprtService.getInventoryMasterList(limit, offset));
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping("/inventroyNewList")
	public @ResponseBody InventroyRprtListBean getInventoryNewMasterList(@RequestParam("limit") int limit, @RequestParam("offset") int offset) throws CustomException, InterruptedException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean.setInventoryMasterList(inventoryRprtService.getInventoryNewMasterList(limit, offset));
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping("/inventroyNewSubList")
	public @ResponseBody InventroyRprtListBean getInventroyNewSubList(@RequestParam("item") int item, @RequestParam("invDate") String invDate) throws CustomException, InterruptedException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean.setInventorySubList(inventoryRprtService.getInventroyNewSubList(item, invDate));
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping("/inventroySubList")
	public @ResponseBody InventroyRprtListBean getInventroySubList(@RequestParam("item") int item, @RequestParam("location") int location, @RequestParam("invDate") String invDate) throws CustomException, InterruptedException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean.setInventorySubList(inventoryRprtService.getInventroySubList(item, location, invDate));
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping("/getSubGridBatchDetails")
	public @ResponseBody InventroyRprtListBean getSubGridBatchDetails(@RequestParam("ledgerId") int ledgerId) throws CustomException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean.setInventoryBatchList(inventoryRprtService.getSubGridBatchDetails(ledgerId));
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping("/getDropDowns")
	public @ResponseBody InventroyRprtListBean getDropDowns() throws CustomException, InterruptedException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean = inventoryRprtService.getDropDowns();
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping("/inventroyListWithParam")
	public @ResponseBody InventroyRprtListBean getInventroyListWithParam(@RequestParam("itm") int item, @RequestParam("location") int location, @RequestParam("stockon") String stockon) throws CustomException, InterruptedException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean.setInventoryMasterList(inventoryRprtService.getInventroyListWithParam(item, location, stockon));
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping("/inventroyNewListWithParam")
	public @ResponseBody InventroyRprtListBean getInventroyNewListWithParam(@RequestParam("item") String item, @RequestParam("location") String location, @RequestParam("fromdate") String fromdate, @RequestParam("todate") String todate, @RequestParam("category") String category) throws CustomException, InterruptedException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean.setInventoryMasterList(inventoryRprtService.getInventroyNewListWithParam(item, location, fromdate, todate, category));
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping("/invlistBelowROL")
	public @ResponseBody InventroyRprtListBean getinvlistBelowROL() throws CustomException {
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();
		try {
			objInventroyRprtListBean.setInventoryMasterList(inventoryRprtService.getinvlistBelowROL());
			objInventroyRprtListBean.setSuccess(true);
		} catch (Exception e) {
			LOGGER.error("Error", e);
			throw new CustomException();
		}
		return objInventroyRprtListBean;
	}

	@RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
	public @ResponseBody boolean exportTransactionLevelExcel(@RequestBody InventoryRprtBean obj, HttpServletRequest request, HttpServletResponse response) {
		List<InventoryRprtBean> rsList = new ArrayList<>();
		InventroyRprtListBean objInventroyRprtListBean = new InventroyRprtListBean();

		boolean isSuccess = false;
		try {
			objInventroyRprtListBean.setInventoryMasterList(inventoryRprtService.getInventroyNewListExport(obj.getItem(), obj.getLocation(), obj.getFomdate(), obj.getTodate(), obj.getCategoryid()));
			String sFilePath = request.getServletContext().getRealPath("tempdoc");

			isSuccess = inventoryRprtService.exportExcel(sFilePath, objInventroyRprtListBean.getInventoryMasterList());
		} catch (Exception e) {
			LOGGER.error("Error", e);
		}
		return isSuccess;
	}
}
