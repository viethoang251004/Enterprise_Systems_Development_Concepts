public class InvoiceItem {

    private String id, desc;
    private int qty;
    private double unitPrice;

    public InvoiceItem() {
        this.id = "";
        this.desc = "";
        this.qty = 0;
        this.unitPrice = 0.0;
    }

    public InvoiceItem(String id, String desc, int qty, double unitPrice) {
        this.id = id;
        this.desc = desc;
        if(qty > 0) this.qty = qty;
        if(unitPrice > 0) this.unitPrice = unitPrice;
    }

    public InvoiceItem(InvoiceItem item) {
        this.id = item.id;
        this.desc = item.desc;
        if(item.qty > 0) this.qty = item.qty;
        if(item.unitPrice > 0) this.unitPrice = item.unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if(unitPrice > 0) this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public double getTotal() {
        return this.unitPrice * this.qty;
    }

}