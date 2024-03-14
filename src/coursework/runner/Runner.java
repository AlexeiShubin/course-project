package coursework.runner;

import coursework.entrance.Entrance;
import coursework.service.fileDescription.path.EnterThePath;
import coursework.service.statistic.FileWithStatistic;

import java.io.IOException;

/**
 * the runner class calls a method to request a login and password from the user and a method to record file statistics
 */

public class Runner {
    public static void main(String[] args) throws IOException {
        if(Entrance.loginAndPassword()) {
            String path = EnterThePath.enterThePath();
            FileWithStatistic.fileWithStatistic(path);
        }
    }
}
