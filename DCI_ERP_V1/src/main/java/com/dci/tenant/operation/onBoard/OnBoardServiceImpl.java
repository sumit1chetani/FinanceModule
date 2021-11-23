package com.dci.tenant.operation.onBoard;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dci.common.model.SelectivityBean;
import com.dci.tenant.common.Email;
import com.dci.tenant.common.MailUtility;


@Service
public class OnBoardServiceImpl implements OnBoardService {

	@Autowired
	OnBoardDao onBoardDao;

	@Override
	public List<SelectivityBean> getVesselList() {
		return onBoardDao.getVesselList();
	}
	
	@Override
	public List<SelectivityBean> getSlotList() {
		return onBoardDao.getSlotList();
	}
	
	@Override
	public List<SelectivityBean> getPort() {
		return onBoardDao.getPort();
	}

	@Override
	public List<SelectivityBean> getVoyageList(String vesselCode) {
		return onBoardDao.getVoyageList(vesselCode);
	}

	@Override
	public List<SelectivityBean> getPortList(String voyage) {
		return onBoardDao.getPortList(voyage);
	}

	@Override
	public OnBoardResultBean getContainerData(OnBoardBean onBoardBean) {
		return onBoardDao.getContainerData(onBoardBean);
	}

	/*@Override
	public OnBoardResultBean save(OnBoardBean onBoardBean) {
		
		OnBoardResultBean rbean = new OnBoardResultBean();
		
		rbean =  onBoardDao.save(onBoardBean);
		
		if(rbean.isSuccess() == true) {
			
			if(rbean.getOnBoardBeanList().size() > 0) {

			String logoImage = "http://213.42.28.72:8082/img/csl.png";
			Email email = new Email();
			String from = "team@cordelialine.com";
			String[] to = {"sreevalsan@cordelialine.com","Eransha@cordelialine.com","afnan@cordelialine.com","vaishakh@cordelialine.com"};
			//String[] bcc = {"kamalbharathy@paragondynamics.in","muthu@paragondynamics.in","balaje@paragondynamics.in"};
			String[] cc = {"support@cordelialine.com"};
 			
			    email.setBodyHtml(generateEmailBodyForBookingTypeCSLTS(rbean,logoImage).toString());
				email.setSubject("Cordelia - CSL T/S Shipped OnBoard  has been confirmed");
				email.setFromEmailAddress(from);
				email.setToEmailAddress(to);
				email.setToEmailAddress(cc);
	 			//email.setBccEmailAddress(bcc);
				
				//sendMailThread(email);
		}
		}
		
		//new customer mail
		
		OnBoardBean onBoardDataBean = new OnBoardBean();
		
		UserDetail userDetails = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(rbean.isSuccess() == true) {
			
			onBoardDataBean=onBoardDao.getOnBoardDetailsForMail(rbean.getOnBoardNo());
			
			for (OnBoardBean beanDtl : onBoardDataBean.getDetailList()) {
			try {
			Email sendalertmail = new Email();
			StringBuffer st = new StringBuffer();
			StringBuffer sb = new StringBuffer();
			String logoImage = "http://213.42.28.72:8082/img/csl.png";

			st.append("<html><body>");
			
			st.append("<b>"+beanDtl.getCustomerName()+"</b>");
			st.append("<br><br>");
			
			st.append("\n\n\n\n Dear Sirs,<br>");
			st.append("<br>");
			st.append("We thank you for the opportunity given to us to be your carrier for the above shipment.");
			st.append("<br><br>");
			st.append("We are pleased to inform you that your containers have been Shipped On Board on <b>"+beanDtl.getOnBoardDate()+"</b> at the <b>"+beanDtl.getPort()+"</b> and more details below.");
			st.append("<br><br>");
			st.append(
					"<TABLE align='center' border='1' bordercolor='#000000' cellpadding='5' cellspacing='0' width='100%' >"
							+ "<TR style='background-color: #353b64;'>"
							+ "<TD align='center' width='10%' height='22' ><FONT face=Verdana size=2 color=ffffff><b>Vessel</b></font></TD>"
							+ "<TD align='center' width='10%' height='22' ><FONT face=Verdana size=2 color=ffffff><b>Voyage</b></font></TD>"
							+ "<TD align='center' width='10%' height='22' ><FONT face=Verdana size=2 color=ffffff><b>POL</b></font></TD>"
							+ "<TD align='center' width='10%' height='22' ><FONT face=Verdana size=2 color=ffffff><b>POD</b></font></TD>"
							+ "<TD align='center' width='30%' height='22' ><FONT face=Verdana size=2 color=ffffff><b>BL Number</b></font></TD>"
							+ "<TD align='center' width='30%' height='22' ><FONT face=Verdana size=2 color=ffffff><b>Booking Number</b></font></TD>"
					);

			sb.append("<html><body>");

			
				st.append("<TR><TD align='center'> <FONT face=Verdana size=2>"
						+ beanDtl.getVessel()+ "</font></TD>"
						+ "<TD align='center'> <FONT face=Verdana size=2>"
						+ beanDtl.getVoyage()+ "</font></TD>"
						+ "<TD align='center'> <FONT face=Verdana size=2>"
						+ beanDtl.getPort()+ "</font></TD>"
						+ "<TD align='center'> <FONT face=Verdana size=2>"
						+ beanDtl.getPod()+ "</font></TD>"
						+ "<TD align='center'> <FONT face=Verdana size=2>"
						+ beanDtl.getBlNo()+ "</font></TD>"	
						+ "<TD align='center'> <FONT face=Verdana size=2>"
						+ beanDtl.getBookingNo()+ "</font></TD>"	

				);

			st.append("</table><br>");
			
            st.append("<br>");
			
			st.append(
					"<TABLE border='1' bordercolor='#000000' cellpadding='0' cellspacing='0' width='50%' >"
							+ "<TR style='background-color: #353b64;'>"
							+ "<TD align='center' width='10%' height='22' ><FONT face=Verdana size=2 color=ffffff><b>Container Details</b></font></TD>"
					);

			sb.append("<html><body>");
			
			          String[] container =beanDtl.getContainerNo().split(",");
					 
					  for (int i = 0; i < container.length; i++) { 
						String containerSplit = container[i].trim();
					  
				     st.append("<TR><TD align='center' height='22'> <FONT face=Verdana size=2>" + containerSplit
						+ "</font></TD>");

					  }

			st.append("</table><br>");
			
			st.append("We thank you for choosing us as your shipping partner, and look forward to be of service to you soon.");
			st.append("<br><br>");
			st.append("If you would like to receive further updates such as date of which delivery taken by the consignee, please let us know.");

			st.append("<br><br><b>Warm kind regards, </b><br><b> Team Cordelia </b>");
			st.append("<br><br>");
			st.append("<img style='width:86px;height:33px;' src=" + logoImage + ">");
			st.append("</body></html>");
			sendalertmail.setSubject("CORDELIA - Shipped On Board Notification : "+ "\n\n"+beanDtl.getVoyage()+ "\n\n"+beanDtl.getPort()+ " -\n\n"+beanDtl.getOnBoardDate());
			String toIds = "";
			String assignedEamilId = userDetails.getEmail().trim();
			
			if (beanDtl.getCustomerMail() != null && !beanDtl.getCustomerMail().isEmpty()) {
				toIds = assignedEamilId + "," +beanDtl.getCustomerMail().trim();
			} else {
				toIds = assignedEamilId;
			}
			
			
			//String[] to = { "balaje@paragondynamics.in" };
			
			String[] to = toIds.trim().split(",");

			String[] bcc = { "sgopes@gmail.com", "balaje@paragondynamics.in"};

			String[] cc = { "support@cordelialine.com" };

			sendalertmail.setFromEmailAddress("team@cordelialine.com");
			sendalertmail.setCcEmailAddress(cc);
			sendalertmail.setToEmailAddress(to);
			sendalertmail.setBccEmailAddress(bcc);
			sendalertmail.setBodyHtml(st.toString());

			
			MailUtility.sendMailCordelia(sendalertmail, "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			
		}
		

      return rbean;
		
	}*/
	
