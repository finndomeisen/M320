package item;

public class Loot {
  private String explainloot; // loaction bag or chest like somethin
  private int money; // loot its self like money or somethin

  public Loot(String s, int i) {
    this.explainloot = s;
    this.money = i;
  }

  public String getexlpainloot(){
    return this.explainloot;
  }

  public int getStuff(){
    return this.money;
  }
}
