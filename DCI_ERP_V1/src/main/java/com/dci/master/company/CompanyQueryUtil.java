package com.dci.master.company;

public class CompanyQueryUtil {
	
	public static final String list = "select  company_code as company_code,company_name as company_name,location as location,address as address,telephone_no as  telephone_no,currency as currency,short_name as short_name,fax_no as fax_no,email as email,person_incharge as person_incharge,relationship as relationship,"
			+ "    intercompanygroup as intercompanygroup,vat_reg_no as vat_reg_no from company_master";

	public static final String INSERT = "	insert into company_master (company_code,company_name,location,address,telephone_no,currency,short_name,fax_no,email,person_incharge,relationship,intercompanygroup,vat_reg_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String UPDATE = "update company_master set company_name=?,location=?,address=?,telephone_no=?,currency=?,short_name=?,fax_no=?,email=?,person_incharge=?,relationship=?,intercompanygroup=?,vat_reg_no=? where company_code=?";

	public static final String delete = "delete from company_master where company_code=?";

	public static final String GET_COMPANY = "select  company_code as company_code,company_name as company_name,location as location,address as address,telephone_no as  telephone_no,currency as currency,short_name as short_name,fax_no as fax_no,email as email,person_incharge as person_incharge,relationship as relationship,"
			+ "    intercompanygroup as intercompanygroup,vat_reg_no as vat_reg_no from company_master where company_code=?";
    
	public static final String GENERATE_COMPANY_CODE =" SELECT  case when (select max(company_code)from company_master where company_code~*?) is null then '0001' ELSE   lpad(cast(cast((SUBSTRING((select max(company_code) from company_master where company_code~*?),2)) as int)+1  as text),4,'0')  END";
	
	public static final String  GETCountrylist ="select distinct country_code as id,  (coalesce(country_code,'-')|| '-' || coalesce(country_name,'-')) as text,country_name  from country_master order by country_name asc";

	public static final String  GETCurrencylist ="select distinct currency_code as id,CONCAT(currency_code,'-', currency_name )as text from currency_master  order by currency_code asc ";

}

