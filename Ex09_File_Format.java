import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Format {
	public static void main(String[] args) {
		File dir = new File("C:\\Temp");
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			File file = files[i];
			
			String name = file.getName();
			
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH-mma");
			
			//파일엔 속성이라는 것이 있다
			String attribute = "";
			String size = "";
			
			if(files[i].isDirectory()) {
				attribute = "<DIR>";
			} else {
				size = file.length() + "byet";
				attribute = file.canRead() ? "R" : "";
				attribute += file.canWrite() ? "W" : "";
				attribute += file.isHidden() ? "H" : "";
			}
			
			System.out.printf("%s   %3s   %10s   %s \n",
								dt.format(new Date(file.lastModified())),
								attribute,			// 마지막으로 수정된 날짜를 구하는 함수
								size,
								name);
		}
	}
        

}
