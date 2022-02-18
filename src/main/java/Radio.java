public class Radio {
    private int currentRadioVolume;
    private int maxRadioVolume = 100;
    private int minRadioVolume = 0;

    private int currentRadioStation = 5;
    private int maxRadioStation = 9;
    private int allRadioStations = 10;
    private int minRadioStation = 0;


    public Radio(int allRadioStations) {
        this.allRadioStations = allRadioStations;
    }

    public Radio() {
    }


    public void setStations(int currentRadioStation) {

        if (currentRadioStation >= allRadioStations) {
            return;
        }
        if (currentRadioStation < 0) {
            return;
        }
        this.currentRadioStation = currentRadioStation;


    }

    public void setAllRadioStations(int allRadioStations) {
        if (allRadioStations > 100) {
            return;
        }
        if (allRadioStations < 1) {
            return;
        }
        this.allRadioStations = allRadioStations;
    }

    public void selectingTheWrongRadioStationNumber() {
        if (currentRadioStation >= maxRadioStation) {
            currentRadioStation = 0;

        } else {
            currentRadioStation += 1;
        }
    }

    public void changeTheStationByPrevButton() {
        if (currentRadioStation == minRadioStation) {
            currentRadioStation = maxRadioStation;

        } else {
            currentRadioStation -= 1;
        }
    }

    public void increaseVolume() {
        if (currentRadioVolume >= maxRadioVolume) {
            currentRadioVolume = maxRadioVolume;
            return;
        } else {
            currentRadioVolume++;
            return;
        }
    }

    public void decreaseVolume() {
        if (currentRadioVolume <= minRadioVolume) {
            currentRadioVolume = minRadioVolume;
            return;

        } else {
            currentRadioVolume--;
            return;

        }
    }

    public int getCurrentRadioVolume() {
        return currentRadioVolume;

    }

    public void setCurrentRadioVolume(int currentRadioVolume) {
        this.currentRadioVolume = currentRadioVolume;

    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        this.currentRadioStation = currentRadioStation;
    }

    public int getMaxRadioVolume() {
        return maxRadioVolume;
    }

    public int getMinRadioVolume() {
        return minRadioVolume;
    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public int getAllRadioStations() {
        return allRadioStations;
    }
}

