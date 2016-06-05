package little_mylyn.actions;

import little_mylyn.biz.TaskManager;
import little_mylyn.entity.Task;
import little_mylyn.entity.TaskFile;
import little_mylyn.views.TaskView;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

public class ResourceChangedListener implements IResourceChangeListener {

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		Task activatedTask = TaskManager.getTaskManager().getActivatedTask();
		if (activatedTask == null)
			return;
	    //we are only interested in POST_CHANGE events
	    if (event.getType() != IResourceChangeEvent.POST_CHANGE)
	    	return;
	    IResourceDelta rootDelta = event.getDelta();
	    //get the delta, if any, for the documentation directory
	    IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
	    	public boolean visit(IResourceDelta delta) {
	    		//only interested in changed resources (not added or removed)
	    		if (delta.getKind() != IResourceDelta.CHANGED)
	    			return true;
	            //only interested in content changes
	    		if ((delta.getFlags() & IResourceDelta.CONTENT) == 0)
	    			return true;
	    		IResource resource = delta.getResource();
	    		//only interested in files with "java" extension
	    		if (resource.getType() == IResource.FILE && "java".equalsIgnoreCase(resource.getFileExtension())) {
	    			if (activatedTask.getFile(resource.getName()) == null) {
	    				activatedTask.addFile(new TaskFile(resource.getName(), resource.getFullPath().toOSString()));
		    			TaskView.refresh();
	    			}
	    		}
	    		return true;
	    	}
	    };
	    try {
	    	rootDelta.accept(visitor);
	    } catch (CoreException e) { }
	}

}
