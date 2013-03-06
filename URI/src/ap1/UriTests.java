package ap1;

public class UriTests {

	public static void should_fail_if_asserts_are_enabled() {
	
		boolean condition = false;
		assert condition; // O programa deve parar com excep��o "AssertionError" neste ponto
	}

	public static void should_not_parse_malformed_host() {
		Uri malformedUri = Uri.createUri("httxp://www.isel");
		assert malformedUri == null;
	}
	
	public static void should_parse_uri_with_host_and_default_path() {
		Uri iselUri = Uri.createUri("http://www.isel.pt/");
		assert iselUri != null;	// assertNotNull(iselUri);
		assertEquals(iselUri.getHost(), "www.isel.pt");
		assertEquals(iselUri.getPath(), "/");
		assertEquals(iselUri.getPort(), (short)-1);
		assertEquals(iselUri.getQueryString(), "");

		System.out.println("URL: " + iselUri.toString());
	}

	public static void should_parse_uri_with_host_and_path_without_querystring() {
		Uri iselUri = Uri.createUri("http://www.isel.pt/alunos");
		assert iselUri != null;
		assertEquals(iselUri.getHost(), "www.isel.pt");
		assertEquals(iselUri.getPath(), "/alunos");
		assertEquals(iselUri.getPort(), (short)-1);
		assertEquals(iselUri.getQueryString(), "");

		System.out.println("URL: " + iselUri.toString());
	}

	public static void should_parse_uri_with_host_and_path_with_querystring() {
		Uri iselUri = Uri.createUri("http://www.isel.pt/alunos?num=22");
		assert iselUri != null;
		assertEquals(iselUri.getHost(), "www.isel.pt");
		assertEquals(iselUri.getPath(), "/alunos");
		assertEquals(iselUri.getPort(), (short)-1);
		assertEquals(iselUri.getQueryString(), "?num=22");

		System.out.println("URL: " + iselUri.toString());
	}


	private static void assertEquals(String value, String expected)
	{
		if(!value.equals(expected)) {
			System.err.println(
				java.text.MessageFormat.format("Assert Error: expected value {0} instead of {1}", expected, value)
			); 
			assert value.equals(expected);
		}
	}

	private static void assertEquals(short value, short expected)
	{
		if(value != expected) {
			System.err.println(
				java.text.MessageFormat.format("Assert Error: expected value {0} instead of {1}", expected, value)
			); 
			assert value == expected;
		}
	}

	public static void main(String[] args) {
		//should_fail_if_asserts_are_enabled();
		should_not_parse_malformed_host();
		should_parse_uri_with_host_and_default_path();
		should_parse_uri_with_host_and_path_without_querystring();
		//should_parse_uri_with_host_and_path_with_querystring();
		System.out.println("Success");
	}
	

}
