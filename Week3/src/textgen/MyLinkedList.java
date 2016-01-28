package textgen;

import java.util.AbstractList;

// 相当于是Node class, 注意这里也是generic programming
class LLNode<E> {
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	// 注意：构造函数这里的写法并不是 LLNode<E>, 没有<E>, 但是实际creat该类object时，要put actual type, 见下面代码。
	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	public LLNode() {
		this.prev = null;
		this.next = null;
	}
}


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	
	// generic programming 泛型编程
	LLNode<E> head;
	LLNode<E> tail;
	int size; // 可以考虑用private修饰

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		// Create head dummy node and tail dummy node, then connect them, draw memory model
		head = new LLNode<E>();
		tail = new LLNode<E>();
		head.next = tail;
		tail.prev = head;
	}
	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> newNode = new LLNode<E>(element);
		tail.prev.next = newNode;
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev = newNode;
		// 别忘了还有一个成员变量维护linked list的size !!!
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	// 注意1：这个方法，是父类也就是AbstractList<E>这个抽象类，没有implement的方法，因此作为子类必须要implement它。
	// 注意2：对于无效的index, an invalid index (say -1 or beyond upper boundary ), you will thrown an IndexOutOfBoundsException.
	public E get(int index) 
	{
		// TODO: Implement this method.
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("Invalid index");
		}
		LLNode<E> crtNode = head;
		while( index-- > 0 ){
			crtNode = crtNode.next;
		}
		return crtNode.next.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	/* 
	 1. You will want to throw an IndexOutOfBoundsException if the index provided is not reasonable for inserting an element. 
	 2. Optional: After authoring this version of the add method, you could consider removing redundant code by having the add 
	    method you originally wrote just call this method. 
	 */
	public void add(int index, E element ) {
		// TODO: Implement this method
		if( index > this.size ){
			throw new IndexOutOfBoundsException("Invalid index");
		}
		LLNode<E> crtNode = head;
		while( index-- > 0 ){
			crtNode = crtNode.next;
		}
		LLNode<E> newNode = new LLNode<E>(element);
		crtNode.next.prev = newNode;
		newNode.next = crtNode.next;
		newNode.prev = crtNode;
		crtNode.next = newNode;
		this.size++;
	}


	/** Return the size of the list */
	public int size() {
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	//  thrown an IndexOutOfBoundsException if the index provided is out of bounds. 
	public E remove(int index) 
	{
		// TODO: Implement this method
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("Invalid index");
		}
		LLNode<E> crtNode = head;
		while( index-- > 0 ){
			crtNode = crtNode.next;
		}
		LLNode<E> res = crtNode.next;
		crtNode.next = res.next;
		res.next.prev = crtNode;
		res.next = null;
		res.prev = null;
		this.size--;
		return res.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	/* you will want to thrown an IndexOutOfBoundsException if the index provided is out of bounds. 
	 * In addition, if someone tries to set a node with a null element, you should throw a NullPointerException.
	 * */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if( element == null ){
			throw new NullPointerException("Null Pointer");
		}
		LLNode<E> crtNode = head;
		while(index-- > 0 ){
			crtNode = crtNode.next;
		}
		E res = crtNode.next.data;
		crtNode.next.data = element;
		return res;
	} 
	
}


