/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Qcho
 */
public class Sandbox {

    public static void main(String[] args) {
	String[] stringArray = {"hola", "probando", "varargs", "y strings!"};
	Collection<String> stringCollection = new LinkedList<String>();
	stringCollection.add("probando");
	stringCollection.add("add");
	stringCollection.add("comun");
	//Collections.addAll(stringCollection, stringArray);

	System.out.println(join(", ", "hola", "pepe"));
	System.out.println(join(", ", stringArray));
	System.out.println(join(", ", stringCollection.toArray(new String[0])));
    }

    public static <T> String join(String connector, String... elements) {
	StringBuilder builder = new StringBuilder();

	for (String element : elements) {
	    builder.append(element);
	    builder.append(connector);
	}

	return builder.substring(0, builder.length() - connector.length());
    }
}
