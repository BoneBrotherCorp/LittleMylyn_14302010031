package little_mylyn.entity;

public enum TaskType {
	debug, new_feature, refactor;
	
	public String toString() {
		if (this.equals(new_feature))
			return "new feature";
		return name();
	}
}
