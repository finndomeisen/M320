package item;

public class Loot {
  private String explainloot; // location bag or chest like something
  private int money; // lootwoth its self like money or something

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
