package myTests;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

public class ModuleContainerTests {

    private AbsorbingModule absorbingModuleMocked1;
    private AbsorbingModule absorbingModuleMocked2;
    private EnergyModule energyModuleMocked1;
    private EnergyModule energyModuleMocked2;
    private Container container;

    @Before
    public void before() {
        this.container = new ModuleContainer(2);
        this.absorbingModuleMocked1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModuleMocked2 = Mockito.mock(AbsorbingModule.class);
        this.energyModuleMocked1 = Mockito.mock(EnergyModule.class);
        this.energyModuleMocked2 = Mockito.mock(EnergyModule.class);

        Mockito.when(absorbingModuleMocked1.getHeatAbsorbing()).thenReturn(2000000000);
        Mockito.when(absorbingModuleMocked2.getHeatAbsorbing()).thenReturn(2000000000);
        Mockito.when(energyModuleMocked1.getEnergyOutput()).thenReturn(2000000000);
        Mockito.when(energyModuleMocked2.getEnergyOutput()).thenReturn(2000000000);
        Mockito.when(absorbingModuleMocked1.getId()).thenReturn(1);
        Mockito.when(absorbingModuleMocked2.getId()).thenReturn(2);
        Mockito.when(energyModuleMocked1.getId()).thenReturn(3);
        Mockito.when(energyModuleMocked2.getId()).thenReturn(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleException() {
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleException() {
        this.container.addAbsorbingModule(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void zeroSize(){
        this.container = new ModuleContainer(0);
        this.container.addAbsorbingModule(this.absorbingModuleMocked1);
    }

    @Test
    public void removeModule() {
        this.container.addAbsorbingModule(absorbingModuleMocked1);
        this.container.addEnergyModule(energyModuleMocked1);
        this.container.addEnergyModule(energyModuleMocked2);

        Assert.assertEquals(0, container.getTotalHeatAbsorbing());
        Assert.assertEquals(4000000000L, container.getTotalEnergyOutput());
    }

    @Test
    public void absorbingModelWorksWithLong() {
        this.container.addAbsorbingModule(absorbingModuleMocked1);
        this.container.addAbsorbingModule(absorbingModuleMocked2);

        Assert.assertEquals(container.getTotalHeatAbsorbing(), 4000000000L);
    }

    @Test
    public void emptyContainerReturnsZero(){
        Assert.assertEquals(container.getTotalHeatAbsorbing(), 0);
        Assert.assertEquals(container.getTotalEnergyOutput(), 0);
    }
}
