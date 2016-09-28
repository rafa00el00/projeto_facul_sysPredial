package Funcoes;
import java.util.ArrayList;
import java.util.function.Predicate;

public class MyList<E> extends ArrayList<E> {

	public MyList<E> find(Predicate<E> func){
		MyList<E> lst = new MyList<E>();
		
		for(E item : this ){
			if (func.test(item)){
				lst.add(item);				
			}
		}
			
		return lst;
	}
   	
}
