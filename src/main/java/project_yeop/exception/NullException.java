package project_yeop.exception;

@SuppressWarnings("serial")
public class NullException extends RuntimeException {

	public NullException() {
		super("검색 결과가 존재하지 않습니다.");
	}

	public NullException(Throwable cause) {
		super("검색 결과가 존재하지 않습니다.", cause);
	}

	public NullException(String message) {
		super(message);
	}
}
