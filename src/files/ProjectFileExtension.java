package files;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ProjectFileExtension extends FileFilter {

	@Override
	public boolean accept(File f) {
		if (f.isDirectory() || f.getName().toLowerCase().endsWith(".wrd") || !f.getName().contains(".")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getDescription() {
		String extension = "GeRuDok Project File (*.wrd)";

		return extension;
	}

}
