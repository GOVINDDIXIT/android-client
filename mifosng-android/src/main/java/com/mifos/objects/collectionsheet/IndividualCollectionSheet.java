package com.mifos.objects.collectionsheet;

import android.os.Parcel;
import android.os.Parcelable;

import com.mifos.objects.accounts.loan.PaymentTypeOptions;

import java.util.ArrayList;

/**
 * Created by Tarun on 06-07-2017.
 */

public class IndividualCollectionSheet implements Parcelable {

    private int[] dueDate;

    private ArrayList<ClientCollectionSheet> clients;

    private ArrayList<PaymentTypeOptions> paymentTypeOptions;

    public int[] getDueDate() {
        return dueDate;
    }

    public void setDueDate(int[] dueDate) {
        this.dueDate = dueDate;
    }

    public ArrayList<ClientCollectionSheet> getClients() {
        return clients;
    }

    public void setClients(ArrayList<ClientCollectionSheet> clients) {
        this.clients = clients;
    }

    public ArrayList<PaymentTypeOptions> getPaymentTypeOptions() {
        return paymentTypeOptions;
    }

    public void setPaymentTypeOptions(ArrayList<PaymentTypeOptions> paymentTypeOptions) {
        this.paymentTypeOptions = paymentTypeOptions;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.dueDate);
        dest.writeList(this.clients);
        dest.writeList(this.paymentTypeOptions);
    }

    public IndividualCollectionSheet() {
    }

    protected IndividualCollectionSheet(Parcel in) {
        this.dueDate = in.createIntArray();
        this.clients = new ArrayList<ClientCollectionSheet>();
        in.readList(this.clients, ClientCollectionSheet.class.getClassLoader());
        this.paymentTypeOptions = new ArrayList<PaymentTypeOptions>();
        in.readList(this.paymentTypeOptions, PaymentTypeOptions.class.getClassLoader());
    }

    public static final Parcelable.Creator<IndividualCollectionSheet> CREATOR = new
            Parcelable.Creator<IndividualCollectionSheet>() {
        @Override
        public IndividualCollectionSheet createFromParcel(Parcel source) {
            return new IndividualCollectionSheet(source);
        }

        @Override
        public IndividualCollectionSheet[] newArray(int size) {
            return new IndividualCollectionSheet[size];
        }
    };
}
