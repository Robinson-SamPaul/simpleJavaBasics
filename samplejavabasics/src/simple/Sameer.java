package simple;

public class Sameer {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		String s = "      <STUB_LINE AMSDataObject=\"Y\">\r\n"
				+ "         <VEND_INV_NO Attribute=\"Y\"><![CDATA[   ]]></VEND_INV_NO>\r\n"
				+ "         <VEND_INV_LN_NO Attribute=\"Y\"><![CDATA[   ]]></VEND_INV_LN_NO>\r\n"
				+ "         <VEND_INV_DT Attribute=\"Y\"><![CDATA[   ]]></VEND_INV_DT>\r\n"
				+ "         <RFED_DOC_CD Attribute=\"Y\"><![CDATA[   ]]></RFED_DOC_CD>\r\n"
				+ "         <RFED_DOC_DEPT_CD Attribute=\"Y\"><![CDATA[   ]]></RFED_DOC_DEPT_CD>\r\n"
				+ "         <RFED_DOC_ID Attribute=\"Y\"><![CDATA[   ]]></RFED_DOC_ID>\r\n"
				+ "         <DESC Attribute=\"Y\"><![CDATA[   ]]></DESC>\r\n"
				+ "         <AMOUNT Attribute=\"Y\"><![CDATA[   ]]></AMOUNT>\r\n"
				+ "         <PYMT_RQST_CD Attribute=\"Y\"><![CDATA[   ]]></PYMT_RQST_CD>\r\n"
				+ "         <PYMT_RQST_DEPT_CD Attribute=\"Y\"><![CDATA[   ]]></PYMT_RQST_DEPT_CD>\r\n"
				+ "         <PYMT_RQST_DOC_ID Attribute=\"Y\"><![CDATA[   ]]></PYMT_RQST_DOC_ID>\r\n"
				+ "         <PYMT_RQST_FUND_NM Attribute=\"Y\"><![CDATA[   ]]></PYMT_RQST_FUND_NM>\r\n"
				+ "      </STUB_LINE>";
		Object a = s;
		String b = a.toString();
		System.out.println(b);
	}
	

}