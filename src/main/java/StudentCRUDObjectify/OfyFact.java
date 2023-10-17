package StudentCRUDObjectify;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

public class OfyFact extends ObjectifyFactory {
	public static Objectify init() {
		return new OfyFact().begin();
	}
	public OfyFact() {
		register(Student.class);
	}
	@Override
	public Objectify begin() {
		return super.begin();
	}
}
