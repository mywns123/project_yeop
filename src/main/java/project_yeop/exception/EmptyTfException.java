package project_yeop.exception;

@SuppressWarnings("serial")
public class EmptyTfException extends RuntimeException {

	public EmptyTfException() {
		super("공백이 존재합니다.");
	}

	public EmptyTfException(Throwable cause) {
		super("공백이 존재합니다.", cause);
	}

	public EmptyTfException(String message) {
		super(message);
	}
}
