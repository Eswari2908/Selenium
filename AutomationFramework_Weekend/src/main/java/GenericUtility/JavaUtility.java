package GenericUtility;

import java.time.LocalDateTime;

public class JavaUtility {
	/**
	 * It captures current system date and time and returns to the caller
	 * @return
	 */
	
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
		
	}

}
