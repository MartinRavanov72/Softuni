package test.bg.softuni;

import main.bg.softuni.dataStructures.SimpleSortedBag;
import main.bg.softuni.dataStructures.SimpleSortedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrderedBagTests {
    private SimpleSortedBag<String> names;

    @Before
    public void setUp() {
        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyCtor(){
        this.names = new SimpleSortedList<>(String.class);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialComparer(){
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialCapacity(){
        this.names = new SimpleSortedList<>(String.class, 20);
        Assert.assertEquals(20, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithAllParams(){
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER, 30);
        Assert.assertEquals(30, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testAddIncreasesSize(){
        this.names.add("Azis");
        Assert.assertEquals(1, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullThrowsException(){
        this.names.add(null);
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted(){
        this.names.add("Czis");
        this.names.add("Azis");
        this.names.add("Bzis");
        int czisIndex = -1;
        int azisIndex = -1;
        int bzisIndex = -1;
        int cnt = 0;
        for (String name : names) {
            if (name.equalsIgnoreCase("Czis")) {
                czisIndex = cnt;
            }
            else if (name.equalsIgnoreCase("Azis")) {
                azisIndex = cnt;
            }
            else if (name.equalsIgnoreCase("Bzis")) {
                bzisIndex = cnt;
            }
            cnt++;
        }
        Assert.assertEquals(true, azisIndex < bzisIndex && bzisIndex < czisIndex);
    }

    @Test
    public void testAddingMoreThanInitialCapacity(){
        for (int i = 0; i < 17; i++) {
            names.add(i + "");
        }
        Assert.assertEquals(true, this.names.size() == 17 && this.names.capacity() != 16);
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize(){
        List<String> azis = new ArrayList<>();
        azis.add("Azis");
        azis.add("Toni");
        names.addAll(azis);
        Assert.assertEquals(2, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAllFromNullThrowsException(){
        names.addAll(null);
    }

    @Test
    public void testAddAllKeepsSorted(){
        this.names.add("Czis");
        this.names.add("Azis");
        this.names.add("Bzis");
        int czisIndex = -1;
        int azisIndex = -1;
        int bzisIndex = -1;
        int cnt = 0;
        for (String name : names) {
            if (name.equalsIgnoreCase("Czis")) {
                czisIndex = cnt;
            }
            else if (name.equalsIgnoreCase("Azis")) {
                azisIndex = cnt;
            }
            else if (name.equalsIgnoreCase("Bzis")) {
                bzisIndex = cnt;
            }
            cnt++;
        }
        Assert.assertEquals(true, azisIndex < bzisIndex && bzisIndex < czisIndex);
    }

    @Test
    public void testRemoveValidElementDecreasesSize(){
        names.add("Serafim");
        int currentSize = names.size();
        names.remove("Serafim");
        Assert.assertEquals(-1, names.size() - currentSize);
    }

    @Test
    public void testRemoveValidElementRemovesSelectedOne(){
        names.add("Serafim");
        names.add("Kocho");
        names.remove("Kocho");
        boolean hasKocho = false;
        for (String name : names) {
            if (name.equalsIgnoreCase("Kocho")) {
                hasKocho = true;
            }
        }
        Assert.assertEquals(false, hasKocho);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException(){
        names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull(){
        names.add("Serafim");
        names.add("Kocho");
        names.joinWith(null);
    }

    @Test
    public void testJoinWorksFine(){
        names.add("Serafim");
        names.add("Kocho");
        String output = names.joinWith(",");
        Assert.assertEquals("Kocho,Serafim", output);
    }
}
