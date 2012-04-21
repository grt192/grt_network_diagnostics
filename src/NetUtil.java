import java.net.InetAddress;


public class NetUtil {
	
	/**
	 * Ping a certain host, and see if it is reachable
	 * @param host The host we want to ping
	 * @param timeout The timeout for the ping (ms)
	 * @return True if reachable, else false.
	 */
	public static boolean ping(String host, int timeout){
		boolean reachable = false;	//If we get an error, we assume the host is unreachable
		try{
			InetAddress addr = InetAddress.getByName(host);
			reachable = addr.isReachable(timeout);
		} catch (Exception e) {
			System.err.println("Error connecting to host " + host);
			e.printStackTrace();
		}
		
		return reachable;
	}

}
