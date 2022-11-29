package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	
	private final Map<String, Student> map;  
	
	public UniversityDatabase() {
		map = new HashMap<String, Student>();
	}
	

	public void addStudent(String accountName, Student student) {
		map.put(accountName, student); 
	}

	public int getStudentCount() {
		return map.size();
	}

	public String lookupFullName(String accountName) {
		Student student = map.get(accountName); 
		if (student == null) {
			return null;
		}else {
			return student.getFullName();
		}
	}

	public double getTotalBearBucks() {
		double count = 0; 
		for (String account : map.keySet()) {
			count = count + map.get(account).getBearBucksBalance();  
		}
		return count; 
	}
}
