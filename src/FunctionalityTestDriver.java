/**
 * 
 */
import cmc.*;
/**
 * @author kmendel001
 *
 */
public class FunctionalityTestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//successful login (user)
		String userUsername = "";
		String userPassword = "";
		user = login(userUsername, userPassword);
		
		//successful login (admin)
		String adminUsername = "";
		String adminPassword = "";
		user = login(adminUsername, adminPassword);
		
		//failed login - invalid credentials (admin and user)
		String username = "";
		String password = "";
		user = login(username, password);
		
		//failed login - inactive status (admin and user)
		String username = "";
		String password = "";
		user = login(username, password);
		
		//view profile (user)
		user = login(userUsername, userPassword);
		
		user.viewProfile();
		
		
		//edit profile (user)
		user.editProfile("","","","");
		user.viewProfile();
		
		//view profile (admin)
		user = login(adminUsername, adminPassword);
		
		user.viewProfile();
		
		//edit profile (admin)
		user.editProfile("","","","", "", "");
		user.viewProfile();
		
		//Search for schools - state, # of students (user)
		user = login(userUsername, userPassword);

		String state = "";
		String numStudents = "";
		String results = search(/*search criteria*/);
		print(results);
		
		//find top 5 recommended schools (user)
		University university = new University(/*info for a school*/);
		String recommended = findRecommended(university);
		print(recommended);
		
		//view list of universities (admin)
		user = login(adminUsername, adminPassword);
		viewUniversityList(/*parameters*/);

	}

}