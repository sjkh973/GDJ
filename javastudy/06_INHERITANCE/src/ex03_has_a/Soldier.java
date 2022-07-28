package ex03_has_a;

public class Soldier extends Gun  {

	//필드
	private Gun gun;

	//메소드
	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
	public void reload(int bullet) { 
		  gun.reload(bullet); 
	}
	  
	public void shoot(int bullet) { 
		  gun.shoot(); 
	}
	 

}
