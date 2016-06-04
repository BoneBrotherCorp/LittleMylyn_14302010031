package little_mylyn.actions;

import little_mylyn.biz.TaskManager;
import little_mylyn.entity.Task;
import little_mylyn.entity.TaskFile;

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
	    			activatedTask.addFile(new TaskFile(resource.getName(), resource.getFullPath().toOSString()));
	    			System.out.println(resource.getFullPath().toOSString());
	    			try {
	    				//TODO refresh dosen't work
						resource.refreshLocal(IResource.DEPTH_INFINITE, null);
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
	    		return true;
	    	}
	    };
	    try {
	    	rootDelta.accept(visitor);
	    } catch (CoreException e) {
	    	//open error dialog with syncExec or print to plugin log file
	    }
	    //nothing more to do if there were no changed text files
//        switch (event.getType()) {
//           case IResourceChangeEvent.PRE_CLOSE:
//              System.out.print("Project ");
//              System.out.print(res.getFullPath());
//              System.out.println(" is about to close.");
//              break;
//           case IResourceChangeEvent.PRE_DELETE:
//              System.out.print("Project ");
//              System.out.print(res.getFullPath());
//              System.out.println(" is about to be deleted.");
//              break;
//           case IResourceChangeEvent.POST_CHANGE:
//              System.out.println("Resources have changed.");
////              event.getDelta().accept(new DeltaPrinter());
//              break;
//           case IResourceChangeEvent.PRE_BUILD:
//              System.out.println("Build about to run.");
////              event.getDelta().accept(new DeltaPrinter());
//              break;
//           case IResourceChangeEvent.POST_BUILD:
//              System.out.println("Build complete.");
////              event.getDelta().accept(new DeltaPrinter());
//              break;
//     }
	}

}
