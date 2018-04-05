package test;

import static org.junit.Assert.*;
import listasencadeadas.Node;
import listasencadeadas.SLinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {
	
	SLinkedList lista = null;
	@Before
	public void setUp() throws Exception {
		lista = new SLinkedList();
	}

	@After
	public void tearDown() throws Exception {
		lista = null;
	}

	@Test
	public void test() {
		Node n1 = new Node("aaaa", null);
		lista.addFirst(n1);
		assertEquals(n1, lista.removeFirst());
	}

}
