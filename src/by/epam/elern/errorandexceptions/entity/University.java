package by.epam.elern.errorandexceptions.entity;

import java.util.List;

public class University {
	private String name;
	private List<Faculty> faculties;

	public University() {
	}

	public University(String name, List<Faculty> faculties) {
		this.name = name;
		this.faculties = faculties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faculties == null) ? 0 : faculties.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof University)) {
			return false;
		}
		University other = (University) obj;
		if (faculties == null) {
			if (other.faculties != null) {
				return false;
			}
		} else if (!faculties.equals(other.faculties)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "University [name = " + name + ", faculties = " + faculties + "]";
	}

}
