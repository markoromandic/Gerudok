package command;

public class UndoCommand implements Order{
	
	private Action action;
	
	public UndoCommand(Action action) {
		// TODO Auto-generated constructor stub
		this.action=action;
		execute();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		action.undo();
	}

}
