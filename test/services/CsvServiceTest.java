package services;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by Igor_Kravchenko on 4/19/16.
 */
public class CsvServiceTest {

    private CsvService csvService = new CsvService();

    @Test
    public void shouldParseStringIntoStatisticBatch() throws IOException {
        StatisticBatch statisticBatch = csvService.parseMessage("one,two,three\nUK,1,2\nUS,3,4\nUA,5,6");
        assertEquals("one", statisticBatch.columnNames.get(0).name);
        assertEquals("UK", statisticBatch.records.get(0).keyFigures.get(0).value);
    }


}