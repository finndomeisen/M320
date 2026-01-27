package player;

public class Player {
  private String name;
  private int passivHealSkill;
  private int health;
  private int money;

  public Player(String name, int healthi){
    this.name = name;
    this.passivHealSkill = 10;
    this.health = healthi;
    this.money = 5;
  }

  public int getMoney() {
    return money;
  }

  public void changeMoney(int addmoney) {
    this.money = this.money+addmoney;
  }

  public int changeHealth(int damageHeal){
    this.health = this.health + damageHeal;
    return  this.health;
  }

  public int getPassivHealSkill(){
    return this.passivHealSkill;
  }

  public int health(){
    return health;
  }

  public String getName(){
    return this.name;
  }
}
