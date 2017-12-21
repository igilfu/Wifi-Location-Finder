package Filter;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import Objects.Row;
import Read_Write.ReadAndWriteCSV;
import Read_Write.WriteToKML;

public class Q3 {
	/** 
	 * This function get a path with the file we created in q2.
	 * then it's upload it to list by the function ReadFileIntoList3
	 * and then send it to filter,and after create a kml file
	 * @param srcPath
	 * @param desPath
	 * @param desPathAfterFilterKML 
	 * @throws ParseException
	 */

	public void ReadFile(String srcPath, String desPathAfterFilterCSV, String desPathAfterFilterKML) throws ParseException
	{
		File file = new File(srcPath);		
		ReadAndWriteCSV read = new ReadAndWriteCSV();

		List<Row> listInput = new ArrayList<Row>();  
		listInput = read.ReadFileIntoList3(file.getPath());
		List<Row> listOutput = new ArrayList<Row>();  	

		if(!listInput.isEmpty()){
			System.out.println("-------");
			Filter f = new Filter();
			listOutput = f.filter(listInput,listOutput,desPathAfterFilterCSV);	
		}
		/**
		 * write the kml file		
		 */
		WriteToKML kml=new WriteToKML();
		kml.createKMLFile(listOutput,desPathAfterFilterKML);
	}

}