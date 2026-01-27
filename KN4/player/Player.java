package player;

import item.Loot;

import java.util.ArrayList;

public class Player {
  private String name;
  private int passivHealSkill;
  private int health;
  private int money;
  private ArrayList<Loot> inventory;

  public Player(String name, int healthi){
    this.name = name;
    this.passivHealSkill = 10;
    this.health = healthi;
    this.money = 5;
  }

  public ArrayList<Loot> getInventory() {
    return inventory;
  }

  public void setInventory(ArrayList<Loot> inventory) {
      this.inventory = inventory;
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
