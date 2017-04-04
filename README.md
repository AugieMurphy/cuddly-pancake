# cuddly-pancake

Jeffrey Lin, Augie Murphy, and Arpita Nag's implementation of
[java.util.LinkedList][1].

## Method selections

We implemented `addFirst(T x)` and `addLast(T x)` so that an element could be
added to the Deque from both front and the end. We also implemented `add(T x)`
because `Deque<T>` extends `Queue<T>`.

We implemented `removeFirst(T x)` and `removeLast(T x)` so that an element could
be removed from both the front and the end of the Deque. We also implemented
`remove(T x)` because it is part of the `Queue<T>` interface. Along a similar
vein, we implemented `poll()`, which returns null if there is no data in the
deque rather than throwing an exception.

`peekFirst(T x)` and `PeekLast(T x)` allow us to view the topmost and
bottommost elements, respectively, without removing them.

## Underlying architecture

We chose a Linked List as the underlying structure for our implementation of
Deque because it seemed like a logical approach when both sides of the data set
are being added and removed from. Linking to and unlinking from the end is just
as easy as linking to and unlinking from the front.

If we had chosen a slightly more restricting data type, such as arrays or even
ArrayLists, we would have had to check for space restrictions and expand
accordingly, which would have caused more trouble in the end since some methods
throw exceptions when expansion is required.

[1]: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
