package cresla.manager;

import cresla.entities.ModuleContainer;
import cresla.interfaces.*;
import cresla.models.modules.CooldownSystem;
import cresla.models.modules.CryogenRod;
import cresla.models.modules.HeatProcessor;
import cresla.models.reactors.CryoReactor;
import cresla.models.reactors.HeatReactor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager{
    private Map<Integer, Reactor> reactorMap;
    private Map<Integer, Module> moduleMap;
    private int id;
    private int energyModulesCnt;
    private int absorbingModulesCnt;
    private int cryoReactorCnt;
    private int heatReactorCnt;

    public ManagerImpl() {
        this.moduleMap = new LinkedHashMap<>();
        this.reactorMap = new LinkedHashMap<>();
        this.id = 1;
        this.energyModulesCnt = 0;
        this.absorbingModulesCnt = 0;
        this.cryoReactorCnt = 0;
        this.heatReactorCnt = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Container container = new ModuleContainer(Integer.parseInt(arguments.get(2)));
        if ("Cryo".equalsIgnoreCase(arguments.get(0))) {
            this.reactorMap.put(this.id, new CryoReactor(container, this.id, Integer.parseInt(arguments.get(1))));
            this.cryoReactorCnt++;
        } else {
            this.reactorMap.put(this.id, new HeatReactor(container, this.id, Integer.parseInt(arguments.get(1))));
            this.heatReactorCnt++;
        }
        return "Created " + arguments.get(0) + " Reactor - " + this.id++;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        switch (arguments.get(1)){
            case "CryogenRod":
                EnergyModule energyModule = new CryogenRod(this.id, Integer.parseInt(arguments.get(2)));
                this.reactorMap.get(reactorId).addEnergyModule(energyModule);
                this.moduleMap.put(this.id, energyModule);
                this.energyModulesCnt++;
                break;
            case "HeatProcessor":
                AbsorbingModule absorbingModule = new HeatProcessor(this.id, Integer.parseInt(arguments.get(2)));
                this.reactorMap.get(reactorId).addAbsorbingModule(absorbingModule);
                this.moduleMap.put(this.id, absorbingModule);
                this.absorbingModulesCnt++;
                break;
            case "CooldownSystem":
                AbsorbingModule absorbingModule1 = new CooldownSystem(this.id, Integer.parseInt(arguments.get(2)));
                this.reactorMap.get(reactorId).addAbsorbingModule(absorbingModule1);
                this.moduleMap.put(this.id, absorbingModule1);
                this.absorbingModulesCnt++;
                break;
        }
        return "Added " + arguments.get(1) + " - " + this.id++ + " to Reactor - " + reactorId;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        if (reactorMap.containsKey(Integer.parseInt(arguments.get(0)))) {
            return reactorMap.get(Integer.parseInt(arguments.get(0))).toString();
        } else {
            return moduleMap.get(Integer.parseInt(arguments.get(0))).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergyOutput = this.reactorMap.entrySet().stream().mapToLong(r -> r.getValue().getTotalEnergyOutput()).sum();
        long totalHeatAbsorbing = this.reactorMap.entrySet().stream().mapToLong(r -> r.getValue().getTotalHeatAbsorbing()).sum();
        return "Cryo Reactors: " + this.cryoReactorCnt + System.lineSeparator() +
                "Heat Reactors: " + this.heatReactorCnt + System.lineSeparator() +
                "Energy Modules: " + this.energyModulesCnt + System.lineSeparator() +
                "Absorbing Modules: " + this.absorbingModulesCnt + System.lineSeparator() +
                "Total Energy Output: " + totalEnergyOutput + System.lineSeparator() +
                "Total Heat Absorbing: " + totalHeatAbsorbing;
    }
}
