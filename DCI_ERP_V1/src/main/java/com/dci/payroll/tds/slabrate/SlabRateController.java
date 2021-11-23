package com.dci.payroll.tds.slabrate;
/*
 * package com.mailapp.payroll.tds.slabrate;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.mailapp.core.util.CustomException;
 * 
 * @RestController
 * 
 * @RequestMapping(value = "payroll/tds/slabrate") public class
 * SlabRateController { private final static Logger LOGGER =
 * LoggerFactory.getLogger(SlabRateController.class);
 * 
 * @Autowired SlabRateService slabRateService;
 * 
 * @RequestMapping(value = "/list") public SlabRateResultBean getSlabRateList()
 * { SlabRateResultBean slabRateResultBean = new SlabRateResultBean(); try {
 * slabRateResultBean.setSlabRateList(slabRateService.getSlabRateList()); }
 * catch (Exception e) { e.printStackTrace(); } return slabRateResultBean; }
 * 
 * @RequestMapping(value = "/payertypelist") public SlabRateResultBean
 * getPayerTypeList() { SlabRateResultBean slabRateResultBean = new
 * SlabRateResultBean(); try {
 * slabRateResultBean.setPayerTypeList(slabRateService.getTaxPayerTypeList()); }
 * catch (Exception e) { e.printStackTrace(); } return slabRateResultBean; }
 * 
 * @RequestMapping(value = "/edit") public SlabRateResultBean
 * getSlabRateListbyId(@RequestBody int taxRateId) { SlabRateResultBean
 * slabRateResultBean = new SlabRateResultBean(); try {
 * slabRateResultBean.setSlabRate(slabRateService.getSlabRateListById(taxRateId)
 * ); } catch (Exception e) { e.printStackTrace(); } return slabRateResultBean;
 * }
 * 
 * @RequestMapping(value = "/save") public boolean save(@RequestBody
 * SlabRateBean slabRateBean) { // SlabRateResultBean slabRateResultBean = new
 * SlabRateResultBean(); boolean isSuccess = false; try {
 * 
 * isSuccess = slabRateService.insertSlabRate(slabRateBean);
 * 
 * } catch (Exception e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }
 * 
 * return isSuccess;
 * 
 * }
 * 
 * @RequestMapping(value = "/update") public boolean update(@RequestBody
 * SlabRateBean slabRateBean) { SlabRateResultBean slabRateResultBean = new
 * SlabRateResultBean(); boolean isSuccess = false; try { isSuccess =
 * slabRateService.updateSlabRate(slabRateBean); } catch (CustomException e) {
 * slabRateResultBean.setSuccess(false);
 * slabRateResultBean.setMessage(e.getCustomMessage()); } catch (Exception e) {
 * // TODO Auto-generated catch block e.printStackTrace(); } return isSuccess; }
 * 
 * @RequestMapping(value = "/delete") public boolean delete(@RequestBody int
 * taxRateId) { boolean isDeleted = false; try { isDeleted =
 * slabRateService.deleteSlabRate(taxRateId); } catch (Exception e) {
 * e.printStackTrace(); } return isDeleted;
 * 
 * }
 * 
 * }
 */