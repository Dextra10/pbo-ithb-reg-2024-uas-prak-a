package model;

import java.util.Date;

public class ShipmentDetails {
    private int id;
    private int transactionId;
    private String status; // ENUM: 'pending', 'transit', 'delivered'
    private String currentPosition;
    private String evidence; 
    private Date date;
    private String updatedBy;

    // Constructor
    public ShipmentDetails(int id, int transactionId, String status, String currentPosition, String evidence,Date date, String updatedBy) {
        this.id = id;
        this.transactionId = transactionId;
        this.status = status;
        this.currentPosition = currentPosition;
        this.evidence = evidence;
        this.date = date;
        this.updatedBy = updatedBy;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}

