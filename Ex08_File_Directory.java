import java.io.File;

public class Ex08_File_Directory {
    public static void main(String[] args) {
        //args > Class Area 에 올라감과 동시에 받는 parameter
        //윈도우 cmd로 
        //System.out.println(args[0]);
        //System.out.println(args[1]);
        //System.out.println(args[2]);
        //if(args.length != 1) {
        //    System.out.println("사용법 : java 파일명 [디렉토리명]");
        //    System.exit(0); //강제종료
        //}
        File f = new File(args[0]);
        if(!f.exists() || !f.isDirectory()) { //존재하지않거나, 디렉토리가 아니라면
            System.out.println("유효하지 않은 경로입니다.");
            System.exit(0);
        }
        
        //실제 존재하는 경로의 폴더라면
        File[] files = f.listFiles(); //C:\Temp > Temp 폴더안에 파일, 폴더"들"이 있다.
        // C:\\Temp 폴더 안에 파일도 있고 폴더도 있는 것
        // 만약 Temp폴더 안에 a.txt, 참새폴더도 있다면 이 두 개가 모두 File 객체다
        // 두 개의 파일 객체가 존재하는 것 > File 클래스로 간주
        // 같은 타입 객체가 두 개니까 배열
        // Files[0] 에는 a.txt
        // Files[1] 에는 참새폴더가 들어있는 것

        for(int i=0;i<files.length;i++) {
            String name = files[i].getName(); //파일, 폴더의 이름 return
            System.out.println(files[i].isDirectory() ? "[DIR]" + name: name);
        }
    }
}