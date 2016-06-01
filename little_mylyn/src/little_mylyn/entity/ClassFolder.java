package little_mylyn.entity;

import java.util.List;


public class ClassFolder {
	private Task task;
	
	public ClassFolder(Task task) {
		this.task = task;
	}

	public List<TaskFile> getFileList() {
		return task.getFileList();
	}
	
	public String toString() {
		return "Related Class(" + task.getFileList().size() + ")";
	}
}
