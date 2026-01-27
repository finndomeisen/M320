package combat;

import java.util.ArrayList;

import enemy.Enemy;
import player.Player;
import userinput.InputHandler;
import world.Room;

public class Combat {

    private ArrayList<Enemy> enemies;
    private Player mainPlayer;
    private Room room; // bleibt drin, auch wenn noch ungenutzt
    private InputHandler input = new InputHandler();

    public Combat(ArrayList<Enemy> enemylist, Player theplayer, Room theroom){
        this.enemies = enemylist;
        this.mainPlayer = theplayer;
        this.room = theroom;
    }

    public void startCombat(){

        System.out.println("combat.Combat gestartet!");

        while(mainPlayer.health() > 0 && enemies.size() > 0){

            System.out.println("\nplayer.Player HP: " + mainPlayer.health());

            for(int i = 0; i < enemies.size(); i++){
                Enemy e = enemies.get(i);
                System.out.println(i + ": " + e.getType() + " HP: " + e.getHealth());
            }

            System.out.println("\n1 = Angreifen");
            System.out.println("2 = Heilen ("+mainPlayer.getPassivHealSkill()+")");
            int choice = input.getInt("Wähle eine Aktion: ");

            if(choice == 1){
                System.out.println("Welchen Gegner?");
                int target = input.getInt("Gegner-Nummer: ");

                if(target >= 0 && target < enemies.size()){
                    Enemy enemy = enemies.get(target);
                    enemy.dealdamage(10);
                    System.out.println("Du triffst " + enemy.getType() + " fuer 10 Schaden");
                }
            }

            if(choice == 2){
                mainPlayer.changeHealth(mainPlayer.getPassivHealSkill());
                System.out.println("Du heilst dich");
            }

            // Tote Gegner entfernen + item.Loot
            for(int i = enemies.size() - 1; i >= 0; i--){
                if(enemies.get(i).getHealth() <= 0){
                    Enemy dead = enemies.remove(i);
                    System.out.println(dead.getType() + " besiegt!");
                    System.out.println("item.Loot erhalten: " + dead.getloot());
                }
            }

            // Gegner greifen an
            for(Enemy e : enemies){
                mainPlayer.changeHealth(-e.getDamage());
                System.out.println(e.getType() + " trifft dich fuer " + e.getDamage());
            }
        }

        if(mainPlayer.health() <= 0){
            System.out.println("Du bist gestorben!");
        } else {
            System.out.println("Alle Gegner besiegt!");
        }
    }
}
