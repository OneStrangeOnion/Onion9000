package onion9000;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	public static void logInfo(String m) {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date().getTime()) + "] [Onion 9000] [INFO] " + m);
	}

	public static void logWarn(String m) {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date().getTime()) + "] [Onion 9000] [WARN] " + m);
	}

	public static void logFatal(String m) {
		System.err.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date().getTime()) + "] [Onion 9000] [FATAL] " + m);
	}

	public static void logDebug(String m) {
		System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date().getTime()) + "] [Onion 9000] [DEBUG] " + m);
	}
}
