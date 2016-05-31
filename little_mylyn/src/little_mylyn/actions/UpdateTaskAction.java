package little_mylyn.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class UpdateTaskAction implements IWorkbenchWindowActionDelegate{

	@Override
	public void run(IAction action) {
		// TODO should get the selected task first, then show a small window for
		// user to change the task properties(name, state and type)
		
		// Caution: name should be checked, type must be one of the three types
		// only one task can be 'activated', i.e, if one task is set to be activated, 
		// the old activated task should be set to 'finished'
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		
	}

}
