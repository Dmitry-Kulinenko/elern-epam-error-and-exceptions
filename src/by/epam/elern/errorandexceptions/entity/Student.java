package by.epam.elern.errorandexceptions.entity;

import java.util.Map;

public class Student {
	private String name;
	private String universityName;
	private String facultyName;
	private Integer groupNumber;
	private Map<Course, Integer> marks;

	public Student() {
	}

	public Student(String name, String universityName, String facultyName, Integer groupNumber,
			Map<Course, Integer> marks) {
		this.name = name;
		this.universityName = universityName;
		this.facultyName = facultyName;
		this.groupNumber = groupNumber;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(Integer groupNumber) {
		this.groupNumber = groupNumber;
	}

	public Map<Course, Integer> getMarks() {
		return marks;
	}

	public void setMarks(Map<Course, Integer> marks) {
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facultyName == null) ? 0 : facultyName.hashCode());
		result = prime * result + ((marks == null) ? 0 : marks.hashCode());
		result = prime * result + ((groupNumber == null) ? 0 : groupNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((universityName == null) ? 0 : universityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (facultyName == null) {
			if (other.facultyName != null) {
				return false;
			}
		} else if (!facultyName.equals(other.facultyName)) {
			return false;
		}
		if (marks == null) {
			if (other.marks != null) {
				return false;
			}
		} else if (!marks.equals(other.marks)) {
			return false;
		}
		if (groupNumber == null) {
			if (other.groupNumber != null) {
				return false;
			}
		} else if (!groupNumber.equals(other.groupNumber)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
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
		return "Student [name = " + name + ", universityName = " + universityName + ", facultyName = " + facultyName
				+ ", groupNumber = " + groupNumber + ", marks = " + marks + "]";
	}

}
