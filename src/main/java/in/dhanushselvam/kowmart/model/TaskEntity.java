package in.dhanushselvam.kowmart.model;

import java.time.LocalDate;

public abstract class TaskEntity implements Comparable<Task> {

	String name;
	int id;
	LocalDate dueDate;
	boolean isActive;

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void setId(int newId) {
		id = newId;
	}

	public int getId() {
		return id;
	}

	public void setDueDate(LocalDate newDueDate) {
		dueDate = newDueDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setActive(boolean isactive) {
		isActive = isactive;
	}

	public boolean getActive() {
		return isActive;
	}

	@Override
	public String toString() {
		return "Task [Name : " + name + ", id : " + id + ", DueDate : " + dueDate + ", isActive : " + isActive + "]";
	}

	public int compareTo(Task o) {

		if (this.getId() == o.getId())
			return 0;
		else {
			if (this.getId() > o.getId())
				return 1;
			else
				return -1;
		}

	}

}
