package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

public class ChangeRelativePathCommand extends Command {
    public ChangeRelativePathCommand(String input, String[] data, StudentsRepository repository, Tester tester, IOManager inputOutputManager, DownloadManager downloadManager) {
        super(input, data, repository, tester, inputOutputManager, downloadManager);
    }

    @Override
    public void execute() throws Exception {
        if (super.getData().length != 2) {
            throw new InvalidCommandException(super.getInput());
        }
        String relativePath = super.getData()[1];
        super.getIoManager().changeCurrentDirRelativePath(relativePath);
    }
}
