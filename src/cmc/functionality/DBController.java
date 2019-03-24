package cmc.functionality;
import java.util.ArrayList;

import cmc.entity.Account;
import cmc.entity.University;
import cmc.entity.UserSavedSchool;
import dblibrary.project.csci230.UniversityDBLibrary;


/**
 * @author pdoyle001
 *
 */
public class DBController 
{
	private UniversityDBLibrary dbLibrary;

	/**
	 * Creates new instance of Database controller
	 */
	public DBController() {
		dbLibrary = new UniversityDBLibrary("error404", "csci230");
	}
	
	/**
	 * Checks to see if user exists
	 * @param inputString
	 * @return boolean true if user already exists in database, else false
	 */
	public Boolean checkUser(String inputString)
	{
		String[][] userList = dbLibrary.user_getUsers();
		for (int n = 0; n < userList.length; n++)
		{
			 
			if (userList[n][2].equals(inputString))
			{
				if(userList[n][5].equals("Y"))
					{
						return true;
					}
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Removes university from database
	 * @param schoolName school to be deleted from database
	 */
	public void removeUniversity(String schoolName)
	{
		dbLibrary.university_deleteUniversity(schoolName);
	}
	
	/**
	 * Adds university to database
	 * @param school university to be added to the database
	 */
	public void addUniversity(University school)
	{
		dbLibrary.university_addUniversity(school.getName(), school.getState(), school.getLocation(), school.getControl(), Integer.parseInt(school.getEnrollment()), Double.parseDouble(school.getPercentFemale()), Double.parseDouble(school.getSatVerbal()), Double.parseDouble(school.getSatMath()), Double.parseDouble(school.getCost()), Double.parseDouble(school.getPercentFinAid()), Integer.parseInt(school.getApplicants()), Double.parseDouble(school.getPercentAdmitted()), Double.parseDouble(school.getPercentEnrolled()), Integer.parseInt(school.getAcademicScale()), Integer.parseInt(school.getSocialScale()), Integer.parseInt(school.getQualityOfLife()));
	}
	
	/**
	 * Retrieve information for a specified university
	 * @param school name of university to access
	 * @return University object with corresponding information
	 */
	public University getUniversity(String school)
	{
		String[][] schoolList = dbLibrary.university_getUniversities();
		for (int n = 0; n < schoolList.length; n++)
		{
			 
			if (schoolList[n][0].equals(school))
			{		

				
				String[][] emphases = dbLibrary.university_getEmphases();
				int emphCounter = 0;
				for(int i = 0; i < emphases.length; i++)
				{
					if(emphases[i][0].equals(school))
					{
						emphCounter++;
					}
				}
				String[] returnEmphases = new String[emphCounter];
				int placer = 0;
				for(int i = 0; i < emphases.length; i++)
				{
					if(emphases[i][0].equals(school))
					{
						returnEmphases[placer] = emphases[i][1];
					}
				}
				
				return new University(schoolList[n][0], schoolList[n][1], schoolList[n][2], schoolList[n][3], schoolList[n][4], schoolList[n][5], schoolList[n][6], schoolList[n][7], schoolList[n][8], schoolList[n][9], schoolList[n][10], schoolList[n][11], schoolList[n][12], schoolList[n][13], schoolList[n][14], schoolList[n][15], returnEmphases);

			}
		}
		return null;
		
	}
	
	/**
	 * Retrieve information for a specified university
	 * @param school name of university to access
	 * @return University object with corresponding information
	 */
	public University getUniversity2(String school)
	{
		String[][] schoolList = dbLibrary.university_getUniversities();
		String[][] namesWithEmphases = dbLibrary.university_getNamesWithEmphases();
		University returnUniversity = null;
		//Making a ArrayList first, because we cannot sure the length of the emphases array
		ArrayList<String> empha = new ArrayList<>();
		for (int i = 0; i < namesWithEmphases.length; i++)
		{
			if(namesWithEmphases[i][0].equals(school))
			{	
				empha.add(namesWithEmphases[i][1]); 
			}
		}
		//Filling the emphases array here
		String[] emphases = new String[empha.size()];
		for(int i=0; i<empha.size(); i++) {
			emphases[i] = empha.get(i);
		}
		//Making a new instance of University then return it
		for (int n = 0; n < schoolList.length; n++)
		{
			if (schoolList[n][0].equals(school)){
				 returnUniversity = new University(schoolList[n][0], schoolList[n][1], schoolList[n][2], schoolList[n][3], schoolList[n][4], 
						schoolList[n][5], schoolList[n][6], schoolList[n][7], schoolList[n][8], 
						schoolList[n][9], schoolList[n][10], schoolList[n][11], schoolList[n][12],
						schoolList[n][13], schoolList[n][14], schoolList[n][15], emphases);
			}
		}
		return returnUniversity;
	}
			

	
	
	/**
	 * Update information in database for a specified university
	 * @param school name of school to be updated in database
	 */
	public void setUniversity(University school)
	{
		dbLibrary.university_editUniversity(school.getName(), school.getState(), school.getLocation(), school.getControl(), Integer.parseInt(school.getEnrollment()), Double.parseDouble(school.getPercentFemale()), Double.parseDouble(school.getSatVerbal()), Double.parseDouble(school.getSatMath()), Double.parseDouble(school.getCost()), Double.parseDouble(school.getPercentFinAid()), Integer.parseInt(school.getApplicants()), Double.parseDouble(school.getPercentAdmitted()), Double.parseDouble(school.getPercentEnrolled()), Integer.parseInt(school.getAcademicScale()), Integer.parseInt(school.getSocialScale()), Integer.parseInt(school.getQualityOfLife()));
	}
	
	/**
	 * Retrieve information for a specified account
	 * @param accountName user name of account to retrieve
	 * @return Account object with corresponding information
	 */
	public Account getAccount(String accountName)
	{
		String[][] accountList = dbLibrary.user_getUsers();
	
		Account returnAccount = new Account("dumty", "asfd", "asdf", "asf", "asf", "asd");
		for (int n = 0; n < accountList.length; n++)
		{
			
			if (accountList[n][2].equals(accountName))
			{		
				
				returnAccount = new Account(accountList[n][0], accountList[n][1],accountList[n][2],accountList[n][3],accountList[n][4],accountList[n][5]);
				return returnAccount;
			}
		}
		System.out.println(returnAccount.toString());
		return null;
	}
	
	/**
	 * Update information for a specified account
	 * @param account Account object to update in database
	 */
	public void setAccount(Account account)
	{
		dbLibrary.user_editUser(account.getUsername(), account.getFirstName(), account.getLastName(), account.getPassword(), account.getUserType().charAt(0), account.getUserStatus().charAt(0));
		
	}
	
	/**
	 * Add new user to database
	 * @param account Account object containing all account information fields
	 */
	public void addUser(Account account)
	{
		dbLibrary.user_addUser(account.getFirstName(), account.getLastName(), account.getUsername(), account.getPassword(), account.getUserType().charAt(0));
	}
	
	/**
	 * Check to see if university exists in database
	 * @param school name of university to search for in database
	 * @return boolean true if university exists in database, else false
	 */
	public boolean findUniversity(String school)
	{
		String[][] schoolList = dbLibrary.university_getUniversities();
		for (int n = 0; n < schoolList.length; n++)
		{
			if (schoolList[n][0].equals(school))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retrieve list of all universities in database
	 * @return ArrayList<University> list of all universities in database
	 */
	public ArrayList<University> getUniversityList()
	{
		String[][] schoolList = dbLibrary.university_getUniversities();

		ArrayList<University> returnArray = new ArrayList<University>();
		for (int i = 0; i < schoolList.length; i++)
		{
				returnArray.add(getUniversity(schoolList[i][0]));
		}
		return returnArray;
		
	}
	
	/**
	 * Retrieve information for all users in database
	 * @return ArrayList<Account> list of all users in database
	 */
	public ArrayList<Account> getAccountList()
	{
		String[][] accountList = dbLibrary.user_getUsers();
		ArrayList<Account> returnList = new ArrayList<Account>();
		for (int n = 0; n < accountList.length; n++)
		{
				returnList.add(new Account(accountList[n][0], accountList[n][1],accountList[n][2],accountList[n][3],accountList[n][4],accountList[n][5]));
		}
		return returnList;
		
	}
	

	/**
	 * Retrieve list of a specified users saved schools
	 * @param account student to retrieve saved school list
	 * @return ArrayList<University> get saved school list for a specified student
	 */
	public ArrayList<UserSavedSchool> getSchoolList2(Account account)
	{
		String[][] savedSchools = dbLibrary.user_getUsernamesWithSavedSchools();
		ArrayList<UserSavedSchool> returnSchools = new ArrayList<>();
		for(int i = 0; i < savedSchools.length; i++) {
			if(savedSchools[i][0].equals(account.getUsername())) {
				University currentSchool = this.getUniversity2(savedSchools[i][1]);
				String dateAdded = savedSchools[i][2];
				UserSavedSchool savedSchool = new UserSavedSchool(currentSchool,dateAdded);
				returnSchools.add(savedSchool);
			}
		}
		return returnSchools;
}
	
	/**
	 * Retrieve list of a specified users saved schools
	 * @param account student to retrieve saved school list
	 * @return ArrayList<University> get saved school list for a specified student
	 */
	public ArrayList<University> getSchoolList(Account account)
	{
		ArrayList<University> returnArray = new ArrayList<University>();
		String[][] savedSchools = dbLibrary.user_getUsernamesWithSavedSchools();
		for(int n = 0; n < savedSchools.length; n++)
			{
				if(savedSchools[n][0].equals(account.getUsername()))
				{
					returnArray.add(this.getUniversity2(savedSchools[n][1]));
					
					
				}
			}

	
		
//	int placer = 0;
//		for(int n = 0; n < savedSchools.length; n++)
//		{
//			University uni = new University(savedSchools[n][0], savedSchools[n][1], savedSchools[n][2], savedSchools[n][3], savedSchools[n][4], 
//					savedSchools[n][5], savedSchools[n][6], savedSchools[n][7], savedSchools[n][8], 
//					savedSchools[n][9], savedSchools[n][10], savedSchools[n][11], savedSchools[n][12],
//					savedSchools[n][13], savedSchools[n][14], savedSchools[n][15], null);
//			returnArray.add(uni);
//		}
//		
		return returnArray;
	}
	
	/**
	 * Updated emphases for a specified university
	 * @param school name of university to update
	 * @param emphasis emphasis to add to univeristy
	 */
	public void addEmphasis(String school, String emphasis)
	{
		dbLibrary.university_addUniversityEmphasis(school, emphasis);
	}
	
	/**
	 * Add a new school on user's saved school list
	 * @param user 
	 * @param school
	 */
	public void saveShool(String user, String school) {
		dbLibrary.user_saveSchool(user, school);
	}
	/**
	 * Remove a saved school from a user's saved school list
	 * @param user
	 * @param school
	 */
	public void removeSavedSchool(String user, String school) {
		dbLibrary.user_removeSchool(user, school);

	}
	/**
	 * get a school's saved statistics
	 * @param school
	 * @return
	 */
	public int getUserSavedStatistics(String school) {
		String[][] namesWithSavedSchools= this.dbLibrary.user_getUsernamesWithSavedSchools();
		int count = 0;
		for(int i = 0 ; i < namesWithSavedSchools.length ; i++) {
			if(namesWithSavedSchools[i][1].equals(school)) {
				count++;
			}
		}
		return count;
	}
}
