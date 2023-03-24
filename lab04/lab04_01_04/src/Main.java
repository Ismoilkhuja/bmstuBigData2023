import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Создаем объект выставки
        ArtExhibition exhibition = new ArtExhibition("Художники Ренессанса", new Date(2022, 5, 15));

        // Создаем объекты картины и добавляем их на выставку
        ArtExhibition.Painting monaLisa = exhibition.new Painting("Мона Лиза", 1503, "Леонардо да Винчи");
        ArtExhibition.Painting lastSupper = exhibition.new Painting("Тайная вечеря", 1498, "Тициан");
        exhibition.addPainting(monaLisa);
        exhibition.addPainting(lastSupper);

        // Выводим информацию о выставке и картинах
        exhibition.showExhibitionInfo();
        
    }
}