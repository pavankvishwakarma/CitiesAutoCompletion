package com.test.autocomplete;


import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.test.autocomplete.Tries;
import junit.framework.Assert;

public class TriesTest {
	Tries t;

	@Before
	public void setup() {
		t = new Tries();
		t.insert("abc");
		t.insert("def");
	}

	@Test
	public void testSearchPos() {
		Assert.assertTrue("Checking for the positive test", t.search("abc"));
	}

	@Test
	public void testSearchNeg() {
		Assert.assertTrue("Checking for the positive test", !t.search("aa"));
	}

	@Test
	public void autocompleteTestPos() {
		List<String> list = new ArrayList<String>();
		list.add("def");
		Assert.assertTrue("Here checking the autocomplete", list.equals(t.autocomplete("d")));
	}

	@Test
	public void autocompleteTestNeg() {
		List<String> list = new ArrayList<String>();
		list.add("def");
		Assert.assertTrue("Here checking the autocomplete", !list.equals(t.autocomplete("z")));
	}
	

}
