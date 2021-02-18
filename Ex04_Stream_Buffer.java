import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*

File 처리할 때 가장 오래 걸리는 작업이 뭘까? 디스크에 쓰는 작업

원칙은 1Byte씩 read&write
즉 10글자(영어기준)을 쓰면 열 번 해야 한다
hello를 입력한다면 가서 h쓰고 다시 오고 다시 가서 e쓰고 다시 온 다음......

한 번에 쭉 쓰고 오면 안되겠니

일단 버스 대절해서 데이터를 다 태운다 버스 용량만큼
여기서 버스는 버퍼 캐시다
데이터의 양이 버퍼 캐시의 용량보다 크면 몇 번 왔다갔다 해야겠지만
원칙 보단 낫잖아

Buffer의 장점

1. IO의 횟수가 줄어든다(=성능이 좋아진다)

2. Line 단위로 읽고 쓸 수 있다(엔터 기준)

BufferedInputStream : 보조 스트림(혼자 못 쓰고 다른 것과 함께 써야 함 주 클래스에 의존)
					성능을 높이기 때문에 개발자는 의무적으로 사용함

 */
public class Ex04_Stream_Buffer {

	public static void main(String[] args) {

		FileOutputStream fos = null; // 주 스트림
		BufferedOutputStream bos = null; // 보조 스트림
		
		try {
			
			fos = new FileOutputStream("data.txt");
			// data가 없으면 파일도 생성하고 write도 한다
			// 근데 성능 별로니까 버스 부르장
			
			bos = new BufferedOutputStream(fos);
			// 보조 스트림이 혼자 못 쓰이는 이유는
			// 디폴트 생성자가 없기 때문이다 파라미터가 있어야 한다
			// 주 스트림을 파라미터로 받는다
			
			for(int i = 0; i < 10; i++) {
				bos.write('A');
				
				// JAVA Buffer의 크기  : 8kByte(8192byte)
				// Buffer비우는 방법(flush)
				// 1. 8kByte가 다 채워지면 스스로 비운다(자동)
				// 2. 명시적으로 flush() 호출(강제)
				// 3. bos.close(); 자원해제(자동)
				// 3번을 제일 많이 쓴다
				
				
			}
		} catch(Exception e) {
			
		} finally {
			
			try {
				bos.close();
				fos.close();
			} catch (Exception e2) {
				
			}
		}
		
		
		
	}

}
