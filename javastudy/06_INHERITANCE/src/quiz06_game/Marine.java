package quiz06_game;

public class Marine extends GameUnit{

	public Marine(String name) {
		super(name, 50, 5);
	}

	@Override
	public void attack(GameUnit unit) {
		// 내 에너지 : getEnergy(), this.getEnergy()
		// 내 공격력 : getPower(), this.getPower()
		// 내 이름   : getName(), this.getName
		// 상대 에너지 : unit.getEnergy();
		// 상대 공격력 : unit.getPower();
		// 상대 이름   : unit.getName();
		
		// 40%확률로 KO시킬수 있다.
		if(Math.random() < 0.2) {
			unit.setEnergy(0);
			unit.setAlive(false);
			System.out.println(unit.getName() + " 를 한방에 죽였다.");
		} else {
			int unitEnergy = unit.getEnergy() - getPower() < 0 ? 0 : unit.getEnergy() - getPower();
			unit.setEnergy(unitEnergy);
			unit.setAlive(unitEnergy > 0);
			System.out.println(unit.getName() + "의 남은 에너지" + unit.getEnergy());
		} 
	}
}
