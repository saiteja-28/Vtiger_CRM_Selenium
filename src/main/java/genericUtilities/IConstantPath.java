package genericUtilities;
/**
 * This Interface contains the External file Paths
 * @author Sai_Teja
 */

public interface IConstantPath {

	String PROPERTIES_PATH = System.getProperty("user.dir") + "/src/test/resources/VtigerCRM_commonData.properties";
	String EXCEL_PATH = System.getProperty("user.dir") + "/src/test/resources/VtigerCRMTestData.xlsx";
	String JDBC_URL = "jdbc:mysql://localhost:3306/advsel_a2";
}
