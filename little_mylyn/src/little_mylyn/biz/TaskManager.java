package little_mylyn.biz;

import java.util.ArrayList;
import java.util.List;

import little_mylyn.entity.Task;
import little_mylyn.entity.TaskFile;
import little_mylyn.entity.TaskState;
import little_mylyn.entity.TaskType;

import java.io.*;


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
		return taskList;
	}
	/**
	 * Add a new task
	 * @param task 
	 * @return true if succeed(name is unique and no other exceptions occur)
	 */
	//the parameter is the one that has been modified
	public boolean addTask(Task task) {
		if (hasTask(task.getName())) {
			return false;
		}
		else{
			taskList.add(task);
			return true;
		}
	}
	/**
	 * Insure at most one task can be activated
	 * @param task the only one task which can be activated 
	 */
	public void keepOneActivated(Task task) {
		taskList.stream()
			.filter(t -> t != task && t.getState().equals(TaskState.Activated))
			.forEach(t -> t.setState(TaskState.Finished));
	}
	/**
	 * Remove a task
	 * @param task
	 * @return true if succeed
	 */
	public boolean removeTask(Task task) {
		if (hasTask(task.getName())) {
			taskList.remove(task);
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Search task by name
	 * @param name
	 * @return true if task already exist
	 */
	public boolean hasTask(String name) {
		return taskList.stream().anyMatch(t -> t.getName().equals(name));
	}
	/**
	 * Search task by name
	 * @param name
	 * @return task with given name, return null if there are no such task
	 */
	public Task getTask(String name) {
		return taskList.stream().filter(t -> t.getName().equals(name))
				.findFirst().orElse(null);
	}
	/**
	 * Get the activated task(At most one task can be activated)
	 * @return the activated task, null if not exist
	 */
	public Task getActivatedTask() {
		return taskList.stream().filter(t -> t.getState().equals(TaskState.Activated))
				.findFirst().orElse(null);
	}
	/**
	 * Initialize task from database, this method should
	 * only be invoked when initializing
	 */
	public void initTask() {
		taskList = new ArrayList<>();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(new File("out.txt"));
			InputStreamReader reader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String linetxtString;
			while ((linetxtString = bufferedReader.readLine())!=null) {
				Task newTask;
				String[] newStrings = linetxtString.split(";");
				if (newStrings[1].equals("new feature")) {
					newTask = new Task(TaskType.new_feature,newStrings[0]);
				}
				else {
					newTask = new Task(TaskType.valueOf(newStrings[1]), newStrings[0]);
				}
				newTask.setState(TaskState.valueOf(newStrings[2]));
				for (int i = 3; i < newStrings.length; i=i+2) {
					newTask.addFile(new TaskFile(newStrings[i], newStrings[i+1]));
				}
				taskList.add(newTask);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			//ignore if file not exists
		} catch (IOException e) {
			//report when i/o error
			e.printStackTrace();
		} 
	}
	/**
	 * Write task back to database, only invoked when plug-in stops
	 */
	public void saveTask() {
		try {
			FileOutputStream fsFileOutputStream = new FileOutputStream(new File("out.txt"));
			PrintStream printStream = new PrintStream(fsFileOutputStream);
			for (int i = 0; i < taskList.size(); i++) {
				printStream.print(taskList.get(i).getName()+";"+
						taskList.get(i).getType()+";"+taskList.get(i).getState());
				for (int j = 0; j < taskList.get(i).getFileList().size(); j++) {
					printStream.print(";"+taskList.get(i).getFileList().get(j).toString()+
							";"+taskList.get(i).getFileList().get(j).getPath());
				}
				printStream.print("\n");
			}
			printStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
