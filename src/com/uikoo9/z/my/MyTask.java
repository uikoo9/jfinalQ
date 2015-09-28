package com.uikoo9.z.my;

import it.sauronsoftware.cron4j.Task;
import it.sauronsoftware.cron4j.TaskExecutionContext;

public class MyTask extends Task{
	
	@Override
	public boolean canBePaused() {
		return true;
	}

	@Override
	public boolean canBeStopped() {
		return true;
	}

	@Override
	public boolean supportsCompletenessTracking() {
		return true;
	}

	@Override
	public boolean supportsStatusTracking() {
		return true;
	}

	@Override
	public void execute(TaskExecutionContext arg0) throws RuntimeException {
		System.out.println(1);
	}
	
}
