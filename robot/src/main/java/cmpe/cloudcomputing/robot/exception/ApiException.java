package cmpe.cloudcomputing.robot.exception;

import java.time.ZonedDateTime;

public class ApiException {
	private final String message;
	private final int status;
	private final ZonedDateTime timestamp;
	
	public ApiException(String message, int httpStatus, ZonedDateTime timestamp) {
		this.message = message;
		this.status = httpStatus;
		this.timestamp = timestamp;
	}
	
	public String getMessage() {
		return this.message;
	}
	public int getStatus() {
		return status;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

}