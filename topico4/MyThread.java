class MyThread extends Thread {
	boolean waiting = true;
	boolean ready = false;

	MyThread() {
	}

	// Executa a thread, caso tenha outra thread rodando ele aguarda a outra
	// terminar
	public void run() {
		String thrdName = Thread.currentThread().getName();
		System.out.println(thrdName + " starting.");
		while (waiting)
			System.out.println(thrdName + " waiting:" + waiting);
		System.out.println(thrdName + " waiting...");
		startWait();
		try {
			Thread.sleep(1000);
		} catch (Exception exc) {
			System.out.println(thrdName + " interrupted.");
		}
		System.out.println(thrdName + " terminating.");
	}

	// Função que da block na thread até q a outra libere
	synchronized void startWait() {
		try {
			while (!ready)
				wait();
		} catch (InterruptedException exc) {
			System.out.println("wait() interrupted");
		}
	}

	// Libera as outras threads
	synchronized void notice() {
		ready = true;
		notify();
	}
}