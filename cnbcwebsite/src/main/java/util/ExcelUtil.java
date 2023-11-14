package util;

import java.util.ArrayList;

import util.*;

public class ExcelUtil {
	static xls_reader reader;
	
	
	public static ArrayList<Object[]> getDataFromExcel(){

			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
			try {
				reader = new xls_reader("./src/main/java/testdata/TestData.xlsx");
				System.out.println(reader);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			for (int rowNum = 2; rowNum <= reader.getRowCount("contacts"); rowNum++) {
				System.out.println(reader);
				

					String firstName = reader.getCellData("contacts", "firstname", rowNum);
					String lastName = reader.getCellData("contacts", "lastname", rowNum);
					String email = reader.getCellData("contacts", "email", rowNum);
					String oldpwd = reader.getCellData("contacts", "oldpwd", rowNum);
					String newpwd = reader.getCellData("contacts", "newpwd", rowNum);
					String cpwd = reader.getCellData("contacts", "cpwd", rowNum);
				
					Object ob[] = {firstName, lastName, email,oldpwd,newpwd,cpwd};
					myData.add(ob);
					
			}
			return myData;
		
	}
	
	
	
	

}