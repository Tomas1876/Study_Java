import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex06_Reader_Writer_Buffer {
	public static void main(String[] args) throws Exception{
		
		// 원래 main에 throw를 던지면 안되지만 지금 try 안 쓰고 해보자
		
		//Lotto
		FileWriter fw = new FileWriter("Lotto.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("로또");
		bw.newLine();
		
		bw.write("1,3,6,8,9");
		bw.newLine();
		bw.flush();
		

		
		
	}
	

}
