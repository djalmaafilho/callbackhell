package callbackhell;

public class SolveComplexProcess {

	static final int PHASE_ONE = 1;
	static final int PHASE_TWO = 2;
	static final int PHASE_THREE = 3;
	static final int PHASE_FOUR = 4;
	static final int PHASE_FIVE = 5;
	static final int FINAL_PHASE = 6;

	public void execPhase(int fase, Object result) {
		switch (fase) {
		case PHASE_ONE:
			phaseOne();
			break;
		case PHASE_TWO:
			phaseTwo(result);
			break;
		case PHASE_THREE:
			phaseThree(result);
			break;
		case PHASE_FOUR:
			phaseFour(result);
			break;
		case PHASE_FIVE:
			phaseFive(result);
			break;
		case FINAL_PHASE:
			System.out.println(result);
			break;
		default:
			System.out.println("No fase");
			break;
		}
	}
	private void phaseOne() {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 1";
			}

			@Override
			public void onResult(Object result) {
				execPhase(PHASE_TWO, result);
			}

			@Override
			public void onError(Exception error) {
				error(PHASE_ONE, error);
			}
		}).start();
	}
	private void phaseTwo(final Object previousResult) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return previousResult.toString() + " Result 2";
			}

			@Override
			public void onResult(Object result) {
				execPhase(PHASE_THREE, result);
			}

			@Override
			public void onError(Exception error) {
				error(PHASE_TWO, error);
			}
		}).start();

	}

	private void phaseThree(final Object previousResult) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return previousResult.toString() + " Result 3";
			}

			@Override
			public void onResult(Object result) {
				execPhase(PHASE_FOUR, result);
			}

			@Override
			public void onError(Exception error) {
				error(PHASE_THREE, error);
			}
		}).start();

	}
	
	private void phaseFour(final Object previousResult) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return previousResult.toString() + " Result 4";
			}

			@Override
			public void onResult(Object result) {
				execPhase(PHASE_FIVE, result);
			}

			@Override
			public void onError(Exception error) {
				error(PHASE_FOUR, error);
			}
		}).start();

	}
	
	private void phaseFive(final Object previousResult) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return previousResult.toString() + " Result 5";
			}

			@Override
			public void onResult(Object result) {
				execPhase(FINAL_PHASE, result);
			}

			@Override
			public void onError(Exception error) {
				error(PHASE_FIVE, error);
			}
		}).start();
	}

	
	public void error(int fase, Exception e) {
		System.out.println("Error in Fase " + fase);
		e.printStackTrace();
	}
}
