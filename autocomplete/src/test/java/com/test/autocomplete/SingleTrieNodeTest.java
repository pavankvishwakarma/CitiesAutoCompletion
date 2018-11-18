package com.test.autocomplete;



import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.test.autocomplete.SingleTrieNode;
import com.test.autocomplete.Tries;

import junit.framework.Assert;

public class SingleTrieNodeTest {
	
	Tries t;
	SingleTrieNode st;

	@Before
	public void setup() {
		t = new Tries();
		t.insert("abc");
		t.insert("def");
		st=new SingleTrieNode('a');
	}
	
	@Test
	public void testGetChild() {
		Assert.assertEquals(st.getChild('a'), null);
		System.out.println(t.root.getChild('a').toString().equals("a"));
	}
	@Test
	public void testGetWords(){
		System.out.println(t.root.getWords());
		List<String> list=new ArrayList<String>();
		list.add("abc");
		list.add("def");
		Assert.assertEquals(t.root.getWords(), list);
	}
}

