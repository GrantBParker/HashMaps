
public class Section {

	private String department;

	private int courseNumber;

	private int sectionNumber;

	private String instructor;

	private String title;

	public Section(String department, int courseNumber, int sectionNumber, String instructor, String title) {

		this.department = department;

		this.courseNumber = courseNumber;

		this.sectionNumber = sectionNumber;

		this.instructor = instructor;

		this.title = title;
	}

	public String getDepartment() {

		return department;
	}

	public void setDepartment(String department) {

		this.department = department;
	}

	public int getCourseNumber() {

		return courseNumber;
	}

	public void setCourseNumber(int courseNumber) {

		this.courseNumber = courseNumber;
	}

	public int getSectionNumber() {

		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {

		this.sectionNumber = sectionNumber;
	}

	public String getInstructor() {

		return instructor;
	}

	public void setInstructor(String instructor) {

		this.instructor = instructor;
	}

	public String getTitle() {

		return title;
	}

	public void setTitle(String title) {

		this.title = title;
	}

	@Override
	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result + courseNumber;

		result = prime * result + ((department == null) ? 0 : department.hashCode());

		result = prime * result + sectionNumber;

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Section other = (Section) obj;

		if (courseNumber != other.courseNumber)

			return false;

		if (department == null) {

			if (other.department != null)

				return false;

		} else if (!department.equals(other.department))

			return false;

		if (sectionNumber != other.sectionNumber)

			return false;

		return true;
	}

	@Override
	public String toString() {

		return "Section [department=" + department + ", courseNumber=" + courseNumber + ", sectionNumber="

				+ sectionNumber + ", instructor=" + instructor + ", title=" + title + "]";
	}

}
