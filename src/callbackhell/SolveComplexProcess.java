package callbackhell;

public class SolveComplexProcess {

	static final int FASE_ONE = 1;
	static final int FASE_TWO = 2;
	static final int FASE_THREE = 3;
	static final int FASE_FOUR = 4;
	static final int FASE_FIVE = 5;
	static final int FINAL_FASE = 6;

	public void execFase(int fase, Object result) {
		switch (fase) {
		case FASE_ONE:
			faseOne();
			break;
		case FASE_TWO:
			faseTwo(result);
			break;
		case FASE_THREE:
			faseThree(result);
			break;
		case FASE_FOUR:
			faseFour(result);
			break;
		case FASE_FIVE:
			faseFive(result);
			break;
		case FINAL_FASE:
			System.out.println(result);
			break;
		default:
			System.out.println("No fase");
			break;
		}
	}
	private void faseOne() {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 1";
			}

			@Override
			public void onResult(Object result) {
				execFase(FASE_TWO, result);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_ONE, error);
			}
		}).start();
	}
	private void faseTwo(final Object previousResult) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return previousResult.toString() + " Result 2";
			}

			@Override
			public void onResult(Object result) {
				execFase(FASE_THREE, result);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_TWO, error);
			}
		}).start();

	}

	private void faseThree(final Object previousResult) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return previousResult.toString() + " Result 3";
			}

			@Override
			public void onResult(Object result) {
				execFase(FASE_FOUR, result);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_THREE, error);
			}
		}).start();

	}
	
	private void faseFour(final Object previousResult) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return previousResult.toString() + " Result 4";
			}

			@Override
			public void onResult(Object result) {
				execFase(FASE_FIVE, result);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_FOUR, error);
			}
		}).start();

	}
	
	private void faseFive(final Object previousResult) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return previousResult.toString() + " Result 5";
			}

			@Override
			public void onResult(Object result) {
				execFase(FINAL_FASE, result);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_FIVE, error);
			}
		}).start();
	}

	
	public void error(int fase, Exception e) {
		System.out.println("Error in Fase " + fase);
		e.printStackTrace();
	}
}
