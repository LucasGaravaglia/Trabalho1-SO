public class Main {

	// Método que faz as chamadas de thread e mostra o estados delas, para
	// demonstrar o funcionamento do monitor
	public static void main(String args[]) throws Exception {
		MyThread thrd = new MyThread();
		MyThread thrd2 = new MyThread();
		thrd.setName("#1 ");
		thrd2.setName("#2 ");
		showThreadStatus(thrd);
		showThreadStatus(thrd2);
		thrd.start();
		thrd2.start();

		thrd.waiting = false;
		Thread.sleep(3);
		showThreadStatus(thrd);
		showThreadStatus(thrd2);

		thrd2.waiting = false;
		Thread.sleep(3);
		showThreadStatus(thrd);
		showThreadStatus(thrd2);

		thrd.notice();
		Thread.sleep(3);
		showThreadStatus(thrd);
		showThreadStatus(thrd2);

		thrd2.notice();
		Thread.sleep(5);
		showThreadStatus(thrd);
		showThreadStatus(thrd2);

		Thread.sleep(5);
		showThreadStatus(thrd);
		showThreadStatus(thrd2);

	}

	static void showThreadStatus(Thread thrd) {
		System.out.println(thrd.getName() + "  Alive:=" + thrd.isAlive() + " State:=" + thrd.getState());
	}
}
