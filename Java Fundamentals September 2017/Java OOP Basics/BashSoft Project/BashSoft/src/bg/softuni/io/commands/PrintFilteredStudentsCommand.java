package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.IOManager;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;
import bg.softuni.staticData.ExceptionMessages;

public class PrintFilteredStudentsCommand extends Command {
    public PrintFilteredStudentsCommand(String input, String[] data, StudentsRepository repository, Tester tester, IOManager inputOutputManager, DownloadManager downloadManager) {
        super(input, data, repository, tester, inputOutputManager, downloadManager);
    }

    @Override
    public void execute() throws Exception {
        if (super.getData().length != 5) {
            throw new InvalidCommandException(super.getInput());
        }
        String course = super.getData()[1];
        String filter = super.getData()[2].toLowerCase();
        String takeCommand = super.getData()[3].toLowerCase();
        String takeQuantity = super.getData()[4].toLowerCase();
        tryParseParametersForFilter(takeCommand, takeQuantity, course, filter);
    }

    private void tryParseParametersForFilter(String takeCommand, String takeQuantity, String courseName, String filter) {
        if (!takeCommand.equals("take")) {
            OutputWriter.displayException(ExceptionMessages.INVALID_TAKE_COMMAND);
            return;
        }

        if (takeQuantity.equals("all")) {
            super.getRepository().filterAndTake(courseName, filter);
            return;
        }

        try {
            int studentsToTake = Integer.parseInt(takeQuantity);
            super.getRepository().filterAndTake(courseName, filter, studentsToTake);
        } catch (NumberFormatException nfe) {
            OutputWriter.displayException(ExceptionMessages.IVALID_TAKE_QUANTITY_PARAMETER);
        }
    }
}
