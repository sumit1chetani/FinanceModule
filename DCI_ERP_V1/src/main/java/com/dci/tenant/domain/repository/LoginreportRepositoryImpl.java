package com.dci.tenant.domain.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dci.tenant.domain.model.DashboardBean;

@Repository
@Transactional("tenantTransactionManager")
public class LoginreportRepositoryImpl implements LoginreportRepository {
	@PersistenceContext(unitName = "tenantEntityManager")
	private EntityManager em;


	@Override
	public DashboardBean getDashboardValues() throws Exception {
		DashboardBean dashboardBean = new DashboardBean();
		String firstMonth = "";
		String lastMonth = "";
		int usersUsage = 0;
		int appsUsage = 0;
		/*DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		List<String> monthList = new ArrayList<String>();
		List<Integer> userStatList = new ArrayList<Integer>();
		List<Integer> appStatList = new ArrayList<Integer>();
		Calendar cal = getCalendarForNow();
		cal.add(Calendar.MONTH, (-1));
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		String pasFirstDate = formatter.format(cal.getTime());
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String pasLastDate = formatter.format(cal.getTime());
		Query curUsrQuery = em.createNativeQuery("select count(*) from tenant_user where login_status = true");
		dashboardBean.setCurUserLogin(((BigInteger)curUsrQuery.getSingleResult()).intValue());
		Query noOfAppsQuery = em.createNativeQuery("select (select count(*) from saml_application) + (select count(*) from nonsaml_appln) as noOfApps");
		dashboardBean.setNoOfApps(((BigInteger) noOfAppsQuery.getSingleResult()).intValue());
		Query acctLoggedInQuery = em.createNativeQuery("select count(*) from (select count(*) from user_event_log where tenant_user_id is not null and status = 'Success' group by tenant_user_id) as count");
		dashboardBean.setAcctLogdIn(((BigInteger) acctLoggedInQuery.getSingleResult()).intValue());
		Query pwdChangeQuery = em.createNativeQuery("select count(*) from (select count(*) from pwd_change_log where tenant_user_id is not null and date(last_updated_on) between STR_TO_DATE(:pasFirstDate,'%d/%m/%Y') and STR_TO_DATE(:pasLastDate,'%d/%m/%Y') group by tenant_user_id) as pwdCount");
		pwdChangeQuery.setParameter("pasFirstDate",pasFirstDate);
		pwdChangeQuery.setParameter("pasLastDate",pasLastDate);
		dashboardBean.setChangePwrdCount(((BigInteger) pwdChangeQuery.getSingleResult()).intValue());
		for (int mon = 0; mon <= 5; mon++) {
			Calendar calendar = getCalendarForNow();
			calendar.add(Calendar.MONTH, (-6+ mon));
			calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			Date firstDateOfPreviousMonth = calendar.getTime();
			calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date lastDateOfPreviousMonth = calendar.getTime();
			String lastDate = formatter.format(lastDateOfPreviousMonth);
			String firstDate = formatter.format(firstDateOfPreviousMonth);
			String month = getMonth(firstDateOfPreviousMonth.getMonth());
			if(mon==0){
				firstMonth = month + " "+ firstDateOfPreviousMonth.getDate();
			}else if(mon==5){
				lastMonth = month + " "+ lastDateOfPreviousMonth.getDate();
			}
			Query userStatQuery = em.createNativeQuery("select round((select count(*) from (select count(*) from user_event_log where tenant_user_id is not null and status = 'Success' and date(event_time) between STR_TO_DATE(:firstDate,'%d/%m/%Y') and STR_TO_DATE(:lastDate,'%d/%m/%Y') group by tenant_user_id) as count) / (select count(*) from tenant_user)*100) as average");
			userStatQuery.setParameter("firstDate", firstDate);
			userStatQuery.setParameter("lastDate", lastDate);
			int userStat = ((BigDecimal) userStatQuery.getSingleResult()).intValue();
			usersUsage += userStat;
			Query appStatQuery = em.createNativeQuery("select round(((select round((select count(*) from (select count(*) from user_event_log uel inner join saml_application sa on uel.asset_id=sa.asset_id where uel.status='SAML Accessed' and tenant_user_id is not null and date(event_time) between STR_TO_DATE(:firstDate,'%d/%m/%Y') and STR_TO_DATE(:lastDate,'%d/%m/%Y') group by sa.asset_id) as count) / (select count(*) from saml_application)*100) as average)+(select round((select count(*) from (select count(*) from user_event_log uel inner join nonsaml_appln nsa on uel.asset_id=nsa.asset_id where uel.status='Non-SAML Accessed' and tenant_user_id is not null and date(event_time) between STR_TO_DATE(:firstDate,'%d/%m/%Y') and STR_TO_DATE(:lastDate,'%d/%m/%Y') group by nsa.asset_id) as count) / (select count(*) from nonsaml_appln)*100) as average))/2) as average");
			appStatQuery.setParameter("firstDate", firstDate);
			appStatQuery.setParameter("lastDate", lastDate);
			int appStat = ((BigDecimal) appStatQuery.getSingleResult()).intValue();
			appsUsage += appStat;
			monthList.add(month);
			userStatList.add(userStat);
			appStatList.add(appStat);
		}
		dashboardBean.setUsersUsage(usersUsage/6);
		dashboardBean.setAppsUsage(appsUsage/6);
		dashboardBean.setUserStatList(userStatList);
		dashboardBean.setAppStatList(appStatList);
		dashboardBean.setMonthList(monthList);
		dashboardBean.setMonthVal(firstMonth+" - "+lastMonth);
		Date date = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
	    c.add(Calendar.DATE, -i - 7);
	    String weekStartDate = formatter.format(c.getTime());
	    c.add(Calendar.DATE, 6);
	    String weekEndDate = formatter.format(c.getTime());
	    Calendar calen = Calendar.getInstance();
	    calen.setTime(date);
	    calen.add(Calendar.DATE, - 30);
	    String monthFirstDay = formatter.format(calen.getTime());
	    calen.add(Calendar.DATE, 29);
	    String monthLastDay = formatter.format(calen.getTime());
	    Calendar todayCal = Calendar.getInstance();
	    todayCal.setTime(date);
	    String todayDate = formatter.format(todayCal.getTime());
	    String userStatQuery = "select count(*) as count, (select case when concat(first_name, ' - ', last_name) is null then display_name else concat(first_name, ' - ', last_name) end from tenant_user where tenant_user_id=uel.tenant_user_id) as name from user_event_log uel where uel.tenant_user_id is not null and uel.status = 'Success' and date(uel.event_time) between STR_TO_DATE(:userFirstDay,'%d/%m/%Y') and STR_TO_DATE(:userLastDay,'%d/%m/%Y') group by uel.tenant_user_id order by count desc limit 3;";
	    String appStatQuery = "select count(*) as count, (case when uel.status='SAML Accessed' then (select name from saml_application where asset_id=uel.asset_id) else (select appName from nonsaml_appln where asset_id=uel.asset_id) end) as name from user_event_log uel where (uel.status='Non-SAML Accessed' or uel.status='SAML Accessed') and date(event_time) between STR_TO_DATE(:appFirstDay,'%d/%m/%Y') and STR_TO_DATE(:appLastDay,'%d/%m/%Y') group by uel.asset_id order by count desc limit 3";
	    Query monthUserStatQuery = em.createNativeQuery(userStatQuery);
	    monthUserStatQuery.setParameter("userFirstDay", monthFirstDay);
	    monthUserStatQuery.setParameter("userLastDay", monthLastDay);
	    dashboardBean.setMonthUserSignList(iteratorList(monthUserStatQuery.getResultList()));
	    Query monthAppStatQuery = em.createNativeQuery(appStatQuery);
	    monthAppStatQuery.setParameter("appFirstDay", monthFirstDay);
	    monthAppStatQuery.setParameter("appLastDay", monthLastDay);
	    dashboardBean.setMonthAppSignList(iteratorList(monthAppStatQuery.getResultList()));
	    Query weekUserStatQuery = em.createNativeQuery(userStatQuery);
	    weekUserStatQuery.setParameter("userFirstDay", weekStartDate);
	    weekUserStatQuery.setParameter("userLastDay", weekEndDate);
	    dashboardBean.setWeekUserSignList(iteratorList(weekUserStatQuery.getResultList()));
	    Query weekAppStatQuery = em.createNativeQuery(appStatQuery);
	    weekAppStatQuery.setParameter("appFirstDay", weekStartDate);
	    weekAppStatQuery.setParameter("appLastDay", weekEndDate);
	    dashboardBean.setWeekAppSignList(iteratorList(weekAppStatQuery.getResultList()));
	    Query todayUserStatQuery = em.createNativeQuery(userStatQuery);
	    todayUserStatQuery.setParameter("userFirstDay", todayDate);
	    todayUserStatQuery.setParameter("userLastDay", todayDate);
	    dashboardBean.setTodayUserSignList(iteratorList(todayUserStatQuery.getResultList()));
	    Query todayAppStatQuery = em.createNativeQuery(appStatQuery);
	    todayAppStatQuery.setParameter("appFirstDay", todayDate);
	    todayAppStatQuery.setParameter("appLastDay", todayDate);
	    dashboardBean.setTodayAppSignList(iteratorList(todayAppStatQuery.getResultList()));*/
		return dashboardBean;
	}
	
	public static String getMonth(int val) {
		String[] month = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		return month[val];
	}
	
	public List<DashboardBean> iteratorList(List<Object> dayList){
		List<DashboardBean> iterateList = new ArrayList<DashboardBean>();
		if(dayList.size()>0)
			for (Object object : dayList) {
				DashboardBean dashboard = new DashboardBean();
				Object[] appObj = (Object[]) object;
				dashboard.setCount(Integer.parseInt(appObj[0].toString()));
				if(appObj[1]!=null)
					dashboard.setName(appObj[1].toString());
				iterateList.add(dashboard);
			}
		return iterateList;
	}
	
	private static Calendar getCalendarForNow() {
	    Calendar calendar = GregorianCalendar.getInstance();
	    calendar.setTime(new Date());
	    return calendar;
	}

	
}
