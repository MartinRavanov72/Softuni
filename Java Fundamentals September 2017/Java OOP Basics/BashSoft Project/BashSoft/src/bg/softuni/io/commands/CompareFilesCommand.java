package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public class CompareFilesCommand extends Command {
    public CompareFilesCommand(String input, String[] data, StudentsRepository repository, Tester tester, IOManager inputOutputManager, DownloadManager downloadManager) {
        super(input, data, repository, tester, inputOutputManager, downloadManager);
    }

    @Override
    public void execute() throws Exception {
        if (super.getData().length != 3) {
            throw new InvalidCommandException(super.getInput());
        }
        String firstPath = super.getData()[1];
        String secondPath = super.getData()[2];
        super.getTester().compareContent(firstPath, secondPath);
    }
}
