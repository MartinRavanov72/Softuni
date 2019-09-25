package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;
import app.models.actions.BossFight;
import app.models.actions.OneVsOne;

import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory{
    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Action action = null;
        switch (actionName){
            case "OneVsOne":
                action = new OneVsOne();
                break;
            case "BossFight":
                action = new BossFight();
                break;
        }
        return action;
    }
}
