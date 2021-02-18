import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex06_Reader_Writer_Buffer_Lotto {
	public static void main(String[] args){
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");
			br = new BufferedReader(fr);
			// 한 번에 버스에 태워서 보내겠다는 뜻
			
			// buffer는 Line 단위로 처리가 가능하다
			// 그러니까 (엔터)줄 단위로 읽고 쓸 수 있다
			// 아래는 공식같은 로직에서 조금 벗어난 형태
			
			String line = "";
			for(int i = 0; (line = br.readLine()) != null; i++) {
				//System.out.println(line);
				// 원래 println이면 한 글자씩만 한 줄에 나오는데
				// line단위로 하니까 우리가 그냥 글 쓰고 엔터친 것처럼 라인단위로 나온다
				
				if(line.indexOf(";") != -1) {
					System.out.println(line);
					//이러면 ;이 포함된 라인만 출력됨
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
			try {
				br.close();
				fr.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
	}
	

}
