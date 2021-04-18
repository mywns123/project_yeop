package project_yeop.exception;

@SuppressWarnings("serial")
public class InvalidationException extends RuntimeException {

	public InvalidationException() {
		super("형식이 맞지 않습니다.");
	}

	public InvalidationException(Throwable cause) {
		super("형식이 맞지 않습니다.", cause);
	}

	public InvalidationException(String message) {
		super(message);
	}
}
