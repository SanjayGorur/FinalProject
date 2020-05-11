
import java.util.*;
import java.io.*;
import java.lang.Integer;
import java.lang.String;

public class TournamentPlayer implements Comparable<TournamentPlayer>
{
  
  /** static constants **/
  private static final int NUM_OF_RDS = 14;
  private static final int TOTAL_RATING = 27795;
  private static final int GAMES_PLAYED = 88;
  
  /** instance variables **/
  private String name;
  private int rating;
  private String level;
  private double points;
  private String rank;
  
  public TournamentPlayer(String name, int rating, String level, double points, String rank)
  {
    this.name = name;
    this.rating = rating;
    this.level = level;
    this.points = points;
    this.rank = rank;
  }
  
  
  public String getName()
  {
    return name;
  }

  
  public int getRating()
  {
    return rating;
  }
  
  
  public String getLevel()
  {
    return level;
  }
  
  
  public double getPoints()
  {
    return points;
  }
  
  
  public String getRank()
  {
    return rank;
  }
  
  
  public boolean beatCarlsen()
  {
    return (getRating() > 2758);
  }

 
  @Override
  public boolean equals(Object obj)
  {
    boolean check = false;
    
    if(obj == null)
    {
      return check;      
    }
    
    if(obj instanceof TournamentPlayer == false)
    {
      return check;
    }
    
    TournamentPlayer competitor = (TournamentPlayer) obj;
    
    if(name.equals(competitor.name) &&
           rating == competitor.rating &&
           level.equals(competitor.level) &&
           points == competitor.points &&
           rank.equals(competitor.rank) == true)
    {
      check = true;
      return check;
    }
    
    return check;
  }

  
  @Override
  public int compareTo(TournamentPlayer obj)
  {
    int compareCount = 0;
    
    int currentRank = Integer.valueOf(this.getRank().substring(0, this.getRank().length() - 2)); 
    int compareRank = Integer.valueOf(obj.getRank().substring(0, obj.getRank().length() - 2)); 
    
    if(currentRank > compareRank)
    {
      compareCount = 1;
      return compareCount;
    }
    
    if(currentRank < compareRank)
    {
      compareCount = -1;
      return compareCount;      
    }
    
    if(this.getPoints() > obj.getPoints())
    {
      compareCount = 1;
      return compareCount;
    }
    
    if(this.getPoints() < obj.getPoints())
    {
      compareCount = -1;
      return compareCount;      
    }
    
    if(this.beatCarlsen() == true && obj.beatCarlsen() == false)
    {
      compareCount = 1;
      return compareCount;
    }
    
    if(this.beatCarlsen() == false && obj.beatCarlsen() == true)
    {
      compareCount = -1;
      return compareCount;      
    }
    
    if(this.getRating() > obj.getRating())
    {
      compareCount = 1;
      return compareCount;
    }
    
    if(this.getRating() < obj.getRating())
    {
      compareCount = -1;
      return compareCount;      
    }

    return compareCount;
  }
  
  
  public int changeRating()
  {
    //Sorry, I am still stuck on the special rating formula.
    
    double calcNumer = (GAMES_PLAYED * rating) + ((NUM_OF_RDS) * ((TOTAL_RATING - rating)/9)) + ((GAMES_PLAYED - 200) * (points - (NUM_OF_RDS - points)));
    int calcDenom = GAMES_PLAYED + NUM_OF_RDS;
    
    int finalRating = (int) calcNumer/calcDenom;
    
    int diff = finalRating - rating;
    rating = finalRating;
    
    return diff;
  }


  public String changeLevel()
  {
    int compareNum = changeRating();
    
    if(compareNum > 15)
    {
      level = "IM";
    }
    
    else if(compareNum < -15)
    {
      level = "NM";
    }
    
    else
    {
      level = "GM";
    }
    
    return level;
  }

 
  public String toString()
  {
    return String.format("%s  -->  RATING - %d LEVEL - %s SCORE - %.1f RANK - %s",
    name, rating, level, points, rank);
  }
  
  
}
