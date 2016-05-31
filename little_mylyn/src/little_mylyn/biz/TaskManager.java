package little_mylyn.biz;

import java.util.List;

import little_mylyn.entity.Task;

public class TaskManager {
	// use this list to store tasks, and write it back to the database
	// only when the plug-in stops
	private List<Task> taskList;
	private static TaskManager taskManagerInstance;
	// Since we use a list to store tasks and not write tasks to database
	// immediately, this class should be a singleton
	private TaskManager() {
		// initialize taskList from database
		initTask();
	}
	public static TaskManager getTaskManager() {
		if (taskManagerInstance == null)
			taskManagerInstance = new TaskManager();
		return taskManagerInstance;
	}
	
	/**
	 * Get all tasks
	 * @return list of all tasks
	 */
	public List<Task> getAllTask() {
		//TODO 
		return null;
	}
	/**
	 * Add a new task
	 * @param task 
	 * @return true if succeed(name is unique and no other exceptions occur)
	 */
	public boolean addTask(Task task) {
		//TODO
		return false;
	}
	/**
	 * Remove a task
	 * @param task
	 * @return true if succeed
	 */
	public boolean removeTask(Task task) {
		//TODO
		return false;
	}
	/**
	 * Update a task
	 * @param task
	 * @return true if succeed
	 */
	public boolean updateTask(Task task) {
		//TODO
		return false;
	}
	/**
	 * Search task by name
	 * @param name
	 * @return true if task already exist
	 */
	public boolean hasTask(String name) {
		//TODO
		return false;
	}
	/**
	 * Initialize task from database, this method should
	 * only be invoked when initializing
	 */
	public void initTask() {
		//TODO taskList = ... (read from database)
	}
	/**
	 * Write task back to database, only invoked when plug-in stops
	 */
	public void saveTask() {
		//TODO 
	}
}
