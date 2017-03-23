package check;

public class TarjanInfo {
	public static final int TARJAN_UNDEFINED = -1;
	protected int tarjanIndex = TARJAN_UNDEFINED;
	protected int  tarjanLowlink = TARJAN_UNDEFINED;
	protected boolean tarjanOnStack = false;
	
	protected void resetTarjan() {
		tarjanIndex = TARJAN_UNDEFINED;
		tarjanLowlink = TARJAN_UNDEFINED;
		tarjanOnStack = false;
	}
}
