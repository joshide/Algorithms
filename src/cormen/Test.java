package cormen;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat cat = new Cat();
		
		Animal a = (Animal)cat;
		//a.sound();

	}

}


class Animal {
	private void sound() {
		
	}
}

class Cat extends Animal {
	
}