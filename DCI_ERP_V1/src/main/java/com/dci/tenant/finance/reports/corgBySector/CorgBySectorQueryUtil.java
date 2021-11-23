package com.dci.tenant.finance.reports.corgBySector;

public class CorgBySectorQueryUtil  {
	
	public static String ContianerValue = "select payer_short_name, A.*, os_amount from "
							+ "( "
							+ " select customer, "
							+ " sum(case when sector = 'FMX1 - SIN HUB' then invamt else 0 end) as FMX1___SIN_HUB, sum(case when sector = 'IGI' then invamt else 0 end) "
							+ " as IGI, sum(case when sector = 'UGS' then invamt else 0 end) as UGS, sum(case when sector = 'INDIA FAR EAST 01' then invamt else 0 end)"
							+ " as INDIA_FAR_EAST_01, sum(case when sector = 'CISC' then invamt else 0 end) as CISC, sum(case when sector = 'ASEAN-GULF-ISC' then invamt"
							+ " else 0 end) as ASEAN_GULF_ISC, sum(case when sector = 'BMS' then invamt else 0 end) as BMS, sum(case when sector = 'KGS' then invamt"
							+ " else 0 end) as KGS, sum(case when sector = 'PGL1' then invamt else 0 end) as PGL1, sum(case when sector = 'RESUPG' then invamt else 0 end)"
							+ " as RESUPG, sum(case when sector = 'IWCS' then invamt else 0 end) as IWCS, sum(case when sector = 'IGX' then invamt else 0 end) as "
							+ " IGX, sum(case when sector = 'SIF' then invamt else 0 end) as SIF, sum(case when sector = 'KDS' then invamt else 0 end) as KDS,"
							+ " sum(case when sector = 'CMX' then invamt else 0 end) as CMX, sum(case when sector = 'APG' then invamt else 0 end) as APG, "
							+  " sum(case when sector = 'MINA' then invamt else 0 end) as MINA, sum(case when sector = 'GIS' then invamt else 0 end) as GIS,"
							+ " sum(case when sector = 'UAE-ASA' then invamt else 0 end) as UAE_ASA, sum(case when sector = 'KCS' then invamt else 0 end) "
							+ " as KCS, sum(case when sector = 'ASX' then invamt else 0 end) as ASX, sum(case when sector = 'PGX' then invamt else 0 end) as"
							+ " PGX, sum(case when sector = 'ADHOC8' then invamt else 0 end) as ADHOC8, sum(case when sector = 'TCT' then invamt else 0 end) "
							+ " as TCT, sum(case when sector = 'JUX' then invamt else 0 end) as JUX, sum(case when sector = 'BWS' then invamt else 0 end) as BWS,"
							+ " sum(case when sector = 'UAE-SOHAR' then invamt else 0 end) as UAE_SOHAR, sum(case when sector = 'LST' then invamt else 0 end) as "
							+ " LST, sum(case when sector = 'MASIIKA' then invamt else 0 end) as MASIIKA, sum(case when sector = 'ADHOC' then invamt else 0 end)"
							+ " as ADHOC, sum(case when sector = 'MISC' then invamt else 0 end) as MISC, sum(case when sector = 'AIM' then invamt else 0 end) as "
							+ " AIM, sum(case when sector = 'ADHOC1' then invamt else 0 end) as ADHOC1, sum(case when sector = 'AD-HOC' then invamt else 0 end) as"
							+ " AD_HOC, sum(case when sector = '#' then invamt else 0 end) as _, sum(case when sector = 'LYG DLN TAO ADHOC' then invamt else 0 end)"
							+ " as LYG_DLN_TAO_ADHOC, sum(case when sector = 'JKS' then invamt else 0 end) as JKS, sum(case when sector = 'KAOHSIUNG CHINA SOUTH "
							+ " EAST ASIA SVC' then invamt else 0 end) as KAOHSIUNG_CHINA_SOUTH_EAST_ASIA_SVC, sum(case when sector = 'CIX2' then invamt else 0 end) "
							+ " as CIX2, sum(case when sector = 'ME2' then invamt else 0 end) as ME2, sum(case when sector = 'CCG SERVICE' then invamt else 0 end) as"
							+ " CCG_SERVICE, sum(case when sector = 'NMG' then invamt else 0 end) as NMG, sum(case when sector = 'GEX' then invamt else 0 end) as GEX"
							+ ", sum(case when sector = 'IFX2' then invamt else 0 end) as IFX2, sum(case when sector = 'PSX' then invamt else 0 end) as PSX, "
							+ " sum(case when sector = 'K-M-S' then invamt else 0 end) as K_M_S, sum(case when sector = 'COASTAL' then invamt else 0 end) as COASTAL, "
							+ " sum(case when sector = 'PSG' then invamt else 0 end) as PSG, sum(case when sector = 'UAE-UMQ' then invamt else 0 end) as UAE_UMQ, "
							+ " sum(case when sector = 'INDIA FAR EAST EXPRESS 2' then invamt else 0 end) as INDIA_FAR_EAST_EXPRESS_2, sum(case when sector = 'AGI'"
							+ " then invamt else 0 end) as AGI, sum(case when sector = 'SJS' then invamt else 0 end) as SJS, sum(case when sector = 'FIX' "
							+ " then invamt else 0 end) as FIX, sum(case when sector = 'AGIS' then invamt else 0 end) as AGIS, sum(case when sector = 'LYG'"
							+ " then invamt else 0 end) as LYG, sum(case when sector = 'AMI' then invamt else 0 end) as AMI, sum(case when sector = 'CMS'"
							+ " then invamt else 0 end) as CMS, sum(case when sector = 'UAE-UPG' then invamt else 0 end) as UAE_UPG, sum(case when sector ="
							+ " 'GALEX' then invamt else 0 end) as GALEX, sum(case when sector = 'JDS' then invamt else 0 end) as JDS, sum(case when sector = "
							+ "'MISA' then invamt else 0 end) as MISA, sum(case when sector = 'INDIA FAR EAST EXPRESS' then invamt else 0 end) as INDIA_FAR_EAST_EXPRESS,"
							+ " sum(case when sector = 'ADHOC-SIN' then invamt else 0 end) as ADHOC_SIN, sum(case when sector = 'INDIAN SUBCONTINENT BANGLADESH SERVICE' "
							+ " then invamt else 0 end) as INDIAN_SUBCONTINENT_BANGLADESH_SERVICE, sum(case when sector = 'IGS1' then invamt else 0 end) as IGS1, "
							+ " sum(case when sector = 'CIX' then invamt else 0 end) as CIX, sum(case when sector = 'IFX01' then invamt else 0 end) as IFX01,"
							+ " sum(case when sector = 'FMX2' then invamt else 0 end) as FMX2, sum(case when sector = 'DJS' then invamt else 0 end) as DJS,"
							+ " sum(case when sector = 'IBS' then invamt else 0 end) as IBS, sum(case when sector = 'SMX2' then invamt else 0 end) as SMX2,"
							+ " sum(case when sector = 'UAE-DOHA' then invamt else 0 end) as UAE_DOHA, sum(case when sector = 'SYM/MYS' then invamt else 0 end)"
							+ " as SYM_MYS, sum(case when sector = 'IFX' then invamt else 0 end) as IFX, sum(case when sector = 'SMILE' then invamt else 0 end) "
							+ " as SMILE "
							+ " from (select * from vw_customer_vs_sector(null, 2016, 20)) T "
							+ " group by customer "
							+ " ) A "
							+ " left join   vw_customer_vs_sector_os(null, 2016, 20) B using (customer) "
							+ " left join payer_master P on customer = acct_head_code";
	
