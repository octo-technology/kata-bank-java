package infrastructure;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TransferServiceTest {
    @Test
    public void should_return_true_when_octoBankApi_return_200_statusCode() {
        // Given
        String iban = "FR3512739000304757795757C09";
        int amount = 250;
        OctoBankApiStub octoBankApiStub = new OctoBankApiStub(200);
        TransferService transferService = new TransferService(octoBankApiStub);

        // When
        boolean transferDone = transferService.sendMoneyToAccount(iban, amount);

        // Then
        assertThat(transferDone).isTrue();
    }

    @Test
    public void should_return_false_when_octoBankApi_return_400_statusCode() {
        // Given
        String iban = "INVALID_IBAN";
        int amount = 250;
        OctoBankApiStub octoBankApiStub = new OctoBankApiStub(400);
        TransferService transferService = new TransferService(octoBankApiStub);

        // When
        boolean transferDone = transferService.sendMoneyToAccount(iban, amount);

        // Then
        assertThat(transferDone).isFalse();
    }

    @Test
    public void should_return_false_when_octoBankApi_return_403_statusCode() {
        // Given
        String iban = "FR3512739000304757795757C09";
        int amount = -250;
        OctoBankApiStub octoBankApiStub = new OctoBankApiStub(403);
        TransferService transferService = new TransferService(octoBankApiStub);

        // When
        boolean transferDone = transferService.sendMoneyToAccount(iban, amount);

        // Then
        assertThat(transferDone).isFalse();
    }

    @Test
    public void should_transform_to_json() {
        // Given
        String iban = "FR3512739000304757795757C09";
        int amount = 250;
        OctoBankApiStub octoBankApiStub = new OctoBankApiStub(200);
        TransferService transferService = new TransferService(octoBankApiStub);

        // When
        transferService.sendMoneyToAccount(iban, amount);

        // Then
        String sentJson = octoBankApiStub.receivedJson;
        String expectedJson = "{'iban': 'FR3512739000304757795757C09', 'montant': 250}";
        assertThat(sentJson).isEqualTo(expectedJson);
    }

    private class OctoBankApiStub implements OctoBankApi {
        private int statusCode;

        public String receivedJson;

        public OctoBankApiStub(int statusCode) {
            this.statusCode = statusCode;
        }

        @Override
        public int transfer(String json) {
            receivedJson = json;
            return statusCode;
        }
    }
}