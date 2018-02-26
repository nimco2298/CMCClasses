import dblibrary.project.csci230.*;
import java.util.ArrayList;
/*
 * File:DBController.java
 */

/**
 * Performs all the messy work needed for accessing and modifiying the databse
 * @author Ian Bush
 * @version February 22, 2018
 */
public class DBController
{
  /* Accessing the database library */
  private UniversityDBLibrary ud;
  
  /**
   * Constructor
   */
  public DBController()
  {
    this.ud = new UniversityDBLibrary("cloud9", "csci230");
  }
  
  /**
   * Returns the list of all universities in the database
   * @return all of the universities in the system
   */
  public ArrayList<University> getUniversities()
  {
    ArrayList<University> univList = new ArrayList<University>();
    String[][] univ = ud.university_getUniversities();
    for(int i = 0; i < univ.length; i++)
    {
      univList.add(new University(univ[i][0], univ[i][1], univ[i][2], univ[i][3], new Integer(univ[i][4]).intValue(), 
      new Integer(univ[i][5]).intValue(), new Integer(univ[i][6]).intValue(), new Integer(univ[i][7]).intValue(), 
      new Integer(univ[i][8]).intValue(), new Integer(univ[i][9]).intValue(), new Integer(univ[i][10]).intValue(), 
      new Integer(univ[i][11]).intValue(), new Integer(univ[i][12]).intValue(), new Integer(univ[i][13]).intValue(),
      new Integer(univ[i][14]).intValue(), new ArrayList<String>()));
    }
    return univList;
  }
  
  public University getUniversity(String univName)
  {
    String[][] univs = ud.university_getUniversities();
    University u = new University();
    for (int i = 0; i < univs.length; i++)
    {
      if (univs[i][0] == univName)
      {
       
      }
    }
    return null;
  }
  /**
   * Returns a list of all users in the databse
   * @return all of the users in the system
   */
  public ArrayList<Account> getAccounts()
  {
    return null;
  }
  
  /**
   * Finds the user in the database with the matching username
   * return: the account with the matching username
   * @param usr the username of the specific user
   */
  public Account getUser(String usr)
  {
    String[][] users = ud.user_getUsers();
    return null;
  }
  
  /**
   * Adds the specified university to the school list of the specified user
   * post: the University will be added to the user's school list
   * @param usr the User whose list will now include the selected university
   * @param univ the University which will be added to the User's school list
   */
  public void addSchoolToUserList(GeneralUser usr, University univ)
  {
    ud.user_saveSchool(usr.getUsername(), univ.getName());
  }
  
  /** 
   * Adds a new university to the database
   * post: a new University will be added to the database 
   * @univ the University to add to the database
   */
  public void addNewUniversity(University univ)
  {
    ud.university_addUniversity(univ.getName(), univ.getState(), univ.getLocation(), univ.getControl(), 
    univ.getStudents(), new Integer(univ.getFemPerc()).doubleValue(), new Integer(univ.getSatV()).doubleValue(), 
    new Integer(univ.getSatM()).doubleValue(), new Integer(univ.getCost()).doubleValue(), new Integer(univ.getFinAidPerc()).doubleValue(),
    univ.getApplicants(), new Integer(univ.getAdmitted()).doubleValue(), new Integer(univ.getEnrolled()).doubleValue(), 
    univ.getAcadScale(), univ.getSocScale(), univ.getQualScale());
  }
  /**
   * Adds a new account to the database
   * post: a new Account will add to the database
   * @param acc the account to add to the database
   */
  public void addAccount(Account acc)
  {
    this.ud.user_addUser(acc.getFirstName(), acc.getLastName(), acc.getUsername(), acc.getPassword(), acc.getType());
  }
  
  /**
   * Modifies an account
   * @param acc the account to modify
   */
  public void updateAccount(Account acc)
  {
    this.ud.user_editUser(acc.getFirstName(), acc.getLastName(), acc.getUsername(), acc.getPassword(), acc.getType(), acc.getActive());
  }
  
  /**
   * Modifies a univeristy
   * @param univ the University to modify
   */
  public void updateUniversity(University univ)
  {
    ud.university_editUniversity(univ.getName(), univ.getState(), univ.getLocation(), univ.getControl(), 
    univ.getStudents(), new Integer(univ.getFemPerc()).doubleValue(), new Integer(univ.getSatV()).doubleValue(), 
    new Integer(univ.getSatM()).doubleValue(), new Integer(univ.getCost()).doubleValue(), new Integer(univ.getFinAidPerc()).doubleValue(),
    univ.getApplicants(), new Integer(univ.getAdmitted()).doubleValue(), new Integer(univ.getEnrolled()).doubleValue(), 
    univ.getAcadScale(), univ.getSocScale(), univ.getQualScale());
  }
  
  /**
   * removes a school from a user's saved school list
   * @param gu the GeneralUser who wishes to remove a saved school 
   * @param
   */
  public void removeSchoolFromSavedSchoolList(GeneralUser gu, University univ)
  {
    ud.user_removeSchool(gu.getUsername(), univ.getName());
  }
 
  /**
   * deletes a university from the database
   * @param univ the university to delete from the database
   */
  public void deleteUniversity(University univ)
  {
    ud.university_deleteUniversity(univ.getName());
  }
  
  /**
   * deletes an account from the database
   * @param acc the account to deleted from the database
   */
  public void deleteAccount(Account acc)
  {
    ud.user_deleteUser(acc.getUsername());
  }
}