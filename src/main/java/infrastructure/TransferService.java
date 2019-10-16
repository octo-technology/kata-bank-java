package infrastructure;

public class TransferService {
    private final OctoBankApi octoBankApi;

    public TransferService(OctoBankApi octoBankApi) {
        this.octoBankApi = octoBankApi;
    }

    public boolean sendMoneyToAccount(String iban, int amount) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{'iban': '")
                .append(iban)
                .append("', 'montant': ")
                .append(amount)
                .append("}");
        int returnCode = octoBankApi.transfer(jsonBuilder.toString());
        if (returnCode == 200) {
            return true;
        }
        return false;
    }
}
