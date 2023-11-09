package JavaStreams;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Example1 {

	public static void main(String[] args) {

        // req:- to print the names of list start with "A"
		ArrayList<String> list=new ArrayList<String>();
		list.add("swapnil");
		list.add("Akshay");
		list.add("chetan");
		list.add("amar");
		list.add("bablu");
		list.add("Akash");
		list.add("Aman");
		list.add("hemant");
		list.add("dev");
		list.add("om");
		
		//using java stream we can achieve this with shortest code.
		
		long modifiedList=list.stream().filter(s->s.startsWith("A")).count();
		System.out.println(modifiedList);
		
		System.out.println("================================================================");
		
		list.stream().filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		System.out.println("================================================================");
		list.stream().filter(s->s.startsWith("A")).limit(1).forEach(s->System.out.println(s));
		System.out.println("================================================================");
		//here map is used to perform further modification on the resulted stream
		list.stream().sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//direct way of creating stream directly
		
		List<String>newList=Arrays.asList("rani","soni","moni");
		
		// we can concat two stream into one big stream and then we can search for any specific element within big stream
		System.out.println("================================================================");

		Stream<String>bigstream=Stream.concat(newList.stream(), list.stream());
		
		boolean flag=bigstream.sorted().map(s->s.toUpperCase()).anyMatch(s->s.equalsIgnoreCase("rani"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		System.out.println("===========================================================================");
		
		//we can collect the result of the stream as well for further usage
		
		List<String>ls=Stream.of("tejas","mohan","mayur","prakash","sunil").filter(s->s.contains("a")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		
	    System.out.println(ls.get(1));
	    
	    System.out.println("==================================================================================");
	    
	    List<Integer>values=Arrays.asList(3,2,2,7,5,1,9,7);
	    
	    //print the unique nos.
	    //sort it
	    //give 3 digit
	    
	    values.stream().distinct().forEach(s->System.out.println(s));
	    System.out.println("----------------------------------------------------------");
	    values.stream().distinct().sorted().forEach(s->System.out.println(s));
	    System.out.println("------------------------------------------------------------");
	    List<Integer>digit=values.stream().distinct().sorted().collect(Collectors.toList());
	    System.out.println(digit.get(2));
	    
		
		
		
		
		
		
		
		
	}

}
