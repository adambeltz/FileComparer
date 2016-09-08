import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
// This program compares the files of 2 folders.  The files of a exFolder will be compared to files of masterFolder.
// Any files in exFolder that match name and size of a file in masterFolder will be deleted.
//  You will be left with the amount of files deleted and the names of files not deleted.
/**
 * Created by adambeltz on 9/8/16.
 */
public class Test2 {
    public static void main(String[] args) {

        File exFolder = new File("PATH OF DIRECTORY OF FILES BEING DELETED GOES HERE");
        ArrayList<File> exFiles = new ArrayList<File>(Arrays.asList(exFolder.listFiles()));

        File masterFolder = new File("PATH OF DIRECTORY OF FILES BEING KEPT GOES HERE");
        ArrayList<File> masterFiles = new ArrayList<File>(Arrays.asList(masterFolder.listFiles()));
        boolean hasMatch;

        int z = 0;

        for (int y = 0; y < exFiles.size(); y++) {
            hasMatch = false;

            for (int x = 0; x < masterFiles.size(); x++) {
                if ((exFiles.get(y).getName().equals(masterFiles.get(x).getName()))
                        && (exFiles.get(y).length() == (masterFiles.get(x).length()))) {

                    hasMatch = true;
                    break;

                } else {
                    hasMatch = false;
                }
            }

            if (hasMatch) {
                exFiles.get(y).delete();
                z++;
            } else {
                System.out.println(exFiles.get(y).getName());
            }
        }
        System.out.println("Deleted" + z + "files.");
    }
}
