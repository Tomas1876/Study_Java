import java.io.File;

/*

파일과 폴더 다루는 클래스

JAVA : 파일, 폴더 하나의 클래스 File

 - a.txt 생성, 삭제, 정보 read
 - Temp 폴더 생성, 삭제, 정보 read
 
 C#은 파일클래스와 디렉토리 클래스가 나눠져있지만 자바는 아니다
 
절대경로와 상대경로
 
1. 절대경로
	: C:\\, D:\\,  >> C:\\Temp\\a.txt

2. 상대경로
	: 현재파일을 중심 ex) C:\\Test...../Temp/ 

 */
public class Ex07_File {

	public static void main(String[] args) {
		String path = "C:\\Temp\\file.txt"; 
		
		File f = new File(path);
		// File 클래스를 사용하면 file에 대한 다양한 정보를 얻을 수 있음
		
		System.out.println("파일명 : " + f.getName());
		// path에 담은 것에서 파일 이름만 뽑아줌
		
		System.out.println("전체경로 : " + f.getPath());
		// 전체 경로 뽑아줌
		System.out.println("절대경로 : " + f.getAbsolutePath());
		// 절대 경로 뽑아줌(지금은 똑같지만 파일이 드라이브 바로 아래에 있지 않으면 다름)
		
		System.out.println("너 폴더니? : "+ f.isDirectory());
		System.out.println("너 파일이니? : "+ f.isFile());
		// File 클래스가 파일, 폴더를 다 다루기 때문에 위 함수를 쓸 일이 꽤 있음
		
		System.out.println("파일의 크기 : "+ f.length());
		
		System.out.println("부모경로(상위경로) : "+ f.getParent());
		
		System.out.println("파일의 실 존재여부 : "+ f.exists());
		
		// 위에 쓴 함수들이 자주 쓰이고 아래는 추가
		// f.createNewFile() 파일생성
		// f.delete() 삭제
		// f.canRead() 읽을 수 있는 파일인지
		
		

	}

}
