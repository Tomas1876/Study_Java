package ShoppingMall2;

// 쇼핑몰 부모클래스
public class Shop {
    
    String name;
    int floornumber;
    
    Shop(){
        
    }
    
    Shop(String name, int floornumber){
        this.name = name;
        this.floornumber = floornumber;
    }
   
}

// 1층 매장들
class Donkatsu extends Shop{

    Donkatsu() {
        super("할배돈까스", 1);
        // TODO Auto-generated constructor stub
    }

	@Override
	public String toString() {
		return "\n"+name + " / " +floornumber + 
				"층 F-1\n영업 시간 11:00~21:00\n등심, 안심, 눈꽃치즈돈까스";
	}

}

// 2층 매장들
class IceCream extends Shop{

    IceCream() {
        super("나뚜루", 1);
        // TODO Auto-generated constructor stub
    }
    @Override
	public String toString() {
		return "\n"+name + " / " +floornumber + 
				"층 F-2\\n영업 시간 11:00~21:00\n입 안에서 퍼지는 향긋하고 시원한 풍미";
	}
}

class Bread extends Shop{

    Bread() {
        super("파리바게트", 1);
        // TODO Auto-generated constructor stub
    }
    @Override
	public String toString() {
		return "\n"+name + " / " +floornumber + 
				"층 F-3\n영업 시간 11:00~21:00\n 갓 구운 빵과 부드러운 크림";
	}
}

class Roem extends Shop{

    Roem() {
        super("로엠", 2);
        // TODO Auto-generated constructor stub
    }
    @Override
	public String toString() {
		return "\n"+name + " / " +floornumber + 
				"층\n러블리쿨 여성 오피스룩";
	}
}

class Kyobo extends Shop{

    Kyobo() {
        super("교보문고", 2);
        // TODO Auto-generated constructor stub
    }
    @Override
	public String toString() {
		return "\n"+name + " / " +floornumber + 
				"층\n대한민국 1등 서점";
	}
}

// 3층 영화관
class Cgv extends Shop{

    Cgv() {
        super("Cgv", 3);
        // TODO Auto-generated constructor stub
    }
    @Override
	public String toString() {
		return "\n"+name + " / " +floornumber + 
				"층\n오늘도 CGV하세요";
	}
}

class MBox extends Shop{

    MBox() {
        super("메가박스", 3);
        // TODO Auto-generated constructor stub
    }
    @Override
	public String toString() {
		return "\n"+name + " / " +floornumber + 
				"층\n오늘 팝콘각? ㄴㄴ 메가박스각!";
	}
}