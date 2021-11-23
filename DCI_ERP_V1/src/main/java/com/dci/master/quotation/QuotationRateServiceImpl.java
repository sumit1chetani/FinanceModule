package com.dci.master.quotation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dci.common.model.CommonUtilityBean;
import com.dci.common.model.SelectivityBean;
import com.dci.reports.quotationsummary.QuotationsummaryResultBean;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;
import com.dci.tenant.user.UserDetail;



@Service
public class QuotationRateServiceImpl implements QuotationRateService {

	@Autowired
	QuotationRateDao quotationDao;
	
	@Value("${file.upload.absolutePath}")
	private String getFilePropertyUrl;

	@Value("${file.upload.serverPath}")
	private String getFileServerPath;

	@Override
	public QuotationRateResultBean save(QuotationRateBean bean) {
		QuotationRateResultBean resultBean =quotationDao.save(bean);
		Email email = new Email();
		try{
	    bean.setQuotationNo(resultBean.getQuotNo());
		bean.setCustomer(resultBean.getCustomer());
		resultBean.getChargeList();
		
		email.setBodyHtml(generateEmailBody(bean,resultBean).toString());
 
		String from = "softwareadmin@fscontainer.com";
		/*String[] to = { "harshaparagon@gmail.com"};
		String[] bcc= { "harshaparagon@gmail.com"};*/
		String[] to = { "tsdesk@fscontainer.com"};
		String[] bcc = { "support@fscontainer.com" ,"sgopes@gmail.com"  };
		email.setFromEmailAddress(from);
		email.setToEmailAddress(to);
		email.setBccEmailAddress(bcc);
		
		email.setSubject("cordelia - Quotation - "+resultBean.getQuotNo()+"  has been submitted for approval.");
		if(resultBean.isSuccess() == true) {
		MailUtility.sendMail(email, "");
		String value ="Mail Sent";
		quotationDao.updateErrorLog(resultBean.getQuotNo(), value);
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
			quotationDao.updateErrorLog(resultBean.getQuotNo(), e.toString());
		}
		return resultBean;
	}

	public StringBuffer generateEmailBody(QuotationRateBean bean,QuotationRateResultBean resultBean){
		StringBuffer sbq = new StringBuffer();
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");  
		    Date date = new Date();  
		sbq.append("<html><body >");
		sbq.append("<TABLE align='center' border='0' bordercolor='#000000' cellpadding='0' cellspacing='0' width='100%'> "
				+ "<tr><td align='center' ><FONT face=Verdana size=2 color='Blue'><b>" + "The following quotation has been submitted for approval. </b></FONT></td></tr></TABLE><br> ");

		sbq.append("<TABLE align='center' border='1' bordercolor='#000000' cellpadding='0'	cellspacing='0' width='100%'>	"
				+ "<TR style='background-color: rgb(66, 165, 245);'>	"
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Quotation No</b></font></TD>"
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Customer</b></font></TD> "
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>POL</b></font></TD> "
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>POD</b></font></TD> "
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>Valid From</b></font></TD> " 
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>Valid Till</b></font></TD> "
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>Submitted By</b></font></TD> "
 				+ "</tr>");
		sbq.append("<tr " + "style='background-color: lightgray;' >");
		sbq.append("<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + bean.getQuotationNo() + "</font></TD>");
		sbq.append("<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" +  bean.getCustomer() + "</font></TD>");
		sbq.append("<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + bean.getPol() + "</font></TD>");
		sbq.append("<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + bean.getPod() + "</font></TD>");
		sbq.append("<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + bean.getQuotationDate() + "</font></TD>");
		sbq.append("<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + bean.getValidTill() + "</font></TD>");
		sbq.append("<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + userDetails.getUserId() +"-"+ userDetails.getUsername() + "</font></TD>");
 		sbq.append("</tr>");
		sbq.append("</table>");

	//	sbq.append( "<br><br>");
		
		sbq.append("<TABLE align='center' border='1' bordercolor='#000000' cellpadding='0'	cellspacing='0' width='100%'>	"
				+ "<TR style='background-color: rgb(66, 165, 245);'>	"
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Charge Type</b></font></TD>"
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Container Type</b></font></TD> "
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Currency</b></font></TD> "
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>Quoted Rate</b></font></TD> "
 				+ "</tr>");
		String trTag = "";
		int iCount = 1;
		for (QuotationRateBean objBean : resultBean.getChargeList()) {

			String sTrHtml = "<tr " + "style='background-color: lightgray;' >";
			sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" +objBean.getChargeName() + "</TD>";
			
			if(!objBean.getConType().equalsIgnoreCase(null) && !objBean.getConType().equalsIgnoreCase("")) {
				
				sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getConType() + "</TD>";
				
			}else {
				
				sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </TD>";
			}
			
              if(!objBean.getLocalCurrency().equalsIgnoreCase(null) && !objBean.getLocalCurrency().equalsIgnoreCase("")) {
				
            	  sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getLocalCurrency() + "</TD>";
				
			}else {
				
				sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </TD>";
			}
              
              if(objBean.getQuotedRate()!=null) {
            	  sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getQuotedRate() + "</TD>";
  				
  			}else {
  				
  				sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </TD>";
  			}
			
			sTrHtml += "</tr> ";

			trTag = trTag + sTrHtml;
		}
		sbq.append(trTag);
		sbq.append("</table>");
		
		
		
		sbq.append("<TABLE align='center' border='1' bordercolor='#000000' cellpadding='0'	cellspacing='0' width='100%'>	"
				+ "<TR style='background-color: rgb(66, 165, 245);'>	"
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Container Type</b></font></TD> "
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>POL Free Days</b></font></TD> "
				+ "<TD align='center' width='5%' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>POD Free Days</b></font></TD> "
 				+ "</tr>");
		String trTag1 = "";
		for (QuotationRateBean objBean1 : resultBean.getQuotationFreeDaysDtl()) {

			String sTrHtml1 = "<tr " + "style='background-color: lightgray;' >";
			if(!objBean1.getConType().equalsIgnoreCase(null) && !objBean1.getConType().equalsIgnoreCase("")) {
				sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean1.getConType() + "</TD>";
				
			}else {
				
				sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </TD>";
			}
			
			if(objBean1.getPolFreeDays()!=null) {
				sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean1.getPolFreeDays() + "</TD>";
				
			}else {
				
				sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </TD>";
			}
			
			if(objBean1.getPodFreeDays()!=null) {
				sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean1.getPodFreeDays() + "</TD>";
				
			}else {
				
				sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </TD>";
			}
			
			
			
			
			sTrHtml1 += "</tr> ";

			trTag1 = trTag1   + sTrHtml1;
		}
		sbq.append(trTag1);
		sbq.append("</table>");

		
		
		sbq.append("</table></body></html>");
		return sbq;
	}
	
	@Override
	public QuotationRateResultBean list() {
		return quotationDao.list();
	}
	
	@Override
	public QuotationRateResultBean ratelist() {
		return quotationDao.ratelist();
	}
	
	
	@Override
	public	 List<QuotationRateBean> listFilter(QuotationRateBean bean) {
		return quotationDao.listFilter(bean);
	}
	
	@Override
	public Integer getApprovalStatus(String quotationNo) {
		return quotationDao.getApprovalStatus(quotationNo);
	}
	
	@Override
	public QuotationRateResultBean listFilterApproval(QuotationRateBean bean) {
		return quotationDao.listFilterApproval(bean);
	}
	

	@Override
	public QuotationRateResultBean getShipment() {
		// System.out.println("inside");
		return quotationDao.getShipment();
	}
	@Override
	public QuotationRateResultBean getShipmentTariff(String isVendor,String userPortStr) {
		// System.out.println("inside");
		return quotationDao.getShipmentTariff(isVendor,userPortStr);
	}
	@Override
	public QuotationRateResultBean edit(String quotHdId) {
		return quotationDao.edit(quotHdId);
	}
	@Override
	public QuotationRateResultBean view(Integer quotHdId) {
		return quotationDao.view(quotHdId);
	}
	
	@Override
	public QuotationRateResultBean getCustomerDetail(String quotHdId) {
		return quotationDao.getCustomerDetail(quotHdId);
	}
	
	@Override
	public QuotationRateResultBean update(QuotationRateBean bean){
		return quotationDao.update(bean);
	}

	@Override
	public QuotationRateResultBean delete(String QuotHdId) {
		return quotationDao.delete(QuotHdId);
	}
	@Override
	public QuotationRateResultBean approve(QuotationRateBean bean) {
		return quotationDao.approve( bean);
	}
	
	
	@Override
	public QuotationRateResultBean mobapprove(QuotationRateBean bean) {
		return quotationDao.mobapprove( bean);
	}
	
	@Override
	public QuotationRateResultBean reject(String quotation) {
		return quotationDao.reject(quotation);
	}
	
	
	@Override
	public QuotationRateResultBean reject(QuotationRateBean bean) {
		return quotationDao.reject(bean);
	}
	
	@Override
	public QuotationRateResultBean mobreject(QuotationRateBean bean) {
		return quotationDao.mobreject(bean);
	}
	
	@Override
	public List<CommonUtilityBean> getiataList() {
		return quotationDao.getiataList();
	}
	@Override
	public List<CommonUtilityBean> getCurrencyList() {
		return quotationDao.getCurrencyList();
	}
	
	@Override
	public List<CommonUtilityBean> getServicePartner() {
		return quotationDao.getServicePartner();
	}
	@Override
	public List<CommonUtilityBean> getBranch() {
		return quotationDao.getBranch();
	}
	
	@Override
	public void insertFiles(String quotationNumber, String filename, String path) {
		quotationDao.insertFiles(quotationNumber,filename,path);
		
	}

	
	@Override
	public List<CommonUtilityBean> getServicePartnerType() {
		// TODO Auto-generated method stub
		return quotationDao.getServicePartnerType();
	}
	

	@Override
	public List<CommonUtilityBean> getEmployeeList() {
		// TODO Auto-generated method stub
		return quotationDao.getEmployeeList();
	}

	@Override
	public List<CommonUtilityBean> getChargeHeads() {
		// TODO Auto-generated method stub
		return quotationDao.getChargeHeads();
	}

	@Override
	public List<CommonUtilityBean> getTerms() {
		// TODO Auto-generated method stub
		return quotationDao.getTerms();
	}

	@Override
	public List<CommonUtilityBean> getUnitList() {
		// TODO Auto-generated method stub
		return quotationDao.getUnitList();
	}

	@Override
	public QuotationRateBean print(Integer quotationHdId) {
		// TODO Auto-generated method stub
		return quotationDao.print(quotationHdId);
	}

	@Override
	public QuotationRateResultBean saveasDraft(QuotationRateBean bean) {
		// TODO Auto-generated method stub
		return quotationDao.saveasDraft(bean);
	}
	
	
	@Override
	public List<CommonUtilityBean> getuomList() {
		// TODO Auto-generated method stub
		return quotationDao.getuomList();
	}

	@Override
	public List<String> getFileNameList(Integer quotationHdId) {
		// TODO Auto-generated method stub
		return quotationDao.getFileNameList(quotationHdId);
	}
	
	@Override
	public void updateFiles(String quotationNo, List<String> check, String filepath,
			List<String> filepaths) {
		// TODO Auto-generated method stub
		 quotationDao.updateFiles(quotationNo, check, filepath,filepaths);
	}

	@Override
	public QuotationRateResultBean getServicePartnerDropdownList() {
		// TODO Auto-generated method stub
		return quotationDao.getServicePartnerDropdownList();
	}
	
	@Override
	public QuotationRateResultBean getServicePartnerDropdownListid(String id) {
		// TODO Auto-generated method stub
		return quotationDao.getServicePartnerDropdownListid(id);
	}

	@Override
	public List<CommonUtilityBean> getcommodity() {
		// TODO Auto-generated method stub
		return quotationDao.getcommodity();
	}
	@Override
	public QuotationRateResultBean DownloadFile(String quotationNo) {
		return quotationDao.downloadfile(quotationNo);
	}
	
	@Override
	public boolean uploaddelete(String quotationNo) {
		// TODO Auto-generated method stub
		return quotationDao.uploaddelete(quotationNo);
	}
	
	@Override
	public boolean deletefiles(String fileName) {
		// TODO Auto-generated method stub
		return quotationDao.deletefiles(fileName);
	}
	
	@Override
	public QuotationRateResultBean getCustomerList() {
		// TODO Auto-generated method stub
		return quotationDao.getCustomerList();
	}
	
	@Override
	public QuotationRateResultBean getCustomerListCompany(String company) {
		// TODO Auto-generated method stub
		return quotationDao.getCustomerListCompany(company);
	}



	@Override
	public List<QuotationRateBean> getChargeList(String pol,String pod,String chargeType,String conType,String hazardous,String oog) {
		// TODO Auto-generated method stub
		return quotationDao.getChargeList(pol, pod,chargeType,conType,hazardous,oog);
	}

	@Override
	public List<QuotationRateBean> getdefaultchargeList(String pol,String crnyName) {
		// TODO Auto-generated method stub
		return quotationDao.getdefaultchargeList(pol,crnyName);
	}

	@Override
	public void excellExport(
			QuotationRateResultBean objQuotationsummaryResultBean,
			QuotationRateBean objQuotationsummaryBean, String pdfFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SelectivityBean> getCustomereditDropdown(String quoteNo) {
		// TODO Auto-generated method stub
		return quotationDao.getCustomereditDropdown(quoteNo);
	}
	
	@Override
	public QuotationsummaryResultBean checkQuoteExists(String pol, String pod,String customer,String special,String cargoType) {
		// TODO Auto-generated method stub
		return quotationDao.checkQuoteExists(pol,pod,customer,special,cargoType);
	}

	@Override
	public QuotationRateResultBean saveNewQuotation(QuotationRateBean bean) {
 		
		QuotationRateResultBean resultBean =  quotationDao.saveNewQuotation(bean);
		Email email = new Email();
		try{
	    bean.setQuotationNo(resultBean.getQuotNo());
		bean.setCustomer(resultBean.getCustomer());
		resultBean.getChargeList();
		
		email.setBodyHtml(generateEmailBody(bean,resultBean).toString());
 
		String from = "softwareadmin@fscontainer.com";
		/*String[] to = { "harshaparagon@gmail.com"};
		String[] bcc= { "harshaparagon@gmail.com"};*/
		String[] to = { "tsdesk@fscontainer.com"};
		String[] bcc = { "support@fscontainer.com" ,"sgopes@gmail.com"  };
		email.setFromEmailAddress(from);
		email.setToEmailAddress(to);
		email.setBccEmailAddress(bcc);
		
		email.setSubject("cordelia - Quotation - "+resultBean.getQuotNo()+"  has been submitted for approval.");
		if(resultBean.isSuccess() == true) {
		MailUtility.sendMail(email, "");
		String value ="Mail Sent";
		quotationDao.updateErrorLog(resultBean.getQuotNo(), value);
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
			quotationDao.updateErrorLog(resultBean.getQuotNo(), e.toString());
		}
		return resultBean;
	
	}

	@Override
	public QuotationRateResultBean saveQuotationDtl(QuotationRateBean bean) {
		// TODO Auto-generated method stub
		return quotationDao.saveQuotationDtl(bean);
	}

	@Override
	public QuotationRateBean print(String quotationNo) {
		// TODO Auto-generated method stub
		return quotationDao.print(quotationNo);
	}
	
	@Override
	public QuotationRateResultBean saveRateCharges(QuotationRateBean bean){
		return quotationDao.saveRateCharges(bean);
	}
	@Override
	public QuotationRateResultBean savereview(QuotationRateBean bean) {
		// TODO Auto-generated method stub
		return quotationDao.savereview(bean);
	}
	
	@Override
	public QuotationRateBean getmrgRate(String mlo, String quotatiopodnNo, String pol, String conType) {
		// TODO Auto-generated method stub
		return quotationDao.getmrgRate(mlo, quotatiopodnNo, pol, conType);
	}
	@Override
	public QuotationRateBean gettariffRate(String mlo, String quotatiopodnNo, String pol, String conType) {
		// TODO Auto-generated method stub
		return quotationDao.gettariffRate(mlo, quotatiopodnNo, pol, conType);
	}

}
