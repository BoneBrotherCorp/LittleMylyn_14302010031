package little_mylyn.views;

import little_mylyn.biz.TaskManager;
import little_mylyn.entity.Task;
import little_mylyn.entity.TaskState;
import little_mylyn.entity.TaskType;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class EditWizard extends Wizard {
	public static final String NAME = "NAME";  
	public static final String TYPE = "TYPE";  
	public static final String STATE = "STATE";
	public static final String SUCCEED = "SUCCEED";
	
	private NamePage name_p;
	private TypePage type_p;
	private StatePage state_p;
	private SucceedPage succeed_p;
	private Task task;
	
	public EditWizard(Task task) {
		this.task = task;
		
		name_p = new NamePage();  
        type_p = new TypePage();  
        state_p = new StatePage();
        succeed_p = new SucceedPage();
          
        this.addPage(name_p);  
        this.addPage(type_p);  
        this.addPage(state_p);
        this.addPage(succeed_p);
        this.setWindowTitle("Edit Task");  
	}

	@Override
	public boolean performFinish() {
		String name = name_p.name_input.getText();
		Button type_button_selected = type_p.b1.getSelection()?type_p.b1:(type_p.b2.getSelection()?type_p.b2:type_p.b3);
		TaskType taskType = TaskType.get(type_button_selected.getText());
		Button state_button_selected = state_p.b2.getSelection()?state_p.b2:state_p.b3;
		TaskState taskState = TaskState.get(state_button_selected.getText());
		task.setName(name);
		task.setState(taskState);
		task.setType(taskType);
		TaskManager.getTaskManager().keepOneActivated(task);
		TaskView.refresh();
		return true;
	}  

	public boolean canFinish(){  
        if(this.getContainer().getCurrentPage() == succeed_p)  
        	return true;  
        else  
	        return false;  
	}  
	
	private class NamePage extends WizardPage{
		
		Text name_input;
		NamePage page = this;
		public NamePage(){
			super(NAME,"Edit a task",null);
			this.setMessage("Please enter the name.");
		}

		@Override
		public void createControl(Composite parent) {
			 Composite composite = new Composite(parent, SWT.NONE);  
		     composite.setLayout(new GridLayout(2, false));
		     new Label(composite,SWT.LEFT).setText("Name");
		     name_input = new Text(composite, SWT.SINGLE | SWT.BORDER); 
		     name_input.setTextLimit(50);
		     name_input.setText(task.getName());
		     name_input.setLayoutData(new GridData(50, name_input.getLineHeight()));
		     this.setPageComplete(true);
		     name_input.setSize(200, name_input.getLineHeight());
		     name_input.setToolTipText("Enter the name of this task!");   
		     name_input.selectAll();  // enable fast erase
		     name_input.addModifyListener(new ModifyListener(){

				@Override
				public void modifyText(ModifyEvent arg0) {
					Task t = TaskManager.getTaskManager().getTask(name_input.getText());
					if(t != null && t != task){
						page.setPageComplete(false);
						page.setErrorMessage("This name have existed.");
					}else if(name_input.getText().length()==0){
						page.setPageComplete(false);
						page.setMessage("Please enter the name.");
					} else {
						page.setErrorMessage(null);
						page.setPageComplete(true);
					}
				}
		     });
		     setControl(composite);  
		}
	}
	
	private class TypePage extends WizardPage{
		Button b1,b2,b3;
		public TypePage(){
			super(TYPE,"Edit a task",null);
			this.setMessage("Set the type");
		}

		@Override
		public void createControl(Composite parent) {
			 Composite composite = new Composite(parent, SWT.NONE);  
		     composite.setLayout(new GridLayout(1, false));  
		     new Label(composite, SWT.CENTER).setText("Type:");  
		     b1 =  new Button(composite, SWT.RADIO);  
		     b1.setText("debug");  
		     b1.setSelection(true);  
		     b2 = new Button(composite, SWT.RADIO);  
		     b2.setText("new feature");  
		     b3 = new Button(composite, SWT.RADIO);  
		     b3.setText("refactor");  
		     setControl(composite);  
		}
	}
	
	private class StatePage extends WizardPage{
		Button b2,b3;
		public StatePage(){
			super(STATE,"Edit a task",null);
			this.setMessage("Set the state");
		}

		@Override
		public void createControl(Composite parent) {
			 Composite composite = new Composite(parent, SWT.NONE);  
		     composite.setLayout(new GridLayout(1, false));  
		     new Label(composite, SWT.CENTER).setText("State:");  
//		     b1 =  new Button(composite, SWT.RADIO);  
//		     b1.setText("New");  
//		     b1.setSelection(true);  
		     b2 = new Button(composite, SWT.RADIO);  
		     b2.setText("Activated");  
		     b2.setSelection(true);
		     b3 = new Button(composite, SWT.RADIO);  
		     b3.setText("Finished");  
		     setControl(composite); 
		}
	}
	
	private class SucceedPage extends WizardPage{
		public SucceedPage(){
			super(SUCCEED,"Done",null);
		}

		@Override
		public void createControl(Composite parent) {
			 Composite composite = new Composite(parent, SWT.NONE);  
		     composite.setLayout(new FillLayout());  
		     new Label(composite, SWT.LEFT).setText("You have edit a task successfully!");
		     setControl(composite);  
		}
	}
}
