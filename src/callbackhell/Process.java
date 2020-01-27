package callbackhell;

public interface Process {
	abstract Object process();
	void onResult(Object result);
	void onError(Exception error);
}