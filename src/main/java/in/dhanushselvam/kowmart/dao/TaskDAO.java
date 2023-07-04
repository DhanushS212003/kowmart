package in.dhanushselvam.kowmart.dao;

import in.dhanushselvam.kowmart.model.Task;

public class TaskDAO {
	
private Task[] arr = TaskList.listOfTask;
	
	public Task[] findAll() {
		
		Task[] taskList = TaskList.listOfTask;
		return taskList;
		
	}
	
	public void create(Task task) {
						
		for (int i = 0; i < arr.length; i++) {
			
			Task currentTask = arr[i];
			
			if (currentTask == null) {
				arr[i] = task;
				break;
			}
			
		}
		
	}
	
	public void update(int id, Task updatedTask) {
				
		for (int i = 0; i < arr.length; i++) {
			
			Task currentTask = arr[i];
			
			if (currentTask == null) {
				continue;
			}
			if (currentTask.getId() == id) {
				
				currentTask.setName(updatedTask.getName());
				break;
				
			}
		}
		
	}
	
	public void delete(int id, Task updatedUser) {
				
		for (int i = 0; i < arr.length; i++) {
			
			Task currentTask = arr[i];
			
			if (currentTask == null) {
				continue;
			}
			if (currentTask.getId() == id) {
				currentTask.setActive(false);
			}
		}
		
	}
	
	public Task getById(int id) {
		
		Task matchedTask = null;
		
		for (int i = 0; i < arr.length; i++) {
			
			Task currentTask = arr[i];
			
			if (currentTask == null) {
				continue;
			}
			if (currentTask.getId() == id) {
				matchedTask = currentTask;
				System.out.print(currentTask);
				break;
			}
			
		}
		return matchedTask;
		
	}

}
