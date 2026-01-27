package enemy;

public class Enemy {
  private String type;
  private int health;
  private int damage;
  private int droploot;

  public Enemy(String typei, int healthi, int damagei, int droplooti) {
    this.type = typei;
    this.health = healthi;
    this.damage = damagei;
    this.droploot = droplooti;
  }

  public int getDamage(){
   return this.damage;
  }

  public int getHealth(){
    return this.health;
  }

  public String getType(){
    return this.type;
  }

  public int dealdamage(int damagedealt){
    this.health = this.health - damagedealt;
    return this.health;
  }

  public int getloot(){
    return this.droploot;
  }
}
