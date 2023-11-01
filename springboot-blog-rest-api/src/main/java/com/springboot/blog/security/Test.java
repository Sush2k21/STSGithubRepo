//package com.springboot.blog.security;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Test {
//
//	public static int getDifference(List<Integer> numSeq) {
//		int first_player = 0;
//		int second_player = 0;
//		int size = numSeq.size();
//		for (int i = 0; i <size; i++) {
//			if (i == 0 || i % 2 == 0) {
//				first_player = first_player + numSeq.get(i);
//				if (numSeq.get(i) % 2 == 0) {
//					numSeq.remove(i);
//					numSeq = revList(numSeq);
//				} else {
//					numSeq.remove(i);
//				}
//			} else {
//				second_player = second_player + numSeq.get(i);
//				if (numSeq.get(i) % 2 == 0) {
//					numSeq.remove(i);
//					numSeq = revList(numSeq);
//				} else {
//					numSeq.remove(i);
//				}
//			}
//			
//		}
//		return second_player - first_player;
//
//	}
//
//	public static List<Integer> revList(List<Integer> seq) {
//		List<Integer> revList = new ArrayList<>();
//		for (int i = seq.size(); i > 0; i--) {
//			revList.add(seq.get(i));
//		}
//		return revList;
//	}
//
//	public static void main(String[] args) {
//		List<Integer> temp = Arrays.asList(3,6,2,3,5);
//		Test.getDifference(temp);
//	}
//}
