package org.fstn.rawOrganizer.event;

public class ViewEvent {
	private Object arg;
	private int type;
	public static int FILECHOOSE=1;
	public static int ASK4RELOAD=2;
	public ViewEvent(int type,Object arg) {
		this.arg=arg;
		this.type=type;
	}
	public Object getArg() {
		return arg;
	}
	public void setArg(Object arg) {
		this.arg = arg;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	

}
