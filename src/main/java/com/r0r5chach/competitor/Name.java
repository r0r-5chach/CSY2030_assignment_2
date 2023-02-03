package com.r0r5chach.competitor;

/**
 * Class that defines a name and it's parts
 * @author r0r5chach
 */
public class Name {
	/**
	 * The first name of the stored name
	 */
	private String firstName;
	/**
	 * The middle name of the stored name
	 */
	private String middleName;
	/**
	 * The last name of the stored name
	 */
	private String lastName;
	/**
	 * Construct a name that does not contain a middle name
	 * @param fName the first name of the name to be stored
	 * @param lName the last name of the name to be stored
	 */
	public Name(String fName, String lName) {
		firstName = fName;
		middleName = "";
		lastName = lName;
  	}
	/**
	 * Construct a name that does have a middle name
	 * @param fName the first name of the name to be stored
	 * @param mName the middle name of the name to be stored
	 * @param lName the last name of the name to be stored
	 */
	public Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
	}
	/**
	 * Construct a name from a single string
	 * @param fullName the first, middle, and last names of the name to be stored separated by whitespace
	 */
  	public Name (String fullName) {
	  int spacePos1 = fullName.indexOf(' ');
	  firstName = fullName.substring(0, spacePos1);
	  int spacePos2 = fullName.lastIndexOf(' ');
	  if (spacePos1 == spacePos2)
		  middleName = "";
	  else 
		  middleName = fullName.substring(spacePos1+1, spacePos2);
	  lastName = fullName.substring(spacePos2 + 1);
  	}
	/**
	 * Get the first name of the stored name
	 * @return the first name of the stored name
	 */
	public String getFirstName() {return firstName; }
	/**
	 * Get the middle name of the stored name
	 * @return the middle name of the stored name
	 */
  	public String getMiddleName() { return middleName; }
	/**
	 * Get the last name of the stored name
	 * @return the last name of the stored name
	 */
  	public String getLastName() {return lastName; }
	/**
	 * Set the stored name's first name to that of the parameter
	 * @param fn the new first name
	 */
  	public void setFirstName(String fn) {
	  firstName = fn;
  	}
	/**
	 * Set the stored name's middle name to that of the parameter
	 * @param mn the new middle name
	 */
	public void setMiddleName(String mn) {
	   middleName = mn;
  	}
	/**
	 * Set the stored name's last name to that of the parameter
	 * @param ln the new last name
	 */
	public void setLastName(String ln) {
	  lastName = ln;
  	}
	/**
	 * Get the first and last name of the stored name
	 * @return a formatted string containing both the first and last names
	 */
	public String getFirstAndLastName() {
		return firstName + " " + lastName;
 	 }
	/**
	 * Get the last and first names of the stored name
	 * @return a formatted string contains both the first and last names in reverse order
	 */
	public String getLastCommaFirst() {
		return lastName + ", "+ firstName;
  	}
	/**
	 * Get the full stored name
	 * @return a string containing the first, middle, and last names
	 */
  	public String getFullName() {
	  String result = firstName + " ";
	  if (!middleName.equals("")) {
		  result += middleName + " ";
	  }
	  result += lastName;
	  return result;	  
  	}
	/**
	 * Get the initials of the stored name
	 * @return a string containing the initials
	 * @author r0r5chach
	 */
	public String getInitials() {
	  String result = firstName.substring(0,1);
	  if (!middleName.equals("")) {
		  result += middleName.substring(0,1);
	  }
	  result += lastName.substring(0,1);
	  return result;
  	}
}