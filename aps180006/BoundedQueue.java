// Authors  1. Akash P Akki     net id: apa190001
//          2. Anant Srivastava netid:  aps180006;


package aps180006;

import java.util.Scanner;

public class BoundedQueue<T> {
	
	private T[] queue;
	private int size;
	private int front, rear;
	private int count;
	
	@SuppressWarnings("unchecked")
	public BoundedQueue(int size)                //modified
	{
		queue = (T[]) new Object[size];
		this.size = size;
		front = 0;
		rear = -1;
		count = 0;
	}
	
	//  Check if queue is full
	private boolean isfull()
	{
		return (count==size);
	}
	
	// Add element in queue
	private boolean offer(T x)                 //modified
	{
		if (isfull())
		{
			System.out.println("Queue is full");
			return false;
		}
		
		rear = (rear+1)%size;
		queue[rear] = x;
		System.out.println("Element enqueued succesfully\n");
		count++;
		return true;
		
	}
	
	// Remove element from queue
	private T poll()
	{
		if (isEmpty())
			return null;
		T x = queue[front];
		front = (front+1)%size;
		count--;
		return x;
	}

	
	// Copying queue to array
	@SuppressWarnings("unchecked")
	public void toArray( Object[] arr) {          
		arr = (T[]) new Object[count];
		int j = front;
		for (int i = 0; i<count;i++)
		{
			arr[i] = queue[j];
			j = (j+1)%size;
		}
		System.out.print("Queue copied to array: ");
		
		for (int k = 0; k<count;k++)
			System.out.print(arr[k]+" ");
		System.out.println();
	}
	
	// clearing the queue
	public void clear() {                      
		front = 0;
		rear = -1;
		count = 0;
		System.out.println("Queue is cleared");
	}
	
	// to fetch the element at front of the queue
	private T peek() {
		if (count==0)
			return null;
		else
			return queue[front];
	}
	
	// print the queue
	private void printq() { 
		if (count ==0) {
			System.out.println("Queue is empty");
			return;
		}
		
		int i = front;
		int k = 0;
				while(k<count)
				{
					System.out.print(queue[i]+" ");
					k++;
					i = (i+1)%size;
				}
				System.out.println();
	}
	
	// return the size of the queue
	private int size() {
		return (count);
	}
	
	// check if the queue is empty
	boolean isEmpty() {
		return (count==0);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter queue size");
		int size = sc.nextInt();
		BoundedQueue<Integer> q1 = new BoundedQueue<>(size);
		System.out.println("Choose one option:");
		System.out.println("1. Offer 2. Poll 3. Clear 4. Peek 5. IsEmpty 6. Size 7. ToArray 8. Print Queue");
		whileloop:
			while(sc.hasNext()) {
				int com = sc.nextInt();
				switch(com)  {
				case 1: 
					System.out.println("Enter element to enqueue");
					q1.offer(sc.nextInt());
					break;
				case 2:
					q1.poll();
					break;
				case 3:
					q1.clear();
					break;
				case 4:
					System.out.println("Peek: " + q1.peek());
					break;
				case 5:
					System.out.println("Is queue empty: " + q1.isEmpty());
					break;
				case 6:
					System.out.println("Queue size: " + q1.size());
					break;
				case 7:
					Object[] arr = null;
					q1.toArray(arr);
					break;
				case 8:
					q1.printq();
					break;
				case 9:
					System.exit(0);
				default:
					break whileloop;
				}
				System.out.println("Choose one option:");
				System.out.println("1. Offer 2. Poll 3. Clear 4. Peek 5. IsEmpty 6. Size 7. ToArray 8. Print Queue 9. Exit");	
			}		
	}
}
