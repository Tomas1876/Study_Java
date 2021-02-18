import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex03_Stream_imageCopy {

	public static void main(String[] args) {
		String orfile = "C:\\Temp\\1.jpg";
		String tarfile = "copy.jpg";
		// 파일을 생성할 때 어떤 경로도 설정하지 않으면
		// 프로젝트 폴더가 디폴트로 설정됨
		// C:\Users\bitcamp\eclipse-workspace\Ex09_IO\copy.jpg
		
		FileInputStream fs = null;
		FileOutputStream fo = null;
		// 위 두 코드를 try 안에 선언하며 try블록 안에서만 유효하기 때문에 밖으로 빼는 것

		
		try {
			
			fs = new FileInputStream(orfile);
			fo = new FileOutputStream(tarfile,false);
			
			int data = 0;
			while((data = fs.read()) != -1) {
				fo.write(data);
			}
			
		} catch(Exception e){
			System.out.println(e.getMessage());
		}  finally {
			try {
				fs.close();
				fo.close();
				
			} catch( Exception e) {
				
			}
		}
		
		

	}

}
