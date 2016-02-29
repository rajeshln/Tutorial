package core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class TriangleDemo {

	
	public static void main(String args[]){
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++XmlBeanFactory bean ++++++++++++++++++++++++++++");
		BeanFactory bf = new XmlBeanFactory(new FileSystemResource("NewFile.xml"));
		
		Triangle triangle1 = (Triangle) bf.getBean("triangleBean");
		triangle1.draw();

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++first bean ++++++++++++++++++++++++++++");
		ApplicationContext context = new ClassPathXmlApplicationContext("allBeanAtOnePlace.xml");
		Triangle triangle = (Triangle) context.getBean("triangleBean");
		triangle.draw();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++Collecction++++++++++++++++++++++++++++");
		///with collection
		//ApplicationContext 
		//context =  new ClassPathXmlApplicationContext("beanCollection.xml"); Created allBeanAtOnePlace.xml and added beanCollection entry there
		TriangleCollection triangleCol = (TriangleCollection) context.getBean("triangleCollBean");
		triangleCol.draw();
		
		// Bean inheritance 
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++Inheritance++++++++++++++++++++++++++++");
		Triangle triangleInherited = (Triangle) context.getBean("triangleChild");
		
		triangleInherited.draw();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++Coding to Interfaces++++++++++++++++++++++++++++");
		// Coding to interfaces.
		// refer objecct with reference to Shape rather than triangle or circle
		Shape shape = (Shape) context.getBean("triangleBean");
		shape.draw();
		
		
		System.out.println("++++++++++++Added new class circle for checking interface ++++++++++++++++++++++++++++");
		Shape shape1 = (Shape) context.getBean("circleBean");
		shape1.draw();
		
		
	}
}
