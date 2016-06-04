package little_mylyn.entity;

public enum TaskType{
	debug, new_feature, refactor;
	
	public String toString() {
		if (this.equals(new_feature))
			return "new feature";
		return name();
	}
	public static TaskType get(String typeStr){
		switch(typeStr.toLowerCase()){
			case "debug":
				return debug;
			case "new feature":
				return new_feature;
			case "refactor":
				return refactor;
			default:
				return null;
		}
	}
}
