package test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;

import com.gs.sdk.task.BaseTask;
import com.gs.sdk.task.BaseTaskFactory;
import com.gs.sdk.task.DefaultTask;
import com.gs.sdk.task.DefaultTaskFactory;
import com.gs.common.utils.LogMaker;

public class Test {  
	public static Logger log = LogMaker.make();
	private Integer id;
	public Test(Integer id){
		this.id = id;
	}

	public static void main(String[] args) {
		System.out.println(Long.getLong(null));
	}

}

class A{
	public void test(){
		System.out.println("A");
	}
}

class B extends A{
	public void test(){
		System.out.println("B");
	}
}