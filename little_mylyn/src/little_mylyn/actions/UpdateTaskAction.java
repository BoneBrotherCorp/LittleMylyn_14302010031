package little_mylyn.actions;

import little_mylyn.entity.Task;
import little_mylyn.views.EditWizard;
import little_mylyn.views.NewWizard;
import little_mylyn.views.TaskView;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.internal.IWorkbenchGraphicConstants;
import org.eclipse.ui.internal.WorkbenchImages;

public class UpdateTaskAction implements IAction {
	ImageDescriptor enabledImage = WorkbenchImages.getImageDescriptor(IWorkbenchGraphicConstants.IMG_ETOOL_PIN_EDITOR);
	ImageDescriptor disabledImage = WorkbenchImages.getImageDescriptor(IWorkbenchGraphicConstants.IMG_ETOOL_PIN_EDITOR);
	String actionId;
	String description = "edit a task state";
	String toolTipText = "edit task";
	boolean isCheck = true;
	boolean isEnabled = true;
	boolean isHandled = true;
	
	@Override
	public void addPropertyChangeListener(IPropertyChangeListener arg0) {
	}

	@Override
	public int getAccelerator() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getActionDefinitionId() {
		// TODO Auto-generated method stub
		return actionId;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	@Override
	public ImageDescriptor getDisabledImageDescriptor() {
		// TODO Auto-generated method stub
		return disabledImage;
	}

	@Override
	public HelpListener getHelpListener() {
		return null;
	}

	@Override
	public ImageDescriptor getHoverImageDescriptor() {
		return null;
	}

	@Override
	public String getId() {
		return actionId;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return enabledImage;
	}

	@Override
	public IMenuCreator getMenuCreator() {
		return null;
	}

	@Override
	public int getStyle() {
		return 0;
	}

	@Override
	public String getText() {
		return null;
	}

	@Override
	public String getToolTipText() {
		return toolTipText;
	}

	@Override
	public boolean isChecked() {
		return isCheck;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return isHandled;
	}

	@Override
	public void removePropertyChangeListener(IPropertyChangeListener arg0) {
	}

	@Override
	public void run() {
		System.out.println("\nstart\n");
	}

	@Override
	public void runWithEvent(Event event) {
		TreeViewer treeViewer = TaskView.getTreeViewer();
		IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
		if (selection.size() == 1 && selection.getFirstElement() instanceof Task) {
			EditWizard ew = new EditWizard((Task) selection.getFirstElement());
			WizardDialog dialog = new WizardDialog(null, ew);
			dialog.open();
			return;
		}
		MessageDialog.openInformation(null, "Edit task", "Must select a task!");
	}

	@Override
	public void setAccelerator(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActionDefinitionId(String arg0) {
		this.actionId = arg0;
	}

	@Override
	public void setChecked(boolean arg0) {
		this.isCheck = arg0;
	}

	@Override
	public void setDescription(String arg0) {
		this.description = arg0;
	}

	@Override
	public void setDisabledImageDescriptor(ImageDescriptor arg0) {
		this.disabledImage = arg0;
	}

	@Override
	public void setEnabled(boolean arg0) {
		this.isEnabled = true;
	}

	@Override
	public void setHelpListener(HelpListener arg0) {
		
	}

	@Override
	public void setHoverImageDescriptor(ImageDescriptor arg0) {
		
	}

	@Override
	public void setId(String arg0) {
		this.actionId = arg0;
	}

	@Override
	public void setImageDescriptor(ImageDescriptor arg0) {
		this.enabledImage = arg0;
	}

	@Override
	public void setMenuCreator(IMenuCreator arg0) {
		
	}

	@Override
	public void setText(String arg0) {
		
	}

	@Override
	public void setToolTipText(String arg0) {
		this.toolTipText = arg0;
	}

}
