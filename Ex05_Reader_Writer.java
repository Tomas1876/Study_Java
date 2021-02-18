import java.io.FileReader;
import java.io.FileWriter;

/*

기존에 썼던 Stream은 1byte만 허용하니 한글처리 등이 문제라서
문자기반의 데이터를 처리할 수 있는(String) 것이 필요
String은 사실 char의 배열이니 Stream이 아닌 어떤 것이 필요

한글 한 글자든 영문 한 글자든 다 처리할 수 있도록

추상 클래스 REader, Writer
앞에 대상의 이름을 붙인다(File을 읽고 쓸 땐 FileReader FileWritwe)

 */
public class Ex05_Reader_Writer {

	public static void main(String[] args) {


		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			
			fr = new FileReader("Ex01_Stream.java");
			fw = new FileWriter("copy_Stream.txt");
			
			int data = 0;
			while((data = fr.read())!= -1) {
				//System.out.print((char)data);
				
				// 웹상에 배포하는 파일은 압축된 형태다
				// 여기서 압축이란 알집이 아니고, 엔터와 공백, 스페이스가 없는 파일을 의미
				if(data != '\n' && data != '\r' && data != '\t' && data != ' '){
					// \r는 엔터를 의미한다
					fw.write(data);					
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			try {
				fw.close();
				fr.close();
			} catch (Exception e2) {
				
			}
		}

	}

}
