package net.mfjassociates.boot.launcher;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.loader.tools.CustomLoaderLayout;
import org.springframework.boot.loader.tools.Layouts.Expanded;
import org.springframework.boot.loader.tools.LoaderClassesWriter;

public class OrderedLayout extends Expanded implements CustomLoaderLayout {

	private String customLauncherPath;
	private static Logger logger = LoggerFactory.getLogger(OrderedLayout.class);

	public OrderedLayout(String aLauncherPath) {
		this.customLauncherPath=aLauncherPath;
	}
	
	@Override
	public void writeLoadedClasses(LoaderClassesWriter writer) throws IOException {
		writer.writeLoaderClasses();
		logger.info("Loading custom launcher JAR "+customLauncherPath);
		writer.writeLoaderClasses(customLauncherPath);
		
	}

	@Override
	public String getLauncherClassName() {
		return OrderedLauncher.class.getCanonicalName();
	}
	public static void main(String[] args) {
		Set<String> a=new LinkedHashSet<String>();
		a.add("mario");
		a.add("had");
		a.add("a");
		a.add("little");
		a.add("lamb");
		displaySet(a);
	}
	
	public static <T> void displaySet(Set<T> aSet) {
		System.out.println("Display set of type "+aSet.getClass().getCanonicalName()+" with size "+aSet.size());
		for (T t : aSet) {
			System.out.println("Set element="+t.toString());
		}
	}

}