	public static String SECTOR_BY_COMPANY = "SELECT * FROM vw_customer_vs_sector_query(?,?,? )";
	
	public static String CORG_PROFIT = "select * from vw_sectorwise_rev_exp_vol_weight(?, ?, ?)";
	
	public static String DUBAI_COMPANY = "select * from vw_corg_by_sector_dxb(?, ?, ?, ?)";
	
	public static String SIN_COMPANY = "select * from vw_corg_by_sector_sin(?, ?, ?, ?)";
	
	public static String DUBAI_COMPANY_BY_VOL = "select description, coalesce(igi,0) igi,coalesce(asx,0) asx,coalesce(ccg,0) ccg,coalesce(kds,0) kds,coalesce(upg,0) upg,coalesce(jks,0) jks,coalesce(uae_umq,0) uae_umq,coalesce(bms,0) bms,coalesce(coastal,0) coastal,coalesce(iwcs,0) iwcs,coalesce(misc,0) misc from vw_corg_by_sector_revw_dxb( ?, ?, ?,?)";
	
	public static String SIN_COMPANY_BY_VOL = "select description, coalesce(agi,0) agi,coalesce(cisc,0) cisc,coalesce(ibs,0) ibs,coalesce(ifx,0) ifx,coalesce(ifx01,0) ifx01,coalesce(ifx2,0) ifx02,coalesce(scs,0) scs,coalesce(fme,0) fme,coalesce(misc,0) misc from vw_corg_by_sector_revw_sin( ?, ?, ?,?)";
	
	
}