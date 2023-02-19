package thread.forkJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class NewTask extends RecursiveAction {

	private long Load = 0;

	public NewTask(long Load) {
		this.Load = Load;
	}

	@Override
	protected void compute() {
		
		List<NewTask> subtasks = new ArrayList<NewTask>();
        subtasks.addAll(createSubtasks());
         
        for (RecursiveAction subtask : subtasks) {
            subtask.fork();
        }

	}

	private List<NewTask> createSubtasks() {
		
		List<NewTask> subtasks = new ArrayList<NewTask>();
		NewTask subtask1 = new NewTask(this.Load / 2);
		NewTask subtask2 = new NewTask(this.Load / 2);
		NewTask subtask3 = new NewTask(this.Load / 2);
		NewTask subtask4 = new NewTask(this.Load / 2);
		
		subtasks.add(subtask1);
		subtasks.add(subtask2);
		subtasks.add(subtask3);
		subtasks.add(subtask4);

		return subtasks;
	}

}
