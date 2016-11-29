package de.westphaf;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

public class QueueTest {
	
	private static Queue queue;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		queue = new Queue(3);
	}
	
	@After
	public void clearQueue(){
		queue = new Queue(3);
	}

	@Test
	public void simpleDequeue() {
		queue.enqueue(1);
		assertEquals(1,queue.dequeue());
	}
	
	@Test
	public void advancedDequeue(){
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(5, queue.dequeue());
		
		queue.enqueue(6);
		assertEquals(6, queue.queue[0]);
	}
	
	@Test(expected=IllegalStateException.class)
	public void dequeueEmptyQueue(){
		queue.dequeue();
	}
	
	@Test(expected=IllegalStateException.class)
	public void dequeueTooManyTimes(){
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}
	
	@Test
	public void finalQueueTest(){
		queue.enqueue(1);
		queue.enqueue(2);
		
		assertEquals(1, queue.dequeue());
		
		queue.enqueue(3);
		assertEquals(3, queue.queue[2]);
		assertEquals(2, queue.dequeue());
		
		queue.enqueue(4);
		queue.enqueue(5);
		assertEquals(3, queue.dequeue());
		assertEquals(4, queue.dequeue());
	}
	
	

}
