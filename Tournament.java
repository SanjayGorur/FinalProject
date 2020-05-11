
import java.util.*;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Scanner;

public class Tournament 
{
  private Queue<TournamentPlayer> masterSet;
  
  public Tournament()
  {
    masterSet = new PriorityQueue<TournamentPlayer>();
  }
  
  public boolean addPlayer(TournamentPlayer newP)
  {
    if(masterSet.size() > 12)
    {
      return false;
    }
    
    masterSet.add(newP);
    
    return true;
  }
  
  public TournamentPlayer removePlayer()
  {
    if(masterSet.size() == 0)
    {
      return null;
    }
    
    return masterSet.remove();
  }
  
  public boolean removeLosers()
  {
    if(masterSet.size() < 3)
    {
      return false;
    }
    
    for(int num = 0; num <= 2; num++)
    {
      masterSet.remove();
    }
    
    return true;
  }
  
  public Queue<String> getStandings()
  {
    Queue<String> playerRanks = new LinkedList<String>();
    Queue<TournamentPlayer> copy = new PriorityQueue<TournamentPlayer>(masterSet);
    
    while(copy.size() > 0)
    {
      playerRanks.add(copy.remove().getName());
    }
    
    return playerRanks;
  }
  
  public String getPrize()
  {
    String topPrizes = "";
    
    Queue<String> names = new LinkedList<String>();
    names = getStandings();
    
    for(int count = 0; count < 3; count++)
    {
      topPrizes += names.remove() + " ";
      if(count == 0)
      {
        topPrizes += "Gold ";
      }
      
      else if(count == 1)
      {
        topPrizes += "Silver ";
      }
      
      else
      {
        topPrizes += "Bronze";
      }
    }
    
    return topPrizes;
  }
  
  public boolean getWinners()
  {
    if(masterSet.size() < 3)
    {
      return false;
    }
    
    String winners = getPrize();
    Scanner scan = new Scanner(winners);
    
    String compare = "";
    int check = 0;
    while(check <= 9)
    {
      check++;
      if(check % 3 == 0)
      {
        System.out.println(compare + "advances to the World Chess Championship!");
        System.out.println();
        compare = "";
      }
      else
      {
        compare += scan.next() + " ";
      }
    }
    
    return true;
  }
  
  public String toString()
  {
    Queue<TournamentPlayer> results = new PriorityQueue<TournamentPlayer>(masterSet);
    String standings = "";
    
    while(results.size() > 0)
    {
      standings += results.remove().toString() + "\n";
    }
    
    return standings;
  }

}
