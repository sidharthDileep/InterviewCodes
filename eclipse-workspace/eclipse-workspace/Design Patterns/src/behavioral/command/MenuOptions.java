package behavioral.command;

public class MenuOptions {
	
	ActionListenerCommand commandOpen;
	ActionListenerCommand commandSave;
	

	public MenuOptions(ActionListenerCommand clickOpen, ActionListenerCommand clickSave) {
		this.commandOpen = clickOpen;
		this.commandSave = clickSave;
		
	}

	public void clickOpen() {
		commandOpen.execute();
	}

	public void clickSave() {
		commandSave.execute();
	}

}
