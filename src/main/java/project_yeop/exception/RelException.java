package project_yeop.exception;

@SuppressWarnings("serial")
public class RelException extends RuntimeException {

	public RelException() {
		super("이미 출고되었습니다.");
	}

	public RelException(Throwable cause) {
		super("이미 출고되었습니다.", cause);
	}

	public RelException(String message) {
		super(message);
	}
}
