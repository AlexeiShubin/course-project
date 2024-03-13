package coursework.fileDescription;

import coursework.fileDescription.path.CheckingPath;
import coursework.invalidFiles.InvalidFiles;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;


public class Check {

    public static LinkedList<File> openingChecks(String path) throws IOException {
        String wayChecks =path+"//checks";
        File check = new File(wayChecks);
        LinkedList<File>trueChecks=new LinkedList<>();
        if(CheckingPath.checkingForFolders(check, "checks")){

            try {
                File[] checks = check.listFiles();

                for (File oneCheck : Objects.requireNonNull(checks)) {
                    if (FileChecking.fileIsTrue(oneCheck)) {
                        trueChecks.add(oneCheck);
                    } else {
                        InvalidFiles.invalidFiles(oneCheck);
                    }
                }
            } catch (NullPointerException checks) {
            throw new IOException();
        }
        }
        return trueChecks;
    }
}