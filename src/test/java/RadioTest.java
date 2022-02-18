import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    void shouldShowNumberOfStations() {
        Radio radio = new Radio();
        assertEquals(10, radio.getAllRadioStations(), "Всего станции");
    }

    @Test
    void shouldSetNumberOfRadioStationInLimit() {
        Radio radio = new Radio(10);
        radio.setAllRadioStations(1);
        assertEquals(1, radio.getAllRadioStations(), " Радиостанция в граничных значениях");
    }

    @Test
    void shouldSetNumberOfRadioStationsMax() {
        Radio radio = new Radio(10);
        radio.setAllRadioStations(10);
        assertEquals(10, radio.getAllRadioStations(), "Количество радиостанции в максимальном значении");
    }

    @Test
    void shouldSetNumberOfRadioStationsOverLimit() {
        Radio radio = new Radio(110);
        radio.setAllRadioStations(100);
        assertEquals(100, radio.getAllRadioStations(), "Количество радиостанции вне граничных значении");
    }

    @Test
    void shouldSetNumberOfRadioStationsZero() {
        Radio radio = new Radio(0);
        radio.setAllRadioStations(0);
        assertEquals(0, radio.getAllRadioStations(), "Радиостанция 0");
    }

    @Test
    void shouldSetStationsOverLimit() {
        Radio radio = new Radio(20);
        radio.setStations(15);
        assertEquals(15, radio.getCurrentRadioStation(), "Номер радиостанции,с заданными 20-ю станциями");
    }

    @Test
    void shouldShowNegativeStationMax() {
        Radio radio = new Radio(10);
        radio.setStations(11);
        assertEquals(4, radio.getCurrentRadioStation(), "Негативное max значение");
    }

    @Test
    void shouldSetStationBorderMaxStation() {
        Radio radio = new Radio();
        radio.setStations(9);
        assertEquals(9, radio.getCurrentRadioStation(), "Граничное значение максимальное станций по умолчанию");
    }

    @Test
    void shouldSetStationNumberStationFirst() {
        Radio radio = new Radio(1);
        radio.setCurrentRadioStation(0);
        radio.setStations(0);
        assertEquals(0, radio.getCurrentRadioStation(), "Номер радиостанции. Кол-во станций - одна.");
    }


    @Test
    void shouldSetNegativeNumberOfStations() {
        Radio radio = new Radio();
        radio.setStations(-1);
        assertEquals(4, radio.getCurrentRadioStation(), "Номер радиостанции. Отрицательное  значение");
    }


    @Test
    void shouldChangeStationIfCurrentIsMax() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);
        radio.selectingTheWrongRadioStationNumber();
        assertEquals(0, radio.getMinRadioStation(), "Текущая макс + 1 следующая = 0");
    }

    @Test
    void shouldChangeTheNextStation() {
        Radio rad = new Radio();
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(5, rad.getCurrentRadioStation(), "Следующий канал");
    }

    @Test
    void shouldChangeTheStationIfCurrentIsNull() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);
        radio.changeTheStationByPrevButton();
        assertEquals(9, radio.getMaxRadioStation(), "Текущая радиостанция - 0,  + предыдущая " + "на пульте, то текущей должна стать максимальная");
    }

    @Test
    void shouldChangeTheStation() {
        Radio rad = new Radio();
        rad.changeTheStationByPrevButton();
        assertEquals(3, rad.getCurrentRadioStation(), "Предыдущий канал");
    }


    @Test
    void shouldIncreaseTheVolume() {
        Radio rad = new Radio();
        rad.setCurrentRadioVolume(44);
        rad.increaseVolume();
        assertEquals(45, rad.getCurrentRadioVolume(), "Увеличить громкость +1");
    }

    @Test
    void shouldIncreaseTheMaxVolume() {
        Radio rad = new Radio();
        rad.setCurrentRadioVolume(108);
        rad.increaseVolume();
        assertEquals(100, rad.getMaxRadioVolume(), "Негативное максимальное граничное значение");
    }

    @Test
    void shouldDecreaseTheVolume() {
        Radio rad = new Radio();
        rad.setCurrentRadioVolume(-1);
        rad.decreaseVolume();
        assertEquals(0, rad.getMinRadioVolume(), "Негативное граничное значение");
    }


    @Test
    void shouldDecreaseTheMinVolume() {
        Radio rad = new Radio();
        rad.setCurrentRadioVolume(99);
        rad.decreaseVolume();
        assertEquals(98, rad.getCurrentRadioVolume(), "Уменьшение громкости -1");
    }

    @Test
    void shouldSetNumberOfRadioStationsNegative() {
        Radio radio = new Radio(100);
        radio.setAllRadioStations(101);
        assertEquals(4, radio.getCurrentRadioStation(), "Установка количества радиостанций");
    }

    @Test
    void shouldSetNumberMax() {
         Radio rad = new Radio(30);
        rad.setCurrentRadioStation(30);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(0, rad.getCurrentRadioStation(), "Негативное максимальное граничное значение");
    }
}