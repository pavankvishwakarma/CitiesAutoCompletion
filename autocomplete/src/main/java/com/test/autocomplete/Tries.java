package com.test.autocomplete;

import java.util.ArrayList;
import java.util.List;

public class Tries {
	private SingleTrieNode root;

	public Tries() {
		root = new SingleTrieNode(' '); 
	}

	public void insert(String word) {
		word=word.toLowerCase();
		if (search(word) == true) 
			return;    

		SingleTrieNode current = root; 
		SingleTrieNode pre ;
		for (char ch : word.toCharArray()) {
			pre = current;
			SingleTrieNode child = current.getChild(ch);
			if (child != null) {
				current = child;
				child.parentNode = pre;
			} else {
				current.childList.add(new SingleTrieNode(ch));
				current = current.getChild(ch);
				current.parentNode = pre;
			}
		}
		current.isLeave = true;
	}

	public boolean search(String word) {
		SingleTrieNode current = root;      
		for (char ch : word.toCharArray()) {
			if (current.getChild(ch) == null)
				return false;
			else {
				current = current.getChild(ch);    
			}
		}      
		if (current.isLeave == true) {       
			return true;
		}
		return false;
	}

	public List<String> autocomplete(String prefix) {     
		SingleTrieNode lastNode = root;
		for (int i = 0; i< prefix.length(); i++) {
			lastNode = lastNode.getChild(prefix.charAt(i));	     
			if (lastNode == null) 
				return new ArrayList<String>();      
		}

		return lastNode.getWords();
	}
}
