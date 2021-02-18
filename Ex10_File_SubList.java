
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ex10_File_SubList {
	
	// 사실 공유자원으로 쓸 건 아니라서 static 안 써도 되는데
	// 객체 생성 안 하려고 임의로 static 설정
	static int totalfiles = 0;
	static int totaldirs = 0;
	
	public static void main(String[] args) {

		if(args.length != 1) {
			System.out.println("사용법 : java [실행할 파일명][경로명]");
			System.out.println("예시 : java EX10_File_Sublist C:\\Temp");
			System.out.println
			("!!주의!! C:\\Users\\bitcamp\\eclipse-workspace\\Ex09_IO\\bin에 들어가서 실행할것");
			System.exit(0);
		}
		File f = new File(args[0]);
		if( !f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 경로");
			System.exit(0);
		}
		
		// 여기까지 내려오면 정상적인 경로고 폴더라는 것이 확인 되었음
		printFileList(f);
		System.out.println("누적폴더수 : " + totaldirs);
	    System.out.println("누적파일수 : " + totalfiles);

	
	}
	
	static void printFileList(File dir) {
		System.out.println("[Full path : ]" + dir.getAbsolutePath());
		
		List<Integer> subdir = new ArrayList<Integer>();
		File[] files = dir.listFiles();
		
		// [0] > a.txt
		// [1] > 1.jpg
		// [2] > 2012 폴더
		// [3] > 2022 폴더
		// 파일은 그냥 정보를 출력하면 되는데 폴더는 한 번 더 들어가야 한다
		
		for(int i = 0; i < files.length; i++) {
			String filename = files[i].getName();
			
			if(files[i].isDirectory()) {
				filename = "<DIR> <" + filename +">";
				
				//POINT
				subdir.add(i);
				// 위의 리스트가 가지고 있는 인덱스 값은 2와 3이다(폴더만 담으니까)
				
				
			}else {
				filename = filename + " / " + files[i].length() + "BYTE";
			}
			int dirnum = subdir.size(); // 폴더의 갯수
			int filenum = files.length - dirnum; // 폴더의 갯수
			
			// 함수 종료돼도 저 수들을 저장하고 싶다면
			// static
			totaldirs += dirnum; //총 누적(하위폴더)
			totalfiles += filenum;
			
			System.out.println("[Current dirNum] : "+ dirnum);
			System.out.println("[Current fileNum] : "+filenum);
			
			System.out.println("******************************************");
			
			// 이제부터 재귀호출(내가 나를 부르는 것)을 해보자!
			// POINT
			// 폴더 안의 폴더(하위 폴더)도 보려면?
			
			for(int j = 0; j < subdir.size(); j++) {
				int index = subdir.get(j);
				
				printFileList(files[index]);
				//이건 이것과 같다
				// printFileList(C:\\Temp\\2021);
				// printFileList(C:\\Temp\\2022);
				
				
			}
		}
		
	}

}
