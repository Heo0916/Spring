package t_tok02;


//분리형 스마트폰  - 배터리 교체할 수 있음
public class BlackPhone implements Phone {
	private Battery battery;

	public BlackPhone() {
		this.battery = new Battery();
	}

	public BlackPhone(Battery battery) { // White 부분과 다른점
		super();
		this.battery = battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	@Override
	public void show() {
		System.out.println(this.getClass().getSimpleName() + ":" + battery.getName());
		
	}
	
	
	

}
