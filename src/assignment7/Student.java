package assignment7;

public class Student {

	//instance variables
		private String firstName; 
		private String lastName;
		private int idNumber;
		private int attemptedCredits;
		private int passingCredits;
		private double totalGradeQualityPoints;
		private double bearBucksBalance; 
		private double GPA; 
		
		/**
		 * 
		 * @param instFirstName
		 * @param instLastName
		 * @param instIdNumber
		 * this is the constructor for student 
		 */
		public Student(String instFirstName, String instLastName, int instIdNumber) {
			firstName = instFirstName;
			lastName = instLastName;
			idNumber = instIdNumber; 
			attemptedCredits = 0; 
			passingCredits = 0; 
			totalGradeQualityPoints = 0;
			bearBucksBalance = 0.0;
			GPA = 0.0; 
		}
		
		/**
		 * 
		 * @return the grade point average 
		 */
		public double calculateGradePointAverage() {
			GPA = totalGradeQualityPoints/attemptedCredits; 
			   return totalGradeQualityPoints/attemptedCredits;
			}
		/**
		 * 
		 * @return the GPA
		 */
		public double getGPA() {
			return GPA; 
		}
		/**
		 * 
		 * @return the ID number
		 */
		public int getId() {
			return idNumber;  
		}
		/**
		 * 
		 * @return the first and last name
		 */
		public String getFullName() {
			return (firstName + " " + lastName);
		}
		/**
		 * 
		 * @return the last name
		 */
		public String getLastName() {
			return lastName; 
		}
		/**
		 * 
		 * @param amount in the account
		 */
		public void deductBearBucks(double amount) {
			bearBucksBalance = bearBucksBalance - amount; 
		}
		/**
		 * 
		 * @param amount in the account
		 */
		public void depositBearBucks(double amount) {
			bearBucksBalance = bearBucksBalance + amount; 
		}
		/**
		 * 
		 * @return the bear bucks balance amount
		 */
		public double getBearBucksBalance() {
			return bearBucksBalance; 
		}
		/**
		 * 
		 * @return the amount of credit the person gets after cashing in their bear bucks 
		 */
		public double cashOutBearBucks() {
			double returnAmount = bearBucksBalance - 10; 
			bearBucksBalance = 0.0; 
			if (returnAmount > 0) {
				return returnAmount; 
			} else {
				return 0.0; 
			}	
		}
		/**
		 * 
		 * @param grade
		 * @param credits
		 * returns nothing
		 */
		public void submitGrade(double grade, int credits) {
			attemptedCredits = attemptedCredits + credits; 
			if (grade >= 1.7) {
				passingCredits = passingCredits + credits;
			}
			double qualityPoints = grade*credits; 
			totalGradeQualityPoints = totalGradeQualityPoints + (qualityPoints); 
			
			GPA = totalGradeQualityPoints/attemptedCredits; 
			
		}
		/**
		 * 
		 * @return the passing credits
		 */
		public int getTotalPassingCredits() {
			return passingCredits; 
		}
		/**
		 * 
		 * @return the attempted credits
		 */
		public int getTotalAttemptedCredits() {
			return attemptedCredits; 
		}
		/**
		 * 
		 * @param firstName
		 * @param other student
		 * @param whether the name isHyphenated
		 * @param ID 
		 * @return the new legacy
		 */
		public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
			String legacyFirstName = firstName; 
			String legacyLastName = "";
			if (isHyphenated) {
				legacyLastName = this.getLastName() + "-" + other.getLastName();
			} else {
				legacyLastName = this.getLastName();
			}
			
			Student legacy = new Student(legacyFirstName, legacyLastName, id);
			
			double newBearBucks = this.cashOutBearBucks() + other.cashOutBearBucks(); 
			
			legacy.depositBearBucks(newBearBucks);
			
			return legacy; 
		}
		/**
		 * 
		 * @return if the person is eligible for PhiBetaKappa
		 */
		public boolean isEligibleForPhiBetaKappa() {
			if ((attemptedCredits >= 98 && GPA >= 3.6) || (attemptedCredits >= 75 && GPA >= 3.8)) {
				return true;
			} else {		
			return false; 
			}
		}
		/**
		 * 
		 * @return the class standing
		 */
		public String getClassStanding() {
			if (passingCredits < 30) {
				return "First Year";
			} else if ((passingCredits >= 30) && (passingCredits < 60)) {
				return "Sophomore";
			} else if ((passingCredits >= 60) && (passingCredits < 90)) {
				return "Junior";
			} else {
				return "Senior"; 
			}
		}
		
		/**
		 * returns the toString
		 */
		public String toString() {
			return (firstName + " " + lastName + " " + idNumber);
		}
		
}
