package cs157b_hw1;
/**
 * 
 * @author davidhurng
 *
 * Presentation Layer displays login menu
 */
public class PresentationLayer {
	
	public static void main(String[] args) {
	int val;
	
    System.out.println("========================================");
    System.out.println("|   Online Hospital Managment System   |");
    System.out.println("========================================");
    System.out.println("| Login:                               |");
    System.out.println("|        1. Administrator              |");
    System.out.println("|        2. Staff                      |");
    System.out.println("|        3. Doctor                     |");
    System.out.println("|        4. Patient                    |");
    System.out.println("========================================");
    val = Keyin.inInt(" Select Login: ");
	
    switch (val) {
    case 1:
      System.out.println("Welcome Administrator");
      Menu.Admin(val);
      break;
    case 2:
      System.out.println("Welcome Staff");
      break;
    case 3:
      System.out.println("Welcome Doctor");
      break;
    case 4:
        System.out.println("Welcome Patient");
        break;
    default:
      System.out.println("Invalid selection");
      break; // This break is not really necessary
    }
  }
}

class Menu { 
	public static void Admin(int val) {
		 System.out.println("========================================");
		 System.out.println("|   			Administrator 		    |");
		 System.out.println("========================================");
		 System.out.println("| Select:                              |");
		 System.out.println("|    1.Create doctor account           |");
		 System.out.println("|    2.View   doctor account           |");
		 System.out.println("|    3.Delete doctor account           |");
		 System.out.println("|    4.Create patient account          |");
		 System.out.println("|    5.View doctor account             |");
		 System.out.println("|    6.Dreate doctor account           |");
		 System.out.println("========================================");
		 val = Keyin.inInt(" Select Option: ");
	}
}

class Keyin {
  public static void printPrompt(String prompt) {
    System.out.print(prompt + " ");
    System.out.flush();
  }
  
  public static void inputFlush() {
    int dummy;
    int bAvail;
    try {
      while ((System.in.available()) != 0)
        dummy = System.in.read();
    } catch (java.io.IOException e) {
      System.out.println("Input error");
    }
  }

  public static String inString(String prompt) {
    inputFlush();
    printPrompt(prompt);
    return inString();
  }

  public static String inString() {
    int aChar;
    String s = "";
    boolean finished = false;

    while (!finished) {
      try {
        aChar = System.in.read();
        if (aChar < 0 || (char) aChar == '\n')
          finished = true;
        else if ((char) aChar != '\r')
          s = s + (char) aChar; 
      }

      catch (java.io.IOException e) {
        System.out.println("Input error");
        finished = true;
      }
    }
    return s;
  }

  public static int inInt(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Integer.valueOf(inString().trim()).intValue();
      }

      catch (NumberFormatException e) {
        System.out.println("Invalid input. Not an integer");
      }
    }
  }

  public static char inChar(String prompt) {
    int aChar = 0;

    inputFlush();
    printPrompt(prompt);

    try {
      aChar = System.in.read();
    }

    catch (java.io.IOException e) {
      System.out.println("Input error");
    }
    inputFlush();
    return (char) aChar;
  }

  public static double inDouble(String prompt) {
    while (true) {
      inputFlush();
      printPrompt(prompt);
      try {
        return Double.valueOf(inString().trim()).doubleValue();
      }

      catch (NumberFormatException e) {
        System.out
            .println("Invalid input. Not a floating point number");
      }
    }
  }
}
           
         
    
  
