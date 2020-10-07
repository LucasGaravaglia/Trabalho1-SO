
public class Main {
	public static void main(String args[]) throws Exception {
		MyThread thrd1 = new MyThread();
		MyThread thrd2 = new MyThread();

		thrd1.setName("MyThread #1");
		thrd2.setName("MyThread #2");
		showThreadStatus(thrd1);
		showThreadStatus(thrd2);
		thrd1.start();
		thrd2.start();

		Thread.sleep(1);
		showThreadStatus(thrd1);
		showThreadStatus(thrd2);
		thrd1.waiting = false;
		thrd2.waiting = false;

		Thread.sleep(1);
		showThreadStatus(thrd1);
		showThreadStatus(thrd2);
		thrd1.notice();
		thrd2.notice();

		Thread.sleep(1);
		showThreadStatus(thrd1);
		showThreadStatus(thrd2);

	}

	static void showThreadStatus(Thread thrd) {
		System.out.println(thrd.getName() + "  Alive:=" + thrd.isAlive() + " State:=" + thrd.getState());
	}
}
