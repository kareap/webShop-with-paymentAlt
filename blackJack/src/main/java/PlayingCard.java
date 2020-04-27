public class PlayingCard {
    int value;
    int gameValue;
    String type;
    boolean isHidden;

    public PlayingCard(int value, int gameValue, String type, boolean isHidden) {
        this.value = value;
        this.gameValue = gameValue;
        this.type = type;
        this.isHidden = isHidden;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getGameValue() {
        return gameValue;
    }

    public void setGameValue(int gameValue) {
        this.gameValue = gameValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    @Override
    public String toString() {
        String valueString;
        switch (value) {
            case 1:  valueString = "Ace";
            break;
            case 11: valueString = "Jack";
            break;
            case 12: valueString = "Queen";
            break;
            case 13: valueString = "King";
            break;
            default: valueString = Integer.toString(value);
        }
        return valueString +" of " + type + " (gameValue: " + gameValue+")";
    }
}
