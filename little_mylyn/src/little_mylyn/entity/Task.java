package little_mylyn.entity;

import java.util.ArrayList;
import java.util.List;

import little_mylyn.biz.TaskManager;

public class Task {
	private TaskState state;
	private TaskType type;
	private String name;
	private ClassFolder classFolder;
	private List<TaskFile> fileList;
	
	// all tasks are "new" when created
	public Task(TaskType type, String name) {
		this.state = TaskState.New;
		this.type = type;
		this.name = name;
		fileList = new ArrayList<>();
		classFolder = new ClassFolder(this);
	}

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		if (state.equals(TaskState.Activated))
			TaskManager.getTaskManager().getAllTask().stream()
				.filter(t -> t.getState().equals(TaskState.Activated))
				.forEach(t -> t.setState(TaskState.Finished));
		this.state = state;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	public String toString() {
		return name;
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

	public ClassFolder getClassFolder() {
		return classFolder;
	}
}
