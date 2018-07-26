import toy.Toy;

public class TestToy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var toy = new Toy();
		
		toy.register(false);
		toy.register(true);
		toy.deregister();

	}

}
