package com.dci.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.dci.web.auth.AuthenticationFailureHandler;
import com.dci.web.auth.UserLogoutSuccessHandler;
import com.dci.web.auth.WebAuthenticationProvider;
import com.dci.web.auth.WebAuthenticatorParam;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private WebAuthenticationProvider webAuthenticationProvider;

	@Autowired
	private WebAuthenticatorParam webAuthenticatorParam;

	@Autowired
	AuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	UserLogoutSuccessHandler userLogoutSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		System.out.println("authentication");
		auth.authenticationProvider(webAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				.antMatchers("/{tenantid}")
				.permitAll()
				.antMatchers("/{tenantid}/login")
				.permitAll()
				.antMatchers("/{tenantid}/loginsso")
				.permitAll()
				.antMatchers("/{tenantid}/app/usermaster/forgetPassword")
				.permitAll()
				.antMatchers("/logout")
				.permitAll()
				.antMatchers("/loginagain")
				.permitAll()
				.antMatchers("/{tenantid}/logout")
				.permitAll()
				.antMatchers("/{tenantid}/app/airtariff**")
				.permitAll()
				
				.antMatchers("/{tenantid}/feeder/mobileApp/mobilelogin")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getCustomer")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getFavouriteCustomer")
				.permitAll()
				.antMatchers("/{tenantid}/app/mobileuser/getFavouriteCustomer")
				.permitAll()
				.antMatchers("/{tenantid}/app/mobileuser/insertVoiceRecord")
				.permitAll()
				.antMatchers("/{tenantid}/app/mobileuser/getVoiceRecorder")
				.permitAll()
				.antMatchers("/{tenantid}/app/mobileuser/getVoiceRecorder")
				.permitAll()
				
				
				.antMatchers("/{tenantid}/app/mobileApp/**")
				.permitAll()
				.antMatchers("/{tenantid}/api/company/**")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/insertFavouriteCustomer")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/list")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getReport")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getaol")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getpol")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getCustomerJob")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getPortToPortISOChart")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getjoborderprofit")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getjoborderloss")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getemployeedesig")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getunit")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getBusinessContinuity")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getCustCode")
				.permitAll()
				
				.antMatchers("/{tenantid}/feeder/mobileApp/getPortToPortISOChartair")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getjobtracking")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getjobtrackingair")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/deleteFavouriteCustomer")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/addFavouriteCustomer")
				.permitAll()
				.antMatchers("/{tenantid}/app/intercompanytransfer/rejectPettyCashTranferListMail")
				.permitAll()
				.antMatchers("/{tenantid}/app/intercompanytransfer/approvePettyCashTranferListMail")
				.permitAll()
				.antMatchers("/{tenantid}/fuelvoucher/approve")
				.permitAll()
				.antMatchers("/{tenantid}/fuelvoucher/reject")
				.permitAll()
				.antMatchers("/{tenantid}/app/finance/accounts/provisionforwriteoff/approve")
				.permitAll()
				.antMatchers("/{tenantid}/app/finance/accounts/provisionforwriteoff/reject")
				.permitAll()
				.antMatchers("/{tenantid}/mobile/webService/login")
				.permitAll()
				.antMatchers("/{tenantid}/mobile/webService/getCurrentTrip")
				.permitAll()
				.antMatchers("/{tenantid}/mobile/webService/getCurrentStatusId")
				.permitAll()
				.antMatchers("/{tenantid}/mobile/webService/insertStatus")
				.permitAll()
				.antMatchers("/{tenantid}/mobile/webService/uploadDocFile")
				.permitAll()
				.antMatchers(
						"/{tenantid}/mobile/webService/updateTechnicalStatus")
				.permitAll()
				.antMatchers(
						"/{tenantid}/mobile/webService/getStatusList")
				.permitAll()
				.antMatchers(
						"/{tenantid}/mobile/webService/insertOnlineOfflineStatus")
				.permitAll()
				.antMatchers(
						"/{tenantid}/feeder/mobileApp/getCustomerDropdownList")
				.permitAll()
				.antMatchers(
						"/{tenantid}/feeder/mobileApp/getCustomerDetails")
				.permitAll()
				
				.antMatchers(
						"/{tenantid}/feeder/mobileApp/getsearate")
				.permitAll()
				.antMatchers(
						"/{tenantid}/feeder/mobileApp/getTariffList")
				.permitAll()
				.antMatchers(
						"/{tenantid}/feeder/mobileApp/getRevenue")
				.permitAll()
				.antMatchers(
						"/{tenantid}/feeder/mobileApp/getCustomerAdmin")
				.permitAll()
				
				.antMatchers(
						"/{tenantid}/feeder/mobileApp/getCustomerManager")
				.permitAll()
				
				
				.antMatchers("/{tenantid}/feeder/mobileApp/saveComment")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/seaQuotationsave")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getCustomerListByLimit")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getComments")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/saveComment")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/save")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getEmpList")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getChargeHead")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getTrackingCust")
				.permitAll()
				.antMatchers("/{tenantid}/feeder/mobileApp/getRemittanceCust")
				.permitAll()
				
				.antMatchers("/{tenantid}/app/tripWiseGpsTracker/VehicleTrack")
				.permitAll()
				.antMatchers("/{tenantid}/hospital/accounts/average/averagemail")
				.permitAll()
				.antMatchers("/imgFiles/**")
				.permitAll()
				
				.antMatchers("/{tenantid}/app/pdc/pdcSchedule")
				.permitAll()
				
				.antMatchers("/{tenantid}/app/ageindays/ageSchedule")
				.permitAll()
				
				.antMatchers("/{tenantid}/app/interestCalculation/interestcalculationSchedule")
				.permitAll()
				
				.antMatchers("/{tenantid}/app/prepaidExpenses/prepaidscheduler")
				.permitAll()
				.antMatchers("/{tenantid}/app/assetDepreciation/assetDepreciationSchedule")
				.permitAll()
				.antMatchers("/{tenantid}/app/bankReconciliation/mail")
				.permitAll()
				.antMatchers("/{tenantid}/app/bankReconciliation/approve")
				.permitAll()
				.antMatchers("/{tenantid}/app/bankReconciliation/reject")
				.permitAll()
				.antMatchers("/{tenantid}/app/trucktracking/getVehicleTrackingPositionList")
				.permitAll()
				.antMatchers("/{tenantid}/app/trucktracking/getVehicleTrackingDriverEavaluationList")
				.permitAll()
				.antMatchers("/{tenantid}/app/trucktracking/getTruckCurrentStatus")
				.permitAll()
				.antMatchers("/{tenantid}/app/trucktracking/restStatusMail")
				.permitAll()
				.antMatchers("/{tenantid}/app/pdc/runManualScheduler")
				.permitAll()
				
				.antMatchers("/")
				.hasAnyAuthority("ADMIN")
				.anyRequest()
				.authenticated()
				.and()
				.csrf()
				.disable()
				.formLogin().loginPage("/dci/login")
				.failureHandler(authenticationFailureHandler)
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.logout()
				.permitAll()
				.deleteCookies("JSESSIONID")
				.logoutRequestMatcher(
						new AntPathRequestMatcher("/dci/logout"))
				.logoutSuccessHandler(userLogoutSuccessHandler)
				.invalidateHttpSession(false)
				.and().sessionManagement()
				.invalidSessionUrl("/dci/login")
				.and().addFilter(userNamePasswordAuthenticationFilter());
		// http.addFilterAfter(expiredSessionFilter(),
		// SessionManagementFilter.class);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/webapp/**", "/static/**",
				"/css/**", "/js/**", "/img/**", "/fonts/**");
	}

	@Bean
	public UsernamePasswordAuthenticationFilter userNamePasswordAuthenticationFilter() {
		UsernamePasswordAuthenticationFilter uPAF = new UsernamePasswordAuthenticationFilter();
		uPAF.setAuthenticationDetailsSource(webAuthenticatorParam);
		try {
			uPAF.setAuthenticationManager(this.authenticationManagerBean());
			uPAF.setAuthenticationSuccessHandler(successHandler());
			uPAF.setAuthenticationFailureHandler(authenticationFailureHandler);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uPAF;
	}

	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler successHandler() {
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setDefaultTargetUrl("/");
		successHandler.setAlwaysUseDefaultTargetUrl(true);
		return successHandler;
	}

	/*
	 * private Filter expiredSessionFilter() {
	 * if(SecurityContextHolder.getContext().getAuthentication() != null){
	 * UserDetails userDetails =
	 * (UserDetails)SecurityContextHolder.getContext().
	 * getAuthentication().getPrincipal(); }
	 * 
	 * SessionManagementFilter smf = new SessionManagementFilter(new
	 * HttpSessionSecurityContextRepository());
	 * smf.setInvalidSessionStrategy((request, response) ->
	 * response.sendRedirect("/loginagain")); return smf; }
	 */

}