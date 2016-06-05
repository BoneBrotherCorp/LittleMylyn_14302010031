package little_mylyn.views;

import little_mylyn.actions.AddTaskAction;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class TaskView extends ViewPart {

	public static final String ID = "little_mylyn.views.TaskView";
	
	private static TreeViewer viewer;
	public static void refresh(){
		viewer.refresh();
	}
	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new TreeContentProvider(this));
//		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new ViewerSorter());
		viewer.setInput(getViewSite());

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager manager = bars.getToolBarManager();
		manager.add(new AddTaskAction());
		
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "little_mylyn.viewer");
//		makeActions();
//		hookContextMenu();
//		hookDoubleClickAction();
//		contributeToActionBars();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
}
