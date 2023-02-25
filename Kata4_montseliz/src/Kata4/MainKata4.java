package Kata4;

public class MainKata4 {
	
	public static void main(String[] args) {
		System.out.println("1.- Llegir fitxer:");
		MethodsKata4.readFile().forEach(System.out::println);
		
		System.out.println("\n2.- Classificar usuaris, hashtags, llocs en tres llistes diferents:");
		MethodsKata4.classifyContent(MethodsKata4.readFile()); 
		
		System.out.println("\n3.- Imprimir cada llista i el seu tamany:"); 
		MethodsKata4.countContent(MethodsKata4.readFile());
		
		System.out.println("4.- Conté aquest hashtag?");
		MethodsKata4.containsHashtag(MethodsKata4.readFile());
		
		System.out.println("\n5.- Hashtags més repetits en ordre ascendent:");
		MethodsKata4.repeatedHashtags(MethodsKata4.readFile());
		
		System.out.println("\n6.- Quants cops apareix un hashtag:");
		MethodsKata4.frequencyHashtags(MethodsKata4.readFile());
	
	}
	
}
