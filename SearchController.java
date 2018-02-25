/* 
 * File: SearchController.java
 * Description: This class get all the universities from DBController and
 * return one or more schools based user's input condition
 * 
 * @author Karld Bai
 * @version Feb 22 2018
 */

import java.util.*;

public class SearchController{
  
  /*
   * @param all are instance variables of a University object
   * @return a list of searching result
   * 
   */
  public ArrayList<University> search(String schoolName, String state, String location, String control,int studentsLow,
                                      int studentsHigh, int femPercLow, int femPercHigh, int satVLow, int satVHigh, 
                                      int satMLow, int sayMHigh, int costLow, int costHigh, int finAidPercLow, int finAidPercHigh,
                                      int applicantsLow, int applicantsHigh, int admittedLow, int admittedHigh, 
                                      int enrolledLow, int enrolledHigh, int acadScaleLow, int acadScaleHigh, int socLifeScaleLow,
                                      int socLifeScaleHigh, int qualLifeScaleLow, int qualLifeScaleHigh, 
                                      ArrayList<String> emphases)
  {
    ArrayList<University> ulist = new ArrayList<University>();
    return ulist;
  }
  
  /*
   * @param a University object that the user selected
   * @return a list of searching result
   * 
   */
  public ArrayList<University> recSearch(University u){
    
    ArrayList<University> ulist = new ArrayList<University>();
    return ulist;
  }
}
