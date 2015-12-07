public class Student implements Comparable<Student> {
	private final String name;
	private Integer grade=0;
	
	public Student(String name,int grade){
		this.name=name;
		this.grade=grade;
	}
	
	public Integer getGrade() {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Student o) {
		if(getGrade().compareTo(o.getGrade())==0){
			return getName().compareTo(o.getName());
		}
		return getGrade().compareTo(o.getGrade());
	}
	
}
