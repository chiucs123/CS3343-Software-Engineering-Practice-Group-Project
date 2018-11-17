package cs3343_core.resources;

public abstract interface Resource {
	public static Resource water = (Resource) new Water();
	public static Resource electricity = (Resource) new Electricity();
	public static Resource network = (Resource) new Network();
	public static Resource gas = (Resource) new Gas();

	public String getType();
}
