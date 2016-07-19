package com.github.GitHub;

import java.io.File;
import java.lang.reflect.Method;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelHandler {
	
	public static void main(String [] args) throws Exception{
		
		File file = new File("DataSheet.xls");
		Workbook workBook = Workbook.getWorkbook(file);
		Sheet testcasesSheet = workBook.getSheet("TestCases");
		int testcasesSheetRows = testcasesSheet.getRows();
		Sheet githubLogin = workBook.getSheet("GitHubLogin");
		int gitHubLoginSheetRows = githubLogin.getRows();
		GitHubLogin gitHub = new GitHubLogin();
		Method gitHubMethods[] = gitHub.getClass().getMethods();
		for (int i = 0;i<testcasesSheetRows;i++){
			String testCasesID = testcasesSheet.getCell(0, i).getContents();
			String testCasesType = testcasesSheet.getCell(2, i).getContents();
			if(testCasesType.equals("yes")){
				for(int j = 0; j<gitHubLoginSheetRows; j++){
					String githubLoginID = githubLogin.getCell(0, j).getContents();
					if(githubLoginID.equalsIgnoreCase(testCasesID)){
						String gitHub_action = githubLogin.getCell(2, j).getContents();
						String gitHub_object = githubLogin.getCell(3, j).getContents();
						String gitHub_data = githubLogin.getCell(4, j).getContents();
						for(int k = 0; k<gitHubMethods.length;k++){
							if(gitHub_action.equals(gitHubMethods[k].getName())){
								gitHubMethods[k].invoke(k, gitHub_object,gitHub_data);
							}
						}
					}
				}
			}
		}
		workBook.close();
	}
}
