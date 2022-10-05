package by.epam.elern.errorandexceptions.entity;

import java.util.List;

public class Faculty {
	private String name;
	private List<StudentGroup> studentGroups;
	private String universityName;

	public Faculty() {
	}

	public Faculty(String name, List<StudentGroup> studentGroups, String universityName) {
		this.name = name;
		this.studentGroups = studentGroups;
		this.universityName = universityName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentGroup> getStudentGroups() {
		return studentGroups;
	}

	public void setStudentGroups(List<StudentGroup> studentGroups) {
		this.studentGroups = studentGroups;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((studentGroups == null) ? 0 : studentGroups.hashCode());
		result = prime * result + ((universityName == null) ? 0 : universityName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Faculty)) {
			return false;
		}
		Faculty other = (Faculty) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (studentGroups == null) {
			if (other.studentGroups != null) {
				return false;
			}
		} else if (!studentGroups.equals(other.studentGroups)) {
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
		return "Faculty [name = " + name + ", studentGroups = " + studentGroups + ", universityName = " + universityName
				+ "]";
	}

}