	public StringBuffer generateEmailBodyForBookingTypeCSLTS(OnBoardResultBean bean,String logoImage) {
		StringBuffer sbq = new StringBuffer();
 
		sbq.append("<html> "
				+ "<head> "
				+ "<style> "
				+ "@page "
				+ "{	size: auto; "
				+ "	margin: 5mm; "
				+ "} "
				+ " "
				+ "#table2, td, th "
				+ "{	border: 1px solid #ddd; "
				+ "	text-align: left; "
				+ "} "
				+ " "
				+ "#table2 "
				+ "{	border-collapse: collapse; "
				+ "	width: 100%; "
				+ "} "
				+ " "
				+ "th, td "
				+ "{	/* padding: 15px; */ "
				+ "	 "
				+ "} "
				+ " "
				+ ".width_auto "
				+ "{	width: auto; "
				+ "} "
				+ " "
				+ ".width_10px "
				+ "{	width: 10px; "
				+ "} "
				+ " "
				+ ".width_05 "
				+ "{	width: 0.50%; "
				+ "} "
				+ " "
				+ ".width_1 "
				+ "{	width: 1%; "
				+ "} "
				+ " "
				+ ".width_2 "
				+ "{	width: 2%; "
				+ "} "
				+ " "
				+ ".width_3 "
				+ "{	width: 3%; "
				+ "} "
				+ " "
				+ ".width_4 "
				+ "{	width: 4%; "
				+ "} "
				+ " "
				+ ".width_5 "
				+ "{	width: 5%; "
				+ "} "
				+ " "
				+ ".width_6 "
				+ "{	width: 6%; "
				+ "} "
				+ " "
				+ ".width_7 "
				+ "{	width: 7%; "
				+ "} "
				+ " "
				+ ".width_8 "
				+ "{	width: 8%; "
				+ "} "
				+ " "
				+ ".width_9 "
				+ "{	width: 9%; "
				+ "} "
				+ " "
				+ ".width_10 "
				+ "{	width: 10%; "
				+ "} "
				+ " "
				+ ".width_11 "
				+ "{	width: 11%; "
				+ "} "
				+ " "
				+ ".width_12 "
				+ "{	width: 12%; "
				+ "} "
				+ " "
				+ ".width_13 "
				+ "{	width: 13%; "
				+ "} "
				+ " "
				+ ".width_14 "
				+ "{	width: 14%; "
				+ "} "
				+ " "
				+ ".width_15 "
				+ "{	width: 15%; "
				+ "} "
				+ " "
				+ ".width_16 "
				+ "{	width: 16%; "
				+ "} "
				+ " "
				+ ".width_17 "
				+ "{	width: 17%; "
				+ "} "
				+ " "
				+ ".width_18 "
				+ "{	width: 18%; "
				+ "} "
				+ " "
				+ ".width_19 "
				+ "{	width: 19%; "
				+ "} "
				+ " "
				+ ".width_20 "
				+ "{	width: 20%; "
				+ "} "
				+ " "
				+ ".width_21 "
				+ "{	width: 21%; "
				+ "} "
				+ " "
				+ ".width_22 "
				+ "{	width: 22%; "
				+ "} "
				+ " "
				+ ".width_23 "
				+ "{	width: 23%; "
				+ "} "
				+ " "
				+ ".width_24 "
				+ "{	width: 24%; "
				+ "} "
				+ " "
				+ ".width_25 "
				+ "{	width: 25%; "
				+ "} "
				+ " "
				+ ".width_26 "
				+ "{	width: 26%; "
				+ "} "
				+ " "
				+ ".width_27 "
				+ "{	width: 27%; "
				+ "} "
				+ " "
				+ ".width_28 "
				+ "{	width: 28%; "
				+ "} "
				+ " "
				+ ".width_29 "
				+ "{	width: 29%; "
				+ "} "
				+ " "
				+ ".width_30 "
				+ "{	width: 30%; "
				+ "} "
				+ " "
				+ ".width_31 "
				+ "{	width: 31%; "
				+ "} "
				+ " "
				+ ".width_32 "
				+ "{	width: 32%; "
				+ "} "
				+ " "
				+ ".width_33 "
				+ "{	width: 33%; "
				+ "} "
				+ " "
				+ ".width_34 "
				+ "{	width: 34%; "
				+ "} "
				+ " "
				+ ".width_35 "
				+ "{	width: 35%; "
				+ "} "
				+ " "
				+ ".width_36 "
				+ "{	width: 36%; "
				+ "} "
				+ " "
				+ ".width_37 "
				+ "{	width: 37%; "
				+ "} "
				+ " "
				+ ".width_38 "
				+ "{	width: 38%; "
				+ "} "
				+ " "
				+ ".width_39 "
				+ "{	width: 39%; "
				+ "} "
				+ " "
				+ ".width_40 "
				+ "{	width: 40%; "
				+ "} "
				+ " "
				+ ".width_41 "
				+ "{	width: 41%; "
				+ "} "
				+ " "
				+ ".width_42 "
				+ "{	width: 42%; "
				+ "} "
				+ " "
				+ ".width_43 "
				+ "{	width: 43%; "
				+ "} "
				+ " "
				+ ".width_44 "
				+ "{	width: 44%; "
				+ "} "
				+ " "
				+ ".width_45 "
				+ "{	width: 45%; "
				+ "} "
				+ " "
				+ ".width_46 "
				+ "{	width: 46%; "
				+ "} "
				+ " "
				+ ".width_47 "
				+ "{	width: 47%; "
				+ "} "
				+ " "
				+ ".width_48 "
				+ "{	width: 48%; "
				+ "} "
				+ " "
				+ ".width_49 "
				+ "{	width: 49%; "
				+ "} "
				+ " "
				+ ".width_50 "
				+ "{	width: 50%; "
				+ "} "
				+ " "
				+ ".width_51 "
				+ "{	width: 51%; "
				+ "} "
				+ " "
				+ ".width_52 "
				+ "{	width: 52%; "
				+ "} "
				+ " "
				+ ".width_53 "
				+ "{	width: 53%; "
				+ "} "
				+ " "
				+ ".width_54 "
				+ "{	width: 54%; "
				+ "} "
				+ " "
				+ ".width_55 "
				+ "{	width: 55%; "
				+ "} "
				+ " "
				+ ".width_56 "
				+ "{	width: 56%; "
				+ "} "
				+ " "
				+ ".width_57 "
				+ "{	width: 57%; "
				+ "} "
				+ " "
				+ ".width_58 "
				+ "{	width: 58%; "
				+ "} "
				+ " "
				+ ".width_59 "
				+ "{	width: 59%; "
				+ "} "
				+ " "
				+ ".width_60 "
				+ "{	width: 60%; "
				+ "} "
				+ " "
				+ ".width_61 "
				+ "{	width: 61%; "
				+ "} "
				+ " "
				+ ".width_62 "
				+ "{	width: 62%; "
				+ "} "
				+ " "
				+ ".width_63 "
				+ "{	width: 63%; "
				+ "} "
				+ " "
				+ ".width_64 "
				+ "{	width: 64%; "
				+ "} "
				+ " "
				+ ".width_65 "
				+ "{	width: 65%; "
				+ "} "
				+ " "
				+ ".width_66 "
				+ "{	width: 66%; "
				+ "} "
				+ " "
				+ ".width_67 "
				+ "{	width: 67%; "
				+ "} "
				+ " "
				+ ".width_68 "
				+ "{	width: 68%; "
				+ "} "
				+ " "
				+ ".width_69 "
				+ "{	width: 69%; "
				+ "} "
				+ " "
				+ ".width_70 "
				+ "{	width: 70%; "
				+ "} "
				+ " "
				+ ".width_71 "
				+ "{	width: 71%; "
				+ "} "
				+ " "
				+ ".width_72 "
				+ "{	width: 72%; "
				+ "} "
				+ " "
				+ ".width_73 "
				+ "{	width: 73%; "
				+ "} "
				+ " "
				+ ".width_74 "
				+ "{	width: 74%; "
				+ "} "
				+ " "
				+ ".width_75 "
				+ "{	width: 75%; "
				+ "} "
				+ " "
				+ ".width_76 "
				+ "{	width: 76%; "
				+ "} "
				+ " "
				+ ".width_77 "
				+ "{	width: 77%; "
				+ "} "
				+ " "
				+ ".width_78 "
				+ "{	width: 78%; "
				+ "} "
				+ " "
				+ ".width_79 "
				+ "{	width: 79%; "
				+ "} "
				+ " "
				+ ".width_80 "
				+ "{	width: 80%; "
				+ "} "
				+ " "
				+ ".width_81 "
				+ "{	width: 81%; "
				+ "} "
				+ " "
				+ ".width_82 "
				+ "{	width: 82%; "
				+ "} "
				+ " "
				+ ".width_83 "
				+ "{	width: 83%; "
				+ "} "
				+ " "
				+ ".width_84 "
				+ "{	width: 84%; "
				+ "} "
				+ " "
				+ ".width_85 "
				+ "{	width: 85%; "
				+ "} "
				+ " "
				+ ".width_100 "
				+ "{	width: 100%; "
				+ "} "
				+ " "
				+ ".no_border "
				+ "{	border: 0px; "
				+ "} "
				+ "</style> "
				+ " "
				+ "<style type='text/css' media='print'> "
				+ "html, body "
				+ "{	margin: 0; "
				+ "	padding: 0; "
				+ "	border: 1px solid; "
				+ "} "
				+ "/* body { height: 11in;  width: 8.5in; } */ "
				+ "a[href]:after "
				+ "{	content: ' (' attr(href) ')'; "
				+ "} "
				+ " "
				+ "#footer "
				+ " "
				+ "{	display: table-footer-group; "
				+ "	width: 100%; "
				+ "	position: absolute; "
				+ "	/* bottom:3px; */ "
				+ "} "
				+ " "
				+ "#content "
				+ "{	margin-bottom: 4px; "
				+ "} "
				+ " "
				+ "@page "
				+ "{	size: A4; "
				+ "	margin: 2mm; "
				+ "} "
				+ "</style> "
				+ "<style type='text/css'> "
				+ ".chngTdCls>tbody>tr>td "
				+ "{	padding: 5px 0px !important; "
				+ "} "
				+ "</style> "
				+ "</head> "
				+ " "
				+ "<body style='border: 1px solid'> "
				+ "</body> "
				+ "</html>");
		
		sbq.append("<html><body >");
		sbq.append("<TABLE align='center' border='0' bordercolor='#000000' cellpadding='0' cellspacing='0' width='100%'> "
				+ "<tr><td align='center' style='padding-left: 34%; '><FONT face=Verdana size=2 color='NAVY'><b> The below T/S BLs are loaded. </b></FONT></td></tr></TABLE><br> ");

		sbq.append("<TABLE align='center' border='1' bordercolor='#000000' cellpadding='0'	cellspacing='0' width='100%'>" + 
				"<TR style='background-color: rgb(0, 45 ,109);'> " + 
				"<TD align='center' width='5%' style='color:white'  height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>BL No</b></font></TD>" + 
				"<TD align='center' width='5%' style='color:white'  height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Ex-Vessel</b></font></TD>  " + 
				"<TD align='center' width='5%' style='color:white'  height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Ex-Voyage</b></font></TD>  " + 
				"<TD align='center' width='5%' style='color:white' height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>POL</b></font></TD>  " + 
				"<TD align='center' width='5%' style='color:white' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>POT</b></font></TD>  " + 
				"<TD align='center' width='5%' style='color:white' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>FPOD</b></font></TD>  " + 
				"<TD align='center' width='5%' style='color:white' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>ETA at POT</b></font></TD>  " + 
				"<TD align='center' width='5%' style='color:white' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>Connecting Vessel</b></font></TD>  " + 
				"<TD align='center' width='5%' style='color:white' height='22' style='padding-left: 5px;padding-right: 5px;'><FONT face=Verdana size=2><b>Connecting Voyage</b></font></TD>  " + 
				"</tr>");
		
		
		String trTag = "";
		int iCount = 1;
		for (OnBoardBean objBean : bean.getOnBoardBeanList()) {
			
			String sTrHtml = "<tr style='background-color: lightgray;' >";
			
    
		sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getBlNo() + "</font></TD>";
		sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getVessel() + "</font></TD>";
		sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getVoyage() + "</font></TD>";
		sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getPol() + "</font></TD>";
		sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getPod() + "</font></TD>";
		sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getFpod() + "</font></TD>";
		   if (objBean.getEtd()!=null) {
			 sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getEtd()+ "</font></TD>";
					}else {
			sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </font></TD>";
					}
		   if (objBean.getConnectVessel()!= null ) {
			   sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getConnectVessel() + "</font></TD>";   
		   }else {
			   sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </font></TD>";  
		   }
		   if (  objBean.getConnectVoyage() != null   ) {
			   sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean.getConnectVoyage() + "</font></TD>";
		   }else {
			   sTrHtml += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2> - </font></TD>";
		   }
		
			
		sTrHtml += "</tr> ";

		trTag = trTag + sTrHtml;
		}
		sbq.append(trTag);
		sbq.append("</table>");
		sbq.append("<br>");
		sbq.append("<br>");
		
		sbq.append(
				"<TABLE align='center' border='1' bordercolor='#000000' cellpadding='0'	cellspacing='0' width='100%'>	"
						+ "<TR style='background-color: rgb(0, 45 ,109);'>	"
						+ "<TD align='center' width='5%' style='color:white'  height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Bl No.</b></font></TD> "
						+ "<TD align='center' width='5%' style='color:white'  height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Container Number</b></font></TD> "
						+ "<TD align='center' width='5%' style='color:white'  height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Container Type</b></font></TD> "
						+ "<TD align='center' width='5%' style='color:white'  height='22' style='padding-left: 5px;padding-right: 5px;' ><FONT face=Verdana size=2><b>Gross Weight</b></font></TD> "
						+ "</tr>");
		
		String trTag1 = "";
		for (OnBoardBean objBean1 : bean.getContList()) {
			
			String sTrHtml1 = "<tr style='background-color: lightgray;' >";
			
			sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean1.getBlNo() + "</font></TD>";
			sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean1.getContainerNo() + "</font></TD>";
			sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean1.getContainerType() + "</font></TD>";
			sTrHtml1 += "<TD align='center'  width='10%' height='22'> <FONT face=Verdana size=2>" + objBean1.getGw() + "</font></TD>";
			sTrHtml1 += "</tr> ";

			trTag1 = trTag1 + sTrHtml1;
		}
		sbq.append(trTag1);
		sbq.append("</table>");
		 
		sbq.append("<br>");
		sbq.append(
				"<span>This is a system-generated e-mail. Do <b style='font-size: 14px;'>NOT</b> reply to this e-mail address.</span>");
		sbq.append("<br>");
		sbq.append("<span >For any resolution, please get in touch with your contact person in <b>Cordelia.</b></span>");
		sbq.append("<br>");
		sbq.append("<br>");
		sbq.append("<b style='font-size: 12px; font-family: arial;'>Warm regards, </b>");
		sbq.append("<br>");
		sbq.append("<b style='font-size: 12px; font-family: arial;'>Team Cordelia</b>");
		sbq.append("<br><br>");
		sbq.append("<img style='width:86px;height:33px;' src=" + logoImage + ">");
		sbq.append("</body></html>");
				 
		return sbq;
	}
	
	
	
	
	private void sendMailThread(final Email email) {
		System.out.println("Thread");
		new Thread(new Runnable() {
			 @Override
			public void run() {
           	try {
           		MailUtility.sendMail(email, "");
           		}catch(Exception e){
					e.printStackTrace();
				}
        		
            }
       }).start();
	}
	
	@Override
	public List<OnBoardBean> getList() {
		return onBoardDao.getList();
	}
	
	@Override
	public OnBoardResultBean delete(String onBoardNo) {
		return onBoardDao.delete(  onBoardNo);
	}
	
	@Override
	public OnBoardBean getOnBoardDetails(String onBoardNo){
		return onBoardDao.getOnBoardDetails(  onBoardNo);
	}

	@Override
	public OnBoardResultBean save(OnBoardBean onBoardBean) {
		// TODO Auto-generated method stub
		return onBoardDao.save(onBoardBean);
	}

	@Override
	public List<SelectivityBean> getbookList(String vesselCode) {
		// TODO Auto-generated method stub
		return onBoardDao.getbookList( vesselCode);
	}

	@Override
	public String generateExcelReport(String onBoardID, String path, String number) throws IOException {
		// TODO Auto-generated method stub
		return onBoardDao.generateExcelReport(onBoardID, path, number);
	}

	@Override
	public List<OnBoardBean> getSearchList(OnBoardBean onBoardBean) {
		return onBoardDao.getSearchList( onBoardBean);
	}
}
