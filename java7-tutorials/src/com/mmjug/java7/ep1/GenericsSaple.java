package com.mmjug.java7.ep1;

public class GenericsSaple {

	class Box<T> {
		private T value;
		
		public Box(T t) {
			this.value = t;
		}
		
		public T getValue() {
			return this.value;
		}
	}
	
	public static void main(String[] args) {
//		Box<Number> box = new Box<>(30);
	}
}
