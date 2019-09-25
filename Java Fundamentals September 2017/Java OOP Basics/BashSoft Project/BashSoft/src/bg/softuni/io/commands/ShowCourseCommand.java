package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public class ShowCourseCommand extends Command {
    public ShowCourseCommand(String input, String[] data, StudentsRepository repository, Tester tester, IOManager inputOutputManager, DownloadManager downloadManager) {
        super(input, data, repository, tester, inputOutputManager, downloadManager);
    }

    @Override
    public void execute() throws Exception {
        if (super.getData().length != 2 && super.getData().length != 3) {
            throw new InvalidCommandException(super.getInput());
        }
        if (super.getData().length == 2) {
            String courseName = super.getData()[1];
            super.getRepository().getStudentsByCourse(courseName);
        }
        if (super.getData().length == 3) {
            String courseName = super.getData()[1];
            String userName = super.getData()[2];
            super.getRepository().getStudentMarkInCourse(courseName, userName);
        }
    }
}
