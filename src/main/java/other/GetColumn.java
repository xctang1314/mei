package other;
import java.io.File; 
import java.io.IOException; 
import jxl.Sheet; 
import jxl.Workbook; 
import jxl.read.biff.BiffException; 
  
public class GetColumn { 
	public static int getSheetCellNum(String str){
		File f=new File(str); 
		 
		  Workbook book = null;
		try {
			book = Workbook.getWorkbook(f);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 
		  Sheet sheet=book.getSheet(0); //获得第一个工作表对象 
		  
		   int j=sheet.getColumns(); 
		   
		return j;
	}
}