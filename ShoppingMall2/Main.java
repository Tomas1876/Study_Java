package ShoppingMall2;

/*간단 시나리오
주제: 쇼핑몰 층별 시설 찾는 프로그램
쇼핑몰의 층마다 1 할배돈까스 2 덕자네방앗간 3 나뚜루 등 번호+시설이 있다
지도로 층을 선택할 수 있다 넘버로 시설을 검색할 수 있다
시설 객체에는 시설의 위치, 상호, 영업시간 등의 정보가 들어있고
사용자는 원하는 정보를 검색해 쓸 수 있으며 즐겨찾기에 저장할 수 있다
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class Main {
    
    public static void main(String[] args) {     
        
    	// 각 층을 담을 배열
        ArrayList<HashMap<Integer, Shop>> floors = new ArrayList<HashMap<Integer, Shop>>();
        
        HashMap<Integer, Shop> floor1 = new HashMap<Integer, Shop>();
        
        floor1.put(0, new Donkatsu());
        floor1.put(1, new IceCream());
        floor1.put(2, new Bread());
        
        HashMap<Integer, Shop> floor2 = new HashMap<Integer, Shop>();
       
        floor2.put(0, new Roem());
        floor2.put(1, new Kyobo());
        
        HashMap<Integer, Shop> floor3 = new HashMap<Integer, Shop>();
        
        floor3.put(0, new Cgv());
        floor3.put(1, new MBox());
        
        floors.add(floor1);
        floors.add(floor2);
        floors.add(floor3);
 
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("*****비트 쇼핑몰 층별 안내 시스템에 오신 것을 환영합니다*****");
        System.out.println("원하시는 메뉴를 선택해주세요.");
        System.out.println("1. 층별안내 2. 나가기");
        System.out.println("***********************************************");
        int menu = scanner.nextInt();
        
        switch(menu) {
        case 1:
           	int floornumber = 0;        
        	while(floornumber == 0 ) {       
        		System.out.println("안내를 원하시는 층을 선택해주세요. 1. 1층 식당 2. 2층 패션, 도서 3. 3층 시네마");
        
        		floornumber = scanner.nextInt();
        	
        		while(floornumber > floors.size() || floornumber <= 0) {
        			System.out.println("잘못 입력하셨습니다.");
        			System.out.println("안내를 원하시는 층을 선택해주세요. 1. 1층 2. 2층 3. 3층");
        			floornumber = scanner.nextInt();
        		}
        
        		System.out.println("안내를 원하시는 매장을 선택해주세요.");
        		
        		//층을 선택하면 매장 넘버(키)로 매장정보(밸류) 찾을 수 있게 해쉬맵
        		HashMap<Integer, Shop> guide = (HashMap<Integer, Shop>)floors.get(floornumber-1);      
        		for(int i = 0; i < guide.size(); i++) {
        		System.out.println(i+1+"번 : "+guide.get(i).name);
        		}
        		int storenumber = scanner.nextInt();
        
        		while( storenumber > floors.get(floornumber-1).size() || storenumber <=0 ) {
        			System.out.println("잘못 입력하셨습니다.");
        			System.out.println("안내를 원하시는 매장을 선택해주세요.");
        			storenumber = scanner.nextInt();       		
        		} 
        		
        		Shop store = guide.get(storenumber-1);
            
        		System.out.println(store.toString()); 
        		
        		System.out.println("즐겨찾기에 저장하시겠습니까? 저장하시려면 1을 입력해주세요.");
        		
        		int save = scanner.nextInt();
        		
        		if( save == 1) {
        			
        			File file = new File("bookmark.txt");
        			
        			try {
        				
        				FileOutputStream fos = new FileOutputStream(file, true);
        				BufferedOutputStream bos = new BufferedOutputStream(fos);
        				ObjectOutputStream oos = new ObjectOutputStream(fos);
        				
        				oos.writeObject(store.toString());
        				
        				bos.close();
        				oos.close();
        				fos.close();
        				System.out.println("저장되었습니다.");
						
					} catch (Exception e) {
						System.out.println("저장에 실패했습니다.");
						e.printStackTrace();
					}
        			
        			
        		}

        	}
        	break;
        	/*
		case 2:
			
			System.out.println("즐겨찾기에 저장하신 매장을 불러옵니다.");
			
			File file = new File("bookmark.txt");
			
			try {
				FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream oos = new ObjectInputStream(fis);
				
				//System.out.println(oos);
				
				oos.close();
				fis.close();
				
			} catch (Exception e) {
				System.out.println("불러오는데 실패하였습니다.");
				e.printStackTrace();
			}

			*/
		case 2: System.out.println("이용해주셔서 감사합니다.");
        	break;
        }
        
        scanner.close();
        
    }
    
}


