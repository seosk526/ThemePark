package themepark0419;

import java.io.File;
import java.util.Calendar;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class SaveOrder {
	static File file = new File("C:\\Users\\강세영\\Desktop\\test.txt");
	static FileWriter fw = null;
	static BufferedWriter br = null;
	static Calendar cal = Calendar.getInstance();
	
	public static void head() throws IOException {
		String title = "날짜 권종 연령구분 수량 가격 우대사항 ";
		fw = new FileWriter(file);
		br = new BufferedWriter(new FileWriter(file));
		if (file.exists() == false){
			br.newLine();
			br.close();
		} else {
			br.write(title);
			br.newLine();
			br.close();
		} 
	}
	
	public static void date() throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		fw = new FileWriter(file, true);
		br = new BufferedWriter(fw);
		br.write(df.format(cal.getTime()) + ", ");
		br.close();
	}
	
	public static void list(String str) throws IOException {
		fw = new FileWriter(file, true);
		br = new BufferedWriter(fw);
		br.write(str + ", ");
		br.close();		
	}
	
	public static void reason(String str) throws IOException {
		fw = new FileWriter(file, true);
		br = new BufferedWriter(fw);
		br.write(str);
		br.newLine();
		br.close();		
	}	
}
