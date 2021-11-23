package com.dci.tenant.finance.reports.csr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.jxls.common.Context;
import org.jxls.template.SimpleExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.common.model.SelectivityBean;
import com.dci.common.util.CommonUtil;

import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@Repository
@Transactional("tenantTransactionManager")
public class CsrReportsDAOImpl implements CsrReportsDAO {
	private final static Logger LOGGER = LoggerFactory.getLogger(CsrReportsDAOImpl.class);

	@Resource
	 private DataSource dataSource;
	
	@Value("${report.export.files.absolutePath}")
	private String local;

	@Value("${report.export.files.serverPath}")
	private String server;
	@Override
	public List getSsfVol() {
		// TODO Auto-generated method stub
		System.out.println("get SFPL Vol");
		List totalList = new ArrayList();
		List<SsfVolReportBean> ssfVol = new ArrayList<SsfVolReportBean>();
		List<SsfIwsReportBean> ssfIws = new ArrayList<SsfIwsReportBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			ssfVol = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_VOL_BY_COMPANY_ID_SLOT_AC, new BeanPropertyRowMapper<SsfVolReportBean>(SsfVolReportBean.class));
			for (int i = 0; i < ssfVol.size(); i++) {
				if (i == 0) {
					ssfVol.get(i).setGrowth("");
				} else {
					Double val = ((Double.parseDouble(ssfVol.get(i).getTotal())) - (Double.parseDouble(ssfVol.get(i - 1).getTotal()))) / (Double.parseDouble(ssfVol.get(i - 1).getTotal())) * 100;
					ssfVol.get(i).setGrowth(String.valueOf(val.intValue()) + "%");
				}
			}
			ssfIws = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_IWS_BY_COMPANY_ID_SLOT_AC, new BeanPropertyRowMapper<SsfIwsReportBean>(SsfIwsReportBean.class));
			totalList.add(ssfVol);
			totalList.add(ssfIws);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getMloShortNameList", e);
		}
		return totalList;
	}

	@Override
	public List<SsfVolReportBean> getSsfMoves() {
		// TODO Auto-generated method stub
		System.out.println("get SFPL Vol");
		List<SsfVolReportBean> ssfmoves = new ArrayList<SsfVolReportBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			ssfmoves = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_SSF_TS_MOVES, new BeanPropertyRowMapper<SsfVolReportBean>(SsfVolReportBean.class));
		} catch (DataAccessException e) {
			LOGGER.error("Error in getMloShortNameList", e);
		}
		return ssfmoves;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List getTopTenNvoMloList(int year) {
		// TODO Auto-generated method stub
		List topTenList = new ArrayList();
		List<TopTenNvoMloReportBean> topTenNvoList = new ArrayList<TopTenNvoMloReportBean>();
		List<TopTenNvoMloReportBean> topTenMloList = new ArrayList<TopTenNvoMloReportBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			topTenNvoList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_TOP_TEN_NVO, new BeanPropertyRowMapper<TopTenNvoMloReportBean>(TopTenNvoMloReportBean.class), year);
			topTenMloList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_TOP_TEN_MLO, new BeanPropertyRowMapper<TopTenNvoMloReportBean>(TopTenNvoMloReportBean.class), year);
			topTenList.add(topTenNvoList);
			topTenList.add(topTenMloList);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTopTenNvoMloList", e);
		}
		return topTenList;
	}

	@Override
	public List getIalVol(String companyId) {
		// TODO Auto-generated method stub
		System.out.println("get SFPL Vol");
		List<IalfVolReportBean> ialVolList = new ArrayList<IalfVolReportBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> ialSsfVolMap = jdbcTemplate.queryForList(CsrReportsQueryUtil.SELECT_IAL_SSF_VOL_BY_COMPANY_ID_SLOT_AC);
			List<Map<String, Object>> ialXclVolMap = jdbcTemplate.queryForList(CsrReportsQueryUtil.SELECT_IAL_XCL_VOL_BY_COMPANY_ID_SLOT_AC);
			Map<Integer, IalfVolReportBean> ialMap = new TreeMap<Integer, IalfVolReportBean>();
			for (int i = 0; i < ialSsfVolMap.size(); i++) {
				IalfVolReportBean ialVolReportBean = new IalfVolReportBean();
				Map<String, Object> row = ialSsfVolMap.get(i);
				if (row.get("year") != null) {
					String year = row.get("year").toString();
					String sfpl = row.get("total").toString();
					ialVolReportBean.setYear(year);
					ialVolReportBean.setSsf(sfpl);
					ialMap.put(Integer.parseInt(year), ialVolReportBean);
				}

			}
			for (int i = 0; i < ialXclVolMap.size(); i++) {
				IalfVolReportBean ialVolReportBean = null;
				Map<String, Object> row = ialXclVolMap.get(i);
				if (row.get("year") != null) {
					String year = row.get("year").toString();
					String xcl = row.get("total").toString();
					if (ialMap.containsKey(Integer.parseInt(year))) {
						ialVolReportBean = ialMap.get(Integer.parseInt(year));
						ialVolReportBean.setXcl(xcl);
					} else {
						ialVolReportBean = new IalfVolReportBean();
						ialVolReportBean.setYear(year);
						ialVolReportBean.setXcl(xcl);
						ialMap.put(Integer.parseInt(year), ialVolReportBean);
					}

				}
			}
			for (Integer year : ialMap.keySet()) {
				IalfVolReportBean ialVolBean = ialMap.get(year);
				if (ialVolBean.getSsf() != null && !ialVolBean.getSsf().isEmpty() && ialVolBean.getXcl() != null && !ialVolBean.getXcl().isEmpty()) {
					Double sfpl = Double.parseDouble(ialVolBean.getSsf());
					Double xcl = Double.parseDouble(ialVolBean.getXcl());
					Double total = sfpl + xcl;
					ialVolBean.setTotal(total.intValue() + "");
					Double ssfShare = (sfpl / total) * 100;
					Double xclShare = (xcl / total) * 100;
					ialVolBean.setSsfGrowth(Math.round(ssfShare) + "%");
					ialVolBean.setXclGrowth(Math.round(xclShare) + "%");
					ialVolList.add(ialVolBean);
				} else if (ialVolBean.getSsf() != null && !ialVolBean.getSsf().isEmpty() && (ialVolBean.getXcl() == null || ialVolBean.getXcl().isEmpty())) {
					Double sfpl = Double.parseDouble(ialVolBean.getSsf());
					ialVolBean.setTotal(sfpl.intValue() + "");
					ialVolBean.setSsfGrowth("100%");
					ialVolList.add(ialVolBean);
				} else if ((ialVolBean.getSsf() == null || ialVolBean.getSsf().isEmpty()) && ialVolBean.getXcl() != null && !ialVolBean.getXcl().isEmpty()) {
					Double xcl = Double.parseDouble(ialVolBean.getXcl());
					ialVolBean.setTotal(xcl.intValue() + "");
					ialVolBean.setSsfGrowth("100%");
					ialVolList.add(ialVolBean);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getIalVol", e);
		}
		return ialVolList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List getTopFifteenCust(int year) {
		List topFifteenList = new ArrayList();
		List<TopFifteenCustReportBean> topFifteenSSF = new ArrayList<TopFifteenCustReportBean>();
		List<TopFifteenCustReportBean> topFifteenXCL = new ArrayList<TopFifteenCustReportBean>();
		List<TopFifteenCustReportBean> topFifteenOEL = new ArrayList<TopFifteenCustReportBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			topFifteenSSF = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_TOP_FIFTEEN_SSF, new BeanPropertyRowMapper<TopFifteenCustReportBean>(TopFifteenCustReportBean.class), year);
			topFifteenXCL = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_TOP_FIFTEEN_XCL, new BeanPropertyRowMapper<TopFifteenCustReportBean>(TopFifteenCustReportBean.class), year);
			topFifteenOEL = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_TOP_FIFTEEN_OEL, new BeanPropertyRowMapper<TopFifteenCustReportBean>(TopFifteenCustReportBean.class), year);
			topFifteenList.add(topFifteenSSF);
			topFifteenList.add(topFifteenXCL);
			topFifteenList.add(topFifteenOEL);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTopTenNvoMloList", e);
		}
		return topFifteenList;
	}

	@Override
	public List<Object> getTransasiaVolList(String companyId) {
		List<Object> totalTransasiaList = new ArrayList<Object>();
		List<TransasiaVolTrendBean> transasiaVolTrendList = new ArrayList<TransasiaVolTrendBean>();
	//	TransasiaVolTrendBean transasiaVolTrendBean =new TransasiaVolTrendBean();
		Map<Integer, TransasiaVolTrendBean> transasiaVolMap = new TreeMap<Integer, TransasiaVolTrendBean>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Map<String, Object>> oelRow = jdbcTemplate.queryForList(CsrReportsQueryUtil.GET_TRANSASIA_VOL_OEL,new Object[]{companyId});
			List<Map<String, Object>> ssfRow = jdbcTemplate.queryForList(CsrReportsQueryUtil.GET_TRANSASIA_VOL_SSF,new Object[]{companyId});

			String oelLastYear = "";
			String oelPrevYear = "";
			String ssfLastYear = "";
			String ssfPrevYear = "";
			for (int index = 0; index < oelRow.size(); index++) {
				TransasiaVolTrendBean objTransasiaVolTrendBean = new TransasiaVolTrendBean();
				Map<String, Object> row = oelRow.get(index);
				int year1 = (int)Double.parseDouble(row.get("year").toString());
				Integer y = year1;
				String year = y.toString();
				objTransasiaVolTrendBean.setYear(year);
				objTransasiaVolTrendBean.setOel(row.get("value").toString());
				transasiaVolMap.put(Integer.parseInt(year), objTransasiaVolTrendBean);
				if (index == oelRow.size() - 1) {
					oelLastYear = year;
				}
				if (oelRow.size()==1) {
					oelPrevYear=String.valueOf(Integer.parseInt(year)-1);
				}
				if (index == oelRow.size() - 2) {
					oelPrevYear = year;
				}
			}
			for (int index = 0; index < ssfRow.size(); index++) {
				TransasiaVolTrendBean objTransasiaVolTrendBean = null;
				Map<String, Object> row = ssfRow.get(index);
				int year1 = (int)Double.parseDouble(row.get("year").toString());
				Integer y = year1;
				String year = y.toString();
				String ssfValue = row.get("value").toString();
				if (transasiaVolMap.containsKey(Integer.parseInt(year))) {
					objTransasiaVolTrendBean = transasiaVolMap.get(Integer.parseInt(year));
					objTransasiaVolTrendBean.setSsf(ssfValue);
				} else {
					objTransasiaVolTrendBean = new TransasiaVolTrendBean();
					objTransasiaVolTrendBean.setSsf(ssfValue);
					objTransasiaVolTrendBean.setYear(year);
					transasiaVolMap.put(Integer.parseInt(year), objTransasiaVolTrendBean);
				}
				if (index == ssfRow.size() - 1) {
					ssfLastYear = year;
				}
				if (ssfRow.size()==1) {
					ssfPrevYear= String.valueOf(Integer.parseInt(year)-1) ;
				}
				if (index == ssfRow.size() - 2) {
					ssfPrevYear = year;
				}
			}

			for (Integer year : transasiaVolMap.keySet()) {
				TransasiaVolTrendBean objTansasiaTrendBean = transasiaVolMap.get(year);
				if (objTansasiaTrendBean.getOel() != null && !objTansasiaTrendBean.getOel().isEmpty() && objTansasiaTrendBean.getSsf() != null && !objTansasiaTrendBean.getSsf().isEmpty()) {
					Double oel = Double.parseDouble(objTansasiaTrendBean.getOel());
					Double sfpl = Double.parseDouble(objTansasiaTrendBean.getSsf());
					Double total = sfpl + oel;
					objTansasiaTrendBean.setTotal(total.intValue() + "");
					transasiaVolTrendList.add(objTansasiaTrendBean);
				} else if (objTansasiaTrendBean.getOel() != null && !objTansasiaTrendBean.getOel().isEmpty() && (objTansasiaTrendBean.getSsf() == null || objTansasiaTrendBean.getSsf().isEmpty())) {
					Double oel = Double.parseDouble(objTansasiaTrendBean.getOel());
					objTansasiaTrendBean.setTotal(oel.intValue() + "");
					transasiaVolTrendList.add(objTansasiaTrendBean);
				} else if (objTansasiaTrendBean.getSsf() != null && !objTansasiaTrendBean.getSsf().isEmpty() && (objTansasiaTrendBean.getOel() == null || objTansasiaTrendBean.getOel().isEmpty())) {
					Double sfpl = Double.parseDouble(objTansasiaTrendBean.getSsf());
					objTansasiaTrendBean.setTotal(sfpl.intValue() + "");
					transasiaVolTrendList.add(objTansasiaTrendBean);
				}
			}
			totalTransasiaList.add(transasiaVolTrendList);
			List<TransasiaVolTrendBean> sharingList = new ArrayList<TransasiaVolTrendBean>();
			if (!CommonUtil.returnEmptyForNull(oelPrevYear).isEmpty()  && 
					!CommonUtil.returnEmptyForNull(oelLastYear).isEmpty() &&
					!CommonUtil.returnEmptyForNull(ssfLastYear).isEmpty() &&
					!CommonUtil.returnEmptyForNull(ssfPrevYear).isEmpty()) {
				if (oelLastYear.equals(ssfLastYear) && oelPrevYear.equals(ssfPrevYear)) {
					TransasiaVolTrendBean lastYearBean = transasiaVolMap.get(Integer.parseInt(oelLastYear));
					TransasiaVolTrendBean prevYearBean = transasiaVolMap.get(Integer.parseInt(oelPrevYear));
					if (!CommonUtil.returnEmptyForNull(prevYearBean.getOel()).isEmpty()  && 
							!CommonUtil.returnEmptyForNull(prevYearBean.getSsf()).isEmpty() &&
							!CommonUtil.returnEmptyForNull(prevYearBean.getTotal()).isEmpty()) {
						int currentOelValue = Integer.parseInt(lastYearBean.getOel());
						int prevOelValue = Integer.parseInt(prevYearBean.getOel());
						double oelGrowthRate = ((double) (currentOelValue - prevOelValue) / prevOelValue) * 100;
						String growthRateOfOel = Math.round(oelGrowthRate) + "%";
						int currentSsfValue = Integer.parseInt(lastYearBean.getSsf());
						int prevSsfValue = Integer.parseInt(prevYearBean.getSsf());
						double ssfGrowthRate = ((double) (currentSsfValue - prevSsfValue) / prevSsfValue) * 100;
						String growthRateOfSsf = Math.round(ssfGrowthRate) + "%";
						totalTransasiaList.add(growthRateOfOel);
						totalTransasiaList.add(growthRateOfSsf);
						double oelLastValue = Double.parseDouble(lastYearBean.getOel().toString());
						double oelPrevValue = Double.parseDouble(prevYearBean.getOel().toString());
						double ssfLastValue = Double.parseDouble(lastYearBean.getSsf().toString());
						double ssfPrevValue = Double.parseDouble(prevYearBean.getSsf().toString());

						double oelLastShare = oelLastValue / Double.parseDouble(lastYearBean.getTotal().toString()) * 100;
						double oelPrevShare = oelPrevValue / Double.parseDouble(prevYearBean.getTotal().toString()) * 100;
						double ssfLastShare = ssfLastValue / Double.parseDouble(lastYearBean.getTotal().toString()) * 100;
						double ssfPrevShare = ssfPrevValue / Double.parseDouble(prevYearBean.getTotal().toString()) * 100;
						TransasiaVolTrendBean shareObj = new TransasiaVolTrendBean();
						shareObj.setOelLastShare(Math.round(oelLastShare) + "%");
						shareObj.setOelPrevShare(Math.round(oelPrevShare) + "%");
						shareObj.setSsfLastShare(Math.round(ssfLastShare) + "%");
						shareObj.setSsfPrevShare(Math.round(ssfPrevShare) + "%");
						shareObj.setLastYear(lastYearBean.getYear());
						shareObj.setPrevYear(prevYearBean.getYear());
						sharingList.add(shareObj);
						totalTransasiaList.add(sharingList);
					}else if (!CommonUtil.returnEmptyForNull(lastYearBean.getOel()).isEmpty()  && 
							!CommonUtil.returnEmptyForNull(lastYearBean.getSsf()).isEmpty() &&
							!CommonUtil.returnEmptyForNull(lastYearBean.getTotal()).isEmpty()) {
						int currentOelValue = Integer.parseInt(lastYearBean.getOel());
						//int prevOelValue = Integer.parseInt(prevYearBean.getOel());
						double oelGrowthRate = ((currentOelValue) );
						String growthRateOfOel = Math.round(oelGrowthRate) + "%";
						int currentSsfValue = Integer.parseInt(lastYearBean.getSsf());
						//int prevSsfValue = Integer.parseInt(prevYearBean.getSsf());
						double ssfGrowthRate = ((currentSsfValue));
						String growthRateOfSsf = Math.round(ssfGrowthRate) + "%";
						totalTransasiaList.add(growthRateOfOel);
						totalTransasiaList.add(growthRateOfSsf);
						double oelLastValue = Double.parseDouble(lastYearBean.getOel().toString());
					//	double oelPrevValue = Double.parseDouble(prevYearBean.getOel().toString());
						double ssfLastValue = Double.parseDouble(lastYearBean.getSsf().toString());
						//double ssfPrevValue = Double.parseDouble(prevYearBean.getSsf().toString());

						double oelLastShare = oelLastValue / Double.parseDouble(lastYearBean.getTotal().toString()) * 100;
						//double oelPrevShare = oelPrevValue / Double.parseDouble(prevYearBean.getTotal().toString()) * 100;
						double ssfLastShare = ssfLastValue / Double.parseDouble(lastYearBean.getTotal().toString()) * 100;
						//double ssfPrevShare = ssfPrevValue / Double.parseDouble(prevYearBean.getTotal().toString()) * 100;
						TransasiaVolTrendBean shareObj = new TransasiaVolTrendBean();
						shareObj.setOelLastShare(Math.round(oelLastShare) + "%");
						//shareObj.setOelPrevShare(Math.round(oelPrevShare) + "%");
						shareObj.setSsfLastShare(Math.round(ssfLastShare) + "%");
						//shareObj.setSsfPrevShare(Math.round(ssfPrevShare) + "%");
						shareObj.setLastYear(lastYearBean.getYear());
						shareObj.setPrevYear(oelPrevYear);
						sharingList.add(shareObj);
						totalTransasiaList.add(sharingList);
					}
		

					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalTransasiaList;
	}

	@Override
	public List<AverageWeightPerTeu> getAvgWeiPerTeu() {
		List<AverageWeightPerTeu> polPodList = new ArrayList<AverageWeightPerTeu>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<AverageWeightPerTeu> polList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_AVG_POL_JAL, new BeanPropertyRowMapper<AverageWeightPerTeu>(AverageWeightPerTeu.class));
			List<AverageWeightPerTeu> podList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_AVG_POD_JAL, new BeanPropertyRowMapper<AverageWeightPerTeu>(AverageWeightPerTeu.class));
			Map<String, AverageWeightPerTeu> avgMap = new TreeMap<String, AverageWeightPerTeu>();
			for (AverageWeightPerTeu avgWeiTeu : polList) {
				AverageWeightPerTeu avgBean = new AverageWeightPerTeu();
				Double avgWeight = Double.parseDouble(avgWeiTeu.getAvg_weight());
				Double avgTeus = Double.parseDouble(avgWeiTeu.getAvg_teus());
				Double avg = (avgWeight / avgTeus);
				double avgDecimal = Math.round(avg * 100);
				avgDecimal = avgDecimal / 100;
				avgBean.setPol(avgWeiTeu.getPol());
				avgBean.setPod(avgWeiTeu.getPod());
				avgBean.setPolAvg(avgDecimal + "");
				avgMap.put(avgWeiTeu.getPol() + "-" + avgWeiTeu.getPod(), avgBean);
			}
			for (AverageWeightPerTeu avgWeiTeu : podList) {
				Double avgWeight = Double.parseDouble(avgWeiTeu.getAvg_weight());
				Double avgTeus = Double.parseDouble(avgWeiTeu.getAvg_teus());
				Double avg = (avgWeight / avgTeus);
				double avgDecimal = Math.round(avg * 100);
				avgDecimal = avgDecimal / 100;
				String key = avgWeiTeu.getPod() + "-" + avgWeiTeu.getPol();
				AverageWeightPerTeu avgBean = null;
				if (avgMap.containsKey(key)) {
					avgBean = avgMap.get(key);
					avgBean.setPodAvg(avgDecimal + "");
				} else {
					avgBean = new AverageWeightPerTeu();
					avgBean.setPol(avgWeiTeu.getPod());
					avgBean.setPod(avgWeiTeu.getPol());
					avgBean.setPodAvg(avgDecimal + "");
					avgMap.put(key, avgBean);
				}

			}
			for (String key : avgMap.keySet()) {
				AverageWeightPerTeu avgBean = avgMap.get(key);
				polPodList.add(avgBean);
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTopTenNvoMloList", e);
		}
		return polPodList;
	}

	@Override
	public List<Object> getSsfShareList() {
		List<Object> ssfResultList = new ArrayList<Object>();
		List<SsfShareBean> ssfShareList = new ArrayList<SsfShareBean>();
		
		String ssfYear[] = new String[7];
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		String Years = "";
		for (int index = 0; index < 6; index++) {
			int cYear = currentYear - (5-index);
			//cYear += index;
			if(Years.isEmpty()){
				Years = "\""+cYear + "\" numeric";
			}else{
				Years = Years+",\""+cYear + "\" numeric";
			}
			ssfYear[index]=cYear+"";
		}
		//Years = Years.substring(0, Years.length() - 1);
		//ssfYear = Years.split(",");
		System.out.println(Years);

		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String sql = CsrReportsQueryUtil.GET_SSF_SHARE_LIST + Years + " )order by Sector";
			List<Map<String, Object>> ssfRow = jdbcTemplate.queryForList(sql);
			for (Map row : ssfRow) {
				SsfShareBean objSsfShareBean = new SsfShareBean();
				if (row.get("sector") != null) {
					objSsfShareBean.setSector(row.get("sector").toString());
				}
				if (row.get(ssfYear[0]) != null) {
					objSsfShareBean.setFirstYear(row.get(ssfYear[0]).toString());
				}
				if (row.get(ssfYear[1]) != null) {
					objSsfShareBean.setSecYear(row.get(ssfYear[1]).toString());
				}
				if (row.get(ssfYear[2]) != null) {
					objSsfShareBean.setThirdYear(row.get(ssfYear[2]).toString());
				}
				if (row.get(ssfYear[3]) != null) {
					objSsfShareBean.setFourthYear(row.get(ssfYear[3]).toString());
				}
				if (row.get(ssfYear[4]) != null) {
					objSsfShareBean.setFifthYear(row.get(ssfYear[4]).toString());
				}
				if (row.get(ssfYear[5]) != null) {
					objSsfShareBean.setSixthYear(row.get(ssfYear[5]).toString());
				}
				ssfShareList.add(objSsfShareBean);
			}
			ssfResultList.add(ssfShareList);
			ssfResultList.add(ssfYear);
		} catch (Exception e) {

		}
		return ssfResultList;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getThirdPartyLoadings() {
		List totalList = new ArrayList();
		List<ThirdPartyLoading> thirdPartyLoadingList = new ArrayList<ThirdPartyLoading>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			Calendar now = Calendar.getInstance();   // Gets the current date and time
			int currentYear = now.get(Calendar.YEAR); 
			int prevYear = currentYear - 1;
			/*String currentYear = jdbcTemplate.queryForObject(CsrReportsQueryUtil.SELECT_CURRENT_YEAR, String.class);*/
			/*String prevYear = jdbcTemplate.queryForObject(CsrReportsQueryUtil.SELECT_PREV_YEAR, String.class);*/
			List<ThirdPartyLoading> lastYearList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_THIRD_PARTY_LOADINGS_BY_YEAR, new BeanPropertyRowMapper<ThirdPartyLoading>(ThirdPartyLoading.class), currentYear);
			List<ThirdPartyLoading> prevYearList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_THIRD_PARTY_LOADINGS_BY_YEAR, new BeanPropertyRowMapper<ThirdPartyLoading>(ThirdPartyLoading.class), prevYear);
			Map<String, ThirdPartyLoading> tPartyLoadingMap = new TreeMap<String, ThirdPartyLoading>();
			for (ThirdPartyLoading lastYearLoading : lastYearList) {
				lastYearLoading.setLastYearValue(lastYearLoading.getTeus());
				String key = lastYearLoading.getPol() + "-" + lastYearLoading.getPod();
				lastYearLoading.setTeus(null);
				tPartyLoadingMap.put(key, lastYearLoading);
			}
			for (ThirdPartyLoading prevYearLoading : prevYearList) {
				String key = prevYearLoading.getPol() + "-" + prevYearLoading.getPod();
				ThirdPartyLoading tPartLoad = null;
				if (tPartyLoadingMap.containsKey(key)) {
					tPartLoad = tPartyLoadingMap.get(key);
					tPartLoad.setPrevYearValue(prevYearLoading.getTeus());
				} else {
					prevYearLoading.setPrevYearValue(prevYearLoading.getTeus());
					tPartyLoadingMap.put(key, prevYearLoading);
				}
				prevYearLoading.setTeus(null);
			}
			for (String key : tPartyLoadingMap.keySet()) {
				ThirdPartyLoading thirdPartyLoading = tPartyLoadingMap.get(key);
				thirdPartyLoadingList.add(thirdPartyLoading);
			}
			totalList.add(thirdPartyLoadingList);
			totalList.add(currentYear);
			totalList.add(prevYear);
		} catch (DataAccessException e) {
			LOGGER.error("Error in getThirdPartyLoadings", e);
		}
		return totalList;
	}

	@Override
	public List getCatABCShare() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getVolumes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CsrReportsResultBean getThirdPartyExcel() {
		// TODO Auto-generated method stub
		CsrReportsResultBean objCsrReportsResultBean =new CsrReportsResultBean();
		List<ThirdPartyLoading> thirdPartyLoadingList = new ArrayList<ThirdPartyLoading>();
		List<String> thirdPartyHeader = new ArrayList<String>();
		ThirdPartyLoadingHeader thirdPartyLoadingBean= new ThirdPartyLoadingHeader();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			String header= "POL - POD";
			/*String currentYear = jdbcTemplate.queryForObject(CsrReportsQueryUtil.SELECT_CURRENT_YEAR, String.class);
			String prevYear = jdbcTemplate.queryForObject(CsrReportsQueryUtil.SELECT_PREV_YEAR, String.class);*/
			Calendar now = Calendar.getInstance();   // Gets the current date and time
			int currentYear = now.get(Calendar.YEAR); 
			int prevYear = currentYear - 1;
			thirdPartyHeader.add(header);
			thirdPartyHeader.add(String.valueOf(prevYear));
			thirdPartyHeader.add(String.valueOf(currentYear));
			List<ThirdPartyLoading> lastYearList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_THIRD_PARTY_LOADINGS_BY_YEAR, new BeanPropertyRowMapper<ThirdPartyLoading>(ThirdPartyLoading.class), currentYear);
			List<ThirdPartyLoading> prevYearList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_THIRD_PARTY_LOADINGS_BY_YEAR, new BeanPropertyRowMapper<ThirdPartyLoading>(ThirdPartyLoading.class), prevYear);
			Map<String, ThirdPartyLoading> tPartyLoadingMap = new TreeMap<String, ThirdPartyLoading>();
			for (ThirdPartyLoading lastYearLoading : lastYearList) {
				lastYearLoading.setLastYearValue(lastYearLoading.getTeus());
				String key = lastYearLoading.getPol() + "-" + lastYearLoading.getPod();
				lastYearLoading.setPolPod(key);
				lastYearLoading.setTeus(null);
				tPartyLoadingMap.put(key, lastYearLoading);
			}
			for (ThirdPartyLoading prevYearLoading : prevYearList) {
				String key = prevYearLoading.getPol() + "-" + prevYearLoading.getPod();
				
				ThirdPartyLoading tPartLoad = null;
				if (tPartyLoadingMap.containsKey(key)) {
					tPartLoad = tPartyLoadingMap.get(key);
					tPartLoad.setPrevYearValue(prevYearLoading.getTeus());
				} else {
					prevYearLoading.setPrevYearValue(prevYearLoading.getTeus());
					tPartyLoadingMap.put(key, prevYearLoading);
				}
				prevYearLoading.setPolPod(key);
				prevYearLoading.setTeus(null);
			}
			for (String key : tPartyLoadingMap.keySet()) {
				ThirdPartyLoading thirdPartyLoading = tPartyLoadingMap.get(key);
				thirdPartyLoadingList.add(thirdPartyLoading);
			}
			Date date = new Date();
			if (thirdPartyLoadingList.size() > 0) {
				String fName = "ThirdPartyLoading" + date.getDay() + date.getHours() + date.getMinutes() + ".xls";
				String fileName = local + fName;
				WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
				workbook.createSheet("Sheet1", 0);
				workbook.write();
				workbook.close();
				try (OutputStream os = new FileOutputStream(fileName)) {
					Context context = new Context();
					context.putVar("thirdPartyLoading", thirdPartyLoadingList);
					SimpleExporter exporter = new SimpleExporter();
					exporter.gridExport(thirdPartyHeader, thirdPartyLoadingList, "polPod,prevYearValue, lastYearValue", os);
					objCsrReportsResultBean.setFilePath(server + "/" + fName);
					objCsrReportsResultBean.setSuccess(true);
				} catch (Exception e) {
					objCsrReportsResultBean.setSuccess(false);
				}
			}
	}catch(Exception e){
		e.printStackTrace();
	}
		return objCsrReportsResultBean;
		
	}

	@Override
	public CsrReportsResultBean getAvgWeightPerteuexcelexp() throws IOException, WriteException {
		// TODO Auto-generated method stub
		CsrReportsResultBean objCsrReportsResultBean =new CsrReportsResultBean();
		List<AverageWeightPerTeu> polPodList = new ArrayList<AverageWeightPerTeu>();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<AverageWeightPerTeu> polList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_AVG_POL_JAL, new BeanPropertyRowMapper<AverageWeightPerTeu>(AverageWeightPerTeu.class));
			List<AverageWeightPerTeu> podList = jdbcTemplate.query(CsrReportsQueryUtil.SELECT_AVG_POD_JAL, new BeanPropertyRowMapper<AverageWeightPerTeu>(AverageWeightPerTeu.class));
			Map<String, AverageWeightPerTeu> avgMap = new TreeMap<String, AverageWeightPerTeu>();
			for (AverageWeightPerTeu avgWeiTeu : polList) {
				AverageWeightPerTeu avgBean = new AverageWeightPerTeu();
				Double avgWeight = Double.parseDouble(avgWeiTeu.getAvg_weight());
				Double avgTeus = Double.parseDouble(avgWeiTeu.getAvg_teus());
				Double avg = (avgWeight / avgTeus);
				double avgDecimal = Math.round(avg * 100);
				avgDecimal = avgDecimal / 100;
				avgBean.setPol(avgWeiTeu.getPol());
				avgBean.setPod(avgWeiTeu.getPod());
				String key = avgWeiTeu.getPod() + "-" + avgWeiTeu.getPol();
				avgBean.setPolPod(key);
				avgBean.setPolAvg(avgDecimal + "");
				avgMap.put(avgWeiTeu.getPol() + "-" + avgWeiTeu.getPod(), avgBean);
			}
			for (AverageWeightPerTeu avgWeiTeu : podList) {
				Double avgWeight = Double.parseDouble(avgWeiTeu.getAvg_weight());
				Double avgTeus = Double.parseDouble(avgWeiTeu.getAvg_teus());
				Double avg = (avgWeight / avgTeus);
				double avgDecimal = Math.round(avg * 100);
				avgDecimal = avgDecimal / 100;
				String key = avgWeiTeu.getPod() + "-" + avgWeiTeu.getPol();
				
				AverageWeightPerTeu avgBean = null;
				if (avgMap.containsKey(key)) {
					avgBean = avgMap.get(key);
					avgBean.setPodAvg(avgDecimal + "");
					avgBean.setPodPol(key);
				} else {
					avgBean = new AverageWeightPerTeu();
					avgBean.setPol(avgWeiTeu.getPod());
					avgBean.setPod(avgWeiTeu.getPol());
					avgBean.setPodAvg(avgDecimal + "");
					avgBean.setPodPol(key);
					avgMap.put(key, avgBean);
				}

			}
			for (String key : avgMap.keySet()) {
				AverageWeightPerTeu avgBean = avgMap.get(key);
				polPodList.add(avgBean);
			}
			Date date = new Date();
			if (polPodList.size() > 0) {
				String fName = "AverageWeightPerTeu" + date.getDay() + date.getHours() + date.getMinutes() + ".xls";
				String fileName = local + fName;
				WritableWorkbook workbook = jxl.Workbook.createWorkbook(new File(fileName));
				workbook.createSheet("Sheet1", 0);
				workbook.write();
				workbook.close();
				try (OutputStream os = new FileOutputStream(fileName)) {
					List<String> headers = Arrays.asList("POL - POD", "AVG WT/TEU","POD - POL","AVG WT/TEU");
					Context context = new Context();
					context.putVar("polPodList", polPodList);
					SimpleExporter exporter = new SimpleExporter();
					exporter.gridExport(headers, polPodList, "polPod,polAvg, podPol,podAvg", os);
					objCsrReportsResultBean.setFilePath(server + "/" + fName);
					objCsrReportsResultBean.setSuccess(true);
				} catch (Exception e) {
					objCsrReportsResultBean.setSuccess(false);
				}
			}
		} catch (DataAccessException e) {
			LOGGER.error("Error in getTopTenNvoMloList", e);
		}
		
		return objCsrReportsResultBean;
	}

	@Override
	public List<SelectivityBean> getCompanyList() {
		List<SelectivityBean> companyList=new ArrayList<SelectivityBean>();
		try{
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			companyList=jdbcTemplate.query(CsrReportsQueryUtil.customerList,new BeanPropertyRowMapper<SelectivityBean>(SelectivityBean.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return companyList;
	}
}
