package little_mylyn.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class UpdateTaskAction implements IAction {

	@Override
	public void addPropertyChangeListener(IPropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAccelerator() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getActionDefinitionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HelpListener getHelpListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getHoverImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMenuCreator getMenuCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStyle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isChecked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removePropertyChangeListener(IPropertyChangeListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runWithEvent(Event arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAccelerator(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActionDefinitionId(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setChecked(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisabledImageDescriptor(ImageDescriptor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHelpListener(HelpListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHoverImageDescriptor(ImageDescriptor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setId(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImageDescriptor(ImageDescriptor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMenuCreator(IMenuCreator arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setText(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setToolTipText(String arg0) {
		// TODO Auto-generated method stub
		
	}
//
//	@Override
//	public void run(IAction action) {
//		// TODO should get the selected task first, then show a small window for
//		// user to change the task properties(name, state and type)
//		
//		// Caution: name should be checked, type must be one of the three types
//		// only one task can be 'activated', i.e, if one task is set to be activated, 
//		// the old activated task should be set to 'finished'
//	}
//
//	@Override
//	public void selectionChanged(IAction action, ISelection selection) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void dispose() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void init(IWorkbenchWindow window) {
//		// TODO Auto-generated method stub
//		
//	}

}
