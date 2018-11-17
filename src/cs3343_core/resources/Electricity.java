package cs3343_core.resources;

public class Electricity implements Resource {
	public static final String type = "electricity";

	@Override
	public String getType() {
		return type;
	}
}
