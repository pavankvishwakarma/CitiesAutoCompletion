package com.test.autocomplete;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SingleTrieNode {

	char nodeCharacter;     
	LinkedList<SingleTrieNode> childList; 
	SingleTrieNode parentNode;
	boolean isLeave;

	public SingleTrieNode(char c) {
		nodeCharacter = c;
		childList = new LinkedList<SingleTrieNode>();
		isLeave = false;        
	}  
	
	public SingleTrieNode getChild(char c) {
		if (childList != null)
			for (SingleTrieNode eachChild : childList)
				if (eachChild.nodeCharacter == c)
					return eachChild;
		return null;
	}

	public List<String> getWords() {
		List<String> list = new ArrayList<String>();      
		if (isLeave) {
			list.add(toString());
		}

		if (childList != null) {
			for (int i=0; i< childList.size(); i++) {
				if (childList.get(i) != null) {
					list.addAll(childList.get(i).getWords());
				}
			}
		}       
		return list; 
	}

	public String toString() {
		if (parentNode == null) {
			return "";
		} else {
			return parentNode.toString() + new String(new char[] {nodeCharacter});
		}
	}

}
