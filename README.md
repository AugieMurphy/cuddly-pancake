cuddly-pancake
(Jeffrey Lin, Augie Murphy, Arpita Nag)

We implemented addFirst(T x) and addLast(T x) so that an element could be added to the Deque from both front and the end. We also implemented add(T x) to get past the compiler.

We implemented removeFirst(T x) and removeLast(T x) so that an element could be removed from the Deque from both front and the end. We also implemented remove(T x) to get past the compiler. Along a similar vein, we implemented poll() to return null if there is no data in the deque rather than throwing an exception.

We implemented peekFirst(T x) and PeekLast(T x) so that an element could be viewed from the Deque from both front and the end without being removed. We also implemented peek(T x) to get past the compiler.

We chose a Linked List as the underlying structure for our implementation of Deque because it seemed like a logical approach when both sides of the data set are being added and removed from. Linking to and unlinking from the end is just as easy as linking to and unlinking from the front.