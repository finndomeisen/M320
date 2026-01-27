package userinput;

import java.util.Scanner;

public class InputHandler {
  private Scanner scanner;

  public InputHandler() {
    this.scanner = new Scanner(System.in);
  }

  public String getString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine();
  }

  public int getInt(String prompt) {
    System.out.print(prompt);
    return scanner.nextInt();
  }

  public void closeScanner() {
    scanner.close();
  }
}