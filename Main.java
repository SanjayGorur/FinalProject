//Not even close to done  :|

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main 
{
  public static void main(String[] args) 
  {
    Tournament list = new Tournament();
    loadPlayers(list, "Masters.txt");
    
    System.out.println();
    System.out.println(list.toString());
    
  }
  
  private static void loadPlayers(Tournament set, String file)
  {
    try
    {
      File results = new File(file);
      Scanner scan = new Scanner(results);
      while(scan.hasNextLine())
      {
        try
        {
          String check = scan.next();
          if(check != null)
          {
            String firstName = check;
            String lastName = scan.next();
            int rating = scan.nextInt();
            String level = scan.next();
            double points = scan.nextDouble();
            String rank = scan.next();
            
            String fullName = firstName + " " + lastName;
            
            TournamentPlayer master = new TournamentPlayer(fullName, rating, level, points, rank);
            set.addPlayer(master);
            
            System.out.println(fullName);               
          }
        }
        
        catch(NoSuchElementException exc)
        {
          exc.printStackTrace();
        }

      }
    }
    
    catch(FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
