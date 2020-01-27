package callbackhell;

public class ComplexProcessWithDTO {

	static final int FASE_ONE = 1;
	static final int FASE_TWO = 2;
	static final int FASE_THREE = 3;
	static final int FASE_FOUR = 4;
	static final int FASE_FIVE = 5;
	static final int FASE_SIX = 6;
	static final int FASE_SEVEN = 7;

	static final int FINAL_FASE = 8;

	public void execFase(FasesDTO dto) {
		switch (dto.getActualFase()) {
		case FASE_ONE:
			faseOne(dto);
			break;
		case FASE_TWO:
			faseTwo(dto);
			break;
		case FASE_THREE:
			faseThree(dto);
			break;
		case FASE_FOUR:
			faseFour(dto);
			break;
		case FASE_FIVE:
			faseFive(dto);
			break;
		case FASE_SIX:
			faseSix(dto);
			break;
		case FASE_SEVEN:
			faseSeven(dto);
			break;
		case FINAL_FASE:
			finalFase(dto);
			break;
		default:
			System.out.println("No fase");
			break;
		}
	}

	private void faseOne(final FasesDTO dto) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 1";
			}

			@Override
			public void onResult(Object result) {
				dto.addFaseResult(FASE_TWO, result);
				execFase(dto);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_ONE, error);
			}
		}).start();
	}

	private void faseTwo(final FasesDTO dto) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 2";
			}

			@Override
			public void onResult(Object result) {
				dto.addFaseResult(FASE_THREE, result);
				execFase(dto);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_TWO, error);
			}
		}).start();

	}

	private void faseThree(final FasesDTO dto) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 3";
			}

			@Override
			public void onResult(Object result) {
				dto.addFaseResult(FASE_FOUR, result);
				execFase(dto);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_THREE, error);
			}
		}).start();

	}

	private void faseFour(final FasesDTO dto) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 4";
			}

			@Override
			public void onResult(Object result) {
				dto.addFaseResult(FASE_FIVE, result);
				execFase(dto);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_FOUR, error);
			}
		}).start();

	}

	private void faseFive(final FasesDTO dto) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 5";
			}

			@Override
			public void onResult(Object result) {
				dto.addFaseResult(FASE_SIX, result);
				execFase(dto);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_FIVE, error);
			}
		}).start();
	}

	private void faseSix(final FasesDTO dto) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 6";
			}

			@Override
			public void onResult(Object result) {
				dto.addFaseResult(FASE_SEVEN, result);
				execFase(dto);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_FIVE, error);
			}
		}).start();
	}

	private void faseSeven(final FasesDTO dto) {
		new BackgroundProcess(new Process() {

			@Override
			public Object process() {
				return "Result 7";
			}

			@Override
			public void onResult(Object result) {
				dto.addFaseResult(FINAL_FASE, result);
				execFase(dto);
			}

			@Override
			public void onError(Exception error) {
				error(FASE_FIVE, error);
			}
		}).start();
	}

	private void finalFase(FasesDTO dto) {
		StringBuilder str = new StringBuilder();
		for (Object item : dto.getFasesResult()) {
			str.append(item);
			str.append(" ");
		}
		System.out.println(str.toString());
	}

	public void error(int fase, Exception e) {
		System.out.println("Error in Fase " + fase);
		e.printStackTrace();
	}
}
