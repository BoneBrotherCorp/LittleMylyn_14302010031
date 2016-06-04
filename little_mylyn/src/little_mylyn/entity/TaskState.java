package little_mylyn.entity;

public enum TaskState{
	New, Activated, Finished;
	
	public static TaskState get(String stateStr){
		switch(stateStr.toLowerCase()){
			case "new":
				return New;
			case "activated":
				return Activated;
			case "finished":
				return Finished;
			default:
					return New;
		}
	}
}
