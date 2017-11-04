package files;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class WorkspaceFileExtension extends FileFilter {

	@Override
	public boolean accept(File f) {
		if (f.isDirectory() || f.getName().toLowerCase().endsWith(".grd") || !f.getName().contains(".")) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub

		String extension = "GeRuDok Workspace File (*.grd)";

		return extension;
	}

}
