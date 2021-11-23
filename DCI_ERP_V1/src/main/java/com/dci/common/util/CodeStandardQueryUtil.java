package com.dci.common.util;

public class CodeStandardQueryUtil {
	/************* For Code Standard ******/

	public static String GETCODESTANDARDCOUNTBYCODENAME = "SELECT count(*) FROM code_standard WHERE code_name = ?";
	public static String GETCODESTANDARDBYID = "SELECT * FROM code_standard WHERE code_standard_id=?";
	public static String GETCODESTANDARDALL = "SELECT AGING as codeStandardId,MLO_NAME as codeName,MLO_NAME as description FROM AR_REG where ROWNUM <= 100";
	public static String GETCODESTANDARDALLBYID = "SELECT code_name,description,code_standard_id FROM code_standard where code_standard_id IN(:code_standard_ids) ORDER BY code_standard_id";

	public static String ADDCODESTANDARD = "INSERT INTO  code_standard(code_name,description,is_company) VALUES (?,?,?)";
	public static String DELETECODESTANDARD = "DELETE FROM code_standard WHERE code_standard_id = ?";
	public static String UPDATECODESTANDARD = "UPDATE code_standard SET description = ? WHERE code_standard_id=?";

	/*public static void main(String args[]) {
		for (int i = 0; i < 10000; i++) {
			System.out.println("INSERT INTO code_standard(code_name,description,is_company) VALUES ('Company" + i + "', 'Desc', true);");
		}
	}*/
}
