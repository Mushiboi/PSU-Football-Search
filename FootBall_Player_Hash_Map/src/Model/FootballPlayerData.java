package Model;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.*;

public class FootballPlayerData extends FootballPlayer implements TableData, Displayable, Sortable,Searchable {

    private final ArrayList<TableMember> players;

    private int firstLineToDisplay = 10;
    private int lastLineToDisplay = 15;
    private int linesBeingDisplayed = 20;
    private int highlightedLines ;
    private int sortField;
    private int searchByField;
    private int foundIndex;
    private boolean found;


    private Map<String, TableMember> numberHash = new HashMap<>();
    private Map<String, TableMember> nameHash = new HashMap<>();
    private Map<String, TableMember> positionHash = new HashMap<>();
    private Map<String, TableMember> heightHash = new HashMap<>();
    private Map<String, TableMember> weightHash = new HashMap<>();
    private Map<String, TableMember> homeTownHash = new HashMap<>();
    private Map<String, TableMember> highSchoolHash = new HashMap<>();



    public FootballPlayerData()
    {
        players = new ArrayList<>();
        loadTable();
        linesBeingDisplayed = 20;
        firstLineToDisplay = 0;
        lastLineToDisplay = firstLineToDisplay + linesBeingDisplayed - 1;
        highlightedLines = lastLineToDisplay - foundIndex - 1;

        sortField = 0;
        loadHash();
    }
    private void loadHash()
    {
        for (TableMember player : players) {
            getNumberHash().put(player.getAttribute(0), player);
            getPositionHash().put(player.getAttribute(1), player);
            getNameHash().put(player.getAttribute(2), player);
            getHeightHash().put(player.getAttribute(3), player);
            getWeightHash().put(player.getAttribute(4), player);
            getHomeTownHash().put(player.getAttribute(5), player);
            getHighSchoolHash().put(player.getAttribute(6), player);
        }
        System.out.println(getNameHash());
    }
    @Override
    public boolean search(String searchTerm) {

        if (getSearchByField() == 0)
            System.out.println(getSearchByField());
        {
            if (getNumberHash().containsKey(searchTerm)) {
                setFoundIndex(players.indexOf(getNumberHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());

                return true;
            }
        }
        if (getSearchByField() == 1)
            System.out.println(getSearchByField());
        {
            if (getPositionHash().containsKey(searchTerm)) {
                setFoundIndex(players.indexOf(getPositionHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                return true;
            }
        }
        if (getSearchByField() == 2)
            System.out.println(getSearchByField());
        {

            if (getNameHash().containsKey(searchTerm)) {
                setFoundIndex(players.indexOf(getNameHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                return true;
            }
        }
        if (getSearchByField() == 3)
            System.out.println(getSearchByField());
        {
            if (getHeightHash().containsKey(searchTerm)) {
                setFoundIndex(players.indexOf(getHeightHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                return true;
            }
        }
        if (getSearchByField() == 4)
            System.out.println(getSearchByField());
        {
            if (getWeightHash().containsKey(searchTerm)) {
                setFoundIndex(players.indexOf(getWeightHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                return true;
            }
        }
        if (getSearchByField() == 5)
            System.out.println(getSearchByField());
        {
            if (getHomeTownHash().containsKey(searchTerm)) {
                setFoundIndex(players.indexOf(getHomeTownHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                return true;
            }
        }
        if (getSearchByField() == 6)
            System.out.println(getSearchByField());
        {
            if (getHighSchoolHash().containsKey(searchTerm)) {
                setFoundIndex(players.indexOf(getHighSchoolHash().get(searchTerm)));
                setFound(true);
                setFirstLineToDisplay(getFoundIndex());
                return true;
            }
        }

        System.out.println("Failed");
        setFound(false);
        return false;

    }

    @Override
    public int getFoundIndex() {
        return foundIndex;
    }

    @Override
    public void setFoundIndex(int tableMemberindex) {
        this.foundIndex = tableMemberindex;
    }

    @Override
    public boolean getFound() {
    return found;
    }

    @Override
    public void setFound(boolean searchResult) {
        found = searchResult;
    }

    @Override
    public int getSearchByField() {
        return searchByField;
    }

    @Override
    public void setSearchByField(int fieldIndex) {
        searchByField = fieldIndex;
    }


    @Override
    public void loadTable()
    {
        ReadPlayersFromXML();
    }

    @Override
    public ArrayList<TableMember> getTable() {

        return players;
    }

    @Override
    public ArrayList<String> getHeaders() {
        return getAttributeNames();
    }

    @Override
    public ArrayList<String> getLine(int line) {

        return players.get(line).getAttributes();
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> attrs = new ArrayList<>();
        for(int i = firstLine; i <= lastLine;i++){
            attrs.add(getLine(i));
        }
        return attrs;
    }
     Comparator sortByNumber = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return Integer.compare(fp1.getNumber(), fp2.getNumber());
        }
    };
     Comparator sortByName = new Comparator<FootballPlayer>() {
            @Override
            public int compare(FootballPlayer fp1, FootballPlayer fp2) {
                return fp1.getName().compareTo(fp2.getName());
            }
        };
     Comparator sortByPosition = new Comparator<FootballPlayer>() {
            @Override
            public int compare(FootballPlayer fp1, FootballPlayer fp2) {
                return fp1.getPosition().compareTo(fp2.getPosition());
            }
        };
     Comparator sortByHeight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return Integer.compare(fp1.getHeight().fixedHeight(fp1.getHeight().getFeet(), fp1.getHeight().getInches()), fp2.getHeight().fixedHeight(fp2.getHeight().getFeet(), fp2.getHeight().getInches()));
        }
    };
     Comparator sortByWeight = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return Integer.compare(fp1.getWeight(), fp2.getWeight());
        }
    };


     Comparator sortByHomeTown = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return fp1.getHometown().compareTo(fp2.getHometown());
        }
    };


     Comparator sortByHighSchool = new Comparator<FootballPlayer>() {
        @Override
        public int compare(FootballPlayer fp1, FootballPlayer fp2) {
            return fp1.getHighSchool().compareTo(fp2.getHighSchool());
        }

    };


    public void sort(int sortField)
    {

        if (sortField == 0)
        {
            Collections.sort(players,sortByNumber);
        }
        if (sortField == 1)
        {
            Collections.sort(players,sortByPosition);
        }
        if (sortField == 2)
        {
            Collections.sort(players,sortByName);
        }
        if (sortField == 3)
        {
            Collections.sort(players,sortByHeight);
        }
        if (sortField == 4)
        {
            Collections.sort(players,sortByWeight);
        }
        if (sortField == 5)
        {
            Collections.sort(players,sortByHomeTown);
        }
        if (sortField == 6)
        {
            Collections.sort(players,sortByHighSchool);
        }
    }


    public void ReadPlayersFromXML()
    {
        try
        {
            FootballPlayer fp;
            XMLDecoder decoder;
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
            fp = new FootballPlayer();
            while (fp != null)
            {
                try
                {
                    fp = (FootballPlayer) decoder.readObject();
                    players.add(fp);

                } catch (ArrayIndexOutOfBoundsException theend)
                {
                    //System.out.println("end of file");
                    break;
                }
            }
            decoder.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }


    @Override
    public int getFirstLineToDisplay() {
        return firstLineToDisplay;
    }

    @Override
    public int getLineToHighlight() {
        return  highlightedLines;
    }

    @Override
    public int getLastLineToDisplay() {
        return lastLineToDisplay;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineToDisplay = firstLine;
        if (firstLineToDisplay < 0) {
            firstLineToDisplay = 0;
        }

        if (firstLineToDisplay >= (players.size() - getLinesBeingDisplayed())) {
            firstLineToDisplay = players.size() - getLinesBeingDisplayed();
        }

        setLastLineToDisplay(firstLineToDisplay + getLinesBeingDisplayed() - 1);
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
    highlightedLines = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineToDisplay = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
    this.linesBeingDisplayed = numberOfLines;
    }

    @Override
    public void sort() {

    }

    @Override
    public int getSortField() {
        return sortField;
    }

    @Override
    public void SetSortField(int sortField) {
        sortField = sortField;
    }


    public Map<String, TableMember> getNumberHash() {
        return numberHash;
    }

    public void setNumberHash(Map<String, TableMember> numberHash) {
        this.numberHash = numberHash;
    }

    public Map<String, TableMember> getNameHash() {
        return nameHash;
    }

    public void setNameHash(Map<String, TableMember> nameHash) {
        this.nameHash = nameHash;
    }

    public Map<String, TableMember> getPositionHash() {
        return positionHash;
    }

    public void setPositionHash(Map<String, TableMember> positionHash) {
        this.positionHash = positionHash;
    }

    public Map<String, TableMember> getHeightHash() {
        return heightHash;
    }

    public void setHeightHash(Map<String, TableMember> heightHash) {
        this.heightHash = heightHash;
    }

    public Map<String, TableMember> getWeightHash() {
        return weightHash;
    }

    public void setWeightHash(Map<String, TableMember> weightHash) {
        this.weightHash = weightHash;
    }

    public Map<String, TableMember> getHomeTownHash() {
        return homeTownHash;
    }

    public void setHomeTownHash(Map<String, TableMember> homeTownHash) {
        this.homeTownHash = homeTownHash;
    }

    public Map<String, TableMember> getHighSchoolHash() {
        return highSchoolHash;
    }

    public void setHighSchoolHash(Map<String,TableMember> highSchoolHash) {
        this.highSchoolHash = highSchoolHash;
    }

}
