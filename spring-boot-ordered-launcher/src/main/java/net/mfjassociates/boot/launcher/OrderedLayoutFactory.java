package net.mfjassociates.boot.launcher;

import java.io.File;

import org.springframework.boot.loader.tools.Layout;
import org.springframework.boot.loader.tools.LayoutFactory;

public class OrderedLayoutFactory implements LayoutFactory {

	private String customLauncherPath;

	public String getCustomLauncherPath() {
		return customLauncherPath;
	}

	public void setCustomLauncherPath(String launcherPath) {
		this.customLauncherPath = launcherPath;
	}

	@Override
	public Layout getLayout(File source) {
		return new OrderedLayout(customLauncherPath);
	}

}
