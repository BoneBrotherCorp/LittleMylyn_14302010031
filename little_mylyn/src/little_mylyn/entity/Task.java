package little_mylyn.entity;

import java.util.ArrayList;
import java.util.List;

public class Task {
	private TaskState state;
	private TaskType type;
	private String name;
	private List<TaskFile> fileList;
	
	// all tasks are "new" when created
	public Task(TaskType type, String name) {
		this.state = TaskState.New;
		this.type = type;
		this.name = name;
		fileList = new ArrayList<>();
	}

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TaskFile> getFileList() {
		return fileList;
	}

	public void addFile(TaskFile file) {
		fileList.add(file);
	}
}
