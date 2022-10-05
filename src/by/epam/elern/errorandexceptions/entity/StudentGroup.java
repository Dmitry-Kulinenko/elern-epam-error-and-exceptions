package by.epam.elern.errorandexceptions.entity;

import java.util.List;

public class StudentGroup {
	private Integer number;
	private List<Student> students;
	private String universityName;
	private String facultyName;

	public StudentGroup() {
	}

	public StudentGroup(Integer number, List<Student> students, String universityName, String facultyName) {
		this.number = number;
		this.students = students;
		this.universityName = universityName;
		this.facultyName = facultyName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultyName == null) ? 0 : facultyName.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((universityName == null) ? 0 : universityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StudentGroup)) {
			return false;
		}
		StudentGroup other = (StudentGroup) obj;
		if (facultyName == null) {
			if (other.facultyName != null) {
				return false;
			}
		} else if (!facultyName.equals(other.facultyName)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		if (students == null) {
			if (other.students != null) {
				return false;
			}
		} else if (!students.equals(other.students)) {
			return false;
		}
		if (universityName == null) {
			if (other.universityName != null) {
				return false;
			}
		} else if (!universityName.equals(other.universityName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "StudentGroup [number = " + number + ", students = " + students + ", universityName = " + universityName
				+ ", facultyName = " + facultyName + "]";
	}

}
