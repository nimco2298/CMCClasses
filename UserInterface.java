/* 
 * File: SearchController.java
 * Description: This class displays the UI and take all user's commands
 * before passing them to the Controller
 * 
 * @author Karld Bai
 * @version Feb 22 2018
 */
import java.util.*;
public class UserInterface
{
  private GeneralUser user;
  private UserFuncController ufc;
  private SearchController sc;
  private DBController db;
  
  public UserInterface(GeneralUser user){
    this.ufc= new UserFuncController(user);
    this.user=user;
    this.db=new DBController();
  }
  
  Scanner scan= new Scanner(System.in);
  /**
   * redirects the user to the homepage
   */
  public void homePage(){
    
    
    String str= scan.next("s for search, m for manage saved schools, p for manage profile");
    if(str.equals("s")){
      System.out.println("Here are all the schools:");
      viewSearchedSchools(db.getUniversities());
      
      String schoolName=strIn("School Name: ");
      String state= strIn("State: ");
      String location=strIn("Location: ");
      String control=strIn("Control: ");
      int studentsLow=intIn("low num of students: ");                           
      int studentsHigh=intIn("high num of students: ");
      int femPercLow=intIn("low % of female: ");
      int femPercHigh =intIn("high % of female: ");
      int satVLow=intIn("low verbal sat: ");
      int satVHigh=intIn("high verbal sat: ");                       
      int satMLow=intIn("low math sat: ");
      int satMHigh=intIn("high math sat: ");
      int costLow=intIn("low cost: ");
      int costHigh=intIn("High cost: ");
      int finAidPercLow=intIn("low financial aid: ");
      int finAidPercHigh=intIn("high financial aid: ");                       
      int applicantsLow=intIn("low applicants num: ");
      int applicantsHigh=intIn("high applicants num: ");
      int admittedLow=intIn("low admitted num: ");
      int admittedHigh=intIn("high admitted num: ");                            
      int enrolledLow=intIn("low enrolled num: ");
      int enrolledHigh=intIn("high enrolled num: ");
      int acadScaleLow=intIn("low academic scale: ");
      int acadScaleHigh=intIn("high academic scale: ");
      int socLifeScaleLow=intIn("low social life scale: ");                      
      int socLifeScaleHigh =intIn("high social life scale: ");  
      int qualLifeScaleLow=intIn("low qual life scale: ");  
      int qualLifeScaleHigh=intIn("high qual life scale: ");  
      ArrayList<String> emphases=new ArrayList<String>();
      String sss=strIn("emphases: ");
      while(!sss.equals("")){
        emphases.add(sss);
        sss=strIn("some more emphases? space to finish: ");
      }
      ArrayList<University> ulist= new ArrayList<University>();
      ulist= sc.search( schoolName,  state,  location,  control, studentsLow,
                       studentsHigh,  femPercLow,  femPercHigh,  satVLow,  satVHigh, 
                       satMLow,  satMHigh,  costLow,  costHigh,  finAidPercLow,  finAidPercHigh,
                       applicantsLow,  applicantsHigh,  admittedLow,  admittedHigh, 
                       enrolledLow,  enrolledHigh,  acadScaleLow,  acadScaleHigh,  socLifeScaleLow,
                       socLifeScaleHigh,  qualLifeScaleLow,  qualLifeScaleHigh, 
                       emphases);
      
      viewSearchedSchools(ulist);
      String s1 = scan.next("s for save and v for view:");
      if(s1.equals("s")){
       String sName= scan.next("please enter the name of the school you want to save:");
       saveToSavedSchoolList(db.getUniversity(sName));
      }
      else{
        String sName= scan.next("please enter the name of the school you want to view details:");
        viewSchoolDetailsAndTop5(db.getUniversity(sName));
      }
    }
    else if(str.equals("m")){
      viewSavedSchools();
      String s3 = scan.next("r for remove and v for view:");
      if(s3.equals("r")){
       String sName= scan.next("please enter the name of the school you want to remove:");
       removeSavedSchool(db.getUniversity(sName));
      }
      else{
        String sName= scan.next("please enter the name of the school you want to view details:");
        viewSchoolDetailsAndTop5(db.getUniversity(sName));
      }
    }
    else{
      
    }
    
  }
  /**
   * takes the view details command and displays the details
   */
  public void viewSchoolDetailsAndTop5(University u)
  {
    viewSavedSchoolDetails(u);
    viewSearchedSchools(sc.recSearch(u));
    String s2 = scan.next("Do you want to save it? y/n:");
    if(s2.equals("y")){
      saveToSavedSchoolList(u);
    }
    else{
      homePage();
    }
  }
  /**
   * takes the view saved school command and displays the saved school list
   */
  public void viewSavedSchools(){
    for(String u: user.getSavedSchools()){
      System.out.println(u);
    }
  }
  /**
   * takes the view saved school details command and displays the details
   */
  public void viewSavedSchoolDetails(University u){
    System.out.println("School details: ");
    u.printDetails();
  }
  /**
   * 
   */
  public boolean isEmpty(){
    
    return true;
  }
  /**
   * takes the view profile command and displays the profile of the user
   */
  public void viewProfile(){
    
  }
  /**
   * takes the edit file command and redirect the user to the edit page
   */
  public void editProfile(){
    
  }
  /**
   * redirect the user to the homepage and save the changes
   */
  public void submitProfileChanges(){
    
  }
  /**
   * takes the search command and shows the result
   */
  public Collection searchForShools(String schoolName, String state, String location, String control,int studentsLow,
                                    int studentsHigh, int femPercLow, int femPercHigh, int satVLow, int satVHigh, 
                                    int satMLow, int sayMHigh, int costLow, int costHigh, int finAidPercLow, int finAidPercHigh,
                                    int applicantsLow, int applicantsHigh, int admittedLow, int admittedHigh, 
                                    int enrolledLow, int enrolledHigh, int acadScaleLow, int acadScaleHigh, int socLifeScaleLow,
                                    int socLifeScaleHigh, int qualLifeScaleLow, int qualLifeScaleHigh, 
                                    ArrayList<String> emphases)
  {
    
    return null;
  }
  /**
   * displays the result of searching
   */
  public void viewSearchedSchools(ArrayList<University> c){
    System.out.println("Here is the result of searching: ");
    for(University u: c){
      System.out.println(u.getName());
    }
  }
  /*
   *  takes the save to list command and add the school to the saved school list 
   */
  public void saveToSavedSchoolList(University u){
    db.addSchoolToUserList(user, u);
    this.user=(GeneralUser)db.getUser(user.getUsername());
    ufc.updateUser(user);
    System.out.println("Success");
    homePage();
  }
  /*
   * removes the selected school
   */
  public void removeSavedSchool(University u){
    db.removeSchoolFromSavedSchoolList(this.user, u);
    this.user=(GeneralUser)db.getUser(user.getUsername());
    ufc.updateUser(user);
    System.out.println("Success");
    homePage();
  }
  
  public String strIn(String ss){
    System.out.print(ss);
    String re= scan.next();
    return re;
  }
  public int intIn(String ss){
    System.out.print(ss);
    int re= scan.nextInt();
    return re;
  }
  
//para for copy: String schoolName, String state, String location, String control,int students, int femPerc, int satM, int cost, int finAidPerc, int applicants, int admitted, ArrayList<String> emphases
}

