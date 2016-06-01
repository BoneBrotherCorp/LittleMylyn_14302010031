package little_mylyn.views;

import little_mylyn.biz.TaskManager;
import little_mylyn.entity.Task;
import little_mylyn.entity.ClassFolder;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class TreeContentProvider implements ITreeContentProvider {
	private TaskView view;
	
	public TreeContentProvider(TaskView view) {
		this.view = view;
	}
	
	@Override
	public void dispose() {	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

	@Override
	public Object[] getChildren(Object parent) {
		if (parent instanceof Task)
			return new Object[] {((Task) parent).getState(), ((Task) parent).getType(), ((Task) parent).getClassFolder() };
		if (parent instanceof ClassFolder)
			return ((ClassFolder) parent).getFileList().toArray();
		return null;
	}

	@Override
	public Object[] getElements(Object parent) {
		if (parent.equals(view.getViewSite()))
			return TaskManager.getTaskManager().getAllTask().toArray();
		return getChildren(parent);
	}

	@Override
	public Object getParent(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object parent) {
		if (parent.equals(view.getViewSite()))
			return true;
		if (parent instanceof Task)
			return true;
		if (parent instanceof ClassFolder)
			return true;
		return false;
	}

}
