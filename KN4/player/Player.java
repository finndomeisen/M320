package player;

public class Player {
  private String name;
  private int passivHealSkill;
  private int health;

  public Player(String name, int healthi){
    this.name = name;
    this.passivHealSkill = 10;
    this.health = healthi;
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
