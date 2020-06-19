package Protocol;

public interface Protocol {

	public default void sendName(String name){};
	public default void sendNameOK(){};
	public default void sendRefus() {};
	
}
