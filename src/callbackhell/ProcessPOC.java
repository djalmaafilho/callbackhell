package callbackhell;

public class ProcessPOC {

	public static void main(String[] args) {
		new BackgroundProcess(new Process() {
			@Override
			public Object process() {
				return "Result1";
			}

			@Override
			public void onResult(Object result) {

				new BackgroundProcess(new Process() {
					String previousResult = result.toString();

					@Override
					public Object process() {
						return previousResult + " Result2";
					}

					@Override
					public void onResult(Object result) {
						new BackgroundProcess(new Process() {
							String previousResult = result.toString();

							@Override
							public Object process() {
								return previousResult + " Result3";
							}

							@Override
							public void onResult(Object result) {
								System.out.println(result);
							}

							@Override
							public void onError(Exception error) {
								error.printStackTrace();
							}
						}).start();
					}

					@Override
					public void onError(Exception error) {
						error.printStackTrace();
					}
				}).start();;
			}

			@Override
			public void onError(Exception error) {
				error.printStackTrace();
			}
		}).start();
	}

}
