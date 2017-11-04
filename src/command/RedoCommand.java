package command;

public class RedoCommand implements Order{

	private Action action;
	public RedoCommand(Action action) {
		// TODO Auto-generated constructor stub
		this.action=action;
		execute();
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		action.redo();
	}

}
