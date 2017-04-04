public class LinkedListTest {
	public static void main( String[] args ){
		Deque<String> ship = new LinkedList<>();

		System.out.println("\nnow adding to the front");
		ship.addFirst("James");
		ship.addFirst("Todd");
		System.out.println("\nnow adding to the end");
		ship.addLast("Smith");
		ship.addLast("William");
		System.out.println("\nnow adding to the front");
		ship.addFirst("Joe");
		ship.addLast("Ed");

		System.out.println("\nnow testing toString()...");
		System.out.println( ship ); // Should be Joe -> Todd -> James -> Smith -> William -> Ed

		System.out.println("\nnow removing from the front");
		System.out.println(ship.removeFirst()); //Joe
		System.out.println(ship.removeFirst()); //Todd

		System.out.println( ship ); // Should be James -> Smith -> William -> Ed

		System.out.println(ship.removeLast()); //Ed

		System.out.println( ship ); // Should be James -> Smith -> William

		System.out.println("peek front: \n" + ship.peekFirst()); //James
		System.out.println("remove front: \n" + ship.removeFirst()); //James
		System.out.println("peek tail: \n" + ship.peekLast()); //William
		System.out.println("remove tail: \n" + ship.removeLast()); //William
		System.out.println(ship.removeLast());

		System.out.println( ship );

		System.out.println("\nnow testing auxillary methods");

		ship.add("Washington");
		ship.add("Adams");
		ship.add("Jefferson");
		System.out.println(ship);
		ship.peek(); //Washington
		ship.remove();
		ship.peek(); //Adams
		ship.remove();
		ship.remove();
		System.out.println(ship);
		System.out.println(ship.poll()); //Should be null

		System.out.println("\nRemoving from empty queue should yield error...");
		System.out.println( ship.removeFirst() );
	}
}

