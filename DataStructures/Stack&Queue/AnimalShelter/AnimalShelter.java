import java.util.*;

class AnimalShelter	{
	static LinkedList<Dog> dogs = new LinkedList<>();
	static LinkedList<Cat> cats = new LinkedList<>();
	static int order = 0;


	public static void main(String[] args)	{
		System.out.println("Starts here!");

		enqueue(new Dog("D"));
		enqueue(new Cat("B"));
		System.out.println("Animal removed : " + dequeueAny().name);
		enqueue(new Cat("C"));
		System.out.println("Animal removed : " + dequeueAny().name);
		System.out.println("Cat removed : " + dequeueCat().name);

	}

	static void enqueue(Animal a)	{
		a.setOrder(order);
		order++;

		if(a instanceof Dog)
			dogs.addLast((Dog) a);
		else if(a instanceof Cat)
			cats.addLast((Cat) a);
	}

	static Animal dequeueAny()	{
		if(dogs.size() == 0)
			return dequeueCat();
		else if(cats.size() == 0)
			return dequeueDog();
		Dog d = dogs.peek();
		Cat c = cats.peek();

		if(d.isOlderThanAnimal(c))	{
			return dequeueDog();
		}
		else
			return dequeueCat();
	}

	static Animal dequeueDog()	{
		return dogs.poll();
	}

	static Animal dequeueCat()	{
		return cats.poll();
	}
}


abstract class Animal 	{
	private int order;
	protected String name;
	public Animal(String n)	{
		name = n;
	}
	public int getOrder()	{
		return order;
	}
	public void setOrder(int o)	{
		order = o;
	}
	public boolean isOlderThanAnimal(Animal b)	{
		return this.order < b.getOrder();
	}
}

class Dog extends Animal{
	public Dog(String name)	{
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name)	{
		super(name);
	}
}