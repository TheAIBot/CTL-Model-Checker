package check;

public class TarjanInfo {
	public static final int UNDEFINED = -1;
	protected int index = UNDEFINED;
	protected int  lowlink = UNDEFINED;
	protected boolean onStack = false;
	
	protected void resetTarjan() {
		index = UNDEFINED;
		lowlink = UNDEFINED;
		onStack = false;
	}
}
