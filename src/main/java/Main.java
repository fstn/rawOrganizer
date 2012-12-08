import org.fuid.FuidRunner;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		FuidRunner runner = new FuidRunner();
		runner.loadConfig("src/main/META-INF/fuid.xml");
		runner.run();

	}

}
