
public class AustralianTraffic implements CentralTraffic {

	public static void main(String[] args) {
		CentralTraffic a =new AustralianTraffic();
		a.greenGo();
		a.redStop();
		a.FlashYellow();
		

	}

	@Override
	public void greenGo() {
		System.out.println("greenstop implementation");
		
	}

	@Override
	public void redStop() {
		System.out.println("redstop implementation");
		
	}

	@Override
	public void FlashYellow() {
		System.out.println("yellowstop implementation");
		
	}

}
