package my.code.forest;

public class Timer {
	private long startIteration;
	private long endIteration;
	private long iterationTime;
	private long totalTime = 0;
	
	public void startIter() {
		startIteration = System.nanoTime();
	}
	public long iterTime() {
		endIteration = System.nanoTime();
		iterationTime = endIteration - startIteration;
		totalTime += iterationTime;
		return iterationTime;
	}
	public long totalTime() {
		return totalTime;
	}
}
