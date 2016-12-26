
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Payment implements Serializable{
    private String paymentId;
    private String paymentType;
    private double totalAmount;
    private Date paymentDate;
    private String paymentStatus;
    private String customerId;
    private String roomId;

    public Payment() {
    }

    public Payment(String paymentId, String paymentType, double totalAmount, Date paymentDate, String paymentStatus, String customerId, String roomId) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
        this.paymentStatus = paymentStatus;
        this.customerId = customerId;
        this.roomId = roomId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    
    
    
}
