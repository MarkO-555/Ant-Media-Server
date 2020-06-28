package io.antmedia.shutdown;

import java.util.ArrayList;
import java.util.List;

public class AMSShutdownManager {
	private static AMSShutdownManager instance = new AMSShutdownManager();

	private boolean isShuttingDown = false;

	private ArrayList<IShutdownListener> listeners = new ArrayList<>();

	//this is not included to the list to guarantee called at the last
	private IShutdownListener shutdownServer;

	public static AMSShutdownManager getInstance() {
		return instance;
	}

	//make a private constructor for singleton instance
	private AMSShutdownManager() {
	}

	public void subscribe(IShutdownListener listener) {
		listeners.add(listener);
	}

	public synchronized void notifyShutdown() {
		System.out.println("notify shutdown ----> " + System.currentTimeMillis());
		/*
		if(!isShuttingDown) 
		{
			try {
				System.out.println("notify shutdown -- number of listener count: " + listeners.size() + " time: " + System.currentTimeMillis());
				isShuttingDown = true;
				for (IShutdownListener listener : listeners) {
					System.out.println("before serverShutdown -- " + listener.getClass().getCanonicalName() + " time: " + System.currentTimeMillis());
					try {
						listener.serverShuttingdown();
					}
					catch (Exception e) {
						System.out.println("++++++++++++++");
						e.printStackTrace();
					}
					System.out.println("after servershutdown --");
				}
				System.out.println("Before shutdownServer --- " + shutdownServer);
				if(shutdownServer != null) {
					shutdownServer.serverShuttingdown();
				}
				System.out.println("After Shutdown server ---");
			}
			catch (Exception e) {
				System.out.println("-------------");
				e.printStackTrace();
			}


		}
		*/
	}

	public List<IShutdownListener> getListeners() {
		return listeners;
	}

	public void setShutdownServer(IShutdownListener shutdownServer) {
		this.shutdownServer = shutdownServer;
	}

	public IShutdownListener getShutdownServer() {
		return shutdownServer;
	}
}
